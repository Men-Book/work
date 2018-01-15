package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.IndentInfo;
import Dao.HotelDao;

@WebServlet("/HotelSelectIndentServlet")
public class HotelSelectIndentServlet extends HttpServlet {
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
		List<IndentInfo> indentinfolist = hoteldao.selectAllIndent();
		if(indentinfolist == null){
			System.out.println("查询出错");
		}else{
			request.setAttribute("NY", indentinfolist);
			request.getRequestDispatcher("hotel/HotelIndentShow.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
