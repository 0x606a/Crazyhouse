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
	public ArrayList<String> getValidmove(){return validmove;}
	@Override
	public ArrayList<String> validMoves(char[][] board, int x, int y)throws Exception 
	{
		this.validmove.clear();
		/*if(x >7 || y>7 || y<0 || x<0)// pruefe ob die Boardgrenze erreicht ist
    	{	
    		throw new Exception(" uebergebene Position fuer den Turm liegt nicht auf dem Spielfeld");
    	
    	}*/
		if ( this.getPlayer()=="w")
        {
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
	       
	       i=x-1;
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
	       
	       i=y-1;
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
	       
	       i=y+1;
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
	       
	       return this.validmove;
        }
		else // player black
		{
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
		 	
		    i=x-1;
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
		    
		    i=y-1;
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
		    
		    i=y+1;
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
		    return this.validmove;
		}	
	}
}