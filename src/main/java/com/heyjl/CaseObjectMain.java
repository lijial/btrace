package com.heyjl;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Random;

/**
 * 使用btrace-bin-1.3.8.3 版本，环境变量如下
 * export BTRACE_HOME=/Users/lijialiang/soft/btrace-bin-1.3.8.3/
 * PATH=$PATH:$BTRACE_HOME/bin
 * <p>
 * CaseObjectMain是被监听的程序
 * 第一步：执行被侧程序，注意这里不能用idea 启动被测程序，否则btrace监听不到
 * cd workspace/btrace/target/classes
 * java com.heyjl.CaseObjectMain
 */
public class CaseObjectMain {

    public static void main(String[] args) throws Exception {
        Random random = new Random();
        CaseObject object = new CaseObject();
        int count = 0;
        while (count <= 1000000000) {
            int result = object.execute(count++);
        }
    }

    public static int getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])
                .intValue();
    }
}
