package com.catonata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.catonata.validation.ProductForm;


/**
 * 1.商品登録
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

}
