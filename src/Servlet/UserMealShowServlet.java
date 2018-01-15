package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Meal;
import Bean.Style;
import Dao.MealDao;
import Dao.StyleDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/UserMealShowServlet")
public class UserMealShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf8");
		String style_id_str = request.getParameter("style_id");
		int style_id = Integer.valueOf(style_id_str);
		HttpSession sess = request.getSession();
		MealDao mealdao = new MealDao();
		List<Meal> meallist = mealdao.getMealList(style_id);
		if(meallist == null){
			// 无菜或错误
		}else{
			sess.setAttribute("MEALLIST", meallist);
		}
		JSONArray json = JSONArray.fromObject(meallist);
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
