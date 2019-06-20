package malin.jvm;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/13 21:36  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/13-01  [malin.jvm]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;


/**
 * 功能说明： JAVA反射基础
 *
 * @author 马琳-君子自强，脚踏实地积累
 * @date 2019年5月14日
 * @email 1217575485@qq.com
 */
public class JAVAJDKreflect {

    /****
     *
     * 使用java字节码技术创建字节码
     *
     * @throws CannotCompileException
     * @throws NotFoundException
     * @throws IOException
     */
    public static void ByJavassist() throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool = ClassPool.getDefault();
        // 1.创建user类
        CtClass userClass = pool.makeClass("com.study.days.jvm.User");
        // 2.创建name 和age属性
        CtField nameField = CtField.make("	private String name;", userClass);
        CtField ageField = CtField.make("	private Integer age;", userClass);
        // 3.添加属性
        userClass.addField(nameField);
        userClass.addField(ageField);
        // 4.创建方法
        CtMethod nameMethod = CtMethod.make("public String getName() {return name;}", userClass);
        // 5.添加方法
        userClass.addMethod(nameMethod);
        // 6.添加构造函数
        CtConstructor ctConstructor = new CtConstructor(
                new CtClass[]{pool.get("java.lang.String"), pool.get("java.lang.Integer")}, userClass);

        ctConstructor.setBody("	{ this.name = name; this.age = age; }");
        userClass.addConstructor(ctConstructor);

        // 生成class文件
        userClass.writeFile("D:/IT/files");

    }

    /****
     *
     * 使用反射技术执行某方法
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static void ByJAVAreflect() throws ClassNotFoundException, NoSuchMethodException,
            SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        Class<?> forName = Class.forName("com.study.days.jvm.JAVAJDKreflect");
        Object newInstance = forName.newInstance();
        Method method = forName.getDeclaredMethod("sum", int.class, int.class);
        method.invoke(newInstance, 1, 5);
    }

    /***
     *
     * 动态修改字节码文件
     *
     */
    public static void DynasticByJavassist() {
        try {
            ClassPool pool = ClassPool.getDefault();
            // 读取com.itmayiedu.User
            CtClass userClass = pool.get("com.study.days.jvm.User");
            CtMethod method = new CtMethod(CtClass.voidType, "sum", new CtClass[]{CtClass.intType, CtClass.intType},
                    userClass);
            method.setBody("{System.out.println(\"sun:\" + ($1 + $2));}");
            // 添加方法
            userClass.addMethod(method);
            userClass.writeFile("D:/IT/files");
            // 动态执行方法
            Class clazz = userClass.toClass();
            Object newInstance = clazz.newInstance();

            Method sumMethod = clazz.getDeclaredMethod("sum", int.class, int.class);
            System.out.println("开启事物");
            sumMethod.invoke(newInstance, 2, 5);
            // 使用 javassist 实现动态代理。
            System.out.println("提交事物");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //使用java字节码技术创建字节码
        ByJavassist();
        //使用反射技术执行某方法
        ByJAVAreflect();
        //动态修改字节码文件
        DynasticByJavassist();
    }
}
