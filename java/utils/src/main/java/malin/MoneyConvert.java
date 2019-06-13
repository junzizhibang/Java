package malin;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/13 20:30  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/13-01  [malin]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

/**
 * 功能说明：主要实现金额与汉字大小写的转换 金额转换，阿拉伯数字的金额转换成中国传统的形式如：（￥1011）－>（一 千零一拾一元整）输出。 去零的代码：
 *
 * @date 2019年5月8日
 * @author 马琳-君子自强，脚踏实地积累
 * @email 1217575485@qq.com
 *
 */
public class MoneyConvert {

    private static final char[] data = new char[] { '零', '壹', '贰', '叁', '肆','伍', '陆', '柒', '捌', '玖' };
    private static final char[] units = new char[] { '元', '拾', '佰', '仟', '万','拾', '佰', '仟', '亿' };

    public static void main(String[] args) {
        System.out.println(convert(135689123));

    }

    public static String convert(int money) {
        StringBuffer sbf = new StringBuffer();  //线程安全
        int unit = 0;
        while (money != 0) {
            sbf.insert(0, units[unit++]);//插入  char  字节  然后synchronized  确保多线程安全
            int number = money % 10;
            sbf.insert(0, data[number]);
            money /= 10;
        }

        return sbf.toString();
    }
}
/***
 * 运行结果显示：
 * 壹亿叁仟伍佰陆拾捌万玖仟壹佰贰拾叁元
 */
