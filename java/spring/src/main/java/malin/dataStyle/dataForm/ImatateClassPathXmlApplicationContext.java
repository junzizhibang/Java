package malin.dataStyle.dataForm;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/15 14:46  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/15-01  [malin.dataStyle.dataForm]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import malin.beans.UserInfo;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.lang.reflect.Field;
import java.util.List;

/**
 * malin.dataStyle.dataForm  功能说明：    模仿Spring的bean的加载方式
 * 初始版本基础夯实积攒Java架构师的基础内容
 *
 * @author 马琳-君子自强，脚踏实地积累  ImatateClassPathXmlApplicationContext.java
 * @date 2019/6/15 14:46  今年一定要成为Java高级开发攻城狮
 * @email 1217575485@qq.com
 */
public class ImatateClassPathXmlApplicationContext {
    private String xmlPath;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, DocumentException, IllegalAccessException {
        ImatateClassPathXmlApplicationContext applicationContext = new ImatateClassPathXmlApplicationContext("application.xml");
        Object bean = applicationContext.getBean("user2");
        UserInfo user = (UserInfo) bean;
        System.out.println(user.toString());
    }

    public ImatateClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    /****
     * SPring的加载过程或者Spring的IOC实现原理1.读取xml'的配置
     * @param beanId
     * @return
     * @throws DocumentException
     */
    public Object getBean(String beanId) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        SAXReader saxReader = new SAXReader();
        //获取当前配置的项目路径中的xml配置路径
        Document read = saxReader.read(this.getClass().getClassLoader().getResource(xmlPath));
        //获取节点对象
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();
        Object object = null;
        for (Element sonElement :
                elements) {
            //2.获取到每个bean配置,获取class地址
            String sonBeanId = sonElement.attributeValue("id");
            if (!beanId.equals(sonBeanId)) {
                continue;
            }
            String beanClassPath = sonElement.attributeValue("class");
            //3.拿到Class地址  进行反射实例化对象,使用反射api为  私有属性赋值
            Class<?> forName = Class.forName(beanClassPath);
            object = forName.newInstance();
            //全部成员属性
            List<Element> sonSoneleme = sonElement.elements();
            for (Element element :
                    sonSoneleme) {
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                //使用反射API为私有属性赋值
                Field declaredField = forName.getDeclaredField(name);
                //为私有成员变量赋值
                declaredField.setAccessible(true);
                declaredField.set(object, value);
            }
        }
        //拿到class地址,进行反射实例化对象,使用反射API为私有属性赋值
        return object;

    }


}


/***
 * 发送详情 [接收人姓名=马云,手机号码=0,短信内容=null
 * UserInfo [userName=马云, id=0, content=null, description=null, passWord=null, telNum=null, age=0, sex=女, reserve1=null, reserve2=null, reserve3=null, reserve4=null]
 */
