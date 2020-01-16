package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "lsit", urlPatterns = { "/dept/list.do" })
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=euc-kr");
		PrintWriter pw = res.getWriter();
		
		DeptDAOImpl dao =new DeptDAOImpl();
		dao.getDeptList();
		ArrayList<DeptDTO> list = dao.getDeptList();
		
		pw.print("<h1>�μ���Ϻ���</h1>");
		pw.print("<hr>");
		pw.print("<table border=1 width='500p'>");
		pw.print("<tr>");
		pw.print("<th>�μ� ��ȣ</th>");
		pw.print("<th>�μ� �̸�</th>");
		pw.print("<th>�μ� ��ġ</th>");
		pw.print("<th>��ȭ ��ȣ</th>");
		pw.print("<th>������</th>");
		pw.print("<th>����</th>");
		pw.print("</tr>");
		
		//�ѹ��� �ݵǵ��� ��������Ƽ� for���ȿ� �־��ش�.
		int size= list.size();
		for(int i=0;i<size;i++) {
			DeptDTO dept=list.get(i);
			pw.print("<tr>");
			pw.print("<td>" + dept.getDeptNo() + "</td>");
			pw.print("<td>" + dept.getDeptName() + "</td>");
			pw.print("<td>" + dept.getLoc() + "</td>");
			pw.print("<td>" + dept.getTel() + "</td>");
			pw.print("<td>" + dept.getMgr() + "</td>");
			pw.print("<td><a href='/serverweb/dept/delete.do?deptno="+dept.getDeptNo()+
						"&info=test'>���� </a></td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
	}
}
