package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.List;
import java.util.ArrayList;

public class Laeufer extends Figur{
	private ArrayList<String> validmove;
	
	public Laeufer(String player)
	{
		super(player);
		this.validmove = new ArrayList<String>();
	}

	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y) throws Exception {
		this.validmove.clear();
		if(x >7 || y>7 || y<0 || x<0)// pr�fe ob die Boardgrenze erreicht ist
    	{	
    		throw new Exception(" uebergebene Position fuer den Laeufer liegt nicht auf dem Spielfeld");
    		
    	}
		if (this.getPlayer()=="w"){
			int i=x;
			int j=y;
			while(i<board.length || j<board.length){ //Links Oben
				if(board[i][j]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[i][j])){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[i][j])){
					break;
				}
				i--;
				j--;
			}
			i=x;
			j=y;
			while(i<board.length || j<board.length){ //Rechts Oben
				if(board[i][j]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[i][j])){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[i][j])){
					break;
				}
				i--;
				j++;
			}
			i=x;
			j=y;
			while(i<board.length || j<board.length){ //Rechts Unten
				if(board[i][j]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[i][j])){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[i][j])){
					break;
				}
				i++;
				j++;
			}
			i=x;
			j=y;
			while(i<board.length || j<board.length){ //Links Unten
				if(board[i][j]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[i][j])){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[i][j])){
					break;
				}
				i++;
				j--;
			}
        }else{ // player black
			int i=x;
			int j=y;
			while(i<board.length || j<board.length){ //Links Oben
				if(board[i][j]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[i][j])){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[i][j])){
					break;
				}
				i--;
				j--;
			}
			i=x;
			j=y;
			while(i<board.length || j<board.length){ //Rechts Oben
				if(board[i][j]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[i][j])){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[i][j])){
					break;
				}
				i--;
				j++;
			}
			i=x;
			j=y;
			while(i<board.length || j<board.length){ //Rechts Unten
				if(board[i][j]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[i][j])){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[i][j])){
					break;
				}
				i++;
				j++;
			}
			i=x;
			j=y;
			while(i<board.length || j<board.length){ //Links unten
				if(board[i][j]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[i][j])){
					String move=this.generateString(i, y);
					this.validmove.add(move);
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
