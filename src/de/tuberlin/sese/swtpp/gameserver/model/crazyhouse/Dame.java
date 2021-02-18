package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.List;
import java.util.ArrayList;
public class Dame extends Figur {
	
	private ArrayList<String> validmove;
	
	public Dame(String player) {
		super(player);
		this.validmove = new ArrayList<String>();
	}

	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y) throws Exception {
		this.validmove.clear();
		if(x >7 || y>7 || y<0 || x<0)// pr�fe ob die Boardgrenze erreicht ist
    	{	
    		throw new Exception(" Uebergebene Position fuer das Pferd liegt nicht auf dem Spielfeld");
    		
    	}
		if ( this.getPlayer()=="w"){
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
			i=x;
			while(i<board.length){  //Oben
				if(board[i][y]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[i][y])){			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf?gen des Moves
					String move=this.generateString(i, y);
					this.validmove.add(move);
					break; 										// beende die Schleife
				}
				if(Character.isUpperCase(board[i][y])){			// pr?fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
					break; 										// beende die Schleife ohne das Feld zu adden
				}
				i++;
			}
			i=x;
			while(i<board.length){  //Unten
				if(board[i][y]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[i][y])){			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf?gen des Moves
					String move=this.generateString(i, y);
					this.validmove.add(move);
					break; 										// beende die Schleife
				}
				if(Character.isUpperCase(board[i][y])){			// pr?fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
					break; 										// beende die Schleife ohne das Feld zu adden
				}
				i--;
			}
			i=y;
			while(i<board.length){  //Links
				if(board[x][i]=='\0'){
					String move=this.generateString(x, i);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x][i])){			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf?gen des Moves
					String move=this.generateString(x, i);
					this.validmove.add(move);
					break; 										// beende die Schleife
				}
				if(Character.isUpperCase(board[x][i])){			// pr?fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
					break; 										// beende die Schleife ohne das Feld zu adden
				}
				i--;
			}
			i=y;
			while(i<board.length)  //Rechts
			{
				if(board[x][i]=='\0'){
					String move=this.generateString(x, i);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x][i])){			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf?gen des Moves
					String move=this.generateString(x, i);
					this.validmove.add(move);
					break; 										// beende die Schleife
				}
				if(Character.isUpperCase(board[x][i])){			// pr?fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
					break; 										// beende die Schleife ohne das Feld zu adden
				}
				i++;
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
			while(i<board.length){  //Oben
				if(board[i][y]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[i][y])){			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf?gen des Moves
					String move=this.generateString(i, y);
					this.validmove.add(move);
					break; 										// beende die Schleife
				}
				if(Character.isLowerCase(board[i][y])){			// pr?fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
					break; 										// beende die Schleife ohne das Feld zu adden
				}
				i++;
			}
			i=x;
			while(i<board.length){  //Unten
				if(board[i][y]=='\0'){
					String move=this.generateString(i, y);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[i][y])){			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf?gen des Moves
					String move=this.generateString(i, y);
					this.validmove.add(move);
					break; 										// beende die Schleife
				}
				if(Character.isLowerCase(board[i][y])){			// pr?fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
					break; 										// beende die Schleife ohne das Feld zu adden
				}
				i--;
			}
			i=y;
			while(i<board.length){  //Links
				if(board[x][i]=='\0'){
					String move=this.generateString(x, i);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x][i])){			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf?gen des Moves
					String move=this.generateString(x, i);
					this.validmove.add(move);
					break; 										// beende die Schleife
				}
				if(Character.isLowerCase(board[x][i])){			// pr?fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
					break; 										// beende die Schleife ohne das Feld zu adden
				}
				i--;
			}
			i=y;
			while(i<board.length)  //Rechts
			{
				if(board[x][i]=='\0'){
					String move=this.generateString(x, i);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x][i])){			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf?gen des Moves
					String move=this.generateString(x, i);
					this.validmove.add(move);
					break; 										// beende die Schleife
				}
				if(Character.isLowerCase(board[x][i])){			// pr?fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
					break; 										// beende die Schleife ohne das Feld zu adden
				}
				i++;
			}
		}
		return validmove;
	}
}
