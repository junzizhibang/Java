package thread;

/********************************************
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/15 13:30  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/15-01  [thread]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import java.util.concurrent.atomic.AtomicInteger;

/**
 * thread  功能说明：   Volatile 修饰变量 实现局部变量实时刷新  Volatile不具备原子性!AtomicInteger  使用incrementAndGet 保证原子性
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/15 13:31  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  VolatileNoAtomic.java
 * @email 1217575485@qq.com
 */
public class VolatileNoAtomic   {
    public static void main(String[] args) {
        VolatileNoAutomicThread[]  volatileNoAtomics=new  VolatileNoAutomicThread[10];
        for (int i = 0; i <volatileNoAtomics.length ; i++) {
            volatileNoAtomics[i]=new VolatileNoAutomicThread();
        }
        for (int i = 0; i <volatileNoAtomics.length ; i++) {
            volatileNoAtomics[i].start();
        }

    }
}
class   VolatileNoAutomicThread  extends Thread{

    private  static  volatile  int count=0;
   private static AtomicInteger  atomicInteger=new AtomicInteger(0);
    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
                    count++;
            atomicInteger.incrementAndGet();
        }
           System.out.println(getName()+"--count----"+count);
              System.out.println(getName()+"----atomicInteger--"+atomicInteger);
    }
}


/****
 *
 * 只允许count运行时,发现结果并没有实现原子性  :  要么全部执行,要么全部不执行保证数据一致,线程安全一致.
 * D:\root\aplication\installpath\JDK\JDK1.8\bin\java.exe "-javaagent:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\lib\idea_rt.jar=58987:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\charsets.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\deploy.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\access-bridge-64.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\cldrdata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\dnsns.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jaccess.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jfxrt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\localedata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\nashorn.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunec.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunjce_provider.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunmscapi.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunpkcs11.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\zipfs.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\javaws.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jce.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfr.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfxswt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jsse.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\management-agent.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\plugin.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\resources.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\rt.jar;E:\root\workpacket\git\Ideal\java\redis\target\classes;D:\root\aplication\workinfo\Mavenrepo\redis\clients\jedis\3.0.1\jedis-3.0.1.jar;D:\root\aplication\workinfo\Mavenrepo\org\slf4j\slf4j-api\1.7.22\slf4j-api-1.7.22.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\commons\commons-pool2\2.4.3\commons-pool2-2.4.3.jar thread.VolatileNoAtomic
 * Thread-0------3000
 * Thread-5------6000
 * Thread-4------5000
 * Thread-6------7000
 * Thread-1------3000
 * Thread-3------4000
 * Thread-2------3000
 * Thread-8------9259
 * Thread-7------9935
 * Thread-9------8000
 *
 * Process finished with exit code 0
 *
 *
 * =============
 *atomicInteger 运行结果如下:
 *
 *D:\root\aplication\installpath\JDK\JDK1.8\bin\java.exe "-javaagent:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\lib\idea_rt.jar=59039:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\charsets.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\deploy.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\access-bridge-64.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\cldrdata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\dnsns.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jaccess.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jfxrt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\localedata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\nashorn.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunec.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunjce_provider.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunmscapi.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunpkcs11.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\zipfs.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\javaws.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jce.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfr.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfxswt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jsse.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\management-agent.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\plugin.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\resources.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\rt.jar;E:\root\workpacket\git\Ideal\java\redis\target\classes;D:\root\aplication\workinfo\Mavenrepo\redis\clients\jedis\3.0.1\jedis-3.0.1.jar;D:\root\aplication\workinfo\Mavenrepo\org\slf4j\slf4j-api\1.7.22\slf4j-api-1.7.22.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\commons\commons-pool2\2.4.3\commons-pool2-2.4.3.jar thread.VolatileNoAtomic
 * Thread-3------6671
 * Thread-7------8000
 * Thread-8------9818
 * Thread-0------6660
 * Thread-4------7000
 * Thread-6------7000
 * Thread-1------7000
 * Thread-5------6660
 * Thread-2------6669
 * Thread-9------10000
 *
 * Process finished with exit code 0
 *
 *
 * 一起运行结果如下:  明显发现有区别
 * D:\root\aplication\installpath\JDK\JDK1.8\bin\java.exe "-javaagent:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\lib\idea_rt.jar=59073:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\charsets.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\deploy.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\access-bridge-64.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\cldrdata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\dnsns.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jaccess.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jfxrt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\localedata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\nashorn.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunec.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunjce_provider.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunmscapi.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunpkcs11.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\zipfs.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\javaws.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jce.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfr.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfxswt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jsse.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\management-agent.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\plugin.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\resources.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\rt.jar;E:\root\workpacket\git\Ideal\java\redis\target\classes;D:\root\aplication\workinfo\Mavenrepo\redis\clients\jedis\3.0.1\jedis-3.0.1.jar;D:\root\aplication\workinfo\Mavenrepo\org\slf4j\slf4j-api\1.7.22\slf4j-api-1.7.22.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\commons\commons-pool2\2.4.3\commons-pool2-2.4.3.jar thread.VolatileNoAtomic
 * Thread-0--count----4143
 * Thread-6--count----6044
 * Thread-4--count----5827
 * Thread-4----atomicInteger--10000
 * Thread-2--count----5662
 * Thread-2----atomicInteger--10000
 * Thread-3--count----5202
 * Thread-1--count----4453
 * Thread-3----atomicInteger--10000
 * Thread-5--count----6799
 * Thread-6----atomicInteger--9883
 * Thread-0----atomicInteger--9477
 * Thread-7--count----6179
 * Thread-9--count----6205
 * Thread-8--count----6208
 * Thread-9----atomicInteger--10000
 * Thread-7----atomicInteger--10000
 * Thread-5----atomicInteger--10000
 * Thread-1----atomicInteger--10000
 * Thread-8----atomicInteger--10000
 *
 * Process finished with exit code 0
 */
