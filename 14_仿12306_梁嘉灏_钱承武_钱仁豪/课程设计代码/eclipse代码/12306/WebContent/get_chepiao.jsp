<%@page import="my12306.trainInfo"%>
<%@page import="my12306.trainBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	trainBean bean = new trainBean();
	List<trainInfo> data = bean.getAll();
	
	//封装成XML
	out.println("<data>");
	Iterator< trainInfo > iter = data.iterator();
	while( iter.hasNext() ){
		trainInfo info = iter.next();
		out.println("<train>");
		out.println("<checi>"+ info.getCheci() + "</checi>");
		out.println("<date>"+ info.getDate() + "</date>");
		out.println("<start>" + info.getStart() + "</start>");
		//out.println("-->");
		out.println("<arrive>" + info.getArrive() + "</arrive>");
		out.println("<start_time>" + info.getStat_time() + "</start_time>");
		//out.println("-->");
		out.println("<arrive_time>" + info.getArrive_time() + "</arrive_time>");
		out.println("<type>" + info.getType() + "</type>");
		out.println("<yideng>" + info.getYideng() + "</yideng>");
		out.println("<erdeng>" + info.getErdeng() + "</erdeng>");
		out.println("<wuzuo>" + info.getWuzuo() + "</wuzuo>");
		out.println("<price>" + info.getPrice() + "</price>");
		out.println("</train>");
	
		System.out.printf( "%s\n", info.toString()  );
		
	}
	out.println("</data>");

%>
