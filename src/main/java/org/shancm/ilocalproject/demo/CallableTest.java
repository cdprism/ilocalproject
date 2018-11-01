package org.shancm.ilocalproject.demo;

import com.uubee.risk.assist.id.IdWorker;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author shancm
 */
public class CallableTest {

	/**
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
        Set<Long> set = Collections.synchronizedSet(new HashSet<Long>(700000));

        ExecutorService threadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
		
		Future<Long> future;
		
		long start = System.currentTimeMillis();
		
		for(int i=0; i<500; i++) {
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

	/**
	 * @Param: [s]
	 * @Author: shancm@bellion.com
	 * @Date: 2018/7/19
	 * @Description:
	 * @return: void
	 */
	public void run(String s){

	}
}
