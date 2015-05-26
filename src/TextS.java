import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class TextS {

	/**
	 * @Title: main
	 * @Description: TODO 查询
	 * @param: @param args 设定文件
	 * @return: void 返回类型
	 * @throws:
	 */
	public static void main(String[] args) {
		try{
			SAXReader sax =new SAXReader();
			Document doc =sax.read("D:\\digisky_game_log.xml");
			Element docs = doc.getRootElement();
			List<Element> ele =docs.elements("struct");
			for(Element e:ele){
				List<Element> es =e.elements("entry");
				String fName=e.attributeValue("name");
				StringBuilder sb =new StringBuilder();
				int i=0;
				String q ="";
				for(Element k :es){
					if(i==es.size()-1){
				//		sb.append(k.attributeValue("name")+"=? ;\n");
						q+="?";
					}else{						
				//		sb.append(k.attributeValue("name")+"=?,");
						q+="?,";
					}
					
					i++;
				}
				sb.append("insert into "+fName+" values (null,"+q+"); \n");
				System.out.println(sb.toString());
			}
			
		}catch(Exception e){
			
		}
	}

}
