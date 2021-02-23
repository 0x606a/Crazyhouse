package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;
import java.util.ArrayList;
import java.util.List;


public abstract class Figur
{

				// Array List die die m�glichen Z�ge zur�ck gibt
	private String player;// Farbe des Spielers
	
    public Figur (String player)
    {
       this.player=player;
    }

    public String getPlayer() {return player;}
  //  public ArrayList<String> getValidmove(){return validmove;}
    
    public abstract ArrayList<String> validMoves(Board b, int x, int y); // kriegt beim Aufruf auf dem Feld die Startposition
    public ArrayList<String> filterMoves(Board b, ArrayList<String> moves, int x, int y){
    	ArrayList<String> val= new ArrayList<>();
    	boolean check=true;
    	char figure = b.getBoard()[x][y];
    	for(int i= 0; i<moves.size(); i++) {
        	Board temp= b.copy();
        	String m_S = b.xytoString(y, x)+"-"+moves.get(i);        	
    		temp.doMoveBoard(m_S, y, x, figure);

    		System.out.println(m_S);
    		System.out.println(temp.BoardToString());
    		try {
    			check= temp.Check(getPlayer(), false);
    		}catch(Exception e) {
    			System.out.println ("bei ischeck ist irgendwas nicht durchgegangen");
    		}
    		if(!check) val.add(moves.get(i));
       	}
    	return  val;
    }
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
    	//String zugString= ""+zeile+x;
    	String zugString= ""+zeile+Math.abs(8-x);
    	return zugString;
    }
 
    
}
    
}