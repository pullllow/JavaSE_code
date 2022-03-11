package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/15 14:23
 *  @description 319. 灯泡开关
 *  @Version V1.0
 */

public class BulbSwitchCase {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println(bulbSwitch(i));
        }


    }

    public static int bulbSwitch(int n) {
        if(n==0){
            return n;
        }
        boolean[] res = new boolean[n];

        for(int i=1;i<=n;i++){
            for(int j=0;j<n;j++){
                if((j+1)%i==0){
                    res[j] = !res[j];
                }
            }
        }
        int count = 0;
        for(int j=0;j<n;j++){
            if(res[j]){
                count++;
            }
        }
        return count;
        //打表法

    }


}
