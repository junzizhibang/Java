package malin.servletdemo;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/20 19:56  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/20-01  [malin.demo]  1217575485@qq.com        
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
 * malin.demo  功能说明： Cookie存放再客户端中,请求报文头的方式吧Cookie发送给服务器端,
 *           响应头中返回给你客户端,不建议使用
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/20 19:56  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  CookieDemo.java
 * @email 1217575485@qq.com
 */
@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie  cookie=new Cookie("userName","君子志邦");
        cookie.setMaxAge(60*24);
        resp.addCookie(cookie);
        System.out.println("-------Cookie保存成功--------");

        if(req.getRequestURI().equals("cookieDemo")){
            System.out.println("-------Cookie保存成功--------");
        }
    }
}
