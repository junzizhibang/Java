package malin.servletdemo.cookie;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/21 16:05  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/21-01  [malin.servletdemo.cookie]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * malin.servletdemo.cookie  功能说明：
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/21 16:05  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  AddCookieServlet.java
 * @email 1217575485@qq.com
 */
@WebServlet("/AddCookieServlet")
public class AddCookieServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie  =new Cookie("userName","君子志邦--AddCookieServlet");
        cookie.setMaxAge(60*60*24);//如果是负数浏览器关闭就失效,如果正数以秒为单位进行保存,cookie保存一天,没有任何一家公司应该保存登录
        resp.addCookie(cookie);//将Cookie 发送客户端
        System.out.println("创建Cookie成功.....");

    }
}
