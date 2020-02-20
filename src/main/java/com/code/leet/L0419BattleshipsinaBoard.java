/**
 * 
 */
package com.code.leet;

/**
 Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's,
 empty slots are represented with '.'s. You may assume the following rules:

 You receive a valid board, made of only battleships or empty slots.
 Battleships can only be placed horizontally or vertically.
 In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column),
 where N can be of any size.
 At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.

 */
public class L0419BattleshipsinaBoard {

	public static void main(String[] args) {
		// TODO 
		L0419BattleshipsinaBoard bean = new L0419BattleshipsinaBoard();
		char[][] input = new char[10][5];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = '.';
//				System.out.print(input[i][j]);
			}
//			System.out.println();
		}
		int result = bean.countBattleships(input);
		System.out.println(result);
		
	}
	
	//5ms
	public int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (
						i==0 && j==0 && board[i][j] == 'X'
						|| i!=0 && j==0 && board[i][j] == 'X' && board[i-1][j]== '.'
						|| i==0 && j!=0 && board[i][j] == 'X' && board[i][j-1]== '.'
						|| i!=0 && j!=0 && board[i][j] == 'X' && board[i-1][j]== '.' && board[i][j-1] == '.'
						) {
					count++;
				}
			}
		}
		return count;
    }
	
	//4ms
	public int countBattleships2(char[][] board) {
	    int count = 0;
	    for(int i=0;i<board.length;i++)
	        for(int j=0;j<board[0].length;j++)
	            if(board[i][j]=='X' && (i==0 || board[i-1][j]!='X') && (j==0 || board[i][j-1]!='X')) count++;
	        return count;
	    }
}
