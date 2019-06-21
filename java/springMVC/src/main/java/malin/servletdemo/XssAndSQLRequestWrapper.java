package malin.servletdemo;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/20 20:31  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/20-01  [malin.demo]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * malin.demo  功能说明： 防止XSS攻击
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/20 20:31  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  XssAndSQLRequestWrapper.java
 * @email 1217575485@qq.com
 */
public class XssAndSQLRequestWrapper  extends HttpServletRequestWrapper {
    HttpServletRequest request;
    public XssAndSQLRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request=request;
    }

    @Override
    public String getParameter(String name) {
        String value=request.getParameter(name);
        System.out.println("name="+name+","+value);
        if(!StringUtils.isEmpty(value)){//转换成Html格式
            value=StringEscapeUtils.escapeHtml4(value);
            System.out.println("---获取到翻译为 ---"+value);
        }
        return value;
    }
}
