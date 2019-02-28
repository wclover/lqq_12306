<%@page import="my12306.my12306Info"%>
<%@page import="my12306.my12306Bean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String username = request.getParameter("username");
	String name = request.getParameter("name");
	String time = request.getParameter("time");
	String start = request.getParameter("start");
	String arrive = request.getParameter("arrive");
	String start_time = request.getParameter("start_time");
	String arrive_time = request.getParameter("arrive_time");
	String price = request.getParameter("price");
	String type = request.getParameter("type");
	
	//?username=hh&name=hh&time=s&start=s&arrive=q&start_time=a&arrive_time=a&price=as&type=asd
	
	my12306Bean bean = new my12306Bean();
	my12306Info info = new my12306Info(username, name, time, start, arrive, start_time, arrive_time, price, type);
	//my12306Info info = new my12306Info("哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈");
	out.print(start);
	boolean result = bean.add(info);
	
	if( result == true ){
		out.println("true");
	}
	else{
		out.println("false");
}
%>
