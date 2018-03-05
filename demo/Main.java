package concurrent.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Integer> future = es.submit(new Calculator(100));
		while(!future.isDone()) {
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println("#");
		}
		System.out.println(future.get());
		es.shutdown();
	}
}
