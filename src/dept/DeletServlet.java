package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "delete", urlPatterns = { "/dept/delete.do" })
public class DeletServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html; charset=euc-kr");
		PrintWriter pw = res.getWriter();

		//1. ��û���� ����
		String deptno = req.getParameter("deptno");
	
		//2. �����Ͻ��޼ҵ� ȣ��
		DeptDAOImpl dao = new DeptDAOImpl();
		int result = dao.delete(deptno);
		
		//3. ����޽��� ���� ---> ��û������
		res.sendRedirect("/serverweb/dept/list.do");
	}
}
