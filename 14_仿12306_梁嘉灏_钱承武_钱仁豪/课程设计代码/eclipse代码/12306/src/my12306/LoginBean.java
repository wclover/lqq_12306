package my12306;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginBean {
	public boolean getZhanghao(String account, String password){
		
		Connection conn = null;
		conn = DBConn.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			
			String sql = "select mima from login " + "where zhanghao = ?";
			st = conn.prepareStatement( sql );
			int i = 1;
			st.setString( i, account );
			rs = st.executeQuery( );// ִ�в�ѯ���
			++i;
			
			while( rs.next() ){
				//����
				String mima = rs.getString("mima");
				System.out.println("***"+mima);
				System.out.println("////"+password);
				System.out.println("/////*******"+(mima.equals(password)));
				
				if(mima.equals(password)){
					return true;
				}
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

		return false;
	}
	public boolean Add_Login( LoginInfo info ){
		
		// ��ȡ����
		Connection conn = DBConn.getConnection();
		int count = 0;
		int x = 1;
		
		try{
			if(x == 1){
			String sql = " insert login "
					+ "  (zhanghao, mima) "
					+ "  values(?, ?) ";
			PreparedStatement st = conn.prepareStatement( sql );
			int i = 1;
			
			//  zhanghao
			st.setString( i, info.getZhanghao() );
			++i;
			//  mima
			st.setString( i, info.getMima() );
			++i;
			System.out.println(info.getZhanghao());
			System.out.println(info.getMima());
		
			System.out.printf("sql = %s\n", st.toString());
				
			count = st.executeUpdate(  );// ִ�����
			
			System.out.printf( "����%d����¼\n", count );
			x = 0;
			}
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
