package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "deptinsert", urlPatterns = { "/deptinsert.do" })
public class DeptServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html; charset=euc-kr");
		PrintWriter pw = res.getWriter();
		
		String deptNo = req.getParameter("deptNo"); 
		String deptName = req.getParameter("deptName"); 
		String loc = req.getParameter("loc"); 
		String tel = req.getParameter("tel"); 
		String mgr = req.getParameter("mgr"); 
		
		DeptDTO dept = new DeptDTO(deptNo, deptName, loc, tel, mgr);
		DeptDAOImpl dao = new DeptDAOImpl();
		int result = dao.insert(dept);
		
		pw.print("<h1>삽입성공</h1>");
		pw.print("<hr/>");
		pw.print("<h3>"+result+"개의 행 ");
		
	}
}
