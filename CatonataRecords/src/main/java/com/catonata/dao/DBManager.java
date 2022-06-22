package com.catonata.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データベースと接続するクラス
 * @author akutsu
 *
 */
public class DBManager {
	/**
	 * DBと接続する
	 *
	 * @return DBコネクション
	* @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public Connection getConn() throws ClassNotFoundException, SQLException {

		// JDBCドライバクラスをJVMに登録
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// DBへ接続
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE",
				"catonatarecords", "catonata0630");
		System.out.println("接続されました");

		return conn;
	}

	/**
	 * DB接続を切断する
	 *
	 * @param conn
	 * DBコネクション
	 */
	public void close(Connection conn) {
		try {
			// 切断処理
			if (conn != null) {
				conn.close();
				System.out.println("切断");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
