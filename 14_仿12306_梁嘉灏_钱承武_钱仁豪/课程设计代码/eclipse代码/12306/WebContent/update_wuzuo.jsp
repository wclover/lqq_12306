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
	String wuzuo = request.getParameter("wuzuo");
	out.println(checi);
	out.println(wuzuo);

	boolean num = bean.update_wuzuo(wuzuo, checi);
	out.println(num);

%>
