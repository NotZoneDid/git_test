import java.io.File;
import java.io.FileWriter;
import java.io.IOException;





public class  TestF {
		/**
	 * @Title: main
	 * @Description: TODO
	 * @param: @param args 设定文件
	 * @return: void 返回类型
	 * @throws IOException 
	 * @throws:
	 */
	public static void main(String[] args) throws IOException {
		File f =new File("D:\\workspace\\function core_l2\\src\\com\\xd100\\function\\bean\\log");
		String[] m=f.list();
		for(int i=0;i<m.length;i++){
			String name =m[i].split("\\.")[0]; 
			File ja =new File("D:\\workspace\\function core_l2\\src\\com\\xd100\\function\\bean\\log\\"+name+".java");
			FileWriter fw =new FileWriter(ja,true);
//			fw.write("package com.xd100.function.wsi.log; public class "+name+"Service implements "+name+"ServiceIF{}");
			fw.write("//~~~~~~~~!!~~!");
			fw.flush();
			System.out.println(name);
		}
	}
	
}

