package com.catonata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public void productUpdate(ProductForm form) {
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
			ps.setString(1, form.getArtist());
			ps.setString(2, form.getMedia());
			ps.setString(3, form.getPrice());
			ps.setString(4, form.getRelease_date());
			ps.setString(5, form.getLabel());
			ps.setString(6, form.getSold());
			ps.setString(7, form.getStock());
			ps.setString(8, form.getPro_name());
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
