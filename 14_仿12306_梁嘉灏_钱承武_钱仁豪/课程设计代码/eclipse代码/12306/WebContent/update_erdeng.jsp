<%@page import="my12306.trainInfo"%>
<%@page import="my12306.trainBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	trainBean bean = new trainBean();

	String checi = request.getParameter("checi");
	String erdeng = request.getParameter("erdeng");
	//out.println(checi);
	//out.println(erdeng);

	boolean num = bean.update_erdeng(erdeng, checi);
	out.println(num);

%>
