package malin.sessionDemo;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/21 10:34  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/21-01  [malin.sessionDemo]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * malin.sessionDemo  功能说明：  提高缓存API
 * 			初始版本基础夯实积攒Java架构师的基础内容
 * @date   2019/6/21 10:34  今年一定要成为Java高级开发攻城狮
 * @author 马琳-君子自强，脚踏实地积累  CacheManager.java
 * @email 1217575485@qq.com
 */
public class CacheManager {

    //存放缓存数据
    private Map<String,Cache>  cacheMap= new HashMap<String , Cache>();
    public  void  put(String key,Object value){
        put(key,value,null);
    }


    public   synchronized   void put(String  key,Object  value,Long  timeout) {

        Cache  cache=new Cache();
        cache.setKey(key);
        cache.setValue(value);
        if(timeout!=null){
            cache.setTimeout(System.currentTimeMillis()+timeout);
        }
        cacheMap.put(key,cache);
    }

    public   synchronized   void del(String key){
        cacheMap.remove(key);
    }

    public  synchronized   void   remove(String key){
        System.out.println("key: "+key+" 删除成功.....");
        cacheMap.remove(key);
    }
    public synchronized  void checkValidityData(){
        for (String  key:cacheMap.keySet()){
            Cache cache=cacheMap.get(key);
            if(cache==null){
                break;
            }
            Long  timeout=cache.getTimeout();
            Long  currentTime=System.currentTimeMillis();
            //说明已经过期
            if((currentTime-timeout)>0){
                remove(key);
            }
        }
    }
    public  synchronized  Object  get(String  key){
        Cache cache=cacheMap.get(key);
        if(cache!=null){
            return cache.getValue();
        }
        return  null;
    }

    public static void main(String[] args) {
        final  CacheManager  cacheManager  =new CacheManager();
        cacheManager.put("userName","君子志邦",5000l);
        System.out.println("保存成功...");
        //定期检查刷新数据....  开启线程,检查有效期
        ScheduledExecutorService  scheduledExecutorService  = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("-----开始在检测----");
                cacheManager.checkValidityData();
                System.out.println("----- 检测已经结束----");
            }
        },5000,TimeUnit.MILLISECONDS);
        try{
            Thread.sleep(5000);
        }catch (Exception  ex){
            ex.printStackTrace();
        }
        String  userName=(String) cacheManager.get("userName");
        System.out.println("userName:"+userName);
    }







}
