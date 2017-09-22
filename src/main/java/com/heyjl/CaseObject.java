package com.heyjl;

/**
 * Created by jalo on 2017/9/22.
 */
public class CaseObject{

    private static int sleepTotalTime=0;

    public boolean execute(int sleepTime) throws Exception{
        System.out.println("sleep: "+sleepTime);
        sleepTotalTime+=sleepTime;
        Thread.sleep(sleepTime);
        if(sleepTime%2==0)
            return true;
        else
            return false;
    }

}
