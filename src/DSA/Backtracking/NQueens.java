package Backtracking;

public class NQueens {

    public static void main(String[] args) {
        int nQueens = 4;
        boolean[][] arr = new boolean[nQueens][nQueens];
        int count = queens(arr,0);
        System.out.println(count);
    }

    static int queens(boolean[][] arr , int row){

        if(row == arr.length){
            display(arr);
            System.out.println();
            return 1;
        }


        int count = 0;
        for(int col = 0; col < arr.length; col++){
            if(isSafe(arr,row,col)){
                arr[row][col] = true;
                count += queens(arr, row + 1);
                arr[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] arr, int row, int col) {
        for(int i = 0; i < row; i++){
            if(arr[i][col]){
                return false;
            }
        }

        int maxLeft = Math.min(row , col);
        for(int i = 1; i <= maxLeft; i++){
            if(arr[row-i][col-i]){
                return false;
            }
        }

        int maxRight = Math.min(row , arr.length-col-1);
        for(int i = 1; i <= maxRight; i++){
            if(arr[row-i][col+i]){
                return false;
            }
        }
        return true;
    }


    private static void display(boolean[][] arr) {
        for(boolean[] row : arr){
            for(boolean col : row){
                if(col){
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}

