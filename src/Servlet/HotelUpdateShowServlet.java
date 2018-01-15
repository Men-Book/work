package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Hotel;
import Dao.HotelDao;
import net.sf.json.JSONArray;

@WebServlet("/HotelUpdateShowServlet")
public class HotelUpdateShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HotelDao hoteldao = new HotelDao();
		Hotel hotleinformation = hoteldao.getHotelinformation();
		if(hotleinformation == null){
			// 返回商家信息失败
		}else{
			// 返回成功存入request
			JSONArray json = JSONArray.fromObject(hotleinformation);
			PrintWriter out = response.getWriter();
			out.print(json);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
