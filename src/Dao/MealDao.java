package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Meal;
import DBUtil.LoginMysql;

public class MealDao {
	Connection conn = LoginMysql.conn();
	
	/**
	 * 查询菜品用菜系id
	 * @param styletype_int
	 * @return 此菜系菜品列表
	 */
	public List<Meal> getMealList(int styletype_int) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `meal` WHERE `meal`.meal_id = ?";
		PreparedStatement prep = null;
		ResultSet re = null;
		List<Meal> meallist = null;
		try {
			prep= conn.prepareStatement(sql);
			prep.setInt(1, styletype_int);
			re= prep.executeQuery();
			meallist = new ArrayList<Meal>();
			while(re.next()){
				Meal meal = new Meal();
				meal.setMeal_description(re.getString("meal_description"));
				meal.setMeal_id(re.getInt("meal_id"));
				meal.setMeal_img(re.getString("meal_img"));
				meal.setMeal_name(re.getString("meal_name"));
				meal.setMeal_NY(re.getString("meal_NY"));
				meal.setMeal_price(re.getFloat("meal_price"));
				meal.setStyle_id(re.getInt("style_id"));
				meallist.add(meal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meallist;
	}
	
	/**
	 * 删除一个菜品用其id
	 * @param meal_id_int	菜品id
	 * @return 返回是否删除成功
	 */
	public int hotelDelectMeal(int meal_id_int) {
		// TODO Auto-generated method stub
		String sql = "";
		PreparedStatement prep = null;
		int re = 0;
		try {
			prep= conn.prepareStatement(sql);
			prep.setInt(1, meal_id_int);
			re = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

}
