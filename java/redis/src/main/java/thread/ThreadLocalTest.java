package thread;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/15 12:10  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/15-01  [thread]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/
public class ThreadLocalTest {
    public static void main(String[] args) {

        ResSign  res=new  ResSign();
        ThreadLocalDemo demo1=new ThreadLocalDemo(res);
        ThreadLocalDemo demo2=new ThreadLocalDemo(res);
        ThreadLocalDemo demo3=new ThreadLocalDemo(res);
        demo1.start();
        demo2.start();
        demo3.start();
    }
}
/**
 * thread  功能说明：   作为一个类的信号量
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/15 12:14  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  ThreadLocalTest.java
 * @email 1217575485@qq.com
 */
class  ResSign{
    /**
     * 设置本地局部变量,和其他线程局部变量隔离开,互不影响;
     *       设置当前线程局部变量,初始化值
     */
    private  ThreadLocal<Integer>  count=new ThreadLocal<Integer>(){
        protected  Integer initialValue(){
            return   0;
        };
    };

    /***
     * 模拟生成订单号
     * @return
     */
    public  Integer  getNum(){
        int count=this.count.get()+1;
        this.count.set(count);
        return  count;
    }

}

class  ThreadLocalDemo  extends  Thread{
    private  ResSign  res;
    public  ThreadLocalDemo(ResSign  res){
        this.res=res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try{
                Thread.sleep(10);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            System.out.println(getName()+"  "+i+";Number: " +  res.getNum());
        }
    }
}


/****  运行结果如下;局部变量使用的数据可以避免被其他线程影响
 *
 * D:\root\aplication\installpath\JDK\JDK1.8\bin\java.exe "-javaagent:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\lib\idea_rt.jar=58043:D:\root\aplication\installpath\IDEAL\IntelliJ IDEA 2018.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\charsets.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\deploy.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\access-bridge-64.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\cldrdata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\dnsns.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jaccess.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\jfxrt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\localedata.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\nashorn.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunec.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunjce_provider.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunmscapi.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\sunpkcs11.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\ext\zipfs.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\javaws.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jce.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfr.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jfxswt.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\jsse.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\management-agent.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\plugin.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\resources.jar;D:\root\aplication\installpath\JDK\JDK1.8\jre\lib\rt.jar;E:\root\workpacket\git\Ideal\java\redis\target\classes;D:\root\aplication\workinfo\Mavenrepo\redis\clients\jedis\3.0.1\jedis-3.0.1.jar;D:\root\aplication\workinfo\Mavenrepo\org\slf4j\slf4j-api\1.7.22\slf4j-api-1.7.22.jar;D:\root\aplication\workinfo\Mavenrepo\org\apache\commons\commons-pool2\2.4.3\commons-pool2-2.4.3.jar thread.ThreadLocalTest
 * Thread-2  0;Number: 1
 * Thread-0  0;Number: 1
 * Thread-1  0;Number: 1
 * Thread-0  1;Number: 2
 * Thread-2  1;Number: 2
 * Thread-1  1;Number: 2
 * Thread-0  2;Number: 3
 * Thread-1  2;Number: 3
 * Thread-2  2;Number: 3
 * Thread-0  3;Number: 4
 * Thread-2  3;Number: 4
 * Thread-1  3;Number: 4
 * Thread-1  4;Number: 5
 * Thread-2  4;Number: 5
 * Thread-0  4;Number: 5
 * Thread-0  5;Number: 6
 * Thread-2  5;Number: 6
 * Thread-1  5;Number: 6
 * Thread-1  6;Number: 7
 * Thread-0  6;Number: 7
 * Thread-2  6;Number: 7
 * Thread-0  7;Number: 8
 * Thread-1  7;Number: 8
 * Thread-2  7;Number: 8
 * Thread-1  8;Number: 9
 * Thread-2  8;Number: 9
 * Thread-0  8;Number: 9
 * Thread-2  9;Number: 10
 * Thread-0  9;Number: 10
 * Thread-1  9;Number: 10
 *
 * Process finished with exit code 0
 */
