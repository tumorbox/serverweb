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
		
		System.out.println("[���]");
		System.out.println("Customer");
		System.out.println("=================");
		System.out.println("����� ���̵� : "+userid);
		System.out.println("����� �̸� : "+username);
		System.out.println("����� ��ȣ : "+passwd);
		System.out.println("����� ���� : "+gender);
		System.out.println("����� ���� : "+job);
		System.out.print("����� ��� : ");
		for (int i = 0; i < favorites.length; i++) {
			System.out.print(favorites[i]+" ");
		}
	}
}
