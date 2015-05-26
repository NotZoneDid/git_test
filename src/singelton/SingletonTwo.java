package singelton;
/**
 * 
* @ClassName: SingletonTwo
* @Description: 饿汉       
* @author DJL
* @date 2015-3-15 下午10:21:50
*
 */
public class SingletonTwo {
	private static SingletonTwo singleton=new SingletonTwo();
	private SingletonTwo(){}
	public static SingletonTwo getSingleton(){
		return singleton;
	}
}

class SingletonTwoOther{
	private static SingletonTwoOther singleton=null;
	private SingletonTwoOther(){}
	
	static{
		singleton=new SingletonTwoOther();
	}
	
	public static SingletonTwoOther getSingleton(){
		return singleton;
	}
}
