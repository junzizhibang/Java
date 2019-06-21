package malin.sessionDemo;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/21 15:35  今年一定要成为Java高级开发攻城狮 
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
 * malin.sessionDemo  功能说明：      创建Session
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/21 15:35  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  CreateSessionServlet.java
 * @email 1217575485@qq.com
 */
@WebServlet("/CreateSessionServlet")
public class CreateSessionServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认是true,标志如果没有Session,就会创建一个session,如果是ffalse.如果没有摘到Session,就不会创建一个session
        HttpSession session=req.getSession();
        session.setAttribute("userName","君子志邦");
        System.out.println("保存session 成功,"+session.getId());

    }
}
