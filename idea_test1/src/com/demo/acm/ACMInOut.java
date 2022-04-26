package com.demo.acm;
/*
 *  @author changqi
 *  @date 2022/3/23 16:49
 *  @description
 *  @Version V1.0
 */

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ACMInOut {
    public static void main(String[] args) {
//        方法一：String的format方法（推荐）

        double f = 111231.5585;
        System.out.println(String.format("%.2f", f));

//        方法二：DecimalFormat的format方法

        //double f = 111231.5585;

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(f));

//        方法三：BigDecimal的setScale方法

        //double f = 111231.5585;

        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);


//        方法四：NumberFormat的setMaximumFractionDigits方法

        //double f = 111231.5585;

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(f));
    }
}
