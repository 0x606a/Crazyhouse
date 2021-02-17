package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.ArrayList;
import java.util.List;

public class Pferd extends Figur 
{

	private ArrayList<String> validmove;
	
	Pferd(String player)
	{
		super(player);
	}

	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y) throws Exception {
		
		this.validmove.clear();
		if(x >7 || y>7 || y<0 || x<0)// prüfe ob die Boardgrenze erreicht ist
    	{	
    		throw new Exception(" Uebergebene Position fuer das Pferd liegt nicht auf dem Spielfeld");
    		
    	}
		if ( this.getPlayer()=="w")
        {
		
        }
		
		return validmove;
	}	
}
