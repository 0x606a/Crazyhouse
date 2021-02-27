package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;
import java.io.Serializable;
import java.util.ArrayList;


public abstract class Figur implements Serializable
{
	private static final long serialVersionUID = -7686875115705542648L;
	// Array List die die m�glichen Z�ge zur�ck gibt
	private String player;// Farbe des Spielers

	public Figur (String player)
	{
		this.player=player;
	}

	public String getPlayer() {return player;}
	//  public ArrayList<String> getValidmove(){return validmove;}

	public abstract ArrayList<String> validMoves(char [][] b, int x, int y); // kriegt beim Aufruf auf dem Feld die Startposition
	public ArrayList<String> filterMoves(Board b, ArrayList<String> moves, int x, int y){
		ArrayList<String> val= new ArrayList<>();
		boolean check=true;
		char figure = b.getBoard()[x][y];

		for(int i= 0; i<moves.size(); i++) {
			Board temp= b.copy();
			String m_S = b.xytoString(y, x)+"-"+moves.get(i);
			temp.doMoveBoard(m_S, y, x, figure);

			check= temp.Check(getPlayer(), false);

			if(!check) val.add(moves.get(i));
		}
		return  val;
	}
	public ArrayList<String> sortMoves(char[][] board,ArrayList<String> validmoves){
		ArrayList<String> newMoves= new ArrayList<String>();
		for(String e: validmoves)
		{
			if(((int)e.charAt(0) >= 97)&&((int)e.charAt(0)) <= 104  && ((int)e.charAt(1) >= 49)&&((int)e.charAt(1)) <=56 ) {
				int x = ((int) e.charAt(0))-97;
				int y = 7-(((int) e.charAt(1))-49);
				if(this.player=="w" & !Character.isUpperCase(board[y][x])||this.player=="b" & !Character.isLowerCase(board[y][x]))
				{addmovee(newMoves, e);}}}
		return newMoves;
	}

	public void addmovee(ArrayList<String> newMoves, String e) {
		if(!newMoves.contains(e))
		{
			newMoves.add(e);
		}
	}

	public String generateString(int x, int y){
		String zugString;
		String zeile="";
		switch (y)
		{case 0: zeile= "a"; break;
			case 1: zeile= "b"; break;
			case 2:zeile= "c";break;
			case 3:zeile= "d";break;
			case 4:zeile= "e";break;
			case 5:zeile= "f";break;
			case 6:zeile= "g";break;
			case 7:zeile= "h";break;
			default: zeile="x"; break;}

		if(check3(x, y)) {zugString= ""+zeile+Math.abs(8-x);}
		else {	x=-5;
			zugString= ""+zeile+x;}
		return zugString;
	}

	public boolean check3(int x, int y) {
		if (x<=7 && x>=0) {
			return true;
		} else {
			return false;
		}
	}

}
    
