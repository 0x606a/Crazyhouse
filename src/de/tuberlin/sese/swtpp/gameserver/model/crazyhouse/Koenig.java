package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.List;
import java.util.ArrayList;

public class Koenig extends Figur 
{
	private ArrayList<String> validmove;
	public Koenig(String player)
	{
		super(player);
	}

	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y) throws Exception 
	{
		this.validmove.clear();
		if(x >7 || y>7 || y<0 || x<0)// pr�fe ob die Boardgrenze erreicht ist
    	{	
    		throw new Exception(" uebergebene Position fuer den Koenig liegt nicht auf dem Spielfeld");
    		
    	}
		if ( this.getPlayer()=="w")
        {
		
        }
		
		return validmove;
	}	
}

