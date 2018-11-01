package org.shancm.ilocalproject.demo;

import java.util.concurrent.*;

import com.uubee.risk.assist.id.IdWorker;

/**
 * @author shancm
 */
public class IdWorkerTest2 {
	
	private static long count = 0;
	
	private static synchronized long add() {
		return (long) (count++);
	}

	public static void main(String[] args) throws Exception {
		
		IdWorkerTest2 idWorderTest = new IdWorkerTest2();
		
		Runnable idWorkerThread = new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName()+" : "+IdWorker.getId());
					IdWorkerTest2.add();
				}
			}
		};
		
		Thread thread = new Thread(idWorkerThread);
		thread.setDaemon(true);
		
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
		long start = System.currentTimeMillis();
		for(int i=0; i<2; i++) {
			executor.execute(thread);
		}
		
		Thread thread2 = Thread.currentThread();
		thread2.sleep(3000);
//		executor.shutdown();
//		while(!executor.awaitTermination(300L, TimeUnit.MILLISECONDS)) {
//			
//		}
		System.out.println(count);
		System.out.println(System.currentTimeMillis()-start);
		thread2.interrupt();
		
		
	}
	
}
