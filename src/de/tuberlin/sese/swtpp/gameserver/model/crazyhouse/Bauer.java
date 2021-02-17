package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;


import java.util.*;
public class Bauer extends Figur
{
	private ArrayList<String> validmove;
    public Bauer(String player )
    {
        super(player);
    }
    //gebe Anhand der Position auf dem Spielfeld eine Liste mit den m√∂glichen z√ºge zur√ºck
    
    @Override
    public ArrayList<String> validMoves(char[][]board, int x, int y) throws Exception
    {
    	this.validmove.clear(); // leere die alte Liste
    	
    	if(x >=7 || y>7 || y<0 || x<=0)// pr¸fe ob die Boardgrenze erreicht ist
    	{	
    		throw new Exception(" uebergebene Position fuer den Bauern liegt nicht auf dem Spielfeld");
    		
    	}
        	
    	if ( this.getPlayer()=="w")
        {
           	
	        if(Character.isLowerCase(board[x+1][y+1]))	// pr¸fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
	        {
	        	String move=this.generateString(x+1, y+1);	// generiere aus den Indizes einen String
	        	this.validmove.add(move);					// speichere ¸brige Ziele in validmoves
	        }
	        		
	        if(Character.isLowerCase(board[x+1][y-1]))
	        {
	        	String move=this.generateString(x+1, y-1);
	        	this.validmove.add(move);
	        }
	        		
	        if(board[x+1][y]=='\0') 
	        {
	        	String move = this.generateString(+1, y);
	        	this.validmove.add(move);
	        }
	        return this.validmove;
        }
    	else 
        {
    		if(Character.isUpperCase(board[x-1][y+1]))
	        {
	        	String move=this.generateString(x-1, y+1);
	        	this.validmove.add(move);
	        }
	        		
	        if(Character.isUpperCase(board[x-1][y-1]))
	        {
	        	String move=this.generateString(x-1, y-1);
	        	this.validmove.add(move);
	        }
	        		
	        if(board[x-1][y]=='\0') 
	        {
	        	String move = this.generateString(x-1, y);
	        	this.validmove.add(move);
	        }
	        return this.validmove;
        }
           
    }

    /*public int convertChar(char c)
    {

        switch (c.toLowerCase())
        {
            case a:
                return 0;
                break;
            case b:
                return 1;
                break;
            case c:
                return 2;
                break;
            case d:
                return 3;
                break;
            case e:
                return 4;
                break;
            case f:
                return 5;
                break;
            case g:
                return 6;
                break;
            case h:
                return 7;
                break;
            default:
                System.out.print("keine g√ºltige Position!");
                break;
        }
    }
    */
    
}