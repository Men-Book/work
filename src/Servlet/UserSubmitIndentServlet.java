package Servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Meal;
import Bean.Style;
import Dao.UserDao;
@WebServlet("/UserSubmitIndentServlet")
public class UserSubmitIndentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String string_meal_id = request.getParameter("string_meal_id");
		System.out.println(string_meal_id);
		if(string_meal_id == null || "".equals(string_meal_id)){
			// 返回未点餐或点餐错误
		}else{
			int meal_id = Integer.parseInt(string_meal_id);
			//取出 菜的所有信息
			UserDao userdaoindent = new UserDao();
			Meal meal = userdaoindent.userSubmintIndent_meal(meal_id);
			Style style = userdaoindent.userSubmintIndent_style(meal_id);
			// 往添加session数据添加
			HttpSession sess = request.getSession();
			sess.setAttribute("MEAL", meal);
			sess.setAttribute("STYLE", style);
			response.sendRedirect("UseraddressServlet");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
