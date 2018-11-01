package org.shancm.ilocalproject.temp;

import org.shancm.ilocalproject.utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shancm
 * @package org.shancm.ilocalproject.temp
 * @description:
 * @date 2018/9/11
 */
public class PlatformOrderDemo {

	public static void main(String[] args) throws IOException, SQLException {
		Connection devConnection = DBUtil.getDevConnection();
		Statement statement = devConnection.createStatement();
		long id = 20040930004951L;

		for (int i = 0; i < 100; i++) {
			id += i;
			String sql = "INSERT INTO `dbavatar`.`tb_platform_order_record` (`oid_order`, `oid_userno`, `user_login`, `name_user`, `exter_order_id`, `order_dtsend`, `order_info`, `cat_big_pro`, `pro_code`, `source_chnl`, `trader_src`, `name_trader`, `amt`, `dt_vaild`, `dt_match_end`, `dt_create`, `dt_lst_update`, `status`, `amt_loan`, `purpose`, `memo`, `notification_url`, `dt_loan`, `requestip`, `period_type`, `periods`, `card_type`, `acct_name`, `bank_acct`, `bank_code`, `bank_name`, `source_code`, `refer_limit_frzno`) \n" +
					"VALUES ('"+id+"', '2016012900332522', '17681889274', '龚韫含', '20170622010023', '2017-06-22 12:07:14', NULL, '400000', '400001', '36', '201706090000003002', '贝勒爷', '1000000', '2017-06-29 12:07:14', '2017-06-22 12:12:14', '2004-06-22 12:05:42', '2017-06-22 12:07:46', '1', '1000000', NULL, NULL, NULL, '2017-06-22 12:07:14', '192.168.100.122', '1', '30', '2', '龚韫含', '6217863100001908217', '01040000', '中国银行', NULL, '20170622010022');";

			statement.execute(sql);
		}

	}
}
