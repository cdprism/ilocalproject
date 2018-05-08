package org.shancm.ilocalproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.shancm.utils.DBUtil;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
//import com.uubee.risk.assist.id.IdWorker;

public class TestNGCase {
	
	/*@BeforeTest
	public PreparedStatement getStatement() {
		ExecutorService threadPool = Executors.newFixedThreadPool(50);
		
		Connection connection;
		PreparedStatement statement = null;
		
		String sql = "insert into dbbigdata.temp (id) values (?);";
		try {
			connection = DBUtil.getConnection();
			statement = connection.prepareStatement(sql);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return statement;
	}

	@Test(invocationCount = 500000, threadPoolSize = 50)
	public void workIdCase() {
			
		long start = System.currentTimeMillis();
		PreparedStatement statement = getStatement();
		try {
			statement.setLong(1, IdWorker.getId());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("running time : "+(System.currentTimeMillis()-start));
	}*/
	
	
	
	
}
