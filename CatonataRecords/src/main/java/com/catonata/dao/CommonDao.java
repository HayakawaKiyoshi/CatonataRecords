package com.catonata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.catonata.bean.ProductBean;
import com.catonata.bean.UserInformationBean;


public class CommonDao {

	/**
	 * 名前とパスワードからユーザー情報を検索するメソッド
	 * @param name
	 * @param password
	 * @return
	 */
	public static UserInformationBean find(String name,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		final String LOGIN_SQL = "SELECT ID,PASSWORD,USER_NAME,AGE,GENDER, TO_CHAR(birthday, 'YYYY/MM/DD') AS \"birth\",ADDRESS,EMAIL,AUTHORITY,CREDIT_NUMBER,SPAN,SECURITY_CODE,BANK_NUMBER,BANK_NAME,LABEL FROM USER_TABLE WHERE user_name = ? AND password = ?";

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
				String birthday = rs.getString("birth");
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
	/**
	 * ID,名前,パスワードからユーザー情報を検索するメソッド
	 * @param userid
	 * @param name
	 * @param password
	 * @return
	 */

	public static UserInformationBean findId(String userid,String name,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		final String LOGIN_SQL = "SELECT ID,PASSWORD,USER_NAME,AGE,GENDER, TO_CHAR(birthday, 'YYYY/MM/DD') AS \"birth\",ADDRESS,EMAIL,AUTHORITY,CREDIT_NUMBER,SPAN,SECURITY_CODE,BANK_NUMBER,BANK_NAME,LABEL FROM USER_TABLE WHERE id = ? AND user_name = ? AND password = ?";

		UserInformationBean user = null;

		try {
			conn = manager.getConn();
			ps = conn.prepareStatement(LOGIN_SQL);
			//引数を?にバインド
			ps.setString(1, userid);
			ps.setString(2, name);
			ps.setString(3, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				String id = rs.getString("ID");
				String pass = rs.getString("PASSWORD");
				String username = rs.getString("USER_NAME");
				String age = rs.getString("AGE");
				String gender = rs.getString("GENDER");
				String birthday = rs.getString("birth");
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
	/**
	 * 商品情報の全件表示
	 */

//	public static List<ProductBean> findAll() {
//
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		DBManager manager = new DBManager();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//
//		//ArrayListを初期化
//		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();
//
//		try {
//			conn = manager.getConn();
//
//			final String SQL = "SELECT * FROM PRODUCT_TABLE";
//			ps = conn.prepareStatement(SQL);
//			rs = ps.executeQuery();
//
//			//結果をuserインスタンスに設定し、
//			//ArrayListインスタンスに追加
//			while (rs.next()) {
//				String proid = rs.getString("PROD_ID");
//				String proname = rs.getString("PROD_NAME");
//				String artist = rs.getString("ARTIST");
//				String media = rs.getString("MEDIA");
//				String price = rs.getString("PRICE");
//				String releasedate = sdf.format(rs.getDate("RELEASE_DATE"));
//				String label = rs.getString("LABEL");
//				String sold = rs.getString("SOLD");
//				String stock = rs.getString("STOCK");
//				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
//						releasedate, label, sold, stock);
//				empList.add(bean);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//		return empList;
//
//	}
	/**
	 * 商品情報の全件表示
	 * @return
	 */

	public static List<ProductBean> allProduct() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		//ArrayListを初期化
		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();

		try {
			conn = manager.getConn();

			final String SQL = "SELECT * FROM PRODUCT_TABLE";
			ps = conn.prepareStatement(SQL);
			//引数を?にバインド
			rs = ps.executeQuery();

			//結果をuserインスタンスに設定し、
			//ArrayListインスタンスに追加
			while (rs.next()) {
				String proid = rs.getString("PROD_ID");
				String proname = rs.getString("PROD_NAME");
				String artist = rs.getString("ARTIST");
				String media = rs.getString("MEDIA");
				String price = rs.getString("PRICE");
				String releasedate = sdf.format(rs.getDate("RELEASE_DATE"));
				String label = rs.getString("LABEL");
				String sold = rs.getString("SOLD");
				String stock = rs.getString("STOCK");
				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
						releasedate, label, sold, stock);
				empList.add(bean);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;

	}

	/**
	 * アーティスト名と商品名から商品情報を検索
	 * @param msg
	 * @return
	 */
	public static List<ProductBean> proSearch(String msg) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		//ArrayListを初期化
		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();

		try {
			conn = manager.getConn();
			final String SQL = "SELECT * FROM PRODUCT_TABLE WHERE ARTIST LIKE ? OR PROD_NAME LIKE ?";
			ps = conn.prepareStatement(SQL);
			//引数を?にバインド
			ps.setString(1,"%" + msg + "%");
			ps.setString(2,"%" + msg + "%");
			rs = ps.executeQuery();
			rs = ps.executeQuery();

			//結果をuserインスタンスに設定し、
			//ArrayListインスタンスに追加
			while (rs.next()) {
				String proid = rs.getString("PROD_ID");
				String proname = rs.getString("PROD_NAME");
				String artist = rs.getString("ARTIST");
				String media = rs.getString("MEDIA");
				String price = rs.getString("PRICE");
				String releasedate = sdf.format(rs.getDate("RELEASE_DATE"));
				String label = rs.getString("LABEL");
				String sold = rs.getString("SOLD");
				String stock = rs.getString("STOCK");
				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
						releasedate, label, sold, stock);
				empList.add(bean);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;

	}

	/**
	 * 商品媒体から商品情報を検索
	 * @param msg
	 * @return
	 */
	public static List<ProductBean> proSearchCategory(String msg) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		//ArrayListを初期化
		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();

		try {
			conn = manager.getConn();
			final String SQL = "SELECT * FROM PRODUCT_TABLE WHERE MEDIA LIKE ?";
			ps = conn.prepareStatement(SQL);
			//引数を?にバインド
			ps.setString(1,"%" + msg + "%");
			rs = ps.executeQuery();
			rs = ps.executeQuery();

			//結果をuserインスタンスに設定し、
			//ArrayListインスタンスに追加
			while (rs.next()) {
				String proid = rs.getString("PROD_ID");
				String proname = rs.getString("PROD_NAME");
				String artist = rs.getString("ARTIST");
				String media = rs.getString("MEDIA");
				String price = rs.getString("PRICE");
				String releasedate = sdf.format(rs.getDate("RELEASE_DATE"));
				String label = rs.getString("LABEL");
				String sold = rs.getString("SOLD");
				String stock = rs.getString("STOCK");
				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
						releasedate, label, sold,stock);
				empList.add(bean);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;

	}

	/**
	 * 商品情報とアーティスト名と商品名から商品情報の検索
	 * @param msg
	 * @param category
	 * @return
	 */
	public static List<ProductBean> proCategory(String msg,String category) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		//ArrayListを初期化
		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();

		try {
			conn = manager.getConn();
			final String SQL = "SELECT * FROM PRODUCT_TABLE WHERE MEDIA = ? AND (ARTIST LIKE ? OR PROD_NAME LIKE ?)";
			ps = conn.prepareStatement(SQL);
			//引数を?にバインド
			ps.setString(1,category);
			ps.setString(2,"%" + msg + "%");
			ps.setString(3,"%" + msg + "%");
			rs = ps.executeQuery();
			rs = ps.executeQuery();

			//結果をuserインスタンスに設定し、
			//ArrayListインスタンスに追加
			while (rs.next()) {
				String proid = rs.getString("PROD_ID");
				String proname = rs.getString("PROD_NAME");
				String artist = rs.getString("ARTIST");
				String media = rs.getString("MEDIA");
				String price = rs.getString("PRICE");
				String releasedate = sdf.format(rs.getDate("RELEASE_DATE"));
				String label = rs.getString("LABEL");
				String sold = rs.getString("SOLD");
				String stock = rs.getString("STOCK");
				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
						releasedate, label, sold, stock);
				empList.add(bean);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;

	}
}



//	public static List<ProductBean> executeOne(String sql,String msg) {
//
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		DBManager manager = new DBManager();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//
//		//ArrayListを初期化
//		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();
//
//		try {
//			conn = manager.getConn();
//			final String SQL = "SELECT * FROM PRODUCT_TABLE WHERE MEDIA LIKE ?";
//			ps = conn.prepareStatement(SQL);
//			//引数を?にバインド
//			ps.setString(1,"%" + msg + "%");
//			rs = ps.executeQuery();
//			rs = ps.executeQuery();
//
//			//結果をuserインスタンスに設定し、
//			//ArrayListインスタンスに追加
//			while (rs.next()) {
//				String proid = rs.getString("PROD_ID");
//				String proname = rs.getString("PROD_NAME");
//				String artist = rs.getString("ARTIST");
//				String media = rs.getString("MEDIA");
//				String price = rs.getString("PRICE");
//				String releasedate = sdf.format(rs.getDate("RELEASE_DATE"));
//				String label = rs.getString("LABEL");
//				String sold = rs.getString("SOLD");
//				String stock = rs.getString("STOCK");
//				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
//						releasedate, label, sold,stock);
//				empList.add(bean);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//		return empList;
//
//	}
//
//	public static List<ProductBean> executeTwo(String sql,String msg) {
//
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		DBManager manager = new DBManager();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//
//		//ArrayListを初期化
//		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();
//
//		try {
//			conn = manager.getConn();
//			final String SQL = "SELECT * FROM PRODUCT_TABLE WHERE ARTIST LIKE ? OR PROD_NAME LIKE ?";
//			ps = conn.prepareStatement(SQL);
//			//引数を?にバインド
//			ps.setString(1,"%" + msg + "%");
//			ps.setString(2,"%" + msg + "%");
//			rs = ps.executeQuery();
//			rs = ps.executeQuery();
//
//			//結果をuserインスタンスに設定し、
//			//ArrayListインスタンスに追加
//			while (rs.next()) {
//				String proid = rs.getString("PROD_ID");
//				String proname = rs.getString("PROD_NAME");
//				String artist = rs.getString("ARTIST");
//				String media = rs.getString("MEDIA");
//				String price = rs.getString("PRICE");
//				String releasedate = sdf.format(rs.getDate("RELEASE_DATE"));
//				String label = rs.getString("LABEL");
//				String sold = rs.getString("SOLD");
//				String stock = rs.getString("STOCK");
//				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
//						releasedate, label, sold, stock);
//				empList.add(bean);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//		return empList;
//
//	}
//	public static List<ProductBean> executeThree(String sql,String msg,String category) {
//
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		DBManager manager = new DBManager();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//
//		//ArrayListを初期化
//		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();
//
//		try {
//			conn = manager.getConn();
//			final String SQL = "SELECT * FROM PRODUCT_TABLE WHERE MEDIA = ? AND (ARTIST LIKE ? OR PROD_NAME LIKE ?)";
//			ps = conn.prepareStatement(SQL);
//			//引数を?にバインド
//			ps.setString(1,category);
//			ps.setString(2,"%" + msg + "%");
//			ps.setString(3,"%" + msg + "%");
//			rs = ps.executeQuery();
//			rs = ps.executeQuery();
//
//			//結果をuserインスタンスに設定し、
//			//ArrayListインスタンスに追加
//			while (rs.next()) {
//				String proid = rs.getString("PROD_ID");
//				String proname = rs.getString("PROD_NAME");
//				String artist = rs.getString("ARTIST");
//				String media = rs.getString("MEDIA");
//				String price = rs.getString("PRICE");
//				String releasedate = sdf.format(rs.getDate("RELEASE_DATE"));
//				String label = rs.getString("LABEL");
//				String sold = rs.getString("SOLD");
//				String stock = rs.getString("STOCK");
//				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
//						releasedate, label, sold, stock);
//				empList.add(bean);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//		return empList;
//
//	}
//
//
//}