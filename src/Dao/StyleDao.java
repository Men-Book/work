package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Style;
import DBUtil.LoginMysql;

public class StyleDao {
	Connection conn = LoginMysql.conn();
	public List<Style> getStyleList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `style`";
		List<Style> stylelist = null;
		PreparedStatement prep = null;
		ResultSet re = null;
		try {
			prep= conn.prepareStatement(sql);
			re= prep.executeQuery();
			stylelist = new ArrayList<Style>();
			while(re.next()){
				Style style = new Style();
				style.setStyle_description(re.getString("style_description"));
				style.setStyle_id(re.getInt("style_id"));
				style.setStyle_img(re.getString("style_img"));
				style.setStyle_name(re.getString("style_name"));
				stylelist.add(style);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stylelist;
	}

}
