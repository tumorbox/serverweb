package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "deptread", urlPatterns = { "/dept/read.do" })
public class ReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("������û");
		//1. ��û��������
		//   - Ŭ���̾�Ʈ�� ���� ���±׿� �Է��� ������ �ʿ信 ���ؼ� �ѱ� �Ķ��������
		//   - �⺻������ ��� POST��Ŀ����� ����, get����� ��� �����Ϸ��� server.xml�� ������ �����Ѵ�.
		request.setCharacterEncoding("euc-kr");//POST��Ŀ����� ����
		String deptNo = request.getParameter("deptNo");
		String info = request.getParameter("info");
		System.out.println("�ѱ��������� : "+info);

		//2. �����Ͻ��޼ҵ� ȣ��
		//   - DeptDAOŬ������ �޼ҵ� �߰� �ϰ� ȣ���ϱ�
		DeptDAOImpl dao = new DeptDAOImpl();
		DeptDTO dept = dao.read(deptNo);
		
		//3. jsp�� �Ѱ� �� ������ �����ϱ�
		request.setAttribute("deptInfo",dept);
		
		//4. ��û������(forward) - ������ jsp��û�ϱ�
		RequestDispatcher rd = request.getRequestDispatcher("/dept/dept_read.jsp");
		rd.forward(request, response);
	}

}
