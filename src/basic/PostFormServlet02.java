package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mypost02", urlPatterns = { "/mypost02.do" })	//web.xml에 정의하는것과 같음 둘중 하나만 있으면 된다.
public class PostFormServlet02 extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html; charset=euc-kr");
		
		PrintWriter pw = res.getWriter();
		//요청정보 추출
		String userId = req.getParameter("userId");
		String userName =req.getParameter("userName");
		String passwd =req.getParameter("passwd");
		String gender =req.getParameter("gender");
		String job =req.getParameter("job");
		String [] item =req.getParameterValues("item");
		
		//응답내용을 생성
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<h1>고객정보</h1>");
		pw.print("<h3>아이디: "+userId+"</h3>");
		pw.print("<h3>이름: "+userName+"</h3>");
		pw.print("<h3>favorits</h3>");
		for(String data : item) {
			pw.print(data+" ");
		}
		pw.print("</body>");
		pw.print("</html>");
	
	}

}
