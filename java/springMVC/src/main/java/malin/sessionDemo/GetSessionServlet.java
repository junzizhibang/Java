package malin.sessionDemo;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/21 15:50  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/21-01  [malin.sessionDemo]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * malin.sessionDemo  功能说明：     获取session信息
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/21 15:50  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  GetSessionServlet.java
 * @email 1217575485@qq.com
 */
@WebServlet("/GetSessionServlet")
public class GetSessionServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认是true,表示如果没有session,就会创建一个session,如果是false,没有获取到session就会创建一个session
        HttpSession  session=req.getSession(false);
        if(session!=null){
            String  userName= (String) session.getAttribute("userName");
            System.out.println("--GetSessionServlet-------userName: "+userName);
            System.out.println("sessionId : "+session.getId());
        }else{
            System.out.println("没有找到任何结果!");
        }
    }
}
