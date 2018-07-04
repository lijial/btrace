package com.heyjl;

/**
 * BTrace Script Template
 * 第二步，执行btrace
 * jps CaseObjectMain的pid
 * btrace pid btrace/src/main/java/com/heyjl/TracingScript.java
 *
 * 精品：https://www.jianshu.com/p/dbb3a8b5c92f
 *
 * Created by jalo on 2017/9/22.
 */
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TracingScript {
    /* put your code here */
    /*指明要查看的方法，类*/
    @OnMethod(clazz="com.heyjl.CaseObject",method="execute",location=@Location(Kind.RETURN))
    /*主要两个参数是对象自己的引用 和 返回值，其它参数都是方法调用时传入的参数*/
    public static void traceExecute(@ProbeClassName String probeClassName,@ProbeMethodName String probeMethodName,
                                    int sleepTime, @Return boolean result,@Duration long time){
        println("调用堆栈！！");
        jstack();
        BTraceUtils.println("cost time:" + time);
        println(strcat("被测类名：",str(probeClassName)));
        println(strcat("被测函数名：",str(probeMethodName)));
        println(strcat("被测函数入参是：",str(sleepTime)));
//        println(strcat("返回结果是：",str(result)));
    }

}
