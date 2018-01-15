package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import Bean.Address;
import Bean.IndentInfo;
import Bean.Meal;
import Bean.Style;
import Bean.User;
import DBUtil.LoginMysql;
/**
 * 用户操作数据库的所有方法
 * @author I-CAN
 *
 */
public class UserDao {
	Connection conn = LoginMysql.conn();
	
	/**
	 * 返回用户名是否存在
	 * @param user
	 * @return
	 */
	public ResultSet userLogin_name(User user) {
		// TODO Auto-generated method stub
		String user_name = user.getUser_name();
		String sql = "SELECT * FROM `user` WHERE `user_name` = ?";
		PreparedStatement prep = null;
		ResultSet re = null;
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, user_name);
			re = prep.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	/**
	 * 返回用户信息的一个对象
	 * @param user
	 * @return
	 */
	public User userLogin_namepwd(User user) {
		// TODO Auto-generated method stub
		String user_name = user.getUser_name();
		String user_pwd = user.getUser_pwd();
		String sql = "SELECT * FROM `user` WHERE `user_name` = ? and `user_pwd` = ?";
		
		PreparedStatement prep = null;
		ResultSet re = null;
		User login_user = null;
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, user_name);
			prep.setString(2, user_pwd);
			re = prep.executeQuery();
			while(re.next()){
				login_user = new User();
				login_user.setUser_id(re.getInt("user_id"));
				login_user.setUser_name(user_name);
				login_user.setUser_pwd(user_pwd);
				login_user.setUser_tel(re.getString("user_tel"));
				login_user.setUser_img(re.getString("user_img"));
				login_user.setUser_address(re.getString("user_address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return login_user;
	}

	/**
	 * 用户提交订单后返回的菜的信息，为一个菜对象
	 * @param meal_id
	 * @return
	 */
	public Meal userSubmintIndent_meal(int meal_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `meal` WHERE `meal`.meal_id = ?";
		PreparedStatement prep = null;
		ResultSet re = null;
		Meal meal = null;
		try {
			prep = conn.prepareStatement(sql);
			prep.setInt(1, meal_id);
			re= prep.executeQuery();
			meal = new Meal();
			while(re.next()){
				meal.setMeal_id(meal_id);
				meal.setMeal_name(re.getString("meal_name"));
				meal.setMeal_img(re.getString("meal_img"));
				meal.setMeal_description("meal_desciption");
				meal.setMeal_NY(re.getString("meal_NY"));
				meal.setMeal_price(re.getFloat("meal_price"));
				meal.setStyle_id(re.getInt("style_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meal;
	}

	/**
	 * 返回用户关联的所有订餐地址
	 * @param user
	 * @return
	 */
	public List<Address> getUserAddressList(User user) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `address` WHERE `address`.user_id = ?";
		PreparedStatement prep = null;
		ResultSet re = null;
		List<Address> addresslist = null;
		try {
			prep = conn.prepareStatement(sql);
			prep.setInt(1, user.getUser_id());
			re = prep.executeQuery();			
			addresslist = new ArrayList<Address>();
			while(re.next()){
				Address address = new Address();
				address.setAddress_id(re.getInt("address_id"));
				address.setAddress_name(re.getString("address_name"));
				address.setAddress_tel(re.getString("address_tel"));
				address.setUser_id(user.getUser_id());
				addresslist.add(address);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addresslist;
	}

	public Style userSubmintIndent_style(int meal_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT `style_name` FROM `meal` LEFT JOIN `style` ON `meal`.style_id = `style`.style_id WHERE `meal`.meal_id = ?";
		PreparedStatement prep = null;
		Style style = null;
		try {
			prep= conn.prepareStatement(sql);
			prep.setInt(1, meal_id);
			ResultSet re = prep.executeQuery();
			style = new Style();
			while(re.next()){
				style.setStyle_name(re.getString("style_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return style;
	}

	/**
	 * 新建订单的插入
	 * @param user 用户对象
	 * @param style 菜系对象，只有菜系名
	 * @param meal 菜品对象
	 * @param type_int 地址id
	 * @param indent_txt 
	 * @return 返回执行是否成功
	 */
	public int createNewIndent(User user, Style style, Meal meal, int type_int, String indent_txt) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `indent` (`user_id`, `meal_id`, `address_id`, `indent_price`, `indent_txt`, `indent_time`) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement prep = null;
		int re = 0;
		try {
			prep= conn.prepareStatement(sql);
			prep.setInt(1, user.getUser_id());
			prep.setInt(2, meal.getMeal_id());
			prep.setInt(3, type_int);
			prep.setFloat(4, meal.getMeal_price());
			prep.setString(5, indent_txt);
			prep.setString(6, new Date().toLocaleString());
			re = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	/**
	 * 获取用户所有的订单
	 * @param user_id 传进来的是用户的id
	 * @return 返回的是用户所有订单的列表list
	 */
	public List<IndentInfo> selectNy(int user_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT indent_id,meal_img,meal_name,user_name,address_name,address_tel,indent_NY,indent_price,indent_time,indent_txt from  `indent` LEFT JOIN `user` on `indent`.user_id=`user`.user_id LEFT JOIN `meal` on `indent`.meal_id=`meal`.meal_id LEFT JOIN `address` on `indent`.address_id=`address`.address_id WHERE `indent`.user_id=? ORDER BY `indent`.indent_time  DESC";
		PreparedStatement prep = null;
		List<IndentInfo> indentinfolist = null;
		try {
			prep = conn.prepareStatement(sql);
			prep.setInt(1, user_id);
			ResultSet re = prep.executeQuery();
			indentinfolist = new ArrayList<IndentInfo>();
			while(re.next()){
				IndentInfo indentinfo = new IndentInfo();
				indentinfo.setAddress_name(re.getString("address_name"));
				indentinfo.setAddress_tel(re.getString("address_tel"));
				indentinfo.setIndent_NY(re.getString("indent_NY"));
				indentinfo.setIndent_id(re.getInt("indent_id"));
				indentinfo.setIndent_price(re.getFloat("indent_price"));
				indentinfo.setIndent_time(re.getString("indent_time"));
				indentinfo.setIndent_txt(re.getString("indent_txt"));
				indentinfo.setMeal_name(re.getString("meal_name"));
				indentinfo.setUser_name(re.getString("user_name"));
				indentinfo.setMeal_img(re.getString("meal_img"));
				indentinfolist.add(indentinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indentinfolist;
	}

	public IndentInfo selectNewIndent(int user_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT meal_img,meal_name,user_name,address_name,address_tel,indent_NY,indent_price,indent_time,indent_txt from  `indent` LEFT JOIN `user` on `indent`.user_id=`user`.user_id LEFT JOIN `meal` on `indent`.meal_id=`meal`.meal_id LEFT JOIN `address` on `indent`.address_id=`address`.address_id WHERE `indent`.user_id=? ORDER BY `indent`.indent_time  DESC LIMIT 0,1";
		PreparedStatement prep = null;
		IndentInfo indentinfo = null;
		try {
			prep = conn.prepareStatement(sql);
			prep.setInt(1, user_id);
			ResultSet re = prep.executeQuery();
			indentinfo = new IndentInfo();
			while(re.next()){
				indentinfo.setAddress_name(re.getString("address_name"));
				indentinfo.setAddress_tel(re.getString("address_tel"));
				indentinfo.setIndent_NY(re.getString("indent_NY"));
				indentinfo.setIndent_price(re.getFloat("indent_price"));
				indentinfo.setIndent_time(re.getString("indent_time"));
				indentinfo.setIndent_txt(re.getString("indent_txt"));
				indentinfo.setMeal_name(re.getString("meal_name"));
				indentinfo.setUser_name(re.getString("user_name"));
				indentinfo.setMeal_img(re.getString("meal_img"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indentinfo;
	}

	

}
