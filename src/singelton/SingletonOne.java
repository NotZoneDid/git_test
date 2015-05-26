package singelton;
/**
 * 
* @ClassName: SingletonOne
* @Description: 懒汉
* @author DJL
* @date 2015-3-15 下午9:51:56
*
 */
public class SingletonOne {
	private static SingletonOne singleton;
	private SingletonOne(){}
	/**
	 * 非线程
	 * @return
	 */
	public static SingletonOne getSingleton(){
		if(singleton==null){
			singleton=new SingletonOne();
		}
		return singleton;
	}
	
	public static synchronized SingletonOne getSingletonForThread(){
		if(singleton==null){
			singleton=new SingletonOne();
		}
		return singleton;
	}
}
