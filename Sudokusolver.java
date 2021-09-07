package project1;
import java.util.*;
public class Sudokusolver {


public static void main(String[] args) throws Exception{
		//int[][] board=new int [9][9];
		/*Scanner scn=new Scanner(System.in);
		System.out.println("Input the initial board");
		for(int i=0;i<9;i++){
			System.out.println("Inside "+(i+1)+" Row");
			for(int j=0;j<9;j++){
				
				board[i][j]=scn.nextInt();

			}
		}
		*/
		 int[][] board = {
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
		for(int i=0;i<9;i++){
			
			for(int j=0;j<9;j++){
				System.out.print(board[i][j]+" ");
				
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
		  // Calling the function sudoku solver and passing the board and starting row as arguments
		System.out.println("The solved board is: ");
		Solvesudoku(board,0,0);   
		System.out.println("------------------------------------");
		
	}
public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

	public static void Solvesudoku(int[][] board, int row, int col){
		       //Size of the board
		//Determining where to go next
		
		if(row==board.length){
			display(board);
			return;
		}
		
		int newrow=0;
		int newcol=0;
		 if(col== board[0].length-1){
			newrow=row+1;
			newcol=0;
		}
		else{
			newrow=row;
			newcol=col+1;
		}
		//if non-zero value is in board[row][col] then do nothing and go to next step
		if(board[row][col]!=0){
			Solvesudoku(board,newrow,newcol);
		}
		else{
			//choose from all possible options
			for(int po=1;po<=9;po++){
				if(ispossible(board,row,col,po)){
					board[row][col]=po;
					Solvesudoku(board,newrow,newcol);
					board[row][col]=0;          //if while backtracking
				}

			}
		}
	}

	public static boolean ispossible(int[][]board,int x, int y, int val){
		int n=board.length;
		for (int i = 0; i < n; i++) {
		      if (board[x][i] == val) {
		        return false;
		      }
		    }

		    for (int i = 0; i < n; i++) {
		      if (board[i][y] == val) {
		        return false;
		      }
		    }

		    x = x / 3 * 3;
		    y = y / 3 * 3;
		    for (int i = 0; i < 3; i++) {
		      for (int j = 0; j < 3; j++) {
		        if (board[x + i][y + j] == val) {
		          return false;
		        }
		      }
		    }

		    return true;
}

	
}
