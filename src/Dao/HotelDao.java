package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Hotel;
import Bean.IndentInfo;
import DBUtil.LoginMysql;

public class HotelDao {
	Connection conn = LoginMysql.conn();
	public Hotel LoginHotel_namepwd(Hotel hotel) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `hotel` WHERE `hotel`.hotel_name = ? AND `hotel`.hotel_pwd = ?";
		String name = hotel.getHotel_name();
		String pwd = hotel.getHotel_pwd();
		PreparedStatement prep = null;
		Hotel login_hotel = null;
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, name);
			prep.setString(2, pwd);
			ResultSet re = prep.executeQuery();
			login_hotel = new Hotel();
			while(re.next()){
				login_hotel.setHotel_address(re.getString("hotel_address"));
				login_hotel.setHotel_description(re.getString("hotel_description"));
				login_hotel.setHotel_id(re.getInt("hotel_id"));
				login_hotel.setHotel_name(name);
				login_hotel.setHotel_pwd(pwd);
				login_hotel.setHotel_tel(re.getString("hotel_tel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return login_hotel;
	}
	
	/**
	 * 查询所有用户的订单
	 * @return 订单列表
	 */
	public List<IndentInfo> selectAllIndent() {
		// TODO Auto-generated method stub
		String sql = "SELECT style_id,indent_id,meal_img,meal_name,user_name,address_name,address_tel,indent_NY,indent_price,indent_time,indent_txt from  `indent` LEFT JOIN `user` on `indent`.user_id=`user`.user_id LEFT JOIN `meal` on `indent`.meal_id=`meal`.meal_id LEFT JOIN `address` on `indent`.address_id=`address`.address_id ORDER BY `indent`.indent_time  DESC";
		PreparedStatement prep = null;
		List<IndentInfo> indentinfolist = null;
		try {
			prep = conn.prepareStatement(sql);
			ResultSet re = prep.executeQuery();
			indentinfolist = new ArrayList<IndentInfo>();
			while(re.next()){
				IndentInfo indentinfo = new IndentInfo();
				indentinfo.setAddress_name(re.getString("address_name"));
				indentinfo.setAddress_tel(re.getString("address_tel"));
				indentinfo.setIndent_id(re.getInt("indent_id"));
				indentinfo.setIndent_NY(re.getString("indent_NY"));
				indentinfo.setIndent_price(re.getFloat("indent_price"));
				indentinfo.setIndent_time(re.getString("indent_time"));
				indentinfo.setIndent_txt(re.getString("indent_txt"));
				indentinfo.setMeal_name(re.getString("meal_name"));
				indentinfo.setUser_name(re.getString("user_name"));
				indentinfo.setMeal_img(re.getString("meal_img"));
				indentinfo.setStyle_id(re.getInt("style_id"));
				indentinfolist.add(indentinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indentinfolist;
	}

	/**
	 * 修改商家信息
	 * @param hotel	传进商家信息
	 * @return
	 */
	public int hotelUpdate(Hotel hotel) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `hotel` SET `hotel_name`=?, `hotel_tel`=?, `hotel_address`=?, `hotel_description`=?, `hotel_pwd`=? WHERE (`hotel_id`='1')";
		String hotel_name = hotel.getHotel_name();
		String hotel_tel = hotel.getHotel_tel();
		String hotel_address = hotel.getHotel_address();
		String hotel_description = hotel.getHotel_description();
		String hotel_pwd = hotel.getHotel_pwd();
		
		PreparedStatement prep = null;
		int re = 0;
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, hotel_name);
			prep.setString(2, hotel_tel);
			prep.setString(3, hotel_address);
			prep.setString(4, hotel_description);
			prep.setString(5, hotel_pwd);
			re = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	/**
	 * 查询商家信息，但是此时是没有多个商家的，所有没有传进参数
	 * @return
	 */
	public Hotel getHotelinformation() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `hotel`";
		PreparedStatement prep = null;
		Hotel hotelinformation = null;
		try {
			prep= conn.prepareStatement(sql);
			ResultSet re = prep.executeQuery();
			hotelinformation = new Hotel();
			while(re.next()){
				hotelinformation.setHotel_address(re.getString("hotel_address"));
				hotelinformation.setHotel_description(re.getString("hotel_description"));
				hotelinformation.setHotel_id(re.getInt("hotel_id"));
				hotelinformation.setHotel_name(re.getString("hotel_name"));
				hotelinformation.setHotel_pwd(re.getString("hotel_pwd"));
				hotelinformation.setHotel_tel(re.getString("hotel_tel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotelinformation;
	}

}
