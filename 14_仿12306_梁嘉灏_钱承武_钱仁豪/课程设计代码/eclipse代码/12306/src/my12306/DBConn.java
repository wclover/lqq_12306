package my12306;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	// ������ݿ�����
    public static Connection getConnection(){
    	
    	Connection con = null;
    	try {
    		Class.forName( "com.mysql.jdbc.Driver" );
    	}catch (Exception e){
    		System.out.println("���ǰ�MySQL���ݿ��JDBC-���ݿ����������Ƶ�JDK����չĿ¼��");
    	}
    	try{
    		// ����MySql��������
//    		Class.forName( "com.mysql.jdbc.Driver" );
    		// ��������
//    	    con = DriverManager.getConnection( 
//    	    		//  �������˿ںţ�3306�������ݿ⣺games
//    	    	"jdbc:mysql://localhost:3306/games"
//    	    	+ "?useUnicode=true&characterEncoding=UTF-8",
//				"root", // �û���
//				"" ); // ����
//    	    // �������ݿ�����
    		String uri= "jdbc:mysql://127.0.0.1/my12306";
            String user="root";
            String password="";
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my12306?useUnicode="
            		+ "true&characterEncoding=UTF-8",user,password);
            
            System.out.println("���ݿ����ӳɹ���");
    	}
    	catch( Exception e ){
    		System.out.printf( "���ݿ�����ʧ��\n" );
    	}
    	
    	return con;
    }
}
