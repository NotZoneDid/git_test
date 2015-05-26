import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;



public class TestX {
	
	public static void main(String[] args) {
		String parm="3+2";
		String className="Computer";
		String mouthName="getResult";
		String sourc="package singelton; public class "+className+"{public static double "+mouthName+"(){ return "+parm+"; }}";
		
		JavaCompiler java=ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager file=java.getStandardFileManager(null, null, null);
		try {
			JavaFileObject jfo =new StringJavaObject(className, sourc);
			List<String> options =new ArrayList<String>();
			options.addAll(Arrays.asList("-d","./bin"));
			Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(jfo);
			 CompilationTask task = java.getTask(null,file, null, options, null, fileObjects);
			 boolean result = task.call();
			 if(result){
				Object obj=Class.forName("singelton.Computer").newInstance();
				Class<?> clz=obj.getClass();
				Method m=clz.getMethod(mouthName,new Class[]{});
				double k=(Double) m.invoke(null,new Object[]{});
				System.out.println(k);
			 }else{
				 System.out.println("格式错误!~");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
class StringJavaObject extends SimpleJavaFileObject{
	private String content = null;
	public StringJavaObject(String name, String content)throws URISyntaxException {
        super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.content = content;
     }
	@Override
	 public CharSequence getCharContent(boolean ignoreEncodingErrors)throws IOException {
         return content;
    }
	protected StringJavaObject(URI uri, Kind kind) {
		super(uri, kind);
	}
	
}
