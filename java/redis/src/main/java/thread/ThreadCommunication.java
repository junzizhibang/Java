package thread;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/15 11:01  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/15-01  [thread]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * thread  功能说明：线程进行交互通信,如何使用变量,比如交换的输出奇偶数,模拟生产者和消费者,锁同一个对象
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/15 11:07  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  ThreadCommunication.java
 * @email 1217575485@qq.com
 */
public class ThreadCommunication {

    public static void main(String[] args) {
        Res  res=new Res();
        BoyThread  boyThread=new BoyThread(res);
        GirlThread  girlThread=new GirlThread(res);
        boyThread.start();
        girlThread.start();
    }
}

class  Res{
    public  String userSex;
    public  String  userName;
    public  boolean flag=false;
    public  int  number=0;
    Lock  lock=new ReentrantLock();
    Condition condition= lock.newCondition();
}
class  BoyThread  extends  Thread{
    private  Res res;

    public BoyThread( Res res){
        this.res=res;
    }

    @Override
    public void run() {
           int countNum=0;

           while (true){
               try{
                   res.lock.lock();
                   if(res.flag){  //当前线程变为等待,但是可以释放锁
                       try{
                           res.condition.await();
                       }catch (Exception  ex){
                           ex.printStackTrace();
                           System.out.println(ex.getMessage());
                       }
                   }

               if(countNum%2==0){
                   res.userName="马云";
                   res.userSex="女的";
               }else{
                   res.userSex="男的";
                   res.userName="马云";
               }
               countNum++;
               res.flag=true;
               res.number=countNum;
               res.condition.signal();//唤醒当前线程

           }catch(Exception  ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            }finally {
                   res.lock.lock();
               }
               if(countNum>10){
                   break;
               }
           }

    }
}


/**
 * thread  功能说明：  模拟消费者,
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/15 11:45  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  ThreadCommunication.java
 * @email 1217575485@qq.com
 */
class  GirlThread  extends  Thread{
    private  Res  res;
    public  GirlThread(Res  res){
        this.res=res;
    }

    @Override
    public void run() {
       while(true){
           try {
               res.lock.lock();
               if(!res.flag){
                   try{
                       res.condition.await();
                   }catch (Exception ex){
                       ex.printStackTrace();
                       System.out.println(ex.getMessage());
                   }
               }
               System.out.println("姓名:"+res.userName+"\t性别:"+res.userSex+"\t奇偶性:"+res.number );
               res.flag=false;
               res.condition.signal();  //唤醒当前线程
           }catch (Exception  ex){
               ex.printStackTrace();
               System.out.println(ex.getMessage());
           }finally {
               res.lock.unlock();
           }
           if(res.number>10){
               break;
           }
       }
    }
}


/***     运行结果
 * D:\root\aplication\installpath\JDK\JDK1.8\bin\java.exe "-javaagent:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\lib\idea_rt.jar=57389:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\charsets.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\deploy.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\access-bridge-64.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\cldrdata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\dnsns.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jaccess.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jfxrt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\localedata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\nashorn.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunec.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunjce_provider.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunmscapi.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunpkcs11.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\zipfs.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\javaws.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jce.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfr.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfxswt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jsse.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\management-agent.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\plugin.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\resources.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\rt.jar;E:\root\workpacket\git\Ideal\java\redis\target\classes;D:\root\aplication\workinfo\Mavenrepo\redis\clients\jedis\3.0.1\jedis-3.0.1.jar;D:\root\aplication\workinfo\Mavenrepo\org\slf4j\slf4j-api\1.7.22\slf4j-api-1.7.22.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\commons\commons-pool2\2.4.3\commons-pool2-2.4.3.jar thread.ThreadCommunication
 * 姓名:马云	性别:女的	奇偶性:1
 * 姓名:马云	性别:男的	奇偶性:2
 * 姓名:马云	性别:女的	奇偶性:3
 * 姓名:马云	性别:男的	奇偶性:4
 * 姓名:马云	性别:女的	奇偶性:5
 * 姓名:马云	性别:男的	奇偶性:6
 * 姓名:马云	性别:女的	奇偶性:7
 * 姓名:马云	性别:男的	奇偶性:8
 * 姓名:马云	性别:女的	奇偶性:9
 * 姓名:马云	性别:男的	奇偶性:10
 *
 * Process finished with exit code -1
 */