<%@page import="my12306.LoginInfo"%>
<%@page import="my12306.LoginBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	System.out.println("add_login...");
	request.setCharacterEncoding("UTF-8");

	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	//?zhanghao=qwe&mima=asd
	
	LoginBean bean = new LoginBean();
	LoginInfo info = new LoginInfo(username, password);
	boolean result = bean.Add_Login(info);
	
	if( result == true ){
		out.println("true");
	}
	else{
		out.println("false");
}
%>
