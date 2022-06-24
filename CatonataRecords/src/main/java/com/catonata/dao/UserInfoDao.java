package com.catonata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.catonata.bean.ExecInformationBean;
import com.catonata.bean.UserInformationBean;
import com.catonata.validation.ExecInformationForm;
import com.catonata.validation.UserInformationForm;

/**
 * ユーザー情報を処理するDAOのクラス
 *
 * 目次
 * >登録
 * insert 引き数二つの登録
 * adminInsert 引数一つの管理者用登録
 * execInsert 引数一つの管理者用経営者登録
 * >更新
 * update 引数二つの変更
 * adminUpdate 引数一つの管理者用変更
 * execUpdate 引数一つの管理者用経営者変更
 * >削除
 * delete 引数二つの削除
 * adminDelete 引数一つの管理者用削除
 * execDelete 引数一つの管理者用経営者削除
 * >全件検索
 * allGeneralUserSearch 一般者全件検索
 * allExecUserSearch 経営者全件検索
 *
 * @author 伊藤 馨
 *
 */
public class UserInfoDao {

	/**
	 * 管理者用一般登録メソッド
	 *
	 * @param uif クレカ情報以外の基本情報の入ったフォーム
	 */
	public static void adminInsert (UserInformationForm uif) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		try {
			// 接続する
			conn = manager.getConn();
			ps = conn.prepareStatement("INSERT INTO USER_TABLE VALUES (user_seq.nextval,"
					+ "?, ? , ? , ? , ? , ? , ?, ?, ?, ? , ?, ?, ?, ?)");
			ps.setString(1, uif.getPassword());
			ps.setString(2, uif.getName());
			ps.setString(3, uif.getAge());
			ps.setString(4, uif.getGender());
			ps.setString(5, uif.getBirthday());
			ps.setString(6, uif.getAddress());
			ps.setString(7, uif.getEmail());
			ps.setString(8, "1");
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
	 * 管理者用経営者登録メソッド
	 *
	 * @param uif 経営者の基本情報が入ったフォーム
	 */
	public static void execInsert (ExecInformationForm eif) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		try {
			// 接続する
			conn = manager.getConn();
			ps = conn.prepareStatement("INSERT INTO USER_TABLE VALUES (user_seq.nextval,"
					+ "?, ? , ? , ? , ? , ? , ?, ?, ?, ? , ?, ?, ?, ?)");
			ps.setString(1, eif.getPassword());
			ps.setString(2, eif.getName());
			ps.setString(6, eif.getAddress());
			ps.setString(7, eif.getEmail());
			ps.setString(13, eif.getBanknumber());
			ps.setString(14, eif.getBankname());
			ps.setString(15, eif.getLabel());
			ps.setString(8, "3");
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
	 * 管理者用一般更新メソッド
	 * @param uif
	 */
	public static void adminUpdate (UserInformationForm uif) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		try {
			// 接続する
			conn = manager.getConn();
			ps = conn.prepareStatement("UPDATE USER_TABLE SET PASSWORD = ?,"
					+ "USER_NAME = ? , AGE = ? , GENDER = ? , BIRTHDAY = ? ,"
					+ "ADDRESS = ? , EMAIL = ?"
					+ " WHERE USER_ID = ?");
			ps.setString(1, uif.getPassword());
			ps.setString(2, uif.getName());
			ps.setString(3, uif.getAge());
			ps.setString(4, uif.getGender());
			ps.setString(5, uif.getBirthday());
			ps.setString(6, uif.getAddress());
			ps.setString(7, uif.getEmail());
			ps.setString(8, uif.getId());
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
	 * 管理者用経営者情報更新メソッド
	 * @param uif
	 */
	public static void execUpdate (ExecInformationForm eif) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		try {
			// 接続する
			conn = manager.getConn();
			ps = conn.prepareStatement("UPDATE USER_TABLE SET PASSWORD = ? ,"
					+ "USER_NAME = ? , ADDRESS = ? , EMAIL = ? , BANKNUMBER = ? ,"
					+ "BANKNAME = ? , LABEL = ? , USER_ID = ?");
			ps.setString(1, eif.getPassword());
			ps.setString(2, eif.getName());
			ps.setString(3, eif.getAddress());
			ps.setString(4, eif.getEmail());
			ps.setString(5, eif.getBanknumber());
			ps.setString(6, eif.getBankname());
			ps.setString(7, eif.getLabel());
			ps.setString(8, eif.getId());
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
	 * 管理者用一般削除メソッド
	 * @param uif
	 */
	public static void adminDelete (String name) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		try {
			// 接続する
			conn = manager.getConn();
			ps = conn.prepareStatement("DELETE FROM USER_TABLE WHERE USER_NAME = ?");
			ps.setString(1, name);
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
	 * 管理者用経営者情報削除メソッド
	 * @param uif
	 */
	public static void execDelete (String name) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		try {
			// 接続する
			conn = manager.getConn();
			ps = conn.prepareStatement("DELETE FROM USER_TABLE WHERE USER_NAME = ?");
			ps.setString(1, name);
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
	 * 一般情報全件検索
	 * @return
	 */
	public static ArrayList<UserInformationBean> allGeneralUserSerach () {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		ArrayList<UserInformationBean> userList = new ArrayList<UserInformationBean>();
		try {
			// 接続する
			conn = manager.getConn();
			ps = conn.prepareStatement("SELECT * FROM USER_TABLE WHERE authority = 1 ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserInformationBean uib = new UserInformationBean();
				uib.setId(rs.getString("id"));
				uib.setPassword(rs.getString("password"));
				uib.setName(rs.getString("name"));
				uib.setGender(rs.getString("gender"));
				uib.setAddress(rs.getString("birthday"));
				uib.setBirthday(rs.getString("address"));
				uib.setAuthority(rs.getString("authority"));
				uib.setCreditnumber(rs.getString("creditnumber"));
				uib.setCreditspan(rs.getString("creditspan"));
				uib.setSecuritycode(rs.getString("securitycode"));
				userList.add(uib);
			}
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
		return userList;
	}

	/**
	 * 経営者全件検索
	 * @return
	 */
	public static ArrayList<ExecInformationBean> allExecUser () {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		ArrayList<ExecInformationBean> execList = new ArrayList<ExecInformationBean>();
		try {
			// 接続する
			conn = manager.getConn();
			ps = conn.prepareStatement("SELECT * FROM USER_TABLE WHERE authority = 3 ORDER BY id ASC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExecInformationBean eib = new ExecInformationBean();
				eib.setName(rs.getString("name"));
				eib.setLabel(rs.getString("label"));
				eib.setPassword(rs.getString("password"));
				eib.setMail(rs.getString("email"));
				eib.setAddress(rs.getString("address"));
				eib.setBanknumber(rs.getString("banknumber"));
				eib.setBankname(rs.getString("bankname"));
				eib.setAuthority(rs.getString("authority"));
				execList.add(eib);
			}
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
		return execList;
	}
}
