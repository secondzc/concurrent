package concurrent.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable{
	private CyclicBarrier cb;
	public  Worker(CyclicBarrier cb) {
		this.cb = cb;
	}
	@Override
	public void run() {
		try {
			TimeUnit.MICROSECONDS.sleep(new Random().nextInt(20));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"has arrived the point");
		try {
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
