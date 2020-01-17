<%@page import="dept.DeptDAOImpl"%>
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
	<%-- DeptServlet에 구현된 기능과 동일하게 동작할 수 있도록 insert.jsp작성하기
		1. 요청정보추출
		2. DeptDAO의 insert호출하면서 db에 insert되도록 처리
		3. 화면 생성 1개의 행 삽입성공----<h1>
	  --%>

	<%
		request.setCharacterEncoding("euc-kr");
		
		String deptNo = request.getParameter("deptNo"); 
		String deptName = request.getParameter("deptName"); 
		String loc = request.getParameter("loc"); 
		String tel = request.getParameter("tel"); 
		String mgr = request.getParameter("mgr"); 
		
		DeptDTO dept = new DeptDTO(deptNo, deptName, loc, tel, mgr);
		DeptDAOImpl dao = new DeptDAOImpl();
		int result = dao.insert(dept);
		
	%>
	<h1><%=result%>개의 행 삽입 성공 </h1>
		
</body>
</html>