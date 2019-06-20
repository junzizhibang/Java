package malin.jvm;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/13 21:35  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/13-01  [malin.jvm]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/


import java.io.InputStream;

/**
 * 功能说明 自定义类加载器
 *
 * @author 马琳-君子自强，脚踏实地积累
 * @date 2019年5月15日
 * @email 1217575485@qq.com
 */

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // 文件名称
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            // 获取文件输入流
            InputStream is = this.getClass().getResourceAsStream(fileName);
            // 读取字节
            byte[] b = new byte[is.available()];
            is.read(b);
            // 将byte字节流解析成jvm能够识别的Class对象
            return defineClass(name, b, 0, b.length);
        } catch (Exception e) {
            throw new ClassNotFoundException();
        }

    }

}
