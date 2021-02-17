package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.io.Serializable;
import java.util.*;
import Character
public class Bauer extends Figur
{
	private List<String> validmove;
    public Bauer(String player )
    {
        super(player);
    }
    //gebe Anhand der Position auf dem Spielfeld eine Liste mit den m√∂glichen z√ºge zur√ºck

    public List<String> validMoves(char[][]board, int x, int y)
    {
    	this.validmove.clear(); // leere die alte Liste
    	
    	if(x >=7 || y>7 || y<0 || x<=0)// pr¸fe ob die Boardgrenze erreicht ist
    	{	
    		throw new Exception(" Uebergebene Position fuer den Bauern liegt nicht auf dem Spielfeld");
    		
    	}
        	// pr¸fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
        	// speichere ¸brige Ziele in validmoves
        	
       else
        {
    	   if ( this.getPlayer()=="w")
           {
           	
	        	if(Character.isLowerCase(board[x+1][y+1]))
	        	{
	        		String move=this.generateString(x+1, y+1);
	        		this.validmove.add(move);
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