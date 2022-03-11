package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/9 20:49
 *  @description 89. 格雷编码
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;

public class GrayCodeCase {
    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i=1;i<=n;i++){
            for(int j=res.size()-1;j>=0;j--){
                res.add(((1<<(i-1))+res.get(j)));
            }
        }
        return res;

    }

}
