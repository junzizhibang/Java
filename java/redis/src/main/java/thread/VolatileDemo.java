package thread;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/15 12:45  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/15-01  [thread]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/
/**
 * thread  功能说明：   实现局部变量实时刷新  Volatile不具备原子性!
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/15 13:27  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  VolatileDemo.java
 * @email 1217575485@qq.com
 */
public class VolatileDemo {

    public static void main(String[] args) throws InterruptedException {
        VolatileThread volatileThread=new  VolatileThread();
        volatileThread.start();
        Thread.sleep(300);
        volatileThread.isRun(false);
        System.out.println("flag="+volatileThread.flag);

    }
}


class  VolatileThread  extends  Thread{

    public  volatile   boolean flag =true;

    @Override
    public void run() {
        System.out.println("子线程开始执行.....");
        while(flag){
        }
        System.out.println("子线程结束执行-------");
    }
    public void isRun(boolean  flag) {
         this.flag=flag;
    }


}