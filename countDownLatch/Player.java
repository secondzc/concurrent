package concurrent.countDownLatch;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Player implements Callable<Integer>{
	private CountDownLatch start;
	private CountDownLatch end;
	public Player(CountDownLatch start,CountDownLatch end) {
		this.start = start ;
		this.end = end;
	}
	@Override
	public Integer call() throws Exception {
		int score = new Random().nextInt(25);
		start.await();
	    TimeUnit.MILLISECONDS.sleep(score);
	    end.countDown();
	    return score;
	}
	
}
