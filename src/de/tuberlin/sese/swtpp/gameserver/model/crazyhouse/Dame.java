package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.io.Serializable;
import java.util.ArrayList;
public class Dame extends Figur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4123132931716879521L;
	private ArrayList<String> validmove;

	public Dame(String player) {
		super(player);
		this.validmove = new ArrayList<String>();
	}
	//public ArrayList<String> getValidmove(){return validmove;}
	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y) {

		this.validmove.clear();

		if (this.getPlayer()=="w"){

			checkLeftUp(board, x, y);

			checkRightUp(board, x, y);

			checkLeftDown(board, x, y);

			checkRightDown(board, x, y);

			checkDown(board, x, y);

			checkUp(board, x, y);

			checkLeft(board, x, y);

			checkRight(board, x, y);

			return this.validmove;
		}
		else // player black
		{
			checkLeftUpB(board, x, y);

			checkRightUpB(board, x, y);

			checkLeftDownB(board, x, y);

			checkRightDownB(board, x, y);

			checkDownB(board, x, y);

			checkUpB(board, x, y);

			checkLeftB(board, x, y);

			checkRightB(board, x, y);

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

	private void checkDown(char[][] board, int x, int y) {

		int i=x+1;

		while(i<board.length && i>=0)  // Direction: DOWN
		{
			if(board[i][y]=='\0')
			{
				String move=this.generateString(i, y);
				this.validmove.add(move);
			}

			if(Character.isLowerCase(board[i][y]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf�gen des Moves
			{
				String move=this.generateString(i, y);
				this.validmove.add(move);
				break; 										// beende die Schleife
			}
			if(Character.isUpperCase(board[i][y]))			// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			{
				break; 										// beende die Schleife ohne das Feld zu adden
			}
			i++;
		}
	}

	private void checkUp(char[][] board, int x, int y) {

		int i=x-1;

		while(i<board.length && i>=0)  // Direction: UP
		{
			if(board[i][y]=='\0')
			{
				String move=this.generateString(i, y);
				this.validmove.add(move);
			}

			if(Character.isLowerCase(board[i][y]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf�gen des Moves
			{
				String move=this.generateString(i, y);
				this.validmove.add(move);
				break; 										// beende die Schleife
			}
			if(Character.isUpperCase(board[i][y]))			// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			{
				break; 										// beende die Schleife ohne das Feld zu adden
			}
			i--;
		}
	}

	private void checkLeft(char[][] board, int x, int y) {

		int i=y-1;

		while(i<board.length && i>=0)  // Direction: LEFT
		{
			if(board[x][i]=='\0')
			{
				String move=this.generateString(x, i);
				this.validmove.add(move);
			}

			if(Character.isLowerCase(board[x][i]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf�gen des Moves
			{
				String move=this.generateString(x, i);
				this.validmove.add(move);
				break; 										// beende die Schleife
			}
			if(Character.isUpperCase(board[x][i]))			// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			{
				break; 										// beende die Schleife ohne das Feld zu adden
			}
			i--;
		}
	}

	private void checkRight(char[][] board, int x, int y) {

		int i=y+1;

		while(i<board.length && i>=0)  // Direction: RIGHT
		{
			if(board[x][i]=='\0')
			{
				String move=this.generateString(x, i);
				this.validmove.add(move);
			}

			if(Character.isLowerCase(board[x][i]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf�gen des Moves
			{
				String move=this.generateString(x, i);
				this.validmove.add(move);
				break; 										// beende die Schleife
			}
			if(Character.isUpperCase(board[x][i]))			// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			{
				break; 										// beende die Schleife ohne das Feld zu adden
			}
			i++;
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
	private void checkDownB(char[][] board, int x, int y) {

		int i=x+1;

		while(i<board.length && i>=0)  // Direction: DOWN
		{
			if(board[i][y]=='\0')
			{
				String move=this.generateString(i, y);
				this.validmove.add(move);
			}

			if(Character.isUpperCase(board[i][y]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf�gen des Moves
			{
				String move=this.generateString(i, y);
				this.validmove.add(move);
				break; 										// beende die Schleife
			}
			if(Character.isLowerCase(board[i][y]))			// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			{
				break; 										// beende die Schleife ohne das Feld zu adden
			}
			i++;
		}
	}

	private void checkUpB(char[][] board, int x, int y) {

		int i=x-1;

		while(i<board.length && i>=0)  // Direction: UP
		{
			if(board[i][y]=='\0')
			{
				String move=this.generateString(i, y);
				this.validmove.add(move);
			}

			if(Character.isUpperCase(board[i][y]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf�gen des Moves
			{
				String move=this.generateString(i, y);
				this.validmove.add(move);
				break; 										// beende die Schleife
			}
			if(Character.isLowerCase(board[i][y]))			// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			{
				break; 										// beende die Schleife ohne das Feld zu adden
			}
			i--;
		}
	}

	private void checkLeftB(char[][] board, int x, int y) {

		int i=y-1;

		while(i<board.length && i>=0)  // Direction: LEFT
		{
			if(board[x][i]=='\0')
			{
				String move=this.generateString(x, i);
				this.validmove.add(move);
			}

			if(Character.isUpperCase(board[x][i]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf�gen des Moves
			{
				String move=this.generateString(x, i);
				this.validmove.add(move);
				break; 										// beende die Schleife
			}
			if(Character.isLowerCase(board[x][i]))			// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			{
				break; 										// beende die Schleife ohne das Feld zu adden
			}
			i--;
		}
	}

	private void checkRightB(char[][] board, int x, int y) {

		int i=y+1;

		while(i<board.length && i>=0)  // Direction: RIGHT
		{
			if(board[x][i]=='\0')
			{
				String move=this.generateString(x, i);
				this.validmove.add(move);
			}

			if(Character.isUpperCase(board[x][i]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzuf�gen des Moves
			{
				String move=this.generateString(x, i);
				this.validmove.add(move);
				break; 										// beende die Schleife
			}
			if(Character.isLowerCase(board[x][i]))			// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			{
				break; 										// beende die Schleife ohne das Feld zu adden
			}
			i++;
		}
	}
}
