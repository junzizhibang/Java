package malin.jvm;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/13 21:37  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/13-01  [malin.jvm]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/


import java.util.ArrayList;


/**
 * 功能说明：内存溢出问题JVMOOM
 *
 * @author 马琳-君子自强，脚踏实地积累
 * @date 2019年5月14日
 * @email 1217575485@qq.com
 */
public class JVMOOM {
    public static void main(String[] args) {


    }

    /****
     * 	   垃圾回收机制基本原则:内存不足的时候回去回收，内存如果足够，暂时不会区回收。 减少回收次数和回收的时间
     -Xms1m -Xmx50m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     *
     */
    public static void printGCDetails() {
        ArrayList<Object> listObject = new ArrayList<Object>();
        for (int i = 0; i < 10; i++) {
            System.out.println("i:" + i);
            Byte[] bytes = new Byte[1 * 1024 * 1024];
            listObject.add(bytes);
        }
        System.out.println("添加成功...");
    }

    /***
     *
     * 配置堆内存大小,读取设置
     *
     */
    public static void giveHeap() {
        byte[] b = new byte[25 * 1024 * 1024];
        System.out.println("分配了25M空间给数组[b.length=]" + b.length + " [b.hashCode()=]" + b.hashCode());

        System.out.println("最大内存" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        System.out.println("可用内存" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println("已经使用内存" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
    }

    /***
     * 配置新生代比例大小
     -Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
     *  SurvivorRatio=2 配置新生代中 eden from to 比例关系 2 1 1
     */
    public static void setSurvivorRatio() {
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[1 * 1024 * 1024];
            System.out.println("分配了1M空间给数组[b.length=]" + b.length);
        }
    }

    /****
     * 配置新生代和老年代
     *  -Xms20m -Xmx20m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
     -XX:+UseSerialGC -XX:NewRatio=2
     新生代与老年代占比 1/2 13696K
     *
     */
    public static void setNewRatio() {
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[1 * 1024 * 1024];
            System.out.println("分配了1M空间给数组[b.length=]" + b.length);
        }
    }

    /***
     * 栈溢出
     * // 最大深度:10636 244972 10805
     *
     */
    public static void setStack() {
        int count = 0;
        for (int i = 0; i < 10636; i++) {
            try {
                //System.out.println(count  +"\t");
                count++;
            } catch (Throwable e) {
                System.out.println("最大深度:" + count);
                e.printStackTrace();
            }
        }
    }


}
