package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/11 15:57
 *  @description 10. 正则表达式匹配
 *  @Version V1.0
 */

public class IsMatchCase {
    public static void main(String[] args) {
        String s = "a";
        String p = ".*c";
        System.out.println(isMatch(s,p));

    }

    public static boolean isMatch(String s, String p) {
        if(s.length()==0||p.length()==0){
            return false;
        }
        return match(s,p,0,0);




    }

    public static  boolean match(String s, String p,int indexS,int indexP){
        if(indexS==s.length()&&indexP==p.length()){
            return true;
        }
        if(indexP==p.length()&&indexS<s.length()){
            return false;
        }
        if(indexS==s.length()&&indexP<p.length()){
            if(indexP+1<p.length()&&p.charAt(indexP+1)=='*'){
               return match(s,p,indexS,indexP+2);
            } else {
               return false;
            }

        }
        if(indexP+1<p.length()&&p.charAt(indexP+1)=='*'){
            //'*' 有三种选择
            // 直接为0
            // 匹配成功直接下一个
            // 匹配成功接着判断该indexP
            if(s.charAt(indexS)==p.charAt(indexP)||(p.charAt(indexP)=='.'&& indexS<s.length())){
                return match(s,p,indexS,indexP+2)||match(s,p,indexS+1,indexP+2)||match(s,p,indexS+1,indexP);
            } else {
                return match(s,p,indexS,indexP+2);
            }

        }
        if(s.charAt(indexS)==p.charAt(indexP)||(p.charAt(indexP)=='.'&&indexS<s.length())){
            return match(s,p,indexS+1,indexP+1);
        }



        return false;
    }
}
