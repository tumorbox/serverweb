package dept;
/*DeptSeurvlet에서 응답화면을 분리하기
 * 동일한 결과가 출력되도록 foraward작업
 * 응답결과
 * 		dept
 * 			inserResult.jsp작성*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		
		
		//데이터 공유
		req.setAttribute("insertresult", result);
		RequestDispatcher rd = req.getRequestDispatcher("/dept/insertResult.jsp");
		rd.forward(req, res);
		
		//res.sendRedirect("/serverweb/dept/insertResult.html");
	}
}
