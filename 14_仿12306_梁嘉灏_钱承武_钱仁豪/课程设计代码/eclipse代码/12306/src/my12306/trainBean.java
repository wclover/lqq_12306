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
			
			rs = st.executeQuery( );// ִ�в�ѯ���
			System.out.println( "��ѯ���Ϊ��" );
			
			while( rs.next() ){
				//����
				String checi = rs.getString("checi");
				//����
				String date = rs.getString("date");
				//���
				String start = rs.getString("start");
				//��ʼʱ��
				String start_time = rs.getString("start_time");
//				//��ʽ
//				String take = rs.getString("take");
				//�յ�
				String arrive = rs.getString("arrive");
				//����ʱ��
				String arrive_time = rs.getString("arrive_time");
				//����
				String type = rs.getString("type");
				//һ����
				String yideng = rs.getString("yideng");
				//������
				String erdeng = rs.getString("erdeng");
				//����
				String wuzuo = rs.getString("wuzuo");
				//�۸�
				String price = rs.getString("price");
				
				trainInfo info = new trainInfo(checi, date, start, start_time, arrive, arrive_time, type, yideng, erdeng, wuzuo,price);
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
	
	public boolean update_yideng( String ticket, String checi){
		
		// ��ȡ����
		Connection conn = DBConn.getConnection();
		int count = -1;
		
		try{
			System.out.println("****"+ticket);
			System.out.println("////"+checi);
			String a1[] = ticket.split("��");
			String a2 = a1[1];
			String a3[] = a2.split("��");
			int num = Integer.parseInt(a3[0]);
			if ( num == 0){
				System.out.println("���޳�Ʊ");
				return false;
			}
			String newyideng = "һ�ȣ�" + --num + "��";
			String sql = " update train " + "set yideng = ?"  + " where checi = ?";
			PreparedStatement st = conn.prepareStatement( sql );
			int i = 1;
			
			st.setString( i, newyideng );
			++i;
			
			st.setString( i, checi );
			++i;
			
		
			System.out.printf("sql = %s\n", st.toString());
			
			count = st.executeUpdate(  );// ִ�����
			System.out.printf( "�޸�%d����¼\n", count );
		}
		catch( SQLException e ){
			System.out.printf( "�޸�ʧ��:" + e.getMessage() );
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
	
	public boolean update_erdeng( String ticket, String checi){
		
		// ��ȡ����
		Connection conn = DBConn.getConnection();
		int count = -1;
		
		try{
			System.out.println("****"+ticket);
			System.out.println("////"+checi);
			String a1[] = ticket.split("��");
			String a2 = a1[1];
			String a3[] = a2.split("��");
			int num = Integer.parseInt(a3[0]);
			if ( num == 0){
				System.out.println("���޳�Ʊ");
				return false;
			}
			String newyideng = "���ȣ�" + --num + "��";
			String sql = " update train " + "set erdeng = ?"  + " where checi = ?";
			PreparedStatement st = conn.prepareStatement( sql );
			int i = 1;
			
			st.setString( i, newyideng );
			++i;
			
			st.setString( i, checi );
			++i;
			
		
			System.out.printf("sql = %s\n", st.toString());
			
			count = st.executeUpdate(  );// ִ�����
			System.out.printf( "�޸�%d����¼\n", count );
		}
		catch( SQLException e ){
			System.out.printf( "�޸�ʧ��:" + e.getMessage() );
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

	public boolean update_wuzuo( String ticket, String checi){
	
	// ��ȡ����
	Connection conn = DBConn.getConnection();
	int count = -1;
	
	try{
		System.out.println("****"+ticket);
		System.out.println("////"+checi);
		String a1[] = ticket.split("��");
		String a2 = a1[1];
		String a3[] = a2.split("��");
		int num = Integer.parseInt(a3[0]);
		if ( num == 0){
			System.out.println("���޳�Ʊ");
			return false;
		}
		String newyideng = "������" + --num + "��";
		String sql = " update train " + "set wuzuo = ?"  + " where checi = ?";
		PreparedStatement st = conn.prepareStatement( sql );
		int i = 1;
		
		st.setString( i, newyideng );
		++i;
		
		st.setString( i, checi );
		++i;
		
	
		System.out.printf("sql = %s\n", st.toString());
		
		count = st.executeUpdate(  );// ִ�����
		System.out.printf( "�޸�%d����¼\n", count );
	}
	catch( SQLException e ){
		System.out.printf( "�޸�ʧ��:" + e.getMessage() );
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
