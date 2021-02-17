package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.List;
import java.util.ArrayList;

public class Turm extends Figur
{
	private List<String> validmove;
	
	public Turm (String player)
	{
		super(player);
	}

	@Override
	public List<String> validMoves(char[][] board, int x, int y)throws Exception 
	{
		this.validmove.clear();
		if(x >7 || y>7 || y<0 || x<0)// prüfe ob die Boardgrenze erreicht ist
    	{	
    		throw new Exception(" Uebergebene Position fuer den Turm liegt nicht auf dem Spielfeld");
    		
    	}
		if ( this.getPlayer()=="w")
        {
           int i=x;
	       while(i<board.length)  // Direction: DOWN
	       {
	    	   if(board[i][y]=='\0') 
	    	   {
	    		   String move=this.generateString(i, y);
		        	this.validmove.add(move);
	    	   }
	    	   
	    	   if(Character.isLowerCase(board[i][y]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzufügen des Moves
		       {
	    		   String move=this.generateString(i, y);
		        	this.validmove.add(move);
		        	break; 										// beende die Schleife
		       }
	    	   if(Character.isUpperCase(board[i][y]))			// prüfe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
		       {
	    		   break; 										// beende die Schleife ohne das Feld zu adden
		       }
	    	   i++;
	       }
	       
	       i=x;
	       while(i<board.length)  // Direction: UP
	       {
	    	   if(board[i][y]=='\0') 
	    	   {
	    		   String move=this.generateString(i, y);
		        	this.validmove.add(move);
	    	   }
	    	   
	    	   if(Character.isLowerCase(board[i][y]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzufügen des Moves
		       {
	    		   String move=this.generateString(i, y);
		        	this.validmove.add(move);
		        	break; 										// beende die Schleife
		       }
	    	   if(Character.isUpperCase(board[i][y]))			// prüfe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
		       {
	    		   break; 										// beende die Schleife ohne das Feld zu adden
		       }
	    	   i--;
	       }
	       
	       i=y;
	       while(i<board.length)  // Direction: LEFT
	       {
	    	   if(board[x][i]=='\0') 
	    	   {
	    		   String move=this.generateString(x, i);
		        	this.validmove.add(move);
	    	   }
	    	   
	    	   if(Character.isLowerCase(board[x][i]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzufügen des Moves
		       {
	    		   String move=this.generateString(x, i);
		        	this.validmove.add(move);
		        	break; 										// beende die Schleife
		       }
	    	   if(Character.isUpperCase(board[x][i]))			// prüfe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
		       {
	    		   break; 										// beende die Schleife ohne das Feld zu adden
		       }
	    	   i--;
	       }
	       
	       i=y;
	       while(i<board.length)  // Direction: RIGHT
	       {
	    	   if(board[x][i]=='\0') 
	    	   {
	    		   String move=this.generateString(x, i);
		        	this.validmove.add(move);
	    	   }
	    	   
	    	   if(Character.isLowerCase(board[x][i]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzufügen des Moves
		       {
	    		   String move=this.generateString(x, i);
		        	this.validmove.add(move);
		        	break; 										// beende die Schleife
		       }
	    	   if(Character.isUpperCase(board[x][i]))			// prüfe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
		       {
	    		   break; 										// beende die Schleife ohne das Feld zu adden
		       }
	    	   i++;
	       }
	       
	       return this.validmove;
        }
		else // player black
		{
		 	int i=x;
		 	while(i<board.length)  // Direction: DOWN
		    {
		 		if(board[i][y]=='\0') 
		    	{
		 			String move=this.generateString(i, y);
			        this.validmove.add(move);
		    	}
		    	   
		    	if(Character.isUpperCase(board[i][y]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzufügen des Moves
			    {
		    		String move=this.generateString(i, y);
		    		this.validmove.add(move);
			        break; 										// beende die Schleife
			    }
		    	if(Character.isLowerCase(board[i][y]))			// prüfe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			    {
		    		break; 										// beende die Schleife ohne das Feld zu adden
			    }
		    	i++;
		    }
		 	
		    i=x;
		    while(i<board.length)  // Direction: UP
		    {
		    	if(board[i][y]=='\0') 
		    	{
		    		String move=this.generateString(i, y);
			        this.validmove.add(move);
		    	}
		    	   
		    	if(Character.isUpperCase(board[i][y]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzufügen des Moves
			    {
		    		String move=this.generateString(i, y);
			        this.validmove.add(move);
			        break; 										// beende die Schleife
			    }
		    	if(Character.isLowerCase(board[i][y]))			// prüfe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			    {
		    		break; 										// beende die Schleife ohne das Feld zu adden
			    }
		    	i--;
		    }
		    
		    i=y;
		    while(i<board.length)  // Direction: LEFT
		    {
		    	if(board[x][i]=='\0') 
		    	{
		    		String move=this.generateString(x, i);
			        this.validmove.add(move);
		    	}
		    	   
		    	if(Character.isUpperCase(board[x][i]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzufügen des Moves
			    {
		    		String move=this.generateString(x, i);
		    		this.validmove.add(move);
			        break; 										// beende die Schleife
			    }
		    	if(Character.isLowerCase(board[x][i]))			// prüfe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			    {
		    		break; 										// beende die Schleife ohne das Feld zu adden
			    }
		    	i--;
		    }
		    
		    i=y;
		    while(i<board.length)  // Direction: RIGHT
		    {
		    	if(board[x][i]=='\0') 
		    	{
		    		String move=this.generateString(x, i);
			        this.validmove.add(move);
		    	}
		    	   
		    	if(Character.isUpperCase(board[x][i]))			// wenn ein Gegner auf dem Zielfeld steht dann beende die While nach dem Hinzufügen des Moves
			    {
		    		String move=this.generateString(x, i);
			        this.validmove.add(move);
			        break; 										// beende die Schleife
			    }
		    	if(Character.isLowerCase(board[x][i]))			// prüfe ob eine Figur mit gleicher Farbe auf dem Zielfeld steht
			    {
		    		break; 										// beende die Schleife ohne das Feld zu adden
			    }
		    	i++;
		    }
		    return this.validmove;
		}	
	}
}