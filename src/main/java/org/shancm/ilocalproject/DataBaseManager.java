package org.shancm.ilocalproject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.text.AbstractDocument.BranchElement;

import org.shancm.utils.ConnectionPool;
import org.shancm.utils.DBUtil;

//import com.uubee.risk.assist.id.IdWorker;

public class DataBaseManager {




	/*public static void main(String[] args) throws Exception {

		ExecutorService threadPool = Executors.newFixedThreadPool(250);

		long start = 0l;
		final String sql = "insert into dbbigdata.temp (id) values (?);";
		start = System.currentTimeMillis();
		
		final ConnectionPool connectionPool = new ConnectionPool();
		connectionPool.createPool();

		for (int i = 0; i < 100000; i++) {
			threadPool.execute(new Runnable() {
				
				public void run() {
					try (Connection connection = connectionPool.getConnection(); 
							PreparedStatement statement = connection.prepareStatement(sql)) {
						long innerstart = System.currentTimeMillis();
						statement.setLong(1, IdWorker.getId());
						statement.execute();
						connectionPool.returnConnection(connection);
						System.out.println(System.currentTimeMillis()-innerstart);
					} catch (SQLException e) {
						e.printStackTrace();
						try {
							Connection connection = connectionPool.getConnection();
							String sql = "insert into dbbigdata.temp (id) values ('123');";
							PreparedStatement statement = connection.prepareStatement(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				}
				
				
				*//*public void run() {
					try (Connection connection = DBUtil.getConnection();
							PreparedStatement statement = connection.prepareStatement(sql)) {
						statement.setLong(1, IdWorker.getId());
						statement.execute();
					} catch (SQLException | IOException e) {
						e.printStackTrace();
					}
				}*//*
				
			});
		}
		System.out.println("running time : " + (System.currentTimeMillis() - start));
		*//*
		 * File file = new File("C:\\Users\\shancm\\Desktop\\record.txt");
		 * BufferedReader br = new BufferedReader( new InputStreamReader(new
		 * FileInputStream(file)));
		 *//*

		*//*
		 * Set<String> set = new HashSet<String>(); Collections.synchronizedSet(set);
		 * 
		 * String str = null; while((str=br.readLine())!=null){ set.add(str);
		 * System.out.print(str); } br.close(); System.out.println(set.size());
		 *//*
	}*/

}
