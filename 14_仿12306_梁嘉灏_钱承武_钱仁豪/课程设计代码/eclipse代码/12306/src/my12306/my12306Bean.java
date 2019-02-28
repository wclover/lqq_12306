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
			
			rs = st.executeQuery( );// ִ�в�ѯ���
			System.out.println( "��ѯ���Ϊ��" );
			
			while( rs.next() ){
				//�û�
				String username = rs.getString("username");
				//����
				String name = rs.getString("name");
				//����
				String time = rs.getString("time");
				//���
				String start = rs.getString("start");
				//�յ�
				String arrive = rs.getString("arrive");
				//��ʼʱ��
				String start_time = rs.getString("start_time");
				//����ʱ��
				String arrive_time = rs.getString("arrive_time");
				//�۸�
				String price = rs.getString("price");
				//����
				String type = rs.getString("type");
				
				my12306Info info = new my12306Info(username, name, time, start, arrive, start_time, arrive_time, price, type);
				data.add( info );
			}
			
		}
		catch( SQLException e ){
			e.printStackTrace();
			System.out.printf( "���ݿ��ѯʧ��\n" + e.getMessage()  );
		}
		finally{
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "�ر�����ʧ��\n" + e.getMessage()  );
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
			rs = st.executeQuery( );// ִ�в�ѯ���
			++i;
			
			rs = st.executeQuery( );// ִ�в�ѯ���
			System.out.println( "��ѯ���Ϊ��" );
			
			while( rs.next() ){
				//�û�
				String username = rs.getString("username");
				//����
				String name = rs.getString("name");
				//����
				String time = rs.getString("time");
				//���
				String start = rs.getString("start");
				//�յ�
				String arrive = rs.getString("arrive");
				//��ʼʱ��
				String start_time = rs.getString("start_time");
				//����ʱ��
				String arrive_time = rs.getString("arrive_time");
				//�۸�
				String price = rs.getString("price");
				//����
				String type = rs.getString("type");
				
				my12306Info info = new my12306Info(username, name, time, start, arrive, start_time, arrive_time, price, type);
				data.add( info );
			}
			
		}
		catch( SQLException e ){
			e.printStackTrace();
			System.out.printf( "���ݿ��ѯʧ��\n" + e.getMessage()  );
		}
		finally{
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "�ر�����ʧ��\n" + e.getMessage()  );
				}// try
			}// if
			
		}// finally

		return data;
	}
	
	public boolean add( my12306Info info ){
		
		// ��ȡ����
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
			
			count = st.executeUpdate(  );// ִ�����
			System.out.printf( "����%d����¼\n", count );
			System.out.println(info.getStart());
			System.out.println(info.getArrive());
		}
		catch( SQLException e ){
			System.out.printf( "����ʧ��:" + e.getMessage() );
			return false;
		}
		finally{
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "�ر�����ʧ��\n" + e.getMessage()  );
				}// try
			}// if
			
		}// finally
		
		return true;
	}
}
