

public class TestWaitNotify {
	public static void main(String[] args) {
		final Business bs =new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=1;i<=5;i++){
					bs.sub(i);
				}
			}
		}).start();
		for(int i=1;i<=5;i++){
			bs.main(i);
		}
	}
}

class Business{
	private boolean flag=true;
	
	public synchronized void sub(int i){
		while(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=0;j<10;j++){
			System.out.println("子线程："+i+" 次数："+j);
		}
		flag=!flag;
		this.notify();
	}
	
	public synchronized void main(int i){
		while(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=0;j<20;j++){
			System.out.println("主线程："+i+" 次数："+j);
		}
		flag=!flag;
		this.notify();
	}
}