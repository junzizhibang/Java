package malin;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/13 20:28  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/13-01  [malin]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/


import java.io.File;

/**
 * 功能说明：批量修改文件名称
 *
 * @author 马琳-君子自强，脚踏实地积累
 * @date 2019年5月8日
 * @email 1217575485@qq.com
 */
public class BatchReName {

    public static String InitPath = "E:/QQjava面试";
    public static String containStr = "MK_";

    public static void main(String[] args) {
        // StringBuffer stf=new StringBuffer();
        // stf.append("[www.java1234.com]编写高质量代码：改善Java程序的151个建议.pdf");
        // System.out.println("判断是这个文件名称里面是否含有该字段："+stf.toString().contains(containStr));
        // System.out.println("删除文件名称之后该字段显示为："+stf.toString().replace(containStr,""));
        convertFileName(InitPath, true);  //true 操作对象为文件夹  ，false操作对象为文件
        convertFileName(InitPath, false);  //true 操作对象为文件夹  ，false操作对象为文件
    }

    public static void convertFileName(String flieName, boolean flag) {
        File file = new File(flieName);
        File[] fileArray = file.listFiles();
        if (fileArray.length > 0) {
            if (flag) {
                for (int i = 0; i < fileArray.length; i++) {
                    if (fileArray[i].isDirectory()) {
                        String name = fileArray[i].getName();
                        System.out.println("获取到文件夹名称：  " + fileArray[i].getName());
                        if (name.contains(containStr)) {
                            name = name.replace(containStr, "");
                            System.out.println("修改之后文件Name=" + name);
                            File desFile = new File(flieName + "/" + name);
                            fileArray[i].renameTo(desFile);
                        }
                    }
                }
            } else {
                for (int i = 0; i < fileArray.length; i++) {
                    if (!fileArray[i].isDirectory()) {
                        String name = fileArray[i].getName();
                        if (name.contains(containStr)) {
                            System.out.println("修改之前文件Name=" + name);
                            name = name.replace(containStr, "");
                            System.out.println("修改之后文件Name=" + name);
                            File desFile = new File(flieName + "/" + name);
                            fileArray[i].renameTo(desFile);
                        }
                    }
                }
            }
        }
    }
}
