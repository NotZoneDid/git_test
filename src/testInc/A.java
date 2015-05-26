package testInc;

public class A extends Thread implements Runnable{
	@Override
	public void run() {
		System.out.println("xxx");
	}
	public static void main(String[] args) {
		Thread t=new Thread(new A());
		t.start();
	}
}
