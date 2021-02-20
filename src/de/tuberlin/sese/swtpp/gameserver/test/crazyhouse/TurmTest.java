package de.tuberlin.sese.swtpp.gameserver.test.crazyhouse;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Turm;


public class TurmTest {

	Turm t1=new Turm ("w");
	Turm t2=new Turm ("b");
	char[][] board = new char[8][8];
	ArrayList<String> moves= new ArrayList<String>();
	ArrayList<String>testmoves=new ArrayList<String>();
    @Test
    public void testConstructor()
    {
        assertTrue(t1.getValidmove()!=null);
        assertFalse(t1.getPlayer().isEmpty());
        assertTrue(t1.getPlayer()=="w");
        assertTrue(t2.getPlayer()=="b");
    }

    @Test
    public void testValidMoves() throws Exception
    {

        //Test Figur schlagen

        // Dame weiß im Spielfeld
    	
        //gerade
        board[2][3]='k';
        board[6][3]='p';
        board[4][1]='p';
        board[4][5]='q';
        moves=t1.validMoves(board, 4,3);
        assertEquals(moves.size(),8);
        boardClear();
        
        // Dame weiß am linken Rand
        
        //gerade
        board[2][0]='k';
        board[6][0]='p';
        board[4][5]='p';
        moves=t1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),9);
        boardClear();
        
        // Dame weiß am rechten Rand
        
        //gerade
        board[2][7]='k';
        board[6][7]='p';
        board[4][5]='p';
        moves=t1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();

        // Dame schwarz im Spielfeld

        //gerade
        board[2][3]='P';
        board[6][3]='P';
        board[4][1]='P';
        board[4][5]='P';
        moves=t2.validMoves(board, 4,3);
        assertEquals(moves.size(),8);
        boardClear();
        
        // Dame schwarz am linken Rand
        
        //gerade
        board[2][0]='P';
        board[6][0]='P';
        board[4][5]='P';
        moves=t2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),9);
        boardClear();
        
        // Dame schwarz am rechten Rand

        //gerade
        board[2][7]='P';
        board[6][7]='P';
        board[4][5]='P';
        moves=t2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();

        // Test auf eigene Figur im Weg

        //weiß

        //gerade
        board[2][3]='P';
        board[6][3]='P';
        board[4][1]='P';
        board[4][5]='P';
        moves=t1.validMoves(board, 4,3);
        assertEquals(moves.size(),4);
        boardClear();
        
        // Dame weiß am linken Rand

        //gerade
        board[2][0]='P';
        board[6][0]='P';
        board[4][5]='P';
        moves=t1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        
        // Dame weiß am rechten Rand

        //gerade
        board[2][7]='P';
        board[6][7]='P';
        board[4][5]='P';
        moves=t1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),3);
        boardClear();

        //schwarz
        
        //gerade
        board[2][3]='p';
        board[6][3]='p';
        board[4][1]='p';
        board[4][5]='p';
        moves=t2.validMoves(board, 4,3);
        assertEquals(moves.size(),4);
        boardClear();
        
        // Dame schwarz am linken Rand
        
        //gerade
        board[2][0]='p';
        board[6][0]='p';
        board[4][5]='p';
        moves=t2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        
        // Dame schwarz am rechten Rand

        //gerade
        board[2][7]='p';
        board[6][7]='p';
        board[4][5]='p';
        moves=t2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),3);
        boardClear();

        // Test auf leeres Feld

        //gerade
        board[2][3]='\0';
        board[6][3]='\0';
        board[4][1]='\0';
        board[4][5]='\0';
        moves=t1.validMoves(board, 4,3);
        assertEquals(moves.size(),14);
        boardClear();
        
        // Dame weiß am linken Rand
        
        //gerade
        board[2][0]='\0';
        board[6][0]='\0';
        board[4][5]='\0';
        moves=t1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),14);
        boardClear();
        
        // Dame weiß am rechten Rand
       
        //gerade
        board[2][7]='\0';
        board[6][7]='\0';
        board[4][5]='\0';
        moves=t1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),14);
        boardClear();

        //gerade
        board[2][3]='\0';
        board[6][3]='\0';
        board[4][1]='\0';
        board[4][5]='\0';
        moves=t2.validMoves(board, 4,3);
        assertEquals(moves.size(),14);
        boardClear();
        
        // Dame weiß am linken Rand
       
        //gerade
        board[2][0]='\0';
        board[6][0]='\0';
        board[4][5]='\0';
        moves=t2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),14);
        boardClear();
        
        // Dame weiß am rechten Rand
        
        //gerade
        board[2][7]='\0';
        board[6][7]='\0';
        board[4][5]='\0';
        moves=t2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),14);
        boardClear();
    }
    private void boardClear()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                board[i][j]='\0';
            }
        }
    }
}
