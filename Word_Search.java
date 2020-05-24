/*
Given a 2D board and a word, determines whether The word can be constructed from letters of adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. The same cell can only be used once.
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for(int i=0; i<board.length; i++){ //number of rows
            for(int j=0; j<board[0].length; j++){   //number of columns
                if(dfs(board, i, j, 0, arr)) return true;
            }
        }       //i is xth row and j is xth column
        return false;
    }
    public static boolean dfs(char[][] board, int i, int j, int index, char[] word){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word[index] != board[i][j]) return false;
        
        char c = board[i][j]; //current cell
        if(index == word.length-1) return true; //empty
        
        board[i][j] = '.'; //represents visited cell
        if(dfs(board, i-1, j, index+1, word)) return true; //bc this can make i= -1 
        if(dfs(board, i+1, j, index+1, word)) return true;
        if(dfs(board, i, j-1, index+1, word)) return true; 
        if(dfs(board, i, j+1, index+1, word)) return true;//this can make j==board[0].length
      
        board[i][j] = c; //explored all the possibilites
        return false;
    }
}
//this accounts for adjacent cells 
//index is going through arr, which is word