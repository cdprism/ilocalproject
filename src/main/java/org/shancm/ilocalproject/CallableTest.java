package org.shancm.ilocalproject;

import com.uubee.risk.assist.id.IdWorker;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

//import com.uubee.risk.assist.id.IdWorker;

public class CallableTest<V> {
	
	public static void main(String[] args) throws Exception {
		
		final Set<Long> set = new HashSet<Long>(700000);
		Collections.synchronizedSet(set);
		
        ExecutorService threadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
		
		Future<Long> future;
		
		long start = System.currentTimeMillis();
		
		for(int i=0; i<500000; i++) {
			future = threadPool.submit(new Callable<Long>() {
	            @Override
				public Long call() throws Exception {
	            	long temp = IdWorker.getId();
	            	set.add(temp);
	                return temp;
	            }
	        });
			
		}
		
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(set.size());
	}
}
