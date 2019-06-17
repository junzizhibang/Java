package malin.dataStyle.designStyle;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/17 11:41  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/17-01  [malin.dataStyle.designStyle]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/
/**
 * malin.dataStyle.designStyle  功能说明：   单例模式的设计示例,懒汉模式天生就是线程安全,在类加载的时候就被初始化,
 *            饿汉模式需要俩个null判断和俩个锁一个方法锁和类锁,才能保证安全
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/17 11:41  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  SingleDemo.java
 * @email 1217575485@qq.com
 */
public class SingleDemo {
    //当Class加载到实例化时候,被加载初始化
    private static   SingleDemo  demo ;
//    private static   SingleDemo  demo =new SingleDemo();

    private SingleDemo( ) {

    }
    public  static SingleDemo  getSingleDemo(){
        return demo;
    }
    public  static SingleDemo  getSingleDemo1(){
        if(demo==null){
            demo=new SingleDemo();
        }
        return demo;
    }
    public  static  synchronized SingleDemo  getSecutitySingleDemo () {

        if (null == demo) {
            synchronized (SingleDemo.class) {
                if (null == demo) {
                    demo = new SingleDemo();
                }
            }
        }
        return   demo;
    }


    public static void main(String[] args) {
        SingleDemo  test1=SingleDemo.getSingleDemo();
        SingleDemo  test2=SingleDemo.getSingleDemo();
        System.out.println("是否是统一对象?"+(test1==test2)+"   结果是"  );
        SingleDemo  test3=SingleDemo.getSingleDemo1();
        SingleDemo  test4=SingleDemo.getSingleDemo1();
        System.out.println("是否是统一对象?"+(test3==test4)+"   结果是");
        SingleDemo  test6=SingleDemo.getSecutitySingleDemo();
        SingleDemo  test5=SingleDemo.getSecutitySingleDemo();
        System.out.println("是否是统一对象?"+(test5==test6)+"   结果是");

    }




}
