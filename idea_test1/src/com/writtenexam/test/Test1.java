package com.writtenexam.test;
/*
 *  @author changqi
 *  @date 2022/3/5 13:01
 *  @description
 *  @Version V1.0
 */

import java.util.*;


public class Test1 {

    public static void main(String[] args) {


        PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);





        Scanner sc = new Scanner(System.in);

        String cur  = sc.nextLine();
        String ans = ""; //3[a4[b]] 3[a]2[b]

        Info process = process(cur, 0, 0);
//        ans = process;

        System.out.println(process.res);
//        int i = 0;




    }

    public static Info process(String cur, int index , int num) {

        if(index==cur.length()) {
            return new Info();
        }
        String s = "";
        String ans = "";
        int cnt = 0;
        int i=index;
        Info res = new Info();

        while(i<cur.length()) {
            char ch = cur.charAt(i);
            if(ch>='0' && ch<='9') {
                cnt = cnt*10+ch-'0';
                i++;
            } else if(ch=='[') {
                 Info temp =  process(cur,i+1,cnt);
                 i = temp.index+1;
                 ans += temp.res;
                 cnt = 0;

            } else if(ch==']') {
                for(int j=0;j<num;j++) {
                    s = s + ans;
                }
                res.index = i;
                res.res = s;
                return res;

            } else {
                ans = ans+ch;
                i++;
            }

        }

        res.index = i;
        res.res = ans;

        return res;
    }






}
class Info{
    public int index;
    public String res;


}