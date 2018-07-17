package org.shancm.ilocalproject;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

import com.uubee.risk.assist.id.IdWorker;

public class IdWorkerTest {
	
	private static long count = 0;
	
	static CountDownLatch c = new CountDownLatch(5000);
	
	private static synchronized long add() {
		return (long) (count++);
	}

	public static void main(String[] args) throws Exception {
		
		/*File file = new File("C:\\Users\\shancm\\Desktop\\record.txt");

		FileOutputStream fileOutputStream = new FileOutputStream(file);
		final PrintWriter printWriter = new PrintWriter(fileOutputStream);*/
		
		/*Connection connection = DBUtil.getConnection();
		final String sql = "insert into dbbigdata.temp (id) values (?);";
		final PreparedStatement  statement = connection.prepareStatement(sql);*/
		
		final Set<Long> set = new HashSet<Long>(7000);
		Collections.synchronizedSet(set);

		ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
				60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		long start = System.currentTimeMillis();
		for(int i=0; i<5000; i++) {
			executor.execute(new Runnable() {
				public void run() {
					try {
						/*statement.setLong(1, IdWorker.getId());
						statement.execute();*/
						/*printWriter.println(IdWorker.getId());*/
						set.add(IdWorker.getId());
						c.countDown();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		}
		c.await();
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(set.size());
//		connection.close();
		
		
	}
	
}
