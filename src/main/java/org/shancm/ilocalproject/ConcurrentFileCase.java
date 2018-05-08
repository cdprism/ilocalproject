package org.shancm.ilocalproject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;

import com.uubee.risk.assist.id.IdWorker;

public class ConcurrentFileCase {
	
	public static void main(String[] args) throws IOException {
		File dir = new File("D:\\repository3");
		if(!dir.exists()) {
			dir.mkdirs();
		}else {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
            	File file = new File("D:\\repository3\\"+children[i]);
	            file.delete();
            }
            dir.delete();
	        dir.mkdirs();
		}
		
		ExecutorService executor = new ThreadPoolExecutor(500, 500,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		long start = System.currentTimeMillis();
		for(int i=0; i<500000; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					File file = new File("D:\\repository3\\"+IdWorker.getId());
					if (file.exists()) {
						try {new File("D:\\repository3\\repeat.dtd").createNewFile();} catch (IOException e) {e.printStackTrace();}
					}else {
						try {file.createNewFile();} catch (IOException e) {e.printStackTrace();}
					}
				}
			});
		}
		
		
		executor.shutdown();
		System.out.println(System.currentTimeMillis()-start);
	}
}
