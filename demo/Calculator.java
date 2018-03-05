package concurrent.demo;

import java.util.concurrent.Callable;

public class Calculator implements Callable<Integer>{
	private int money;
	public Calculator(int money) {
		this.money = money;
	}
	@Override
	public Integer call() throws Exception {
		Thread.sleep(1000);
		return money;
	}
	
}
