package malin.dataStyle.annotation;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/17 16:03  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/17-01  [malin.dataStyle.annotation]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * malin.dataStyle.annotation  功能说明：   表的映射
 * 初始版本基础夯实积攒Java架构师的基础内容
 *
 * @author 马琳-君子自强，脚踏实地积累  TableAnnotation.java
 * @date 2019/6/17 16:03  今年一定要成为Java高级开发攻城狮
 * @email 1217575485@qq.com
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableAnnotation {
    /**
     * 对应数据库表的名称
     *
     * @return
     */
    String value();
}
