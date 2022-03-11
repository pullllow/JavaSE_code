package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/16 21:21
 *  @description
 *  @Version V1.0
 */

import java.util.*;

public class VisiblePointsCase {

    public static void main(String[] args) {



        System.out.println(Math.atan2(1,0));
        List<List<Integer>> points = new ArrayList<>();

        List<Integer> p1 = new ArrayList<>();

        p1.add(2);
        p1.add(1);

        List<Integer> p2 = new ArrayList<>();

        p2.add(2);
        p2.add(2);

        List<Integer> p3 = new ArrayList<>();

        p3.add(3);
        p3.add(4);

        List<Integer> p4= new ArrayList<>();

        p4.add(1);
        p4.add(1);

        List<Integer> location = new ArrayList<>();

        location.add(1);
        location.add(1);


        points.add(p1);
        points.add(p2);
        points.add(p3);

        int angle = 90;

        visiblePoints(points,angle,location);




    }

    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {

        List<Double> anglePoints = new ArrayList<>();
        int x0 = location.get(0);
        int y0 = location.get(1);
        int z = 0;
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            if(x==x0&&y==y0){
                z++;
            }

            Double temp = Math.atan((double) (y - y0) / (double) (x - x0));
            anglePoints.add(temp+Math.PI);
        }

        anglePoints.sort((o1, o2) -> (int) (o1-o2));

        int res = 0;

        for (int i = 0; i < anglePoints.size(); i++) {
             double maxAngle = anglePoints.get(i)+Math.PI*((double)angle/180.0);
             int temp = 1;
             for(int j=i+1;j<anglePoints.size();j++){
                 if(anglePoints.get(j)>=anglePoints.get(i) && anglePoints.get(j)<=maxAngle){
                     temp++;
                 } else {
                     break;
                 }
             }
             res = Math.max(res,temp);


        }

        return res+z;

    }
}
