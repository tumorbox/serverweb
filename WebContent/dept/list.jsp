<%@page import="java.util.ArrayList"%>
<%@page import="dept.DeptDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%--
	1. ������ �����Ͳ�����
	2. for�����ε����Ͳ����� ����ϱ�
 --%>
 
 	<%
 		ArrayList<DeptDTO> newlist = (ArrayList<DeptDTO>)request.getAttribute("list");
 	%>
 	
 	<h1>�μ���Ϻ���!!!!</h1>
		<hr>
		<table border=1 width="600px">
			<tr>
				<th>�μ� ��ȣ</th>
				<th>�μ� �̸�</th>
				<th>�μ� ��ġ</th>
				<th>��ȭ ��ȣ</th>
				<th>������</th>
				<th>����</th>
			</tr>
		
		<% 
		int size= newlist.size();
		for(int i=0;i<size;i++) {
			DeptDTO dept=newlist.get(i);
			%>
			<tr> 
				<td><%=dept.getDeptNo()%></td>
				<td><%=dept.getDeptName()%> </td>
				<td><%=dept.getLoc()%></td>
				<td><%=dept.getTel()%></td>
				<td><%=dept.getMgr()%></td>
				<td>
				<a href="/serverweb/dept/delete.do?deptno=<%=dept.getDeptNo() %>">���� </a>
				</td>
		</tr>
		<% }%>
		</table>
</body>
</html>