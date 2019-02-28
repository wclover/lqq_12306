<%@page import="my12306.my12306Info"%>
<%@page import="my12306.my12306Bean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	my12306Bean bean = new my12306Bean();
	List<my12306Info> data = bean.getAll();
	
	//封装成XML
	out.println("<dingdan_data>");
	Iterator< my12306Info > iter = data.iterator();
	while( iter.hasNext() ){
		my12306Info info = iter.next();
		out.println("<dingdan>");
		out.println("<username>"+ info.getUsername() + "</username>");
		out.println("<name>"+ info.getName() + "</name>");
		out.println("<time>"+ info.getTime() + "</time>");
		out.println("<start>" + info.getStart() + "</start>");
		out.println("--->");
		out.println("<arrive>" + info.getArrive() + "</arrive>");
		out.println("<start_time>" + info.getStart_time() + "</start_time>");
		out.println("--->");
		out.println("<arrive_time>" + info.getArrive_time() + "</arrive_time>");
		out.println("<price>" + info.getPrice() + "</price>");
		out.println("<type>"+ info.getType() + "</type>");
		out.println("</dingdan>");
	
		System.out.printf( "%s\n", info.toString()  );
		
	}
	out.println("</dingdan_data>");

%>
