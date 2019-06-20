package malin.dataStyle.xml;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/********************************************
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/17 8:28  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/17-01  [malin.dataStyle.xml]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/


/**
 * malin.dataStyle.xml  功能说明：    使用SAXReader对xml文件进行解析
 * 初始版本基础夯实积攒Java架构师的基础内容
 *
 * @author 马琳-君子自强，脚踏实地积累  LogXml.java
 * @date 2019/6/17 8:43  今年一定要成为Java高级开发攻城狮
 * @email 1217575485@qq.com
 */
public class LogXml {

    static String fileName = "E:\\root\\workpacket\\git\\Ideal\\java\\spring\\src\\main\\resources\\log.xml";

    public static void main(String[] args) throws DocumentException {
        //xml解析器
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File(fileName));
        //拿到根节点
        Element rootElement = read.getRootElement();
        getnodes(rootElement);

    }

    static public void getnodes(Element rootElement) {
        System.out.println("   节点名称:   " + rootElement.getName());
        List<Attribute> attributeList = rootElement.attributes();
//        拿到节点属性
        for (Attribute attribute :
                attributeList) {
            System.out.println("属性:" + attribute.getName() + "------" + attribute.getText());
        }
        //节点名称
        if (!rootElement.getTextTrim().equals("")) {
            System.out.println("节点名称:" + rootElement.getName() + "---" + rootElement.getText());
        }
        //返回下一个节点
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            //获取当前节点值
            Element next = elementIterator.next();
            getnodes(next);
        }
    }


}
