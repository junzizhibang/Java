package malin.service;

import malin.beans.UserInfo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/********************************************
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/15 14:04  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/15-01  [malin.service]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/
public class SpringMain {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserInfo userInfo = (UserInfo) classPathXmlApplicationContext.getBean("user1");
        System.out.println(userInfo.toString());
    }
}
