package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;
import java.util.ArrayList;


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

    public abstract ArrayList<String> validMoves(char[][] board, int x, int y)throws Exception; // kriegt beim Aufruf auf dem Feld die Startposition
    public String generateString(int x, int y)
    {
        String zeile="";
        switch (y)
        {
            case 0: zeile= "a";
                break;
            case 1: zeile= "b";
                break;
            case 2: zeile= "c";
                break;
            case 3: zeile= "d";
                break;
            case 4: zeile= "e";
                break;
            case 5: zeile= "f";
                break;
            case 6: zeile= "g";
                break;
            case 7: zeile= "h";
                break;
            default:
                break;
        }
        //String zugString= ""+zeile+x;
        String zugString= ""+zeile+Math.abs(x-8);
        return zugString;
    }


}