package my12306;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class my12306Bean {
	public List<my12306Info> getAll(){
		List<my12306Info> data = new ArrayList<my12306Info>();
		
		Connection conn = null;
		conn = DBConn.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			
			String sql = "select * from dingdan ";
			st = conn.prepareStatement( sql );
			
			rs = st.executeQuery( );// 执行查询语句
			System.out.println( "查询结果为：" );
			
			while( rs.next() ){
				//用户
				String username = rs.getString("username");
				//车次
				String name = rs.getString("name");
				//日期
				String time = rs.getString("time");
				//起地
				String start = rs.getString("start");
				//终点
				String arrive = rs.getString("arrive");
				//起始时间
				String start_time = rs.getString("start_time");
				//到达时间
				String arrive_time = rs.getString("arrive_time");
				//价格
				String price = rs.getString("price");
				//类型
				String type = rs.getString("type");
				
				my12306Info info = new my12306Info(username, name, time, start, arrive, start_time, arrive_time, price, type);
				data.add( info );
			}
			
		}
		catch( SQLException e ){
			e.printStackTrace();
			System.out.printf( "数据库查询失败\n" + e.getMessage()  );
		}
		finally{
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "关闭连接失败\n" + e.getMessage()  );
				}// try
			}// if
			
		}// finally

		return data;
	}
	
	public List<my12306Info> getAll_byname(String get_username){
		List<my12306Info> data = new ArrayList<my12306Info>();
		
		Connection conn = null;
		conn = DBConn.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			
			String sql = "select * from dingdan " + "where username = ?";
			st = conn.prepareStatement( sql );
			
			int i = 1;
			st.setString( i, get_username );
			rs = st.executeQuery( );// 执行查询语句
			++i;
			
			rs = st.executeQuery( );// 执行查询语句
			System.out.println( "查询结果为：" );
			
			while( rs.next() ){
				//用户
				String username = rs.getString("username");
				//车次
				String name = rs.getString("name");
				//日期
				String time = rs.getString("time");
				//起地
				String start = rs.getString("start");
				//终点
				String arrive = rs.getString("arrive");
				//起始时间
				String start_time = rs.getString("start_time");
				//到达时间
				String arrive_time = rs.getString("arrive_time");
				//价格
				String price = rs.getString("price");
				//类型
				String type = rs.getString("type");
				
				my12306Info info = new my12306Info(username, name, time, start, arrive, start_time, arrive_time, price, type);
				data.add( info );
			}
			
		}
		catch( SQLException e ){
			e.printStackTrace();
			System.out.printf( "数据库查询失败\n" + e.getMessage()  );
		}
		finally{
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "关闭连接失败\n" + e.getMessage()  );
				}// try
			}// if
			
		}// finally

		return data;
	}
	
	public boolean add( my12306Info info ){
		
		// 获取连接
		Connection conn = DBConn.getConnection();
		int count = -1;
		
		try{
			String sql = " insert dingdan "
					+ "  (username, name, time, start, arrive, start_time, arrive_time, price, type) "
					+ "  values(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement st = conn.prepareStatement( sql );
			int i = 1;
			
			//  username
			st.setString( i, info.getUsername() );
			++i;
			//  name
			st.setString( i, info.getName() );
			++i;
			//  time
			st.setString( i, info.getTime() );
			++i;
			//   start
			st.setString(i, info.getStart() );
			++i;
			//   arrive, 
			st.setString( i, info.getArrive() );
			++i;
			//   start_time, 
			st.setString( i, info.getStart_time() );
			++i;
			//   arrive_time, 
			st.setString( i, info.getArrive_time() );
			++i;
			//   price, 
			st.setString( i, info.getPrice() );
			++i;
			//   type, 
			st.setString( i, info.getType() );
			++i;
		
			System.out.printf("sql = %s\n", st.toString());
			
			count = st.executeUpdate(  );// 执行语句
			System.out.printf( "新增%d条记录\n", count );
			System.out.println(info.getStart());
			System.out.println(info.getArrive());
		}
		catch( SQLException e ){
			System.out.printf( "新增失败:" + e.getMessage() );
			return false;
		}
		finally{
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "关闭连接失败\n" + e.getMessage()  );
				}// try
			}// if
			
		}// finally
		
		return true;
	}
}
