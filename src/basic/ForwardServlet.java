package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;

@WebServlet(name = "forward", urlPatterns = { "/forward.do" })
public class ForwardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html; charset=euc-kr");
		PrintWriter pw = res.getWriter();
		
		pw.print("<h1>sendRedirectȭ��</h1>");
		
		//1. ������ �����ϱ� - request����
		DeptDTO dept = new DeptDTO("001","�����","","","");
		req.setAttribute("mydata", dept);
		System.out.println("sendRedirectServlet����Ϸ�");
		
		//2. ��û������ - sendRedirect
		RequestDispatcher rd = req.getRequestDispatcher("/jspbasic/subPage.jsp");
		rd.forward(req, res);
		
	}
}
