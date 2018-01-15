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
import Bean.Meal;
import Bean.Style;
import Bean.User;
import Dao.UserDao;
@WebServlet("/CreateIndentServlet")
public class CreateIndentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		String indent_txt = request.getParameter("indent_txt");
		int type_int = 0;
		if(type == null || "".equals(type)){
			// 跳转添加地址
			type_int = 1;
		}else{
			type_int = Integer.valueOf(type);
		}
		HttpSession sess = request.getSession();
		Style style = (Style)sess.getAttribute("STYLE");
		Meal meal = (Meal)sess.getAttribute("MEAL");
		User user = (User)sess.getAttribute("USER");
		UserDao createnewindent = new UserDao();
		int gay = createnewindent.createNewIndent(user,style,meal,type_int,indent_txt);
		if(gay == 0){
			//订单失败
		}else{
			//订单成功
			IndentInfo only_ny = createnewindent.selectNewIndent(user.getUser_id());
			request.setAttribute("ONLY", only_ny);
			request.getRequestDispatcher("user/UserIndentSuccess.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
