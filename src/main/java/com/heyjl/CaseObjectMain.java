package com.heyjl;

import java.util.Random;
/**
 * 被测程序
 * 第一步：执行被侧程序，注意这里不能用idea 启动被测程序，否则btrace监听不到
 * cd /workspace/btrace/target/classes
 * java com.heyjl.CaseObjectMain
 *
 *
 */
public class CaseObjectMain {

    public static void main(String[] args) throws Exception{
        Random random=new Random();
        CaseObject object=new CaseObject();
        while(true){
            boolean result=object.execute(random.nextInt(1000));
            Thread.sleep(1000);
        }
    }
}
