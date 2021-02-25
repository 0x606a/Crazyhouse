package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.ArrayList;
public class Dame extends Figur {
	
	private ArrayList<String> validmove;
	
	public Dame(String player) {
		super(player);
		this.validmove = new ArrayList<String>();
	}
	public ArrayList<String> getValidmove(){return validmove;}
	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y) {
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
			i=x+1;
			while(i<board.length && i>=0){  //Unten
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
			i=x-1;
			while(i<board.length && i>=0){  //Oben
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
			i=y-1;
			while(i<board.length && i>=0){  //Links
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
			i=y+1;
			while(i<board.length && i>=0)  //Rechts
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
			return validmove;
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
			i=x+1;
			while(i<board.length && i>=0){  //Oben
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
			i=x-1;
			while(i<board.length && i>=0){  //Unten
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
			i=y-1;
			while(i<board.length && i>=0){  //Links
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
			i=y+1;
			while(i<board.length && i>=0)  //Rechts
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
			
			return this.validmove;
        }
	}
}
