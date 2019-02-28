package my12306;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class trainBean {
	public List<trainInfo> getAll(){
		List<trainInfo> data = new ArrayList<trainInfo>();
		
		Connection conn = null;
		conn = DBConn.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			
			String sql = "select * from train ";
			st = conn.prepareStatement( sql );
			
			rs = st.executeQuery( );// 执行查询语句
			System.out.println( "查询结果为：" );
			
			while( rs.next() ){
				//车次
				String checi = rs.getString("checi");
				//日期
				String date = rs.getString("date");
				//起地
				String start = rs.getString("start");
				//起始时间
				String start_time = rs.getString("start_time");
//				//方式
//				String take = rs.getString("take");
				//终点
				String arrive = rs.getString("arrive");
				//到达时间
				String arrive_time = rs.getString("arrive_time");
				//类型
				String type = rs.getString("type");
				//一等座
				String yideng = rs.getString("yideng");
				//二等座
				String erdeng = rs.getString("erdeng");
				//无座
				String wuzuo = rs.getString("wuzuo");
				//价格
				String price = rs.getString("price");
				
				trainInfo info = new trainInfo(checi, date, start, start_time, arrive, arrive_time, type, yideng, erdeng, wuzuo,price);
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
	
	public boolean update_yideng( String ticket, String checi){
		
		// 获取连接
		Connection conn = DBConn.getConnection();
		int count = -1;
		
		try{
			System.out.println("****"+ticket);
			System.out.println("////"+checi);
			String a1[] = ticket.split("：");
			String a2 = a1[1];
			String a3[] = a2.split("张");
			int num = Integer.parseInt(a3[0]);
			if ( num == 0){
				System.out.println("暂无车票");
				return false;
			}
			String newyideng = "一等：" + --num + "张";
			String sql = " update train " + "set yideng = ?"  + " where checi = ?";
			PreparedStatement st = conn.prepareStatement( sql );
			int i = 1;
			
			st.setString( i, newyideng );
			++i;
			
			st.setString( i, checi );
			++i;
			
		
			System.out.printf("sql = %s\n", st.toString());
			
			count = st.executeUpdate(  );// 执行语句
			System.out.printf( "修改%d条记录\n", count );
		}
		catch( SQLException e ){
			System.out.printf( "修改失败:" + e.getMessage() );
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
	
	public boolean update_erdeng( String ticket, String checi){
		
		// 获取连接
		Connection conn = DBConn.getConnection();
		int count = -1;
		
		try{
			System.out.println("****"+ticket);
			System.out.println("////"+checi);
			String a1[] = ticket.split("：");
			String a2 = a1[1];
			String a3[] = a2.split("张");
			int num = Integer.parseInt(a3[0]);
			if ( num == 0){
				System.out.println("暂无车票");
				return false;
			}
			String newyideng = "二等：" + --num + "张";
			String sql = " update train " + "set erdeng = ?"  + " where checi = ?";
			PreparedStatement st = conn.prepareStatement( sql );
			int i = 1;
			
			st.setString( i, newyideng );
			++i;
			
			st.setString( i, checi );
			++i;
			
		
			System.out.printf("sql = %s\n", st.toString());
			
			count = st.executeUpdate(  );// 执行语句
			System.out.printf( "修改%d条记录\n", count );
		}
		catch( SQLException e ){
			System.out.printf( "修改失败:" + e.getMessage() );
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

	public boolean update_wuzuo( String ticket, String checi){
	
	// 获取连接
	Connection conn = DBConn.getConnection();
	int count = -1;
	
	try{
		System.out.println("****"+ticket);
		System.out.println("////"+checi);
		String a1[] = ticket.split("：");
		String a2 = a1[1];
		String a3[] = a2.split("张");
		int num = Integer.parseInt(a3[0]);
		if ( num == 0){
			System.out.println("暂无车票");
			return false;
		}
		String newyideng = "无座：" + --num + "张";
		String sql = " update train " + "set wuzuo = ?"  + " where checi = ?";
		PreparedStatement st = conn.prepareStatement( sql );
		int i = 1;
		
		st.setString( i, newyideng );
		++i;
		
		st.setString( i, checi );
		++i;
		
	
		System.out.printf("sql = %s\n", st.toString());
		
		count = st.executeUpdate(  );// 执行语句
		System.out.printf( "修改%d条记录\n", count );
	}
	catch( SQLException e ){
		System.out.printf( "修改失败:" + e.getMessage() );
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
