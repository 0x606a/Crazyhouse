package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;
import java.util.ArrayList;
import java.util.List;


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
  
    
    public abstract List<String> validMoves(char[][] board, int x, int y)throws Exception; // kriegt beim Aufruf auf dem Feld die Startposition
    public String generateString(int x, int y)
    {
    	String zeile="";
    	switch (y)
        {
            case 0:
               zeile= "a";
                break;
            case 1:
            	zeile= "b";
                break;
            case 2:
            	zeile= "c";
                break;
            case 3:
                zeile= "d";
                break;
            case 4:
            	zeile= "e";
                break;
            case 5:
            	zeile= "f";
                break;
            case 6:
            	zeile= "g";
                break;
            case 7:
            	zeile= "h";
                break;
            default:
                System.out.print("keine gueltige Position!");
                break;
        }
    	
    	String zugString= ""+x+zeile;
    	return zugString;
    }
 
    
}