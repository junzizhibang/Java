package malin.service;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/13 21:05  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/13-01  [malin.service]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import malin.beans.UserInfo;
import malin.dao.UserInfoDao;
import malin.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userDao;

    @Autowired
    private LogService logService;
    UserInfo user = new UserInfo();

    @Autowired
    private TransactionManager transactionManager;


    @Transactional(propagation = Propagation.REQUIRED)
    public void add() {
        logService.addLog();

        userDao.addUserInfo(user);
        int i = 1 / 0;
    }

    /***
     *
     *@功能描述 手动进行回滚事务
     *@作者 马琳-脚踏实地积累。Java进阶
     *@email 1217575485@qq.com
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void testAddUser() {
        try {
            userDao.addUserInfo(user);
            System.out.println("插入成功！  add方法执行完毕！");
            int i = 1 / 0;
            userDao.addUserInfo(user);

        } catch (Exception e) {
            System.out.println("事务开始回滚！");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

    }

    /***
     *
     *@功能描述 自动判断进行回滚！
     *@作者 马琳-脚踏实地积累。Java进阶
     *@email 1217575485@qq.com
     */
    public void autoTestAdd() {
        TransactionStatus status = null;
        try {
            status = transactionManager.begin();
            userDao.addUserInfo(user);
            System.out.println("插入成功");
            int i = 1 / 0;
            userDao.addUserInfo(user);
            System.out.println("插入成功");
            transactionManager.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            if (transactionManager != null) {
                transactionManager.rollBack(status);

            }
        }
    }


}






