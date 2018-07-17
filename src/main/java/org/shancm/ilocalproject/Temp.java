package org.shancm.ilocalproject;

import org.shancm.utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shancm
 * @package org.shancm.ilocalproject
 * @description:
 * @date 2018/7/5
 */
public class Temp {
	public static void main(String[] args) throws IOException, SQLException {
		Connection devConnection = DBUtil.getDevConnection();
		Statement statement = devConnection.createStatement();

		String sql = "select\n" +
				"\t\tuser_login\n" +
				"\t\t,user_type,borr_amt_occur\n" +
				"\t\t,lend_amt_occur,subject_id,subject_name,acctno_type\n" +
				"\t\t,oid_biz,dt_create,date_acct,user_acctno,seq_journalizing,oid_serialno\n" +
				"\t\tfrom\n" +
				"\t\tTA_ACCOUNT_ACCTNO_DETAIL limit 1";

		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()){
			System.out.println(resultSet.toString());
		}
	}
}
