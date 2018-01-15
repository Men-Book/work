package Servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Hotel;
import Dao.HotelDao;
@WebServlet("/HotelUpdateServlet")
public class HotelUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hotel_name = request.getParameter("hotel_name");
		String hotel_tel = request.getParameter("hotel_tel");
		String hotel_address = request.getParameter("hotel_address");
		String hotel_description = request.getParameter("hotel_description");
		String hotel_pwd = request.getParameter("hotel_pwd");
		
		Hotel hotel = new Hotel();
		hotel.setHotel_address(hotel_address);
		hotel.setHotel_description(hotel_description);
		hotel.setHotel_name(hotel_name);
		hotel.setHotel_pwd(hotel_pwd);
		hotel.setHotel_tel(hotel_tel);
		
		HotelDao hoteldao = new HotelDao();
		int gay = hoteldao.hotelUpdate(hotel);
		if(gay == 0){
			//修改失败
			
		}else{
			response.sendRedirect("HotelUpdateShowServlet");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
