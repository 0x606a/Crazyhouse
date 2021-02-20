package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.ArrayList;

public class Laeufer extends Figur{
	private ArrayList<String> validmove;
	
	public Laeufer(String player){
		super(player);
		this.validmove = new ArrayList<String>();
	}

	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y) throws Exception {
		
		this.validmove.clear();
		
		if (this.getPlayer()=="w"){
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
			i=x-1;
			j=y+1;
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
			i=x+1;
			j=y+1;
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
			i=x+1;
			j=y-1;
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
        }else{ // player black
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
			i=x-1;
			j=y+1;
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
			i=x+1;
			j=y+1;
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
			i=x+1;
			j=y-1;
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
		return validmove;
	}	
}
