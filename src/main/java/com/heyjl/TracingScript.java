package com.heyjl;

/**
 * BTrace Script Template
 * 第二步，执行btrace
 * jps CaseObjectMain的pid
 * btrace pid ${PATH}/TracingScript.java
 * <p>
 * 精品：https://www.jianshu.com/p/dbb3a8b5c92f
 * <p>
 *
 *
 * 一旦执行btrace命令，CaseObjectMain的控制台打印如下语句，可见调用了 instrument
  objc[7677]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/bin/java (0x102f094c0) and /Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/lib/libinstrument.dylib (0x10abd64e0). One of the two will be used. Which one is undefined.
  7677@jalos-MacBook-Pro.local
 */

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class TracingScript {
    /*指明要查看的方法，类，在注解@OnMethod上*/
    @OnMethod(clazz = "com.heyjl.CaseObject", method = "execute", location = @Location(Kind.RETURN))
    /*主要两个参数是对象自己的引用 和 返回值，其它参数都是方法调用时传入的参数*/
    public static void traceExecute(@ProbeClassName String probeClassName, @ProbeMethodName String probeMethodName,
                                    int supervisorMethodInput, @Return int result,
                                    @Duration long supervisorMethodInvokeCostTime) {
        long supervisorMethodInvokeCostTimeMs = supervisorMethodInvokeCostTime / 1000 / 1000;
        String backGround = "监听 CaseObject.execute()函数";
        BTraceUtils.println(backGround);
        BTraceUtils.println("调用 BTraceUtils.jstack() 查看堆栈,begin");
        BTraceUtils.jstack();
        BTraceUtils.println("CaseObject.execute()函数调用耗时:" + supervisorMethodInvokeCostTimeMs + " ms");
        BTraceUtils.println("调用 BTraceUtils.jstack() 查看堆栈,end\n");
        BTraceUtils.println(BTraceUtils.strcat("被监听类名：", BTraceUtils.str(probeClassName)));
        BTraceUtils.println(BTraceUtils.strcat("被监听函数名：", BTraceUtils.str(probeMethodName)));
        BTraceUtils.println(BTraceUtils.strcat("被监听函数入参是：", BTraceUtils.str(supervisorMethodInput)));
        BTraceUtils.println(BTraceUtils.strcat("被监听函数返回结果是：", BTraceUtils.str(result)));
    }

}
