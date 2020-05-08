package com.heyjl;

/**
 * Created by jalo on 2017/9/22.
 */
public class CaseObject {

    public final int sevenSecond = 1000 * 7;
    public final int threeSecond = 1000 * 3;


    public int execute(int input) throws Exception {
        int output = input;
        System.out.println("sleeptime is threeSecond, pid:" + CaseObjectMain.getProcessID());
        Thread.sleep(threeSecond);
        return output;
    }


}
