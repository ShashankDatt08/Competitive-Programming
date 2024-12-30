package Backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean found = search(board , word , 0);
        System.out.println(found);
    }

    private static boolean search(char[][] board, String word, int index) {

        if(index == word.length()){
            return true;
        }

        if(index > word.length()){
            return false;
        }

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == word.charAt(index)){
                    board[i][j] = ' ';
                    if(search(board , word , index+1)){
                        return true;
                    }
                    board[i][j] = word.charAt(index);
                    System.out.println(board[i][j]);
                }
            }
        }

        return false;
    }
}
