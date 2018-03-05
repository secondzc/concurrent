package concurrent.关于interrupt;

public class interrupt的解析 {
	public static void main(String[] args) {
		//说明interrupted方法会重置线程的中断标志位, 可以理解，interrupted是静态方法，
		//表示只能重置自己的
		Thread.currentThread().interrupt();
		System.out.println(Thread.interrupted());
		System.out.println(Thread.interrupted());

		//isInterrupted不会重置标志位
		Thread.currentThread().interrupt();
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println(Thread.currentThread().isInterrupted());


	}
}
