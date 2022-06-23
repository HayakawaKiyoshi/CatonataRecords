package com.catonata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		final String PRO_REGISTER_SQL = "INSERT INTO PRODUCT_TABLE VALUES (?,?,?,?,?,?,?,?)";

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
			ps.setString(7, form.getSold());
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

	public void productUpdate(ProductForm update) {
		Connection conn = null;
		PreparedStatement ps = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn();

			final String SQL = "UPDATE PRODUCT_TABLE \r\n"
					+ "SET ARTIST = ?, MEDIA = ?,PRICE = ?,\r\n"
					+ "RELEASE_DATE= ?, LABEL= ?,SOLD = ?,STOCK =? \r\n"
					+ "WHERE PROD_NAME = ?";
			ps = conn.prepareStatement(SQL);
			//引数を?にバインド
			ps.setString(1, update.getArtist());
			ps.setString(2, update.getMedia());
			ps.setString(3, update.getPrice());
			ps.setString(4, update.getRelease_date());
			ps.setString(5, update.getLabel());
			ps.setString(6, update.getSold());
			ps.setString(7, update.getStock());
			ps.setString(8, update.getPro_name());
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static ProductForm profind(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		final String LOGIN_SQL = "SELECT * FROM PRODUCT_TABLE WHERE PROD_NAME = ?";

		ProductForm form = null;

		try {
			conn = manager.getConn();
			ps = conn.prepareStatement(LOGIN_SQL);
			//引数を?にバインド
			ps.setString(1, name);
			rs = ps.executeQuery();

			if (rs.next()) {

				form = new ProductForm();
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

}
