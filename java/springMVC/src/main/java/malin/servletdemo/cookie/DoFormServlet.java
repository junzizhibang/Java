package malin.servletdemo.cookie;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/21 16:10  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/21-01  [malin.servletdemo.cookie]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * malin.servletdemo.cookie  功能说明：
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/21 16:10  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  DoFormServlet.java
 * @email 1217575485@qq.com
 */
@WebServlet("/DoFormServlet")
public class DoFormServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html;charset=utf-8");
         if(!isSubmit(req)){
             System.out.println("您已经提交了数据....或者token错误!");
             resp.getWriter().write("您提交了数据...或者token错误!");
             return;
         }
         String  userName=req.getParameter("userName");
         try{
             Thread.sleep(300);
         }catch (Exception  ex){
             ex.printStackTrace();
         }
        System.out.println("数据库插入数据......userName: "+userName);
         //插入数据库操作;;
        resp.getWriter().write("保存成功!");
        req.getSession().removeAttribute("sessionToken");
    }

    public Boolean  isSubmit(HttpServletRequest request){
        String  parameterToken=request.getParameter("parameterToken");
        String  sessionToken=(String) request.getSession().getAttribute("sessionToken");
        //判断是否提交
        if(sessionToken==null){
            return false;
        }
        //判断是否是伪造token
        if(!(parameterToken.equals(sessionToken))){
            return  false;
        }
        return true;
    }



}
