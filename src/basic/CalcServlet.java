package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
@WebServlet(name ="calc", urlPatterns = { "/calc.do" })
public class CalcServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html; charset=euc-kr");
		
		PrintWriter pw = res.getWriter();
		
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		String method =req.getParameter("method");
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(method);
		
		//2. �����Ͻ��޼ҵ� ȣ��
		CalcLogic logic =new CalcLogic();
		int  result = logic.calc(num1, method, num2);	//�����
		
		
		//3. ����ȭ�� ����
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<h1>�����</h1>");
		pw.print("<h3>==============</h3>");
		pw.print("<h3>num1�� "+num1+"��  num2��"+num2+"�� "+method+"�� ������ ����� "+
					result+"�Դϴ�.</h3>");
		pw.print("</body>");
		pw.print("</html>");
		
		System.out.println(result);
		
	}

}
