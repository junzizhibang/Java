package thread;

import jdk.nashorn.internal.runtime.ECMAException;

/********************************************
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/15 10:42  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/15-01  [thread]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/
  class TrainThread   implements   Runnable{

    static  int trainCount=100;
    private  Object oj=new Object();
    public  boolean  flag=true;


    @Override
    public void run() {
        if(flag){  // 如果 falsg为true,先拿到object  ,这把锁才能进入show方法,进入show方法后需要this锁
            while(trainCount>0){
                synchronized (oj){
                    show();
                }
            }
        }else{   //  如果flag 为false,先拿到this 这把锁.才能进入show方法,进入show方法,然后拿到object锁
            while(trainCount>0){
                show();
            }
        }
    }

    private  synchronized    void show() {
        synchronized (oj){
            if(trainCount>0){
                try{
                    Thread.sleep(40);
                }catch (Exception  ex){
                    ex.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"出售第"+(100-trainCount+1)+"张票");
                trainCount--;
            }
        }
    }
}


public   class  ThreadTrain {
    /***
     * 验证死锁现象: 死锁产生的原因,这个示例验证的是同步中嵌套着同步
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        TrainThread  train=new TrainThread();
        Thread  thread1=new Thread(train,"一号窗口");
        Thread  thread2=new Thread(train,"二号窗口");
        thread1.start();
        Thread.sleep(100);
        train.flag=false;
        thread2.start();

    }
}

/***
 *
 *
 * D:\root\aplication\installpath\JDK\JDK1.8\bin\java.exe "-javaagent:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\lib\idea_rt.jar=55669:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\charsets.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\deploy.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\access-bridge-64.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\cldrdata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\dnsns.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jaccess.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jfxrt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\localedata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\nashorn.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunec.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunjce_provider.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunmscapi.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunpkcs11.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\zipfs.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\javaws.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jce.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfr.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfxswt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jsse.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\management-agent.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\plugin.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\resources.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\rt.jar;E:\root\workpacket\git\Ideal\java\redis\target\classes;D:\root\aplication\workinfo\Mavenrepo\redis\clients\jedis\3.0.1\jedis-3.0.1.jar;D:\root\aplication\workinfo\Mavenrepo\org\slf4j\slf4j-api\1.7.22\slf4j-api-1.7.22.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\commons\commons-pool2\2.4.3\commons-pool2-2.4.3.jar thread.ThreadTrain
 * 一号窗口出售第1张票
 * 一号窗口出售第2张票
 * 一号窗口出售第3张票
 * 一号窗口出售第4张票
 * 一号窗口出售第5张票
 * 一号窗口出售第6张票
 * 一号窗口出售第7张票
 * 一号窗口出售第8张票
 * 一号窗口出售第9张票
 * 一号窗口出售第10张票
 * 一号窗口出售第11张票
 * 一号窗口出售第12张票
 * 一号窗口出售第13张票
 * 一号窗口出售第14张票
 * 一号窗口出售第15张票
 * 一号窗口出售第16张票
 * 一号窗口出售第17张票
 * 一号窗口出售第18张票
 * 一号窗口出售第19张票
 * 一号窗口出售第20张票
 * 一号窗口出售第21张票
 * 一号窗口出售第22张票
 * 一号窗口出售第23张票
 * 一号窗口出售第24张票
 * 一号窗口出售第25张票
 * 一号窗口出售第26张票
 * 一号窗口出售第27张票
 * 一号窗口出售第28张票
 * 一号窗口出售第29张票
 * 一号窗口出售第30张票
 * 一号窗口出售第31张票
 * 一号窗口出售第32张票
 * 一号窗口出售第33张票
 * 一号窗口出售第34张票
 * 一号窗口出售第35张票
 * 一号窗口出售第36张票
 * 一号窗口出售第37张票
 * 一号窗口出售第38张票
 * 一号窗口出售第39张票
 * 一号窗口出售第40张票
 * 一号窗口出售第41张票
 * 一号窗口出售第42张票
 * 一号窗口出售第43张票
 * 一号窗口出售第44张票
 * 一号窗口出售第45张票
 * 一号窗口出售第46张票
 * 一号窗口出售第47张票
 * 一号窗口出售第48张票
 * 一号窗口出售第49张票
 * 一号窗口出售第50张票
 * 一号窗口出售第51张票
 * 一号窗口出售第52张票
 * 一号窗口出售第53张票
 * 一号窗口出售第54张票
 * 一号窗口出售第55张票
 * 一号窗口出售第56张票
 * 一号窗口出售第57张票
 * 一号窗口出售第58张票
 * 一号窗口出售第59张票
 * 一号窗口出售第60张票
 * 一号窗口出售第61张票
 * 一号窗口出售第62张票
 * 一号窗口出售第63张票
 * 一号窗口出售第64张票
 * 一号窗口出售第65张票
 * 一号窗口出售第66张票
 * 一号窗口出售第67张票
 * 一号窗口出售第68张票
 * 一号窗口出售第69张票
 * 一号窗口出售第70张票
 * 一号窗口出售第71张票
 * 一号窗口出售第72张票
 * 一号窗口出售第73张票
 * 一号窗口出售第74张票
 * 一号窗口出售第75张票
 * 一号窗口出售第76张票
 * 一号窗口出售第77张票
 * 一号窗口出售第78张票
 * 一号窗口出售第79张票
 * 一号窗口出售第80张票
 * 一号窗口出售第81张票
 * 一号窗口出售第82张票
 * 一号窗口出售第83张票
 * 一号窗口出售第84张票
 * 一号窗口出售第85张票
 * 一号窗口出售第86张票
 * 一号窗口出售第87张票
 * 一号窗口出售第88张票
 * 一号窗口出售第89张票
 * 一号窗口出售第90张票
 * 一号窗口出售第91张票
 * 一号窗口出售第92张票
 * 一号窗口出售第93张票
 * 一号窗口出售第94张票
 * 一号窗口出售第95张票
 * 一号窗口出售第96张票
 * 一号窗口出售第97张票
 * 一号窗口出售第98张票
 * 一号窗口出售第99张票
 * 一号窗口出售第100张票
 *
 * Process finished with exit code 0
 */