package com.datastructure.horse;
/*
 *  @author changqi
 *  @date 2021/10/19 9:36
 *  @description
 *  @Version V1.0
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HorseChessBoard {

    private static int X; //棋盘的列数
    private static int Y; //棋盘的行数
    //标记棋盘的各个位置是否被访问
    private static boolean visited[];
    //标记是否棋盘所有位置被访问
    private static boolean finished; //true 成功

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 2; //初始位置行
        int column = 4; //初始位置列
        int[][] chessBoard = new int[X][Y];
        visited = new boolean[X * Y];
        //测试耗时
        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        //打印结果
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < X; j++) {
                System.out.printf("%-10d\t", chessBoard[i][j]);
            }
            System.out.println();
        }
        System.out.println("耗时" + (end - start) + "ms");


    }


    /**
     * @param chessBoard 棋盘
     * @param row        当前位置行
     * @param column     当前位置列
     * @param step       第几步
     * @return void
     * @Description traversalChessBoard
     **/
    public static void traversalChessBoard(int[][] chessBoard, int row, int column, int step) {
        chessBoard[row][column] = step;
        visited[row * X + column] = true;

        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);
        while (!ps.isEmpty()) {
            Point nextPoint = ps.remove(0);
            //traversalChessBoard(chessBoard, nextPoint.y, nextPoint.x, step + 1);
            //判断该点是否被访问过
            if (!visited[nextPoint.y * X + nextPoint.x]) {
                traversalChessBoard(chessBoard, nextPoint.y, nextPoint.x, step + 1);
            }
        }

        if (step < X*Y && !finished) {
            chessBoard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }


    }


    /**
     * @param curPoint
     * @return java.util.ArrayList<java.awt.Point>
     * @Description next 根据当前位置curPoint，计算下一步可以走的位置，最多8个位置
     **/
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> ps = new ArrayList<>();
        Point p = new Point();

        //判断0号位置是否可行
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p));
        }
        //判断1号位置是否可行
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p));
        }
        //判断2号位置是否可行
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p));
        }
        //判断3号位置是否可行
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p));
        }
        //判断4号位置是否可行
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p));
        }
        //判断5号位置是否可行
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p));
        }
        //判断6号位置是否可行
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = (curPoint.y - 2)) >= 0) {
            ps.add(new Point(p));
        }
        //判断7号位置是否可行
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p));
        }

        return ps;


    }

    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int step1 = next(o1).size();
                int step2 = next(o2).size();

                if (step1 > step2) {
                    return 1;
                } else if (step1 == step2) {
                    return 0;
                } else {
                    return -1;
                }

            }
        });

    }


}
