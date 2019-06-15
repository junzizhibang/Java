package malin.dataStyle.dataForm;

import malin.beans.Log;
import malin.beans.UserInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/********************************************
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/15 14:12  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/15-01  [malin.dataStyle.dataForm]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/


/**
 * malin.dataStyle.dataForm  功能说明：      获取类的对象的几种方式,1.new,2.Class.forName,3newInstance()[只能是无参的构造函数]
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/15 14:43  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  ClassForm.java
 * @email 1217575485@qq.com
 */
public class ClassForm {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1.new  得到的类对象,  同时也可以使用反射机制来创建对象
        //2.forName  必须传入class的类的完整路径
        Class<?>  user=Class.forName("malin.beans.UserInfo");
        //3.newInstance  使用无参构造函数  创建对象new
        UserInfo  userInfo= (UserInfo) user.newInstance();
        System.out.println("user:"+userInfo);
//     运行结果:
//        发送详情 [接收人姓名=null,手机号码=0,短信内容=null
//        user:UserInfo [userName=null, id=0, content=null, description=null, passWord=null, telNum=null, age=0, sex=null, reserve1=null, reserve2=null, reserve3=null, reserve4=null]

        Class<?>  logObject=Class.forName("malin.beans.Log");
        Method []  allMethod=logObject.getMethods();//获取所有的方法名称
        for (Method method:allMethod) {
            System.out.println(method.getName()+"---"+method.getReturnType()+"----"+method.getModifiers());
        }
        Field[] fields = logObject.getDeclaredFields();  //拿到所有的成员属性
        for (Field field :
                fields) {
            System.out.println("获取到的成员属性  "+field.getName());
        }
        Field  field=logObject.getDeclaredField("userName");
        Log log= (Log) logObject.newInstance();//这里的Log一定是无参构造函数不然会出现错误的!!!
        field.setAccessible(true);
        field.set(log,"马云");
        System.out.println("处理过后的数值  "+log.toString());//这回


    }
}
/****运行结果
 * D:\root\aplication\installpath\JDK\JDK1.8\bin\java.exe "-javaagent:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\lib\idea_rt.jar=59581:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\charsets.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\deploy.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\access-bridge-64.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\cldrdata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\dnsns.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jaccess.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jfxrt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\localedata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\nashorn.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunec.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunjce_provider.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunmscapi.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunpkcs11.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\zipfs.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\javaws.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jce.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfr.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfxswt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jsse.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\management-agent.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\plugin.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\resources.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\rt.jar;E:\root\workpacket\git\Ideal\java\spring\target\classes;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-core\3.0.0-M3\camel-core-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-api\3.0.0-M3\camel-api-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-base\3.0.0-M3\camel-base-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-jaxp\3.0.0-M3\camel-jaxp-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-management-api\3.0.0-M3\camel-management-api-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-support\3.0.0-M3\camel-support-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-util\3.0.0-M3\camel-util-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-util-json\3.0.0-M3\camel-util-json-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-bean\3.0.0-M3\camel-bean-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-browse\3.0.0-M3\camel-browse-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-caffeine-lrucache\3.0.0-M3\camel-caffeine-lrucache-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\com\github\ben-manes\caffeine\caffeine\2.7.0\caffeine-2.7.0.jar;D:\root\aplication\workinfo\Mavenrepo\org\checkerframework\checker-qual\2.6.0\checker-qual-2.6.0.jar;D:\root\aplication\workinfo\Mavenrepo\com\google\errorprone\error_prone_annotations\2.3.3\error_prone_annotations-2.3.3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-controlbus\3.0.0-M3\camel-controlbus-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-dataformat\3.0.0-M3\camel-dataformat-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-dataset\3.0.0-M3\camel-dataset-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-direct\3.0.0-M3\camel-direct-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-directvm\3.0.0-M3\camel-directvm-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-file\3.0.0-M3\camel-file-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-language\3.0.0-M3\camel-language-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-log\3.0.0-M3\camel-log-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-mock\3.0.0-M3\camel-mock-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-properties\3.0.0-M3\camel-properties-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-ref\3.0.0-M3\camel-ref-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-rest\3.0.0-M3\camel-rest-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-saga\3.0.0-M3\camel-saga-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-scheduler\3.0.0-M3\camel-scheduler-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-seda\3.0.0-M3\camel-seda-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-stub\3.0.0-M3\camel-stub-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-timer\3.0.0-M3\camel-timer-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-validator\3.0.0-M3\camel-validator-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-vm\3.0.0-M3\camel-vm-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-xpath\3.0.0-M3\camel-xpath-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-xslt\3.0.0-M3\camel-xslt-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-spring\3.0.0-M3\camel-spring-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-core-xml\3.0.0-M3\camel-core-xml-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\spi-annotations\3.0.0-M3\spi-annotations-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-core\5.1.7.RELEASE\spring-core-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-jcl\5.1.7.RELEASE\spring-jcl-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-aop\5.1.7.RELEASE\spring-aop-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-context\5.1.7.RELEASE\spring-context-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-beans\5.1.7.RELEASE\spring-beans-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-expression\5.1.7.RELEASE\spring-expression-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-tx\5.1.7.RELEASE\spring-tx-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\logging\log4j\log4j-api\2.11.2\log4j-api-2.11.2.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\logging\log4j\log4j-core\2.11.2\log4j-core-2.11.2.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\logging\log4j\log4j-slf4j-impl\2.11.2\log4j-slf4j-impl-2.11.2.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-jdbc\4.3.6.RELEASE\spring-jdbc-4.3.6.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\boot\spring-boot-autoconfigure\1.5.1.RELEASE\spring-boot-autoconfigure-1.5.1.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\boot\spring-boot\1.5.1.RELEASE\spring-boot-1.5.1.RELEASE.jar malin.dataStyle.dataForm.ClassForm
 * 发送详情 [接收人姓名=null,手机号码=0,短信内容=null
 * user:UserInfo [userName=null, id=0, content=null, description=null, passWord=null, telNum=null, age=0, sex=null, reserve1=null, reserve2=null, reserve3=null, reserve4=null]
 * toString---class java.lang.String----1
 * getId---int----1
 * getContent---class java.lang.String----1
 * setId---void----1
 * setReserve4---void----1
 * setReserve3---void----1
 * getDescription---class java.lang.String----1
 * getReserve2---class java.lang.String----1
 * setUserName---void----1
 * setContent---void----1
 * setDescription---void----1
 * setReserve1---void----1
 * getReserve4---class java.lang.String----1
 * setReserve2---void----1
 * getReserve3---class java.lang.String----1
 * getReserve1---class java.lang.String----1
 * getUserName---class java.lang.String----1
 * setCreDt---void----1
 * getCreTime---class java.lang.String----1
 * getCreDt---class java.lang.String----1
 * setCreTime---void----1
 * wait---void----17
 * wait---void----17
 * wait---void----273
 * equals---boolean----1
 * hashCode---int----257
 * getClass---class java.lang.Class----273
 * notify---void----273
 * notifyAll---void----273
 * 获取到的成员属性  serialVersionUID
 * 获取到的成员属性  id
 * 获取到的成员属性  userName
 * 获取到的成员属性  content
 * 获取到的成员属性  description
 * 获取到的成员属性  creDt
 * 获取到的成员属性  creTime
 * 获取到的成员属性  reserve1
 * 获取到的成员属性  reserve2
 * 获取到的成员属性  reserve3
 * 获取到的成员属性  reserve4
 * 处理过后的数值  Log [id=0, userName=马云, content=null, description=null, creDt=null, creTime=null, reserve1=null, reserve2=null, reserve3=null, reserve4=null]
 *
 * Process finished with exit code 0
 */