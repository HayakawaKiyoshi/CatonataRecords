package com.catonata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.catonata.bean.ExecInformationBean;
import com.catonata.bean.PurchaseBean;
import com.catonata.bean.UserInformationBean;
import com.catonata.validation.CreditCardInformationForm;
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

	public static void insert (UserInformationForm uif, CreditCardInformationForm ccif) {
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
			ps.setString(9, ccif.getCreditnumber());
			ps.setString(10, ccif.getCreditspan());
			ps.setString(11, ccif.getSecurity());
			ps.setString(12, null);
			ps.setString(13, null);
			ps.setString(14, null);
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
			ps.setString(9, null);
			ps.setString(10, null);
			ps.setString(11, null);
			ps.setString(12, null);
			ps.setString(13, null);
			ps.setString(14, null);
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
			ps.setString(3, null);
			ps.setString(4, null);
			ps.setString(5, null);
			ps.setString(6, eif.getAddress());
			ps.setString(7, eif.getEmail());
			ps.setString(8, "3");
			ps.setString(9, null);
			ps.setString(10, null);
			ps.setString(11, null);
			ps.setString(12, eif.getBanknumber());
			ps.setString(13, eif.getBankname());
			ps.setString(14, eif.getLabel());
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
					+ " WHERE ID = ?");
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
					+ "BANKNAME = ? , LABEL = ? , ID = ?");
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
	public static void adminDelete (String id) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		try {
			// 接続する
			conn = manager.getConn();
			//販売履歴テーブルから消去する処理
			ps = conn.prepareStatement("DELETE FROM PURCHASE_TABLE WHERE USER_ID = ?");
			ps.setString(1, id);
			int cnt1 =ps.executeUpdate();
			conn.commit();
			System.out.println(cnt1 + "件のデータを販売履歴テーブルから削除しました。");
			ps.close();
			//ユーザーテーブルから消去する処理
			ps = conn.prepareStatement("DELETE FROM USER_TABLE WHERE USER_ID = ?");
			ps.setString(1, id);
			int cnt =ps.executeUpdate();
			conn.commit();
			System.out.println(cnt + "件のデータをユーザーテーブルから削除しました。");

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
	public static void execDelete (String id) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		try {
			// 接続する
			conn = manager.getConn();
			//販売履歴テーブルから消去する処理
			ps = conn.prepareStatement("DELETE FROM PURCHASE_TABLE WHERE ID = ?");
			ps.setString(1, id);
			int cnt1 =ps.executeUpdate();
			conn.commit();
			System.out.println(cnt1 + "件のデータを販売履歴テーブルから削除しました。");
			ps.close();
			//ユーザーテーブルから消去する処理
			ps = conn.prepareStatement("DELETE FROM USER_TABLE WHERE ID = ?");
			ps.setString(1, id);
			int cnt =ps.executeUpdate();
			conn.commit();
			System.out.println(cnt + "件のデータをユーザーテーブルから削除しました。");

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

	public static UserInformationForm find(String name,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		final String LOGIN_SQL = "SELECT ID,PASSWORD,USER_NAME,AGE,GENDER, TO_CHAR(birthday, 'YYYY/MM/DD') AS \"birth\",ADDRESS,EMAIL,AUTHORITY,CREDIT_NUMBER,SPAN,SECURITY_CODE,BANK_NUMBER,BANK_NAME,LABEL FROM USER_TABLE WHERE user_name = ? AND password = ?";

		UserInformationForm user = new UserInformationForm();

		try {
			conn = manager.getConn();
			ps = conn.prepareStatement(LOGIN_SQL);
			//引数を?にバインド
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("user_name"));
				user.setAge(rs.getString("age"));
				user.setGender(rs.getString("gender"));
				user.setBirthday(rs.getString("birth"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setAuthority(rs.getString("authority"));
				user.setCreditnumber(rs.getString("credit_number"));
				user.setCreditspan(rs.getString("span"));
				user.setSecurity(rs.getString("security_code"));


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

	public static ExecInformationForm execFind(String name,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
		final String LOGIN_SQL = "SELECT * FROM USER_TABLE WHERE user_name = ? AND password = ?";

		ExecInformationForm user = new ExecInformationForm();

		try {
			conn = manager.getConn();
			ps = conn.prepareStatement(LOGIN_SQL);
			//引数を?にバインド
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setLabel(rs.getString("label"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setBanknumber(rs.getString("banknumber"));
				user.setBankname(rs.getString("bankname"));

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
				uib.setName(rs.getString("user_name"));
				uib.setGender(rs.getString("gender"));
				uib.setAddress(rs.getString("birthday"));
				uib.setBirthday(rs.getString("address"));
				uib.setAuthority(rs.getString("authority"));
				uib.setCreditnumber(rs.getString("credit_number"));
				uib.setCreditspan(rs.getString("span"));
				uib.setSecuritycode(rs.getString("security_code"));
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
	 *
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
				eib.setId(rs.getString("user_id"));
				eib.setName(rs.getString("user_name"));
				eib.setLabel(rs.getString("label"));
				eib.setPassword(rs.getString("password"));
				eib.setEmail(rs.getString("email"));
				eib.setAddress(rs.getString("address"));
				eib.setBanknumber(rs.getString("bank_number"));
				eib.setBankname(rs.getString("bank_name"));
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

	public static List<PurchaseBean> findPurchase(String id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBManager manager = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		//ArrayListを初期化
		ArrayList<PurchaseBean> empList = new ArrayList<PurchaseBean>();

		try {
			conn = manager.getConn();

			final String SQL = "SELECT E.LABEL,PURCHASE_DATE,DELIVERY_DATE,E.PROD_ID,D.PROD_NAME,D.ARTIST,D.MEDIA,D.PRICE FROM PURCHASE_TABLE E INNER JOIN PRODUCT_TABLE D ON D.PROD_ID = E.PROD_ID  WHERE E.ID = ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();

			//結果をuserインスタンスに設定し、
			//ArrayListインスタンスに追加
			while (rs.next()) {
				PurchaseBean bean = new PurchaseBean();
				bean.setPro_name(rs.getString("PROD_NAME"));
				bean.setArtist(rs.getString("ARTIST"));
				bean.setMedia(rs.getString("MEDIA"));
				bean.setPrice(rs.getString("PRICE"));
				bean.setPurchase_date(sdf.format(rs.getDate("PURCHASE_DATE")));
				bean.setDelivery_date(sdf.format(rs.getDate("DELIVERY_DATE")));
				bean.setLabel(rs.getString("LABEL"));
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

	public static void generalUpdate (UserInformationForm uif,CreditCardInformationForm form) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
//		SqlTemplates sqls = new SqlTemplates();
		try {
			// 接続する
			conn = manager.getConn();
			ps = conn.prepareStatement("UPDATE USER_TABLE SET PASSWORD = ?,"
					+ "USER_NAME = ? , AGE = ? , GENDER = ? , BIRTHDAY = ? ,"
					+ "ADDRESS = ? , EMAIL = ? , CREDIT_NUMBER = ?, SPAN = ?, SECURITY_CODE = ?"
					+ " WHERE ID = ?");
			ps.setString(1, uif.getPassword());
			ps.setString(2, uif.getName());
			ps.setString(3, uif.getAge());
			ps.setString(4, uif.getGender());
			ps.setString(5, uif.getBirthday());
			ps.setString(6, uif.getAddress());
			ps.setString(7, uif.getEmail());
			ps.setString(8, form.getCreditnumber());
			ps.setString(9, form.getCreditspan());
			ps.setString(10, form.getSecurity());
			ps.setString(11, uif.getId());
			int cnt =ps.executeUpdate();
			conn.commit();
			System.out.println(cnt + "件のデータを更新しました。");

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

	public static CreditCardInformationForm findCard(String name, String pass) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DBManagerをインスタンス化
		DBManager manager = new DBManager();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		final String LOGIN_SQL = "SELECT CREDIT_NUMBER,SPAN,SECURITY_CODE FROM USER_TABLE WHERE user_name = ? AND password = ?";

		CreditCardInformationForm ccif = new CreditCardInformationForm();

		try {
			conn = manager.getConn();
			ps = conn.prepareStatement(LOGIN_SQL);
			//引数を?にバインド
			ps.setString(1, name);
			ps.setString(2, pass);
			rs = ps.executeQuery();

			if (rs.next()) {
				ccif.setCreditnumber(rs.getString("CREDIT_NUMBER"));
				ccif.setCreditspan(rs.getString("SPAN"));
				ccif.setSecurity(rs.getString("SECURITY_CODE"));

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
		return ccif;

	}

}