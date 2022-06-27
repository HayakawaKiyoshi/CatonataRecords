package com.catonata.dao;

public class SQLTemplates {

	/**
	 * 参考用
	 */
	private final String SEARCH_SQL =
			"SELECT E.emp_id, E.emp_pass, E.emp_name,"
	+ " (CASE WHEN E.gender = 1 THEN '男性' WHEN E.gender = 2 THEN '女性' END) AS \"gender1\","
	+ " E.address, TO_CHAR(E.birthday, 'YYYY-MM-DD') AS \"birth\","
	+ " (CASE WHEN E.authority = 1 THEN '一般' WHEN E.authority = 2 THEN '管理者' END) AS \"autho\","
	+ " E.dept_id, D.dept_name"
	+ " FROM emp_table E INNER JOIN dept_table D"
	+ " ON E.dept_id = D.dept_id"
	+ " WHERE emp_id = ? AND emp_pass = ?";

}
