package com.catonata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.catonata.bean.UserInformationBean;

public class CommonDao {

	public static UserInformationBean find(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		final String LOGIN_SQL = "SELECT * FROM USER_TABLE WHERE user_name = ?";

		UserInformationBean user = null;

		try {
			conn = manager.getConn();
			ps = conn.prepareStatement(LOGIN_SQL);
			//引数を?にバインド
			ps.setString(1, name);
			rs = ps.executeQuery();

			if (rs.next()) {
				String id = rs.getString("ID");
				String pass = rs.getString("PASSWORD");
				String username = rs.getString("USER_NAME");
				String age = rs.getString("AGE");
				String gender = rs.getString("GENDER");
				String birthday = sdf.format(rs.getDate("BIRTHDAY"));
				String address = rs.getString("ADDRESS");
				String email = rs.getString("EMAIL");
				String authority = rs.getString("AUTHORITY");
				String crenum = rs.getString("CREDIT_NUMBER");
				String crespan = rs.getString("SPAN");
				String security = rs.getString("SECURITY_CODE");
				String banknumber = rs.getString("BANK_NUMBER");
				String bankname = rs.getString("BANK_NAME");
				String label = rs.getString("LABEL");

				user = new UserInformationBean(id, pass, username,age, gender,birthday, address,
					email,authority,crenum,crespan,security,label,banknumber,bankname);

			} else {
				return null;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			manager.close(conn);
		}
		return user;

	}

}
