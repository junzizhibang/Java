package malin.sessionDemo;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/21 15:58  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/21-01  [malin.sessionDemo]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import malin.servletdemo.TokenUtils;

/**
 * malin.sessionDemo  功能说明：
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/21 15:58  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  SessionUtils.java
 * @email 1217575485@qq.com
 */
public class SessionUtils {
    private CacheManager cacheManager=new CacheManager();
    public  void  init(){
        if(cacheManager!=null){
            cacheManager=new CacheManager();
        }
    }
    public  String setAttribute(Object value){
        //生成SessionId
        String sessionId=TokenUtils.getToken();
        cacheManager.put(sessionId,value);
        return  sessionId;
    }

    public Object getAttribute(String  key){
        return cacheManager.get(key);
    }
}
