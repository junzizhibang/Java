package malin.servletdemo;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/21 9:07  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/21-01  [malin.servletdemo]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * malin.servletdemo  功能说明：     模拟使用Filter
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/21 9:07  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  FilterDemo.java
 * @email 1217575485@qq.com
 */
public class FilterDemo  implements Filter {
    public FilterDemo() {
        System.out.println("FilterDemo  构造函数被执行");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo..     ---- init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(" FIlterDemo    ----doFilter");
        HttpServletRequest  request= (HttpServletRequest) servletRequest;
        XssAndSQLRequestWrapper  xssAndSQLRequestWrapper=new XssAndSQLRequestWrapper(request);
        HttpServletResponse  response= (HttpServletResponse) servletResponse;
        String  requestUri=request.getRequestURI();//请求地址
        System.out.println("requetUri:"+requestUri);
        //参数
        Map<String,String[]> paramterMap=request.getParameterMap();
        for (String key:paramterMap.keySet()){
            String [] arr=paramterMap.get(key);
            System.out.println("key :");
            for(String  str:arr){
                System.out.println("str :"+str);
            }
        }
        filterChain.doFilter(xssAndSQLRequestWrapper,servletResponse);
    }

    public void destroy() {
        System.out.println("FilterDemo  ----destroy");
    }
}




