package thread;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/15 11:49  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/15-01  [thread]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/
/**
 * thread  功能说明：
 * 使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。cpu会从众多的可执行态里选择。
 * 也就是说，当前也就是刚刚的那个线程还是有可能会被再次执行到的，并不是说一定会执行其他线程而该线程在下一次中不会执行到了。
 *
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/15 11:54  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  JoinThreadDemo.java
 * @email 1217575485@qq.com
 */
public class JoinThreadDemo {
    public static void main(String[] args) {
        JoinThread  thread1=new JoinThread("thread1");
        JoinThread  thread2=new JoinThread("thread2");
        thread1.start();
        thread1.setPriority(10);  //线程的执行顺序不一定按照设定的优先级执行，这是因为线程不一定能获得cpu资源  1; //最低优先级
        thread2.yield();
        thread2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("等待-----"+i);
        }
    }

}
class  JoinThread  extends  Thread{

    public JoinThread(String userName){
        this.setName(userName);
    }
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}

