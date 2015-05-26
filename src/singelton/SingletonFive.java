package singelton;
/**
 * 
* @ClassName: SingletonFive
* @Description: 双重校验锁
* @author DJL
* @date 2015-3-15 下午11:03:16
*
 */
public class SingletonFive {
	private volatile static SingletonFive singleton=null;
	private SingletonFive(){}
	public static SingletonFive getSingleton(){
		if(singleton==null){
			synchronized (SingletonFive.class) {
				if(singleton==null){
					singleton=new SingletonFive();
				}
			}
		}
		return singleton;
	}
}
