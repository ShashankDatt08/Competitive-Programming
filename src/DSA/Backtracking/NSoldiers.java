package Backtracking;

public class NSoldiers {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] arr = new boolean[n][n];
        System.out.println(soldierR(arr,0,0,4));

    }

    static int soldierR(boolean[][] arr , int row , int col , int soldiers){

        if(soldiers == 0){
            display(arr);
            System.out.println();
            return 1;
        }
        if (row == arr.length) {
            return 0;
        }
        if(col == arr.length){
            return soldierR(arr,row+1,0,soldiers);

        }

        int count = 0;
        if(isSafe(arr,row,col)){
            arr[row][col] = true;
            count += soldierR(arr,row,col+1,soldiers-1);
            arr[row][col] = false;
        }
        count += soldierR(arr, row, col + 1, soldiers);
        return count;
    }



    static boolean isSafe(boolean[][] arr,int row,int col){

        int count = 0;
        for (int i = 0; i < row; i++) {
            if (arr[i][col]) {
                count++;
                if (i == row - 1) {
                    return false;
                }
            }
        }

        if (count >= 2) {
            return false;
        }

        if(col > 0 && arr[row][col-1]){
            return false;
        }

        if(col < arr.length-1 && arr[row][col+1]){
            return false;
        }

        if(row > 0 && col > 0 && arr[row - 1][col - 1]) {
            return false;
        }
        if (row > 0 && col < arr.length - 1 && arr[row - 1][col + 1]) {
            return false;
        }

        if(row > 0 && arr[row - 1][col]) {
            return false;
        }

        return true;

    }

    static void display(boolean[][] arr) {
        for (boolean[] row : arr) {
            for (boolean col : row) {
                if (col) {
                    System.out.print("S ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }

    }
}
