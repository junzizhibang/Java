package malin.jvm;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/13 21:34  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/13-01  [malin.jvm]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/



import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 功能说明： 热 更新代码
 *
 * @date 2019年5月15日
 * @author 马琳-君子自强，脚踏实地积累
 * @email 1217575485@qq.com
 *
 */
public class HotCompile {
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException, InterruptedException {
        loadUser();
        System.gc();
        Thread.sleep(1000);// 等待资源回收
        // 需要被热部署的class文件
        File file1 = new File("F:\\test\\User.class");
        // 之前编译好的class文件
        File file2 = new File(
                "F:\\itmayiedujiangke2018-02-24\\itmayiedu_itmayiedu_day_17\\target\\classes\\com\\itmayiedu\\User.class");
        boolean isDelete = file2.delete();// 删除旧版本的class文件
        if (!isDelete) {
            System.out.println("热部署失败.");
            return;
        }
        file1.renameTo(file2);
        System.out.println("update success!");
        loadUser();
    }

    public static void loadUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        MyClassLoader myLoader = new MyClassLoader();
        Class<?> class1 = myLoader.findClass("com.itmayiedu.UserTest");
        Object obj1 = class1.newInstance();
        Method method = class1.getMethod("add");
        method.invoke(obj1);
        System.out.println(obj1.getClass());
        System.out.println(obj1.getClass().getClassLoader());
    }
}
