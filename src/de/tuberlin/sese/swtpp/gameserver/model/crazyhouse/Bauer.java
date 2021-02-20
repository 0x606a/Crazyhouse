package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;


import java.util.*;
public class Bauer extends Figur
{
	private ArrayList<String> validmove;
    public Bauer(String player )
    {
        super(player);
        this.validmove = new ArrayList<String>();
    }
    //gebe Anhand der Position auf dem Spielfeld eine Liste mit den möglichen züge zurück
    
    @Override
    public ArrayList<String> validMoves(char[][]board, int x, int y) throws Exception
    {
    	this.validmove.clear(); // leere die alte Liste
        	
    	if ( this.getPlayer()=="w") // white player
        {
           	if(y>0 && y<7)
           	{
		        if(Character.isLowerCase(board[x-1][y+1]))	// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
		        {
		        	String move=this.generateString(x-1, y+1);	// generiere aus den Indizes einen String
		        	this.validmove.add(move);					// speichere �brige Ziele in validmoves
		        }
		        		
		        if(Character.isLowerCase(board[x-1][y-1]))
		        {
		        	String move=this.generateString(x-1, y-1);
		        	this.validmove.add(move);
		        }
		        		
		        if(board[x-1][y]=='\0') 
		        {
		        	String move = this.generateString(x-1, y);
		        	this.validmove.add(move);
		        }
           	}
           	else // falls der Bauer an einem der Raender steht
           	{
           		if(y==0) // linker Rand
           		{
	           		if(Character.isLowerCase(board[x-1][y+1]))	// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			        {
			        	String move=this.generateString(x-1, y+1);	// generiere aus den Indizes einen String
			        	this.validmove.add(move);					// speichere �brige Ziele in validmoves
			        }
			        if(board[x-1][y]=='\0') 
			        {
			        	String move = this.generateString(x-1, y);
			        	this.validmove.add(move);
			        }
           		}
           		if(y==7) // rechter Rand
           		{
	           		if(Character.isLowerCase(board[x-1][y-1]))	// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			        {
			        	String move=this.generateString(x-1, y-1);	// generiere aus den Indizes einen String
			        	this.validmove.add(move);					// speichere �brige Ziele in validmoves
			        }
			        if(board[x-1][y]=='\0') 
			        {
			        	String move = this.generateString(x-1, y);
			        	this.validmove.add(move);
			        }
           		}
           	}
        }
    	else  // black player
        {
    		if(y>0 && y<7)
    		{
	    		if(Character.isUpperCase(board[x+1][y+1]))
		        {
		        	String move=this.generateString(x+1, y+1);
		        	this.validmove.add(move);
		        }
		        		
		        if(Character.isUpperCase(board[x+1][y-1]))
		        {
		        	String move=this.generateString(x+1, y-1);
		        	this.validmove.add(move);
		        }
		        		
		        if(board[x+1][y]=='\0') 
		        {
		        	String move = this.generateString(x+1, y);
		        	this.validmove.add(move);
		        }
    		}
    		else // falls der Bauer an einem der Raender steht
           	{
           		if(y==0) // linker Rand
           		{
	           		if(Character.isUpperCase(board[x+1][y+1]))	// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			        {
			        	String move=this.generateString(x+1, y+1);	// generiere aus den Indizes einen String
			        	this.validmove.add(move);					// speichere �brige Ziele in validmoves
			        }
			        if(board[x+1][y]=='\0') 
			        {
			        	String move = this.generateString(x+1, y);
			        	this.validmove.add(move);
			        }
           		}
           		if(y==7) // rechter Rand
           		{
	           		if(Character.isUpperCase(board[x+1][y-1]))	// pr�fe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			        {
			        	String move=this.generateString(x+1, y-1);	// generiere aus den Indizes einen String
			        	this.validmove.add(move);					// speichere �brige Ziele in validmoves
			        }
			        if(board[x+1][y]=='\0') 
			        {
			        	String move = this.generateString(x+1, y);
			        	this.validmove.add(move);
			        }
           		}
           	} 
        }
		return validmove;
    }
}