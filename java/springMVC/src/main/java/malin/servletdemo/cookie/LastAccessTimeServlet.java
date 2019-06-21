package malin.servletdemo.cookie;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/21 16:29  今年一定要成为Java高级开发攻城狮 
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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * malin.servletdemo.cookie  功能说明：    显示最后一次时间然后处理
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/21 16:29  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  LastAccessTimeServlet.java
 * @email 1217575485@qq.com
 */
@WebServlet("/LastAccessTimeServlet")
public class LastAccessTimeServlet   extends HttpServlet {
    private static final String COOK_KEY_LASTACCESSTIME="COOK_KEY_LASTACCESSTIME";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html;charset=utf-8");
       //1.获取Cookie信息
        String  lastAccessTime=null;
        Cookie [] cookies =req.getCookies();
        if(cookies!=null){
            for (Cookie  cookie:cookies){
                String cookieKey=cookie.getName();
                if(cookieKey.equals( COOK_KEY_LASTACCESSTIME)){
                    lastAccessTime=cookie.getValue();
                    break;
                }
            }
        }

        //2.如果Cookie信息没有数据,说明第一次访问.有数据的获取上一次Cookie的值
        if(lastAccessTime==null){
            resp.getWriter().write("你是首次访问.....");
        }else{
            resp.getWriter().write("你上次访问的时间是: "+lastAccessTime);
        }

        //3.现在访问的这个登录时间存放在Cookie里面,当前这个日期,存放在Cookie里面
        String currenttime=new SimpleDateFormat("yyyy-hh-dd  hh:mm:ss").format(new Date());
        Cookie cookie =new Cookie(COOK_KEY_LASTACCESSTIME ,currenttime);
        cookie.setMaxAge(60*60*24);
        resp.addCookie(cookie);
    }
}
