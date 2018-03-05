package concurrent.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {
	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(2,new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"after meet ");
			}
			
		});
		new Thread(new Worker(cb)).start();
		new Thread(new Worker(cb)).start();
	}
}
