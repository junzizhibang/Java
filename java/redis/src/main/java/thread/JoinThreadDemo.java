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

/****   运行结果
 D:\root\aplication\installpath\JDK\JDK1.8\bin\java.exe "-javaagent:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\lib\idea_rt.jar=57277:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\charsets.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\deploy.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\access-bridge-64.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\cldrdata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\dnsns.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jaccess.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jfxrt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\localedata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\nashorn.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunec.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunjce_provider.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunmscapi.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunpkcs11.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\zipfs.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\javaws.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jce.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfr.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfxswt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jsse.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\management-agent.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\plugin.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\resources.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\rt.jar;E:\root\workpacket\git\Ideal\java\redis\target\classes;D:\root\aplication\workinfo\Mavenrepo\redis\clients\jedis\3.0.1\jedis-3.0.1.jar;D:\root\aplication\workinfo\Mavenrepo\org\slf4j\slf4j-api\1.7.22\slf4j-api-1.7.22.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\commons\commons-pool2\2.4.3\commons-pool2-2.4.3.jar thread.JoinThreadDemo
 等待-----0
 等待-----1
 等待-----2
 等待-----3
 等待-----4
 等待-----5
 等待-----6
 等待-----7
 thread20
 thread21
 thread22
 thread23
 thread24
 thread25
 thread26
 thread27
 thread28
 thread10
 thread11
 thread12
 thread13
 thread14
 thread15
 thread16
 thread17
 thread18
 thread19
 等待-----8
 等待-----9
 thread29

 Process finished with exit code 0


 */