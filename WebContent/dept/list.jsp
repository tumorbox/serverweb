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
	1. 공유된 데이터꺼내기
	2. for문으로데이터꺼내서 출력하기
 --%>
 
 	<%
 		ArrayList<DeptDTO> newlist = (ArrayList<DeptDTO>)request.getAttribute("list");
 	%>
 	
 	<h1>부서목록보기!!!!</h1>
		<hr>
		<table border=1 width="600px">
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>
				<th>부서 위치</th>
				<th>전화 번호</th>
				<th>관리자</th>
				<th>삭제</th>
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
				<a href="/serverweb/dept/delete.do?deptno=<%=dept.getDeptNo() %>">삭제 </a>
				</td>
		</tr>
		<% }%>
		</table>
</body>
</html>