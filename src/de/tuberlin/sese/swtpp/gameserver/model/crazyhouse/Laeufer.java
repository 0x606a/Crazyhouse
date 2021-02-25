package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.ArrayList;

public class Laeufer extends Figur{
	private ArrayList<String> validmove;

	public Laeufer(String player){
		super(player);
		this.validmove = new ArrayList<String>();
	}
	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y) {

		this.validmove.clear();

		if (this.getPlayer()=="w")
		{
			checkLeftUp(board, x, y);

			checkRightUp(board, x, y);

			checkLeftDown(board, x, y);

			checkRightDown(board, x, y);

			return this.validmove;
		}
		else // player black
		{
			checkLeftUpB(board, x, y);

			checkRightUpB(board, x, y);

			checkLeftDownB(board, x, y);

			checkRightDownB(board, x, y);

			return this.validmove;
		}
	}
	private void checkLeftUp(char[][] board, int x, int y){

		int i=x-1;
		int j=y-1;
		while(i<board.length && i>=0 && j<board.length && j>=0){ //Links Oben
			if(board[i][j]=='\0'){
				String move=this.generateString(i, j);
				this.validmove.add(move);
			}
			if(Character.isLowerCase(board[i][j])){
				String move=this.generateString(i, j);
				this.validmove.add(move);
				break;
			}
			if(Character.isUpperCase(board[i][j])){
				break;
			}
			i--;
			j--;
		}
	}
	private void checkRightUp(char[][] board, int x, int y){

		int i=x-1;
		int j=y+1;
		while(i<board.length && i>=0 && j<board.length && j>=0){ //Rechts Oben
			if(board[i][j]=='\0'){
				String move=this.generateString(i, j);
				this.validmove.add(move);
			}
			if(Character.isLowerCase(board[i][j])){
				String move=this.generateString(i, j);
				this.validmove.add(move);
				break;
			}
			if(Character.isUpperCase(board[i][j])){
				break;
			}
			i--;
			j++;
		}
	}

	private void checkRightDown(char[][] board, int x, int y){

		int i=x+1;
		int j=y+1;
		while(i<board.length && i>=0 && j<board.length && j>=0){ //Rechts Unten
			if(board[i][j]=='\0'){
				String move=this.generateString(i,j);
				this.validmove.add(move);
			}
			if(Character.isLowerCase(board[i][j])){
				String move=this.generateString(i, j);
				this.validmove.add(move);
				break;
			}
			if(Character.isUpperCase(board[i][j])){
				break;
			}
			i++;
			j++;
		}
	}

	private void checkLeftDown(char[][] board, int x, int y){

		int i=x+1;
		int j=y-1;
		while(i<board.length && i>=0 && j<board.length && j>=0){ //Links Unten
			if(board[i][j]=='\0'){
				String move=this.generateString(i, j);
				this.validmove.add(move);
			}
			if(Character.isLowerCase(board[i][j])){
				String move=this.generateString(i, j);
				this.validmove.add(move);
				break;
			}
			if(Character.isUpperCase(board[i][j])){
				break;
			}
			i++;
			j--;
		}
	}

	private void checkLeftUpB(char[][] board, int x, int y){

		int i=x-1;
		int j=y-1;
		while(i<board.length && i>=0 && j<board.length && j>=0){ //Links Oben
			if(board[i][j]=='\0'){
				String move=this.generateString(i, j);
				this.validmove.add(move);
			}
			if(Character.isUpperCase(board[i][j])){
				String move=this.generateString(i, j);
				this.validmove.add(move);
				break;
			}
			if(Character.isLowerCase(board[i][j])){
				break;
			}
			i--;
			j--;
		}
	}

	private void checkRightUpB(char[][] board, int x, int y){

		int i=x-1;
		int j=y+1;
		while(i<board.length && i>=0 && j<board.length && j>=0){ //Rechts Oben
			if(board[i][j]=='\0'){
				String move=this.generateString(i, j);
				this.validmove.add(move);
			}
			if(Character.isUpperCase(board[i][j])){
				String move=this.generateString(i, j);
				this.validmove.add(move);
				break;
			}
			if(Character.isLowerCase(board[i][j])){
				break;
			}
			i--;
			j++;
		}
	}

	private void checkRightDownB(char[][] board, int x, int y){

		int i=x+1;
		int j=y+1;
		while(i<board.length && i>=0 && j<board.length && j>=0){ //Rechts Unten
			if(board[i][j]=='\0'){
				String move=this.generateString(i, j);
				this.validmove.add(move);
			}
			if(Character.isUpperCase(board[i][j])){
				String move=this.generateString(i, j);
				this.validmove.add(move);
				break;
			}
			if(Character.isLowerCase(board[i][j])){
				break;
			}
			i++;
			j++;
		}
	}

	private void checkLeftDownB(char[][] board, int x, int y){

		int i=x+1;
		int j=y-1;
		while(i<board.length && i>=0 && j<board.length && j>=0){ //Links unten
			if(board[i][j]=='\0'){
				String move=this.generateString(i, j);
				this.validmove.add(move);
			}
			if(Character.isUpperCase(board[i][j])){
				String move=this.generateString(i, j);
				this.validmove.add(move);
				break;
			}
			if(Character.isLowerCase(board[i][j])){
				break;
			}
			i++;
			j--;
		}
	}
}
