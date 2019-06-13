package malin.proxy;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/13 21:29  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/13-01  [malin.proxy]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/




import malin.service.UserInfoService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 功能说明：每次生成动态代理类对象时,实现了InvocationHandler接口的调用处理器对象
 *
 * @date 2019年5月15日
 * @author 马琳-君子自强，脚踏实地积累
 * @email 1217575485@qq.com
 *
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private Object target;// 这其实业务实现类对象，用来调用具体的业务方法
    // 通过构造函数传入目标对象

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("使用jdk动态代理 开启事务");
        result = method.invoke(target, args);
        System.out.println("使用jdk动态代理 提交事务");
        return result;
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // 被代理对象
        // IUserDao userDao = new UserDao();
        // UserService userService = new UserServiceImpl();
//        UserInfoService   memberServiceImpl = new MemberServiceImpl();
//        InvocationHandlerImpl invocationHandlerImpl = new InvocationHandlerImpl(memberServiceImpl);
//        ClassLoader loader = memberServiceImpl.getClass().getClassLoader();
//        Class<?>[] interfaces = memberServiceImpl.getClass().getInterfaces();
//        // 主要装载器、一组接口及调用处理动态代理实例
//        MemberService newProxyInstance = (MemberService) Proxy.newProxyInstance(loader, interfaces,
//                invocationHandlerImpl);
//        newProxyInstance.memberAdd();
    }

}
