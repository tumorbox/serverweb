package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		String userid = req.getParameter("userId");
		String username =req.getParameter("userName");
		String passwd =req.getParameter("passwd");
		String gender =req.getParameter("gender");
		String job =req.getParameter("job");
		String [] favorites =req.getParameterValues("item");
		
		System.out.println("[결과]");
		System.out.println("Customer");
		System.out.println("=================");
		System.out.println("사용자 아이디 : "+userid);
		System.out.println("사용자 이름 : "+username);
		System.out.println("사용자 암호 : "+passwd);
		System.out.println("사용자 성별 : "+gender);
		System.out.println("사용자 직업 : "+job);
		System.out.print("사용자 취미 : ");
		for (int i = 0; i < favorites.length; i++) {
			System.out.print(favorites[i]+" ");
		}
	}
}
