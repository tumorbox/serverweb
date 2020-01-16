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

		//1. 요청정보 추출
		String deptno = req.getParameter("deptno");
	
		//2. 비지니스메소드 호출
		DeptDAOImpl dao = new DeptDAOImpl();
		int result = dao.delete(deptno);
		
		//3. 응답메시지 생성 ---> 요청재지정
		res.sendRedirect("/serverweb/dept/list.do");
	}
}
