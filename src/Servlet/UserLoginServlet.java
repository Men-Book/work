package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Hotel;
import Bean.Meal;
import Bean.Style;
import Bean.User;
import Dao.HotelDao;
import Dao.MealDao;
import Dao.StyleDao;
import Dao.UserDao;
@WebServlet("/UserLonginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("login_name");
		String pwd = request.getParameter("login_pwd");
		String type = request.getParameter("type");
		
		if(type.equals("1")){
			// 用户登录
			User user = new User();
			user.setUser_name(name);
			user.setUser_pwd(pwd);	
			UserDao userdao = new UserDao();
			User gay = userdao.userLogin_namepwd(user);
			if(gay == null){
				// 返回用户名或用户密码错误
			}else{
				//返回登录成功，跳转到详情显示页面userShow.jspa
				HttpSession sess = request.getSession();
				sess.setAttribute("USER", gay);
				String styletype = request.getParameter("styletype");
				int styletype_int = 0;
				if(styletype == null || "".equals(styletype)){
					styletype_int = 1;
				}else{
					styletype_int = Integer.valueOf(styletype);
				}
				MealDao mealdao = new MealDao();
				List<Meal> meallist = mealdao.getMealList(styletype_int);
				if(meallist == null){
					// 无菜或错误
				}else{
					sess.setAttribute("MEALLIST", meallist);
				}
				StyleDao styledao = new StyleDao();
				List<Style>stylelist = styledao.getStyleList();
				if(stylelist == null){
					// 无菜品
				}else{
					sess.setAttribute("STYLELIST", stylelist);
				}
				response.sendRedirect(request.getContextPath() + "/user/usershow.jsp");
			}
		}else if(type.equals("2")){
			// 管理员登录
			Hotel hotel = new Hotel();
			hotel.setHotel_name(name);
			hotel.setHotel_pwd(pwd);
			HotelDao hoteldao = new HotelDao();
			Hotel login_hotel = hoteldao.LoginHotel_namepwd(hotel);
			if(login_hotel == null){
				// 用户名密码错误
			}else{
				//返回登录成功，跳转到详情显示页面userShow.jspa
				HttpSession sess = request.getSession();
				sess.setAttribute("HOTEL", login_hotel);
				String styletype = request.getParameter("styletype");
				int styletype_int = 0;
				if(styletype == null || "".equals(styletype)){
					styletype_int = 1;
				}else{
					styletype_int = Integer.valueOf(styletype);
				}
				MealDao mealdao = new MealDao();
				List<Meal> meallist = mealdao.getMealList(styletype_int);
				if(meallist == null){
					// 无菜或错误
				}else{
					sess.setAttribute("MEALLIST", meallist);
				}
				StyleDao styledao = new StyleDao();
				List<Style>stylelist = styledao.getStyleList();
				if(stylelist == null){
					// 无菜品
				}else{
					sess.setAttribute("STYLELIST", stylelist);
				}
				response.sendRedirect(request.getContextPath() + "/hotel/HotelMealShow.jsp");
			}
		}else{
			// 跳转提示选择登陆选项
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
