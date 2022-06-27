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
import com.catonata.validation.ProductForm;


/**
 * 1.productRegister()：商品登録
 * 2.productUpdate()：商品更新
 * 3.pro_find 商品検索(戻り値ProductBean)
 * 4.profind 商品検索(戻り値ProductForm)
 *
 * @author akutsu
 *
 */

public class ExecDao {
	public static void productRegister(ProductForm form) {
		Connection conn = null;
		PreparedStatement ps = null;
		DBManager manager = new DBManager();
		final String PRO_REGISTER_SQL = "INSERT INTO PRODUCT_TABLE VALUES (pro_seq.nextval,?,?,?,?,?,?,?,?)";

		try {
			conn = manager.getConn();
			ps = conn.prepareStatement(PRO_REGISTER_SQL);
			//引数を?にバインド
			ps.setString(1, form.getPro_name());
			ps.setString(2, form.getArtist());
			ps.setString(3, form.getMedia());
			ps.setString(4, form.getPrice());
			ps.setString(5, form.getRelease_date());
			ps.setString(6, form.getLabel());
			ps.setString(7, "0");
			ps.setString(8, form.getStock());
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			manager.close(conn);
		}
	}

	public static void productUpdate(ProductForm update) {
		Connection conn = null;
		PreparedStatement ps = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn();

			final String PRO_UPDATE_SQL = "UPDATE PRODUCT_TABLE \r\n"
					+ "SET PROD_NAME = ?,ARTIST = ?, MEDIA = ?,PRICE = ?,\r\n"
					+ "RELEASE_DATE= ?, LABEL= ?,SOLD = ?,STOCK =? \r\n"
					+ "WHERE PROD_ID = ?";
			ps = conn.prepareStatement(PRO_UPDATE_SQL);
			//引数を?にバインド
			ps.setString(1, update.getPro_name());
			ps.setString(2, update.getArtist());
			ps.setString(3, update.getMedia());
			ps.setString(4, update.getPrice());
			ps.setString(5, update.getRelease_date());
			ps.setString(6, update.getLabel());
			ps.setString(7, update.getSold());
			ps.setString(8, update.getStock());
			ps.setString(9, update.getPro_id());
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	/**
	 * 商品単体検索
	 * 戻り値の方はProductBean型
	 * @param id
	 * @return
	 */
	public static ProductBean pro_find(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		final String PROD_NAME_SQL = "SELECT * FROM PRODUCT_TABLE WHERE PROD_ID = ?";

		ProductBean pb = new ProductBean();

		try {
			System.out.println(id);
			conn = manager.getConn();
			ps = conn.prepareStatement(PROD_NAME_SQL);
			//引数を?にバインド
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				pb.setPro_id(rs.getString("PROD_ID"));
				pb.setPro_name(rs.getString("PROD_NAME"));
				pb.setArtist(rs.getString("ARTIST"));
				pb.setMedia(rs.getString("MEDIA"));
				pb.setPrice(rs.getString("PRICE"));
				pb.setRelease_date(sdf.format(rs.getDate("RELEASE_DATE")));
				pb.setLabel(rs.getString("LABEL"));
				pb.setSold(rs.getString("SOLD"));
				pb.setStock(rs.getString("STOCK"));

				System.out.println(pb.getArtist());
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
		return pb;

	}

	/**
	 * 商品単体検索
	 * 戻り値の方はProductForm型
	 * @param id
	 * @return
	 */
	public static ProductForm profind(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		final String PROD_NAME_SQL = "SELECT * FROM PRODUCT_TABLE WHERE PROD_ID = ?";

		ProductForm form = null;

		try {
			System.out.println(id);
			conn = manager.getConn();
			ps = conn.prepareStatement(PROD_NAME_SQL);
			//引数を?にバインド
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {

				form = new ProductForm();
				form.setPro_id(rs.getString("PROD_ID"));
				form.setPro_name(rs.getString("PROD_NAME"));
				form.setArtist(rs.getString("ARTIST"));
				form.setMedia(rs.getString("MEDIA"));
				form.setPrice(rs.getString("PRICE"));
				form.setRelease_date(sdf.format(rs.getDate("RELEASE_DATE")));
				form.setLabel(rs.getString("LABEL"));
				form.setSold(rs.getString("SOLD"));
				form.setStock(rs.getString("STOCK"));

				System.out.println(form.getArtist());
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
		return form;

	}

	/**
	 * 商品購入処理
	 * 購入履歴テーブルにデータセット
	 *
	 * @param id
	 * @return
	 */
	public static void purchaseHistory(UserInformationBean LoginUser, ProductBean product
			,String purcahseDate, String delivaryDate) {
		Connection conn = null;
		PreparedStatement ps = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		final String PURCHASEHISTORY_SQL = "INSERT INTO PURCHASE_TABLE VALUES (?,?,?,?,?)";
		try {
			conn = manager.getConn();
			ps = conn.prepareStatement(PURCHASEHISTORY_SQL);
			//引数を?にバインド
			ps.setString(1, LoginUser.getId());
			ps.setString(2, product.getLabel());
			ps.setString(3, purcahseDate);
			ps.setString(4, delivaryDate);
			ps.setString(5, product.getPro_id());
			int cnt =ps.executeUpdate();
			System.out.println(cnt + "件のデータを登録しました。");
			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(conn);
		}
	}

	/**
	 * 在庫数と販売数を更新するメソッド
	 * @param id
	 * @param newStock
	 * @param newSold
	 */
	public static void stockUpdate (String id, String newStock, String newSold) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		try {
			// 接続する
			conn = manager.getConn();
			ps = conn.prepareStatement("UPDATE PRODUCT_TABLE SET"
					+ " SOLD = ?, STOCK = ? WHERE PROD_ID = ?");
			ps.setString(1, newSold);
			ps.setString(2, newStock);
			ps.setString(3, id);
			int cnt =ps.executeUpdate();
			conn.commit();
			System.out.println(cnt + "件のデータを登録しました。");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Oracleエラーコード:" + e.getErrorCode());
			System.err.println("SQLStateコード:" + e.getSQLState());
			System.err.println("エラーメッセージ:" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 切断処理
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * 削除するメソッド
	 * @param user
	 */

	public static void productDelete(String[] id) {
		Connection conn = null;
		PreparedStatement ps = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn();
			final String PRO_DELETE_SQL = "DELETE FROM PRODUCT_TABLE WHERE PROD_ID = ? ";

			for(int i = 0; i < id.length; i++) {
			ps = conn.prepareStatement(PRO_DELETE_SQL);
			//引数を?にバインド
			ps.setString(1, id[i]);
			ps.executeUpdate();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static List<ProductBean> findAll(String labelname) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		//ArrayListを初期化
		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();

		System.out.println(labelname);

		try {
			conn = manager.getConn();

			final String SQL = "SELECT * FROM PRODUCT_TABLE WHERE LABEL = ?";
			ps = conn.prepareStatement(SQL);
			//引数を?にバインド
			ps.setString(1, labelname);
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
				String stock = rs.getString("STOCK");
				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
						releasedate, label, stock);
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

//	/**
//	 * 区間検索
//	 * @param labelname
//	 * @return
//	 */
//	public static List<ProductBean> fromTO(String labelname, String from, String to) {
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
//		System.out.println(labelname);
//
//		try {
//			conn = manager.getConn();
//
//			final String SQL = "SELECT * FROM PRODUCT_TABLE WHERE LABEL = ? AND ()";
//			ps = conn.prepareStatement(SQL);
//			//引数を?にバインド
//			ps.setString(1, labelname);
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
//				String stock = rs.getString("STOCK");
//				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
//						releasedate, label, stock);
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

	public static ArrayList<ProductForm> profind2(String[] id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		final String PROD_NAME_SQL = "SELECT * FROM PRODUCT_TABLE WHERE PROD_ID = ?";

		ArrayList<ProductForm> productList = new ArrayList<ProductForm>();
		ProductForm form = null;

		try {
			System.out.println(id);
			conn = manager.getConn();
			for(int i = 0; i < id.length; i++) {


			ps = conn.prepareStatement(PROD_NAME_SQL);
			//引数を?にバインド
			ps.setString(1, id[i]);
			rs = ps.executeQuery();

			while (rs.next()) {

				form = new ProductForm();
				form.setPro_id(rs.getString("PROD_ID"));
				form.setPro_name(rs.getString("PROD_NAME"));
				form.setArtist(rs.getString("ARTIST"));
				form.setMedia(rs.getString("MEDIA"));
				form.setPrice(rs.getString("PRICE"));
				form.setRelease_date(sdf.format(rs.getDate("RELEASE_DATE")));
				form.setLabel(rs.getString("LABEL"));
				form.setSold(rs.getString("SOLD"));
				form.setStock(rs.getString("STOCK"));
				productList.add(form);

				System.out.println(form.getArtist());
			}
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
		return productList;

	}

	public static List<ProductBean> proSearch(String msg,String labelname) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		//ArrayListを初期化
		ArrayList<ProductBean> empList = new ArrayList<ProductBean>();

		System.out.println(labelname);

		try {
			conn = manager.getConn();

			final String SQL = "SELECT * FROM PRODUCT_TABLE WHERE LABEL = ? AND (ARTIST LIKE ? OR PROD_NAME LIKE ?)";
			ps = conn.prepareStatement(SQL);
			//引数を?にバインド
			ps.setString(1, labelname);
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
				String stock = rs.getString("STOCK");
				ProductBean bean = new ProductBean(proid, proname, artist, media, price,
						releasedate, label, stock);
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

