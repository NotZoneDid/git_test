import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.DoubleBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.google.gson.reflect.TypeToken;

public class TestW {
	static Type mapType = new TypeToken<Map<Object,Object>>() {}.getType();
	public static boolean getXX(){
		return true;
	}
	private static String addSql(int num){
		String select=" select ?";
		for(int i=1;i<8;i++){
			select+=",?";
		}
		String nowSelect=select;
		for(int i=1;i<num;i++){
			select+=" union all "+nowSelect;
		}
		return "INSERT INTO vip_massage(serverId,pid,pname,lv,vip,login,register,operaTime) "+select;
	}
	 static final String addSql(){
		return addSql(500);
	}
	public static void main(String[] args) {
			
//			int []k=pao(new int[]{5,2,3,1,4});
//			for(int m:k){
//				System.out.println(m);
//			}
//		        ClassLoader loader = TestW.class.getClassLoader(); 
//		      
//		        while (loader != null) { 
//		            System.out.println(loader.toString()); 
//		            loader = loader.getParent(); 
//		        } 
//		try {
//			URL url =new URL("http://www.baidu.com");
//			InputStream in=url.openStream();
//			BufferedReader br =new BufferedReader(new InputStreamReader(in, "UTF-8"));
//			String m;
//			while((m=br.readLine())!=null){
//				System.out.println(m);
//			}
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private static int[] pao(int[] m){
		for(int i=0;i<m.length-1;i++){
			for(int j=i;j<m.length;j++){
				if(m[i]<m[j]){
					int k=m[j];
					m[j]=m[i];
					m[i]=k;
				}
			}
		}
		return m;
	}
	
	private static List<String> split3( final String str ,String parm){
		final List<String> res = new ArrayList<String>( 10 );
		int pos, prev = 0;
		while ( ( pos = str.indexOf(parm, prev ) ) != -1 )
		{res.add( str.substring( prev, pos ) );
		prev = pos + 1;
		}
		
		return res;
	}
	
	
}