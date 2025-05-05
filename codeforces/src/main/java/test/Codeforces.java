/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package test;
/**
 *
 * @author Num 1
 */
public class Codeforces {
   
  static final int N = 4; 
  //F1
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
       }
    
    /*
------------------------------------------------------------------------------------------------  
    "this is equvllint but i have used the first one enhanced usage of for loop ...."
    
    for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
    }
    System.out.println();  }
------------------------------------------------------------------------------------------------
    */

  
//------------------------------------------------------------------------------------------------



    
    //F2
    private static boolean isSafe(int[][] board, int row, int col) { // take them from solveQueens...
        for (int i = 0; i < row; i++) {  // all colum check ....
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) { //up left ....
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < N; i--, j++) { //up right ....
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    
    
  //-----------------------------------------------------------------------------------------  
    
    
   //F3
    private static boolean solveQueens(int[][] board, int row) { // recursive function.....
   
        if (row >= N) { //rows gets incremented before the base case is checked. //__base case___.....
            return true;  // stop here if not satisfied .....
        }

     
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) { 
                board[row][col] = 1;
                System.out.println("Placing queen at row " + row + ", column " + col);  // by index not postion .....
                printBoard(board);

             
                if (solveQueens(board, row + 1)) {
                    return true;    // and go up again 
                }
                
                board[row][col] = 0;  // remove queen .....
                System.out.println("Backtracking from row " + row + ", column " + col);
                printBoard(board);
            }
        }

        return false;
    }
    
    
//----------------------------------------------------------------------------------------------
    
    // code start .......
    public static void main(String[] args) {
        int[][] board = new int[N][N]; 

        System.out.println("Starting with an empty matrix:");
        printBoard(board);

        if (solveQueens(board, 0)) { // start from first row ....last value will appears 
            System.out.println("Solution:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");   // if no solution ...
        }
    }
}

