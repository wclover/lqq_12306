package my12306;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	// 获得数据库连接
    public static Connection getConnection(){
    	
    	Connection con = null;
    	try {
    		Class.forName( "com.mysql.jdbc.Driver" );
    	}catch (Exception e){
    		System.out.println("忘记把MySQL数据库的JDBC-数据库驱动程序复制到JDK的扩展目录中");
    	}
    	try{
    		// 加载MySql数据驱动
//    		Class.forName( "com.mysql.jdbc.Driver" );
    		// 建立链接
//    	    con = DriverManager.getConnection( 
//    	    		//  本机，端口号：3306，　数据库：games
//    	    	"jdbc:mysql://localhost:3306/games"
//    	    	+ "?useUnicode=true&characterEncoding=UTF-8",
//				"root", // 用户名
//				"" ); // 密码
//    	    // 创建数据库连接
    		String uri= "jdbc:mysql://127.0.0.1/my12306";
            String user="root";
            String password="";
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my12306?useUnicode="
            		+ "true&characterEncoding=UTF-8",user,password);
            
            System.out.println("数据库连接成功！");
    	}
    	catch( Exception e ){
    		System.out.printf( "数据库连接失败\n" );
    	}
    	
    	return con;
    }
}
