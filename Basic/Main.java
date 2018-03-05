package concurrent.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws Exception {
		A a= new A(new Integer(0));
		ExecutorService es = Executors.newFixedThreadPool(3);
		List<Future<Integer>> results = new ArrayList<>();
		for(int i=0;i<3;i++) {
			Future<Integer> result =  es.submit(new Worker(a));
			results.add(result);
		}
		TimeUnit.MILLISECONDS.sleep(200);
		for(int i=0;i<3;i++) {
			System.out.println(results.get(i).get());
		}
	}
}
