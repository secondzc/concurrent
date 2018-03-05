package concurrent.Basic;

//A为资源
public class A {
	private Integer count;
	A(Integer c){
		count = c;
	}
	public synchronized void add() {
		count++;
	}
	public synchronized Integer show() {
		return count;
	}
}
