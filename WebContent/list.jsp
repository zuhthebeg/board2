<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����! �Խ��� - �Խñ� ����Ʈ</title>		<!-- ������ ��ܿ� �ߴ� �����Դϴ�. -->
<style type="text/css">
	table, td, th
{
	border:1px solid green;
}
	th
{
	background-color:green;
	color:white;
}
</style>
</head>
<body>											<!-- HTML������ �� ������ ���� �κ��Դϴ�. -->
	<h1>�Խñ� ����Ʈ</h1>						<!-- ������ �۾��� ǥ���ϴ� �±��Դϴ�. -->
	<table>										<!-- ǥ ������ �����͸� ǥ���ϴ� �±��Դϴ�. -->
		<tr>									<!-- table�±� ������ ���� �����Ҷ� ���� �±��Դϴ�. -->
			<th>��ȣ</th>						<!-- Table Header�� ���ڷ� table�±� ������ -->
			<th>����</th>						<!-- �����ϰ���� �÷��� ��Ÿ���� ���� �±��Դϴ�. -->
			<th>�ۼ���</th>
			<th>��¥</th>
			<th>��ȸ��</th>
		</tr>
		<c:forEach items="${articleList}" var="article">
			<tr>
				<td>${article.idx}</td>
				<td><a href='count.do?idx=${article.idx}'>${article.title} </a></td>
				<td>${article.writer}</td>
				<td>${article.regdate}</td>
				<td>${article.count}</td> 
			</tr>
		</c:forEach>
	</table> 
	
	<c:if test="${page > 0}"> 
		<a href="list.do?page=${page-10}">����������</a> 
	</c:if>
	<c:if test="${page == 0}"> 
		<a href="#">����������</a> 
	</c:if>
	
	<fmt:parseNumber value="${page/10+1 }" type="number"  integerOnly="True" /> ������ 
	
	<c:if test="${fn:length( articleList ) < 10}"> 
		<a href="#">����������</a>
	</c:if>
	<c:if test="${fn:length( articleList ) == 10}"> 
		<a href="list.do?page=${page+10}">����������</a>
	</c:if>
	<br/><a href="write.jsp">�۾���</a>
</body>
</html>