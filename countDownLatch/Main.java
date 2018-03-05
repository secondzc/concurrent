package concurrent.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) throws Exception, ExecutionException {
		int num = 10;
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(num);
		ExecutorService es = Executors.newFixedThreadPool(num);
		List<Future<Integer>> results = new ArrayList<>();
		for(int i=0;i<num;i++) {
			Future<Integer> f = es.submit(new Player(begin,end));
			results.add(f);
		}
		begin.countDown();
		end.await();
		for(int i=0;i<num;i++) {
			System.out.println(results.get(i).get());
		}
	}
}
