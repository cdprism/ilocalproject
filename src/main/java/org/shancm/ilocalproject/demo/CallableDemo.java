package org.shancm.ilocalproject.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shancm
 * @pachage org.shancm.ilocalproject
 * @description:
 * @date 2018/6/6
 */
public class CallableDemo {

    public static void main(String[] args) throws InterruptedException {


        CallableDemo demo = new CallableDemo();
        demo.run();

    }

    public void run() throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        ExecutorService threadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                10L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        List<InnerCallable> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new InnerCallable(count));
        }
        threadPool.invokeAll(list);

        System.out.println(count);
    }


    class InnerCallable implements Callable<Boolean> {

        AtomicInteger count;

        public InnerCallable(AtomicInteger count) {
            this.count = count;
        }

        @Override
        public Boolean call() throws Exception {
            System.out.println(count.incrementAndGet());
            return Boolean.TRUE;
        }
    }
}
