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
	String yideng = request.getParameter("yideng");
	//out.println(checi);
	//out.println(yideng);
	//?yideng=一等：0张&checi=G102

	boolean num = bean.update_yideng(yideng, checi);
	System.out.println(num);
	out.println(num);

%>
