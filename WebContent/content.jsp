<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����! �Խ��� - �Խñ� ��ȸ</title>	
<script>
function onDownload(idx) {
	var o = document.getElementById("ifrm_filedown");	
	o.src = "download.do?idx="+idx;
}
</script>	
</head>
<body>				
<iframe id="ifrm_filedown"  style="position:absolute; z-index:1;visibility : hidden;"></iframe>  							
	<h1>�Խñ� ��ȸ</h1>						
	<table border="1">							<!-- border�� �׵θ��� ǥ���ϴ� �Ӽ��Դϴ�. -->
		<tr>									
			<th>��ȣ</th>						
			<td>${article.idx}</td>
			<th>�ۼ���</th>
			<td>${article.writer}</td>
			<th>ip</th>
			<td>${article.regip}</td>
			<th>��¥</th>
			<td>${article.regdate}</td>
			<th>��ȸ��</th>
			<td>${article.count}</td>
		</tr>
		<tr>
			<th colspan="2">����</th>			<!-- colspan�� �ິ�� �Ӽ��Դϴ�. -->
			<td colspan="8">${article.title}</td>
		</tr>
		<tr>
			<th colspan="2">����</th>						
			<td colspan="8">${article.content}</td>
		</tr>
		<tr>
			<th colspan="2">÷������</th>			
			<td colspan="8"><a href="#" onclick="onDownload('${article.idx}')">${article.filename}</a></td>
		</tr>
	</table>
	<a href="delete.do?idx=${article.idx}">�Խñۻ���</a>
	<a href="list.do">�������</a> 
</body>
</html>