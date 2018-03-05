package concurrent.Basic;

import java.util.concurrent.Callable;

public class Worker implements Callable<Integer> {
	private A a;
	Worker(A a){
		this.a = a;
	}
	@Override
	public Integer call() throws Exception {
		a.add();
		return a.show();
	}
}
