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
	<%-- DeptServlet�� ������ ��ɰ� �����ϰ� ������ �� �ֵ��� insert.jsp�ۼ��ϱ�
		1. ��û��������
		2. DeptDAO�� insertȣ���ϸ鼭 db�� insert�ǵ��� ó��
		3. ȭ�� ���� 1���� �� ���Լ���----<h1>
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
	<h1><%=result%>���� �� ���� ���� </h1>
		
</body>
</html>