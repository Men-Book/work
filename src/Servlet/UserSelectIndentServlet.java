package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.IndentInfo;
import Bean.User;
import Dao.UserDao;

@WebServlet("/UserSelectIndentServlet")
public class UserSelectIndentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession();
		User user = (User)sess.getAttribute("USER");
		UserDao selectny = new UserDao();
		List<IndentInfo> ny = selectny.selectNy(user.getUser_id());
		
		if(ny == null){
			System.out.println("查询出错");
		}else{
			request.setAttribute("NY", ny);
			request.getRequestDispatcher("user/UserIndentShow.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
