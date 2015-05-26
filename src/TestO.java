import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class TestO {
	public static void main(String[] args) {
		try{
			SAXReader sax =new SAXReader();
			
			
			Document doc =sax.read("D:\\digisky_game_log.xml");
			Element docs = doc.getRootElement();
			List<Element> ele =docs.elements("struct");
			for(Element e:ele){
				List<Element> es =e.elements("entry");
				String fName=e.attributeValue("name");
				File f =new File("D:\\workspace\\function core_l2\\src\\com\\xd100\\function\\bean\\log\\"+fName+".java");
				FileWriter fw =new FileWriter(f,true);
				StringBuilder sb =new StringBuilder();
				String pram="";
				for(int k =0;k<es.size();k++){
					if(k==es.size()-1){
						pram+="Object "+es.get(k).attributeValue("name");
					}else{
						pram+="Object "+es.get(k).attributeValue("name")+",";
					}
				}
				sb.append("\n public "+fName+"("+pram+"){super();");
				for(int i =0;i<es.size();i++){
					String pa =es.get(i).attributeValue("name");
					String type =es.get(i).attributeValue("type");
					if(type.trim().equals("string")){
						sb.append("if("+pa+"  == null) this."+pa+"=null;else this."+pa+"="+pa+".toString();");
					}else if(type.trim().equals("int")){
						sb.append("if("+pa+"  == null) this."+pa+"=null;else this."+pa+"=Integer.parseInt("+pa+".toString());");
					}else if(type.trim().equals("long")){
						sb.append("if("+pa+"  == null) this."+pa+"=null;else this."+pa+"=Long.parseLong("+pa+".toString());");
					}
				}
				sb.append("}");
				fw.write(sb.toString());
				fw.flush();
			}
		}catch (Exception e) {
		}
	}
}
