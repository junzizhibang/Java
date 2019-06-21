package malin.sessionDemo;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/21 10:11  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/21-01  [malin.sessionDemo]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/
/**
 * malin.sessionDemo  功能说明：  缓存实体类
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/21 10:31  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  Cache.java
 * @email 1217575485@qq.com
 */
public class Cache {

    private  String  key;//key
    private  Object  value;//存储的值
    private  Long  timeout;//有效期

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }
}
