package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;
import java.util.ArrayList;
import java.util.List;
import de.tuberlin.sese.swtpp.gameserver.model.Move;

public abstract class Figur
{

	private List<String> validmove;			// Array List die die möglichen Züge zurück gibt
	private String player;// Farbe des Spielers
   
    public Figur (String player)
    {
    	this.validmove = new ArrayList<String>();
       this.player=player;
    }

  public String getPlayer() {return player;}
    
    public List<String> validMoves(Board board, int x, int y) // kriegt beim Aufruf auf dem Feld die Startposition
    {
    	return validmove;
    }

}