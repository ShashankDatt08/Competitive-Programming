package Backtracking;

public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {
                {'7', '.', '2', '.', '5', '.', '6', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                {'1', '.', '.', '.', '.', '9', '5', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '4', '3', '.', '.', '.', '7', '5', '.'},
                {'.', '9', '.', '.', '.', '.', '.', '.', '8'},
                {'.', '.', '9', '7', '.', '.', '.', '.', '5'},
                {'.', '.', '.', '2', '.', '.', '.', '.', '.'},
                {'.', '.', '7', '.', '4', '.', '2', '.', '3'}
        };

        printBoard(board);
        System.out.println();

        if (solveBoard(board)) {
            System.out.println("Solved successfully!");
        }
        else {
            System.out.println("Unsolvable board :(");
        }
        System.out.println();

        printBoard(board);

    }

    private static boolean solveBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    for(char numberToTry = '1' ; numberToTry <= '9' ; numberToTry++){
                        if(isValidPlacement(board,i,j,numberToTry)){
                            board[i][j] = numberToTry;
                            if(solveBoard(board) ) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidPlacement(char[][] board, int row, int col, char numberToTry) {

        for(int i = 0; i < 9; i++){
            if(board[i][col] == numberToTry || board[row][i] == numberToTry){
                return false;
            }
        }

        int startRow = row - (row % 3);
        int startCol = col - (col % 3);

        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == numberToTry){
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------------------");
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print(" | ");
                }

                System.out.print(board[row][col] == 0 ? ". " : board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
