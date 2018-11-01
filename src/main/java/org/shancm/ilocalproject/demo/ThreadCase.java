package org.shancm.ilocalproject.demo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//import com.uubee.risk.assist.id.IdWorker;

public class ThreadCase {

	/*public static void main(String[] args) {
		Thread thread0 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int i = 5;
					while (!(i==0)) {
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(500);
						i--;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int i = 5;
					while (!(i==0)) {
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(500);
						i--;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		*//*thread0.start();
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*//*
		
		
		
		
		Set<Long> set0 = new HashSet<>(700000);
		final Set<Long> set = Collections.synchronizedSet(set0);
		
		ExecutorService executor = Executors.newFixedThreadPool(50);
		
		long start = System.currentTimeMillis();
		for(int i=0; i<500000; i++) {
			Thread thread3 = new Thread(new Runnable() {
				@Override
				public void run() {
					set.add(IdWorker.getId());
				}
			});
			executor.execute(thread3);
		}
		executor.shutdown();
		try {
			while (!executor.awaitTermination(10, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(set.size());
		System.out.println(System.currentTimeMillis()-start);
		
		
		
		
		
		*//* long start = System.currentTimeMillis();
         
	        for(int i = 0; i < 5; i++)  
	        {  
	            Thread thread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName() + "子线程开始");  
				        try  
				        {  
				            // 子线程休眠五秒  
				            Thread.sleep(500);  
				        }  
				        catch (InterruptedException e)  
				        {  
				            e.printStackTrace();  
				        }  
				        System.out.println(Thread.currentThread().getName() + "子线程结束");  
					}
				});  
	            thread.start();  
	              
	            try  
	            {  
	                thread.join();  
	            }  
	            catch (InterruptedException e)  
	            {  
	                e.printStackTrace();  
	            }  
	        }  
	          
	        long end = System.currentTimeMillis();  
	        System.out.println("子线程执行时长：" + (end - start)); *//*
		
		
		
		
		
		
		
	}*/
}
