import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class TextQ {
	
	public static void main(String[] args) {
		try {
			SAXReader sax =new SAXReader();
			
			
			Document doc =sax.read("D:\\ttt.xml");
			Element docs = doc.getRootElement();
			List<Element> ele =docs.elements("struct");
			for(Element e:ele){
				List<Element> es =e.elements("entry");
				String fName=e.attributeValue("name");
				File f =new File("D:\\"+fName+".java");
				FileWriter fw =new FileWriter(f,true);
				StringBuilder sb =new StringBuilder();
				sb.append("package com.xd100.function.bean.log;\n");
				sb.append("/**"+e.attributeValue("desc")+"**/\n");
				sb.append("public class "+fName+"{");
				sb.append("public "+fName+"(){ super();}");
				for(Element k :es){
					String type="";
					if(k.attributeValue("type").equals("int")){
						type="Integer";
					}else if(k.attributeValue("type").equals("long")){
						type="Long";
					}else{
						type="String";
					}
					sb.append("private "+type+" "+k.attributeValue("name")+";//"+k.attributeValue("desc")+"\n");
				}
				sb.append("}");
				System.out.println(sb.toString());
				fw.write(sb.toString());
				fw.flush();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
