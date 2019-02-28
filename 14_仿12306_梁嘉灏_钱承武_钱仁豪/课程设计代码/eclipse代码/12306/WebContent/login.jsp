<%@page import="my12306.LoginBean"%>
<%@page import="my12306.LoginInfo"%>
<%@page import="my12306.trainInfo"%>
<%@page import="my12306.trainBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	LoginBean bean = new LoginBean();
	String zhanghao = request.getParameter("zhanghao");
	String mima = request.getParameter("mima");
	boolean data = bean.getZhanghao(zhanghao, mima);
	
	//?zhanghao=whiteclover&mima=whiteclover
	
	//封装成XML
	//out.println("<login>");
	//out.println("<mima>");
	out.println(data);
	//out.println("</mima>");
	//out.println("</login>");

%>
