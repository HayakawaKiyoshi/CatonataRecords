package com.catonata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.catonata.bean.ProductBean;
import com.catonata.validation.ProductForm;


/**
 * 1.productRegister()：商品登録
 * 2.productUpdate()：商品更新
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
					+ "SET ARTIST = ?, MEDIA = ?,PRICE = ?,\r\n"
					+ "RELEASE_DATE= ?, LABEL= ?,SOLD = ?,STOCK =?,PROD_NAME = ? \r\n"
					+ "WHERE PROD_ID = ?";
			ps = conn.prepareStatement(PRO_UPDATE_SQL);
			//引数を?にバインド
			ps.setString(1, update.getArtist());
			ps.setString(2, update.getMedia());
			ps.setString(3, update.getPrice());
			ps.setString(4, update.getRelease_date());
			ps.setString(5, update.getLabel());
			ps.setString(6, update.getSold());
			ps.setString(7, update.getStock());
			ps.setString(8, update.getPro_name());
			ps.setString(9, update.getPro_id());
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static ProductBean profind(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		final String PROD_NAME_SQL = "SELECT * FROM PRODUCT_TABLE WHERE PROD_ID = ?";

		ProductBean form = null;

		try {
			conn = manager.getConn();
			ps = conn.prepareStatement(PROD_NAME_SQL);
			//引数を?にバインド
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {

				form = new ProductBean();
				form.setPro_id(rs.getString("PROD_ID"));
				form.setPro_name(rs.getString("PROD_NAME"));
				form.setArtist(rs.getString("ARTIST"));
				form.setMedia(rs.getString("MEDIA"));
				form.setPrice(rs.getString("PRICE"));
				form.setRelease_date(rs.getString("RELEASE_DATE"));
				form.setLabel(rs.getString("LABEL"));
				form.setSold(rs.getString("SOLD"));
				form.setStock(rs.getString("STOCK"));
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
	 * 削除するメソッド
	 * @param user
	 */

	public static void productDelete(ProductForm form) {
		Connection conn = null;
		PreparedStatement ps = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn();
			final String PRO_DELETE_SQL = "DELETE FROM PRODUCT_FORM WHERE PROD_ID = ? ";
			ps = conn.prepareStatement(PRO_DELETE_SQL);
			//引数を?にバインド
			ps.setString(1, form.getPro_id());
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
