package malin.servletdemo;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/20 21:07  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/20-01  [malin.demo]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * malin.demo  功能说明：
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/20 21:07  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  LastAccessTime.java
 * @email 1217575485@qq.com
 */
@WebServlet("/LastAccessTime")
public class LastAccessTime   extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html;charset=utf-8");//防止浏览器显示乱码
         String  lastAccessTime=null;
         Cookie[]  cookies=req.getCookies();
         for (Cookie cookie:cookies){
             String name=cookie.getName();
             if(name.equals("lastAccessTime")){
                 lastAccessTime=cookie.getValue();
                 break;
             }
         }
         if(StringUtils.isEmpty(lastAccessTime)){
                resp.getWriter().print("您是首次访问");
         }else{
             resp.getWriter().print("你上次访问的时间是:"+lastAccessTime);
         }
         //保存时间[访问],创建cookie将当前时间作为cookie保存到浏览器
        String currenttime=new SimpleDateFormat("yyyyy-mm-dd  hh:mm:ss").format(new Date());
         Cookie  cookie=new Cookie("lastAccessTime",currenttime);
         cookie.setMaxAge(60*60*24);
         resp.addCookie(cookie);//发送Cookie
    }
}
