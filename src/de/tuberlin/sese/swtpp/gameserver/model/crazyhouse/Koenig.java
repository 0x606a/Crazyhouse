package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.ArrayList;

public class Koenig extends Figur
{
	private ArrayList<String> validmove;
	public Koenig(String player)
	{
		super(player);
		this.validmove = new ArrayList<String>();
	}
	public ArrayList<String> getValidmove(){return validmove;}
	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y) throws Exception 
	{
		this.validmove.clear();
		
		if ( this.getPlayer()=="w"){
			if(y>0 && y<7){ //ohne Rand
				//moegliche freie Felder
				if(board[x-1][y]=='\0'){
					String move = this.generateString(x-1, y);
					this.validmove.add(move);
				}
				if(board[x+1][y]=='\0'){
					String move = this.generateString(x+1, y);
					this.validmove.add(move);
				}
				if(board[x][y-1]=='\0'){
					String move = this.generateString(x, y-1);
					this.validmove.add(move);
				}
				if(board[x][y+1]=='\0'){
					String move = this.generateString(x, y+1);
					this.validmove.add(move);
				}
				if(board[x-1][y-1]=='\0'){
					String move = this.generateString(x-1, y-1);
					this.validmove.add(move);
				}
				if(board[x-1][y+1]=='\0'){
					String move = this.generateString(x-1, y+1);
					this.validmove.add(move);
				}
				if(board[x+1][y+1]=='\0'){
					String move = this.generateString(x+1, y+1);
					this.validmove.add(move);
				}
				if(board[x+1][y-1]=='\0'){
					String move = this.generateString(x+1, y-1);
					this.validmove.add(move);
				}
				//Moeglichkeiten zu schlagen
				if(Character.isLowerCase(board[x-1][y])){
					String move = this.generateString(x-1, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+1][y])){
					String move = this.generateString(x+1, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x][y-1])){
					String move = this.generateString(x, y-1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x][y+1])){
					String move = this.generateString(x, y+1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-1][y-1])){
					String move = this.generateString(x-1, y-1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-1][y+1])){
					String move = this.generateString(x-1, y+1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+1][y+1])){
					String move = this.generateString(x+1, y+1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+1][y-1])) {
					String move = this.generateString(x + 1, y - 1);
					this.validmove.add(move);
				}
			}
			else{ // falls der Koenig an einem der Raender steht
				if(y==0) { // linker Rand
					//moegliche freie Felder
					if(board[x-1][y]=='\0'){
						String move = this.generateString(x-1, y);
						this.validmove.add(move);
					}
					if(board[x+1][y]=='\0'){
						String move = this.generateString(x+1, y);
						this.validmove.add(move);
					}
					if(board[x][y+1]=='\0'){
						String move = this.generateString(x, y+1);
						this.validmove.add(move);
					}
					if(board[x-1][y+1]=='\0'){
						String move = this.generateString(x-1, y+1);
						this.validmove.add(move);
					}
					if(board[x+1][y+1]=='\0'){
						String move = this.generateString(x+1, y+1);
						this.validmove.add(move);
					}
					//Moeglichkeiten zu schlagen
					if(Character.isLowerCase(board[x-1][y])){
						String move = this.generateString(x - 1, y);
						this.validmove.add(move);
					}
					if(Character.isLowerCase(board[x+1][y])){
						String move = this.generateString(x+1, y);
						this.validmove.add(move);
					}
					if(Character.isLowerCase(board[x][y+1])){
						String move = this.generateString(x, y+1);
						this.validmove.add(move);
					}
					if(Character.isLowerCase(board[x-1][y+1])){
						String move = this.generateString(x-1, y+1);
						this.validmove.add(move);
					}
					if(Character.isLowerCase(board[x+1][y+1])){
						String move = this.generateString(x+1, y+1);
						this.validmove.add(move);
					}
				}
				if(y==7){ // rechter Rand
					//moegliche freie Felder
					if(board[x-1][y]=='\0'){
						String move = this.generateString(x-1, y);
						this.validmove.add(move);
					}
					if(board[x+1][y]=='\0'){
						String move = this.generateString(x+1, y);
						this.validmove.add(move);
					}
					if(board[x][y-1]=='\0'){
						String move = this.generateString(x, y-1);
						this.validmove.add(move);
					}
					if(board[x-1][y-1]=='\0'){
						String move = this.generateString(x-1, y-1);
						this.validmove.add(move);
					}
					if(board[x+1][y-1]=='\0'){
						String move = this.generateString(x+1, y-1);
						this.validmove.add(move);
					}
					//Moeglichkeiten zu schlagen
					if(Character.isLowerCase(board[x-1][y])){
						String move = this.generateString(x-1, y);
						this.validmove.add(move);
					}
					if(Character.isLowerCase(board[x+1][y])){
						String move = this.generateString(x+1, y);
						this.validmove.add(move);
					}
					if(Character.isLowerCase(board[x][y-1])){
						String move = this.generateString(x, y-1);
						this.validmove.add(move);
					}
					if(Character.isLowerCase(board[x-1][y-1])){
						String move = this.generateString(x-1, y-1);
						this.validmove.add(move);
					}
					if(Character.isLowerCase(board[x+1][y-1])){
						String move = this.generateString(x+1, y-1);
						this.validmove.add(move);
					}
				}
				//oberer und unterer Rand und gleiche figur auf feld break to be done?
			}
		}
		else{  // black player
			if(y>0 && y<7){ //ohne Rand
				//moegliche freie Felder
				if(board[x-1][y]=='\0'){
					String move = this.generateString(x-1, y);
					this.validmove.add(move);
				}
				if(board[x+1][y]=='\0'){
					String move = this.generateString(x+1, y);
					this.validmove.add(move);
				}
				if(board[x][y-1]=='\0'){
					String move = this.generateString(x, y-1);
					this.validmove.add(move);
				}
				if(board[x][y+1]=='\0'){
					String move = this.generateString(x, y+1);
					this.validmove.add(move);
				}
				if(board[x-1][y-1]=='\0'){
					String move = this.generateString(x-1, y-1);
					this.validmove.add(move);
				}
				if(board[x-1][y+1]=='\0'){
					String move = this.generateString(x-1, y+1);
					this.validmove.add(move);
				}
				if(board[x+1][y+1]=='\0'){
					String move = this.generateString(x+1, y+1);
					this.validmove.add(move);
				}
				if(board[x+1][y-1]=='\0'){
					String move = this.generateString(x+1, y-1);
					this.validmove.add(move);
				}
				//Moeglichkeiten zu schlagen
				if(Character.isUpperCase(board[x-1][y])){
					String move = this.generateString(x-1, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+1][y])){
					String move = this.generateString(x+1, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x][y-1])){
					String move = this.generateString(x, y-1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x][y+1])){
					String move = this.generateString(x, y+1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-1][y-1])){
					String move = this.generateString(x-1, y-1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-1][y+1])){
					String move = this.generateString(x-1, y+1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+1][y+1])){
					String move = this.generateString(x+1, y+1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+1][y-1])){
					String move = this.generateString(x+1, y-1);
					this.validmove.add(move);
				}
			}
			else{ // falls der Koenig an einem der Raender steht
				if(y==0) { // linker Rand
					//moegliche freie Felder
					if(board[x-1][y]=='\0'){
						String move = this.generateString(x-1, y);
						this.validmove.add(move);
					}
					if(board[x+1][y]=='\0'){
						String move = this.generateString(x+1, y);
						this.validmove.add(move);
					}
					if(board[x][y+1]=='\0'){
						String move = this.generateString(x, y+1);
						this.validmove.add(move);
					}
					if(board[x-1][y+1]=='\0'){
						String move = this.generateString(x-1, y+1);
						this.validmove.add(move);
					}
					if(board[x+1][y+1]=='\0'){
						String move = this.generateString(x+1, y+1);
						this.validmove.add(move);
					}
					//Moeglichkeiten zu schlagen
					if(Character.isUpperCase(board[x-1][y])){
						String move = this.generateString(x - 1, y);
						this.validmove.add(move);
					}
					if(Character.isUpperCase(board[x+1][y])){
						String move = this.generateString(x+1, y);
						this.validmove.add(move);
					}
					if(Character.isUpperCase(board[x][y+1])){
						String move = this.generateString(x, y+1);
						this.validmove.add(move);
					}
					if(Character.isUpperCase(board[x-1][y+1])){
						String move = this.generateString(x-1, y+1);
						this.validmove.add(move);
					}
					if(Character.isUpperCase(board[x+1][y+1])){
						String move = this.generateString(x+1, y+1);
						this.validmove.add(move);
					}
				}
				if(y==7){ // rechter Rand
					//moegliche freie Felder
					if(board[x-1][y]=='\0'){
						String move = this.generateString(x-1, y);
						this.validmove.add(move);
					}
					if(board[x+1][y]=='\0'){
						String move = this.generateString(x+1, y);
						this.validmove.add(move);
					}
					if(board[x][y-1]=='\0'){
						String move = this.generateString(x, y-1);
						this.validmove.add(move);
					}
					if(board[x-1][y-1]=='\0'){
						String move = this.generateString(x-1, y-1);
						this.validmove.add(move);
					}
					if(board[x+1][y-1]=='\0'){
						String move = this.generateString(x+1, y-1);
						this.validmove.add(move);
					}
					//Moeglichkeiten zu schlagen
					if(Character.isUpperCase(board[x-1][y])){
						String move = this.generateString(x-1, y);
						this.validmove.add(move);
					}
					if(Character.isUpperCase(board[x+1][y])){
						String move = this.generateString(x+1, y);
						this.validmove.add(move);
					}
					if(Character.isUpperCase(board[x][y-1])){
						String move = this.generateString(x, y-1);
						this.validmove.add(move);
					}
					if(Character.isUpperCase(board[x-1][y-1])){
						String move = this.generateString(x-1, y-1);
						this.validmove.add(move);
					}
					if(Character.isUpperCase(board[x+1][y-1])){
						String move = this.generateString(x+1, y-1);
						this.validmove.add(move);
					}
				}
				//oberer und unterer Rand to be done?
			}
		}
		return validmove;
	}	
}

