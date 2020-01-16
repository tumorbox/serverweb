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
		
		//2. 비지니스메소드 호출
		CalcLogic logic =new CalcLogic();
		int  result = logic.calc(num1, method, num2);	//계산결과
		
		
		//3. 응답화면 생성
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<h1>계산결과</h1>");
		pw.print("<h3>==============</h3>");
		pw.print("<h3>num1의 "+num1+"과  num2의"+num2+"을 "+method+"로 연산한 결과는 "+
					result+"입니다.</h3>");
		pw.print("</body>");
		pw.print("</html>");
		
		System.out.println(result);
		
	}

}
