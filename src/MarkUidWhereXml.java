import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class MarkUidWhereXml {
	private Element rootElement;
	private String fileName;
	private Document xmlBody;

	public MarkUidWhereXml(String fileName) {
		this.fileName = fileName;
		try {
			SAXReader sax = new SAXReader();
			this.xmlBody = sax.read(fileName);
			this.rootElement = this.xmlBody.getRootElement();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: writeUid
	 * @Description: 记录UID入XML
	 * @param: @param uid
	 * @param: @param sec_Mark 第二层标签名
	 * @param: @param thr_Mark 第三次标签名 （单标签）
	 * @param: @param groupNum 第二次最大包含多少个第三层
	 * @return: void 返回类型
	 * @throws:
	 */
	public void writeUid(List<String> uid, int groupNum) {
		try {
			for (int i = 0; i < uid.size(); i++) {
				if (i % groupNum == 0) {
					this.rootElement.addElement("dataGroup", "NO."
							+ ((i / groupNum) + 1));
				}
				Element docm = (Element) this.rootElement.elements("dataGroup")
						.get((i / groupNum));
				docm.addElement("uid", uid.get(i));
			}
			saveFile(new FileOutputStream(this.fileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saveFile(OutputStream os) throws IOException {
		XMLWriter writer = new XMLWriter(os);
		try {
			writer.write(this.xmlBody);
			writer.flush();
		} finally {
			writer.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Set<String> readUid(int groupNum) {
		Set<String> uids = new HashSet<String>();
		List<Element> list = this.rootElement.elements("dataGroup");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNamespaceURI().equals("NO." + groupNum)) {
				List<Element> element = list.get(i).elements("uid");
				for (int k = 0; k < element.size(); k++) {
					uids.add(element.get(k).getNamespaceURI());
				}
			}
		}
		return uids;
	}
	/**
	 * 
	 * @Title: saveObject
	 * @Description:记录一个对象
	 * @param: @param obj
	 * @param: @throws IOException 设定文件
	 * @return: void 返回类型
	 * @throws:
	 */
	public void saveObject(Object obj)throws IOException {
		ByteArrayOutputStream byteOS=new ByteArrayOutputStream();
		ObjectOutputStream objOS =new ObjectOutputStream(byteOS);
		objOS.writeObject(obj);
		saveFile(objOS);
	}
	
	
	@SuppressWarnings("unchecked")
	public Set<String> readUidAll() {
		Set<String> uids = new HashSet<String>();
		List<Element> list = this.rootElement.elements("dataGroup");
		for (int i = 0; i < list.size(); i++) {
			List<Element> element = list.get(i).elements("uid");
			for (int k = 0; k < element.size(); k++) {
				uids.add(element.get(k).getNamespaceURI());
			}
		}
		return uids;
	}
}
