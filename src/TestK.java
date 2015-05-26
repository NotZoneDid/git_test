import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;


public class TestK {

	public static void premain(String args, Instrumentation inst) {    
		   inst.addTransformer(new TestK2());
	}
	
	static class TestK2 implements ClassFileTransformer{
		
		@Override
		public byte[] transform(ClassLoader loader, String className,
				Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
				byte[] classfileBuffer) throws IllegalClassFormatException {
			System.out.println("提前进来·");
			return null;
		}
		
	}
}
