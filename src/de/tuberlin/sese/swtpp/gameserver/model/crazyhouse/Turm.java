package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.io.Serializable;
import java.util.ArrayList;

public class Turm extends Figur implements Serializable
{
	private static final long serialVersionUID = 163985863124649519L;
	private ArrayList<String> validmove;

	public Turm (String player)
	{
		super(player);
		this.validmove = new ArrayList<String>();
	}
	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y)throws Exception
	{
		this.validmove.clear();

		if (this.getPlayer()=="w")
		{
			checkDown(board, x, y);

			checkUp(board, x, y);

			checkLeft(board, x, y);

			checkRight(board, x, y);

			return this.validmove;
		}
		else // player black
		{
			checkDownB(board, x, y);

			checkUpB(board, x, y);

			checkLeftB(board, x, y);

			checkRightB(board, x, y);

			return this.validmove;
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