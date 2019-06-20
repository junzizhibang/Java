package malin.dataStyle.json;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/15 16:02  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/15-01  [malin.dataStyle.json]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * malin.dataStyle.json  功能说明：    FastJSON 解析格式
 * 初始版本基础夯实积攒Java架构师的基础内容
 *
 * @author 马琳-君子自强，脚踏实地积累  FastJsonDemo.java
 * @date 2019/6/15 16:02  今年一定要成为Java高级开发攻城狮
 * @email 1217575485@qq.com
 */
public class FastJsonDemo {

    static String JSONSTR = "{\n" +
            "    \"name\": \"马云\",\n" +
            "    \"url\": \"http://www.bejson.com\",\n" +
            "    \"page\": 88,\n" +
            "    \"isNonProfit\": true,\n" +
            "    \"address\": {\n" +
            "        \"street\": \"科技园路.\",\n" +
            "        \"city\": \"江苏苏州\",\n" +
            "        \"country\": \"中国\"\n" +
            "    },\n" +
            "    \"links\": [\n" +
            "        {\n" +
            "            \"name\": \"Google\",\n" +
            "            \"url\": \"http://www.google.com\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Baidu\",\n" +
            "            \"url\": \"http://www.baidu.com\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"SoSo\",\n" +
            "            \"url\": \"http://www.SoSo.com\"\n" +
            "        }\n" +
            "    ]\n" +
            "} ";


    public static void main(String[] args) {
        //
        JSONObject jsonObject = new JSONObject();
        //
        JSONObject parseObject = (JSONObject) jsonObject.parse(JSONSTR);
        JSONArray jsonArray = parseObject.getJSONArray("links");
        for (Object object :
                jsonArray) {
            JSONObject obj = (JSONObject) object;
            String name = obj.getString("name");
            String url = obj.getString("url");
            System.out.println(name + "----" + url);
        }

        System.out.println(getJson());
    }

    public static String getJson() {

        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject bean = new JSONObject();
        bean.put("name", "马云");
        bean.put("url", "www.alibaba.com");
        array.add(bean);
        JSONObject bean2 = new JSONObject();
        bean2.put("name", "马华腾");
        bean2.put("url", "www.tencent.com");
        array.add(bean2);
        jsonObject.put("links", array);
//        System.out.println(jsonObject.toJSONString());


        return jsonObject.toJSONString();
    }
}
/****
 * 运行结果显示:
 D:\root\aplication\installpath\JDK\JDK1.8\bin\java.exe "-javaagent:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\lib\idea_rt.jar=61847:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\charsets.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\deploy.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\access-bridge-64.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\cldrdata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\dnsns.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jaccess.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jfxrt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\localedata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\nashorn.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunec.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunjce_provider.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunmscapi.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunpkcs11.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\zipfs.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\javaws.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jce.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfr.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfxswt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jsse.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\management-agent.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\plugin.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\resources.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\rt.jar;E:\root\workpacket\git\Ideal\java\spring\target\classes;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-core\3.0.0-M3\camel-core-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-api\3.0.0-M3\camel-api-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-base\3.0.0-M3\camel-base-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-jaxp\3.0.0-M3\camel-jaxp-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-management-api\3.0.0-M3\camel-management-api-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-support\3.0.0-M3\camel-support-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-util\3.0.0-M3\camel-util-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-util-json\3.0.0-M3\camel-util-json-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-bean\3.0.0-M3\camel-bean-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-browse\3.0.0-M3\camel-browse-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-caffeine-lrucache\3.0.0-M3\camel-caffeine-lrucache-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\com\github\ben-manes\caffeine\caffeine\2.7.0\caffeine-2.7.0.jar;D:\root\aplication\workinfo\Mavenrepo\org\checkerframework\checker-qual\2.6.0\checker-qual-2.6.0.jar;D:\root\aplication\workinfo\Mavenrepo\com\google\errorprone\error_prone_annotations\2.3.3\error_prone_annotations-2.3.3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-controlbus\3.0.0-M3\camel-controlbus-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-dataformat\3.0.0-M3\camel-dataformat-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-dataset\3.0.0-M3\camel-dataset-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-direct\3.0.0-M3\camel-direct-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-directvm\3.0.0-M3\camel-directvm-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-file\3.0.0-M3\camel-file-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-language\3.0.0-M3\camel-language-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-log\3.0.0-M3\camel-log-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-mock\3.0.0-M3\camel-mock-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-properties\3.0.0-M3\camel-properties-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-ref\3.0.0-M3\camel-ref-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-rest\3.0.0-M3\camel-rest-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-saga\3.0.0-M3\camel-saga-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-scheduler\3.0.0-M3\camel-scheduler-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-seda\3.0.0-M3\camel-seda-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-stub\3.0.0-M3\camel-stub-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-timer\3.0.0-M3\camel-timer-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-validator\3.0.0-M3\camel-validator-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-vm\3.0.0-M3\camel-vm-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-xpath\3.0.0-M3\camel-xpath-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-xslt\3.0.0-M3\camel-xslt-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-spring\3.0.0-M3\camel-spring-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\camel-core-xml\3.0.0-M3\camel-core-xml-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\camel\spi-annotations\3.0.0-M3\spi-annotations-3.0.0-M3.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-core\5.1.7.RELEASE\spring-core-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-jcl\5.1.7.RELEASE\spring-jcl-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-aop\5.1.7.RELEASE\spring-aop-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-context\5.1.7.RELEASE\spring-context-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-beans\5.1.7.RELEASE\spring-beans-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-expression\5.1.7.RELEASE\spring-expression-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-tx\5.1.7.RELEASE\spring-tx-5.1.7.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\logging\log4j\log4j-api\2.11.2\log4j-api-2.11.2.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\logging\log4j\log4j-core\2.11.2\log4j-core-2.11.2.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\logging\log4j\log4j-slf4j-impl\2.11.2\log4j-slf4j-impl-2.11.2.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\spring-jdbc\4.3.6.RELEASE\spring-jdbc-4.3.6.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\boot\spring-boot-autoconfigure\1.5.1.RELEASE\spring-boot-autoconfigure-1.5.1.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\org\springframework\boot\spring-boot\1.5.1.RELEASE\spring-boot-1.5.1.RELEASE.jar;D:\root\aplication\workinfo\Mavenrepo\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;D:\root\aplication\workinfo\Mavenrepo\xml-apis\xml-apis\1.4.01\xml-apis-1.4.01.jar;D:\root\aplication\workinfo\Mavenrepo\com\alibaba\fastjson\1.2.28\fastjson-1.2.28.jar malin.dataStyle.json.FastJsonDemo
 Google----http://www.google.com
 Baidu----http://www.baidu.com
 SoSo----http://www.SoSo.com
 {"links":[{"name":"马云","url":"www.alibaba.com"},{"name":"马华腾","url":"www.tencent.com"}]}

 Process finished with exit code 0

 */
