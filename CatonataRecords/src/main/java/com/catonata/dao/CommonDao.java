package com.catonata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.catonata.bean.UserInformationBean;


public class CommonDao {

	public static UserInformationBean find(String name,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		final String LOGIN_SQL = "SELECT * FROM USER_TABLE WHERE user_name = ? AND password = ?";

		UserInformationBean user = null;

		try {
			conn = manager.getConn();
			ps = conn.prepareStatement(LOGIN_SQL);
			//引数を?にバインド
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				String id = rs.getString("ID");
				String pass = rs.getString("PASSWORD");
				String username = rs.getString("USER_NAME");
				String age = rs.getString("AGE");
				String gender = rs.getString("GENDER");
				String birthday = rs.getString("BIRTHDAY");
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

//	public static List<ProductBean> allProduct() {
//
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		DBManager manager = new DBManager();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//		Sql sql = new Sql();
//
//		//ArrayListを初期化
//		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();
//
//		try {
//			conn = manager.getConn();
//
//			ps = conn.prepareStatement(sql.getALLDISPSQL());
//			rs = ps.executeQuery();
//
//			//結果をuserインスタンスに設定し、
//			//ArrayListインスタンスに追加
//			while (rs.next()) {
//				String empid = rs.getString("emp_id");
//				String pass = rs.getString("emp_pass");
//				String empname = rs.getString("emp_name");
//				String gender;
//				if (rs.getString("gender").equals("1")) {
//					gender = "男";
//				} else {
//					gender = "女";
//				}
//				String address = rs.getString("adress");
//				String birthday = sdf.format(rs.getDate("birthday"));
//				String authority;
//				if (rs.getString("authority").equals("1")) {
//					authority = "管理者";
//				} else {
//					authority = "一般";
//				}
//				String deptname = rs.getString("dept_name");
//				ProductBean user = new ProductBean(empid, pass, empname, gender, address,
//						birthday, authority, deptname);
//				empList.add(user);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}finally {
//			manager.close(conn);
//		}
//		return empList;
//
//	}

}
