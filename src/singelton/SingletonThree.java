package singelton;
/**
 * 
* @ClassName: SingletonThree
* @Description: 静态内部类
* @author DJL
* @date 2015-3-15 下午10:37:42
*
 */
public class SingletonThree {
	private SingletonThree(){}
	private static class Singleton{
		private static final SingletonThree singleton =new SingletonThree();
	}
	public static SingletonThree getSingleton(){
		return Singleton.singleton;
	}
}
