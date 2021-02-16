package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.*;

public class Bauer extends Figur
{
	private List<String> validmove=new ArrayList<String>();
    public Bauer(String player )
    {
        super(player);
    }
    //gebe Anhand der Position auf dem Spielfeld eine Liste mit den möglichen züge zurück

    public List<String> validMoves(String currentPosition)
    {
        return validmove;
       
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
                System.out.print("keine gültige Position!");
                break;
        }
    }
    */
    
}