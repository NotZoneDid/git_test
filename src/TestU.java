import com.sun.org.apache.bcel.internal.util.ClassLoader;


public class TestU {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader cl=new ClassLoader();
		Class<?> one =new ClassLoader().loadClass("TestU");
		Object a=one.newInstance();
		Class<?> two =new ClassLoader().loadClass("TestU");
		Object b=two.newInstance();
		a=b;
	}

}
