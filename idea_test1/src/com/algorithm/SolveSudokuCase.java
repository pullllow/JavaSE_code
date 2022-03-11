package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/10 15:26
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;

public class SolveSudokuCase {
    public static void main(String[] args) {
        char[][] board =
               {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        for(int i=0;i<board.length;i++){
            System.out.println(board[i]);
        }

    }
    static boolean[][] row = new boolean[9][9];
    static boolean[][] column = new boolean[9][9];
    static boolean[][] matrix = new boolean[9][9];
    static  List<int[]> position = new ArrayList<>();
    static boolean valid = false;

    public static void solveSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='.') {
                    position.add(new int[]{i,j});
                } else {
                    row[i][board[i][j]-'0'-1] = true;
                    column[j][board[i][j]-'0'-1] = true;
                    matrix[3*(i/3)+(j/3)][board[i][j]-'0'-1] = true;
                }
            }
        }
        backTrack(0,board);

    }

    //添加链表记录
    public static void backTrack(int pos, char[][] board){
        if(pos==position.size()){
            valid = true;
            return;
        }
        int[] xy = position.get(pos);
        for(int i=0;i<9 && !valid;i++){
            if(!row[xy[0]][i]&&!column[xy[1]][i]&&!matrix[3*(xy[0]/3)+(xy[1]/3)][i]){
                row[xy[0]][i] = true;
                column[xy[1]][i] = true;
                matrix[3*(xy[0]/3)+(xy[1]/3)][i] = true;
                board[xy[0]][xy[1]] = (char)('1'+i);
                backTrack(pos+1,board);

                row[xy[0]][i] = false;
                column[xy[1]][i] = false;
                matrix[3*(xy[0]/3)+(xy[1]/3)][i] = false;

            }

        }


    }

    /*
    public static  void solveSudoku(char[][] board) {
        backTrack(0,0,board);

    }


    public static  boolean check(int x, int y, char[][] board,char num){
        boolean flag = false;
        //check row
        for(int i=0;i<9;i++){
            if(i!=y && board[x][i]==num){
                return false;
            }
        }

        //check column
        for(int i=0;i<9;i++){
            if(i!=x && board[i][y]==num){
                return false;
            }
        }
        //check matrix
        // 9格
        int startX = 0;
        int startY = 0;
        if(x<3){
            startX=0;
            if(y<3){
                startY=0;
            } else if(y<6){
                startY=3;
            } else {
                startY=6;
            }
        } else if(x<6){
            startX=3;
            if(y<3){
                startY=0;
            } else if(y<6){
                startY=3;
            } else {
                startY=6;
            }
        } else{
            startX=6;
            if(y<3){
                startY=0;
            } else if(y<6){
                startY=3;
            } else {
                startY=6;
            }
        }
        for(int i=startX;i<startX+3;i++){
            for(int j=startY;j<startY+3;j++){
                if(i!=x && j!=y && board[i][j]==num){
                    return false;
                }
            }
        }

        return true;

    }

    public static  void backTrack(int x, int y,char[][] board) {
        if(y>=9){
            return;
        }
        if(board[x][y]!='.'){
            backTrack(x,y+1,board);

        } else {
            boolean flag = false;
            for(int i=0;i<9;i++){
                if(check(x,y,board,(char)('1'+i))){
                    flag = true;
                    board[x][y] = (char)('1'+ i);
                    backTrack(x,y+1,board);
                    board[x][y] = '.';
                }
            }

            return;



        }
        backTrack(x+1,0,board);

    }

    */

}
