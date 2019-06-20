package malin;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/13 20:33  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/13-01  [malin]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/


/**
 * 功能说明：单例java的安全版本样例，java单实例实现方式有多重但是，安全性最高的只有一下方式 单例模式的懒汉实现5--线程安全
 * 通过设置同步代码块，使用DCL双检查锁机制 使用双检查锁机制成功的解决了单例模式的懒汉实现的线程不安全问题和效率问题 DCL双检锁
 * 也是大多数多线程结合单例模式使用的解决方案
 *
 * @author 马琳-君子自强，脚踏实地积累
 * @date 2019年5月10日
 * @email 1217575485@qq.com
 */
public class SingletonLazy {

    private static SingletonLazy singletonLazy;

    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        if (null == singletonLazy) {
            synchronized (SingletonLazy.class) {
                if (null == singletonLazy) {
                    singletonLazy = new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }

}
