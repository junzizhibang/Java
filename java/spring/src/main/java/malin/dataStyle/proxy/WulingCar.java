package malin.dataStyle.proxy;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/17 20:21  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/17-01  [malin.dataStyle.proxy]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/
/**
 * malin.dataStyle.proxy  功能说明：     静态代理实现,查询代理模式
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/17 20:45  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  WulingCar.java
 * @email 1217575485@qq.com
 */
public class WulingCar   implements   Car{
    @Override
    public void buyCar() {
        System.out.println("  你好哦,我现在要准备买车了!... ");
    }
}

class Proxy implements  Car{

    private  WulingCar  car;
   public Proxy(WulingCar  car){
       this.car=car;
   }
    @Override
    public void buyCar() {
        System.out.println("我是4S  服务员,买车前给你介绍下哦!  ");
        car.buyCar();
        System.out.println("我是4S  服务员,帮助你买车结束....");
    }

    public static void main(String[] args) {
        Car  proxy=new Proxy(new WulingCar());
        proxy.buyCar();
    }
}

/***
 * D:\root\aplication\installpath\JDK\JDK1.8\bin\java.exe "-javaagent:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\lib\idea_rt.jar=65391:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\charsets.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\deploy.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\access-bridge-64.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\cldrdata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\dnsns.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jaccess.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jfxrt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\localedata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\nashorn.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunec.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunjce_provider.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunmscapi.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunpkcs11.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\zipfs.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\javaws.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jce.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfr.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfxswt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jsse.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\management-agent.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\plugin.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\resources.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\rt.jar;E:\root\workpacket\git\Ideal\java\spring\target\classes;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-core\3.0.0-M3\camel-core-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-api\3.0.0-M3\camel-api-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-base\3.0.0-M3\camel-base-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-jaxp\3.0.0-M3\camel-jaxp-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-management-api\3.0.0-M3\camel-management-api-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-support\3.0.0-M3\camel-support-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-util\3.0.0-M3\camel-util-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-util-json\3.0.0-M3\camel-util-json-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-bean\3.0.0-M3\camel-bean-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-browse\3.0.0-M3\camel-browse-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-caffeine-lrucache\3.0.0-M3\camel-caffeine-lrucache-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\com\github\ben-manes\caffeine\caffeine\2.7.0\caffeine-2.7.0.jar;D:\root\aplication\workinfo\Mavenrepo\org\checkerframework\checker-qual\2.6.0\checker-qual-2.6.0.jar;D:\root\aplication\workinfo\Mavenrepo\com\google\errorprone\error_prone_annotations\2.3.3\error_prone_annotations-2.3.3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-controlbus\3.0.0-M3\camel-controlbus-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-dataformat\3.0.0-M3\camel-dataformat-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-dataset\3.0.0-M3\camel-dataset-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-direct\3.0.0-M3\camel-direct-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-directvm\3.0.0-M3\camel-directvm-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-file\3.0.0-M3\camel-file-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-language\3.0.0-M3\camel-language-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-log\3.0.0-M3\camel-log-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-mock\3.0.0-M3\camel-mock-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-properties\3.0.0-M3\camel-properties-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-ref\3.0.0-M3\camel-ref-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-rest\3.0.0-M3\camel-rest-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-saga\3.0.0-M3\camel-saga-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-scheduler\3.0.0-M3\camel-scheduler-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-seda\3.0.0-M3\camel-seda-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-stub\3.0.0-M3\camel-stub-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-timer\3.0.0-M3\camel-timer-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-validator\3.0.0-M3\camel-validator-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-vm\3.0.0-M3\camel-vm-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-xpath\3.0.0-M3\camel-xpath-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-xslt\3.0.0-M3\camel-xslt-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-spring\3.0.0-M3\camel-spring-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-core-xml\3.0.0-M3\camel-core-xml-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\spi-annotations\3.0.0-M3\spi-annotations-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-core\5.1.7.RELEASE\spring-core-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-jcl\5.1.7.RELEASE\spring-jcl-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-aop\5.1.7.RELEASE\spring-aop-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-context\5.1.7.RELEASE\spring-context-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-beans\5.1.7.RELEASE\spring-beans-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-expression\5.1.7.RELEASE\spring-expression-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-tx\5.1.7.RELEASE\spring-tx-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\logging\log4j\log4j-api\2.11.2\log4j-api-2.11.2.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\logging\log4j\log4j-core\2.11.2\log4j-core-2.11.2.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\logging\log4j\log4j-slf4j-impl\2.11.2\log4j-slf4j-impl-2.11.2.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-jdbc\4.3.6.RELEASE\spring-jdbc-4.3.6.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\boot\spring-boot-autoconfigure\1.5.1.RELEASE\spring-boot-autoconfigure-1.5.1.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\boot\spring-boot\1.5.1.RELEASE\spring-boot-1.5.1.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;D:\root\aplication\workinfo\Mavenrepo\xml-apis\xml-apis\1.4.01\xml-apis-1.4.01.jar;D:\root\aplication\workinfo\Mavenrepo\com\alibaba\fastjson\1.2.28\fastjson-1.2.28.jar;D:\root\aplication\workinfo\Mavenrepo\cglib\cglib\2.1_2\cglib-2.1_2.jar;D:\root\aplication\workinfo\Mavenrepo\asm\asm\1.5.3\asm-1.5.3.jar malin.dataStyle.proxy.Proxy
 * 我是4S  服务员,买车前给你介绍下哦!
 *   你好哦,我现在要准备买车了!...
 * 我是4S  服务员,帮助你买车结束....
 *
 * Process finished with exit code 0
 */
