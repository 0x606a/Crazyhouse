package de.tuberlin.sese.swtpp.gameserver.test.crazyhouse;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.*;
public class KoenigTest {

    Koenig k1= new Koenig("w");
    Koenig k2= new Koenig("b");
    char[][] board = new char[8][8];
    ArrayList<String> moves= new ArrayList<String>();
    ArrayList<String>testmoves=new ArrayList<String>();
    @Test
    public void testConstructor()
    {
        assertTrue(k1.getValidmove()!=null);
        assertFalse(k1.getPlayer().isEmpty());
        assertTrue(k1.getPlayer()=="w");
        assertTrue(k2.getPlayer()=="b");
    }

    @Test(expected = java.lang.Exception.class)
    public void testwrongPositionWhite() throws Exception
    {
        k1.validMoves(board, 8,8);

    }

    @Test
    public void testValidMoves() throws Exception
    {
        //test Exception wenn uebergebene Position nicht auf dem Feld liegt

        // koenig weiß im Spielfeld
        board[3][2]='k';
        board[3][4]='q';
        board[3][3]='p';
        board[4][2]='p';
        board[4][4]='p';
        board[5][2]='p';
        board[5][3]='p';
        board[5][4]='p';
        moves=k1.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),8);
        boardClear();
        // koenig weiß am linken Rand
        board[3][1]='k';
        board[3][0]='p';
        board[4][1]='p';
        board[5][1]='p';
        board[5][0]='p';
        moves=k1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),5);
        boardClear();
        // koenig weiß am rechten Rand
        board[3][6]='k';
        board[3][7]='p';
        board[4][6]='p';
        board[5][6]='p';
        board[5][7]='p';
        moves=k1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),5);
        boardClear();

        // koenig schwarz im Spielfeld
        board[5][2]='K';
        board[5][4]='Q';
        board[5][3]='P';
        board[4][2]='P';
        board[4][4]='P';
        board[3][2]='P';
        board[3][3]='P';
        board[3][4]='P';
        moves=k2.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),8);
        boardClear();
        // koenig schwarz am linken Rand
        board[5][1]='K';
        board[5][0]='P';
        board[4][1]='P';
        board[3][1]='P';
        board[3][0]='P';
        moves=k2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),5);
        boardClear();
        // koenig schwarz am rechten Rand
        board[5][6]='K';
        board[5][7]='P';
        board[4][6]='P';
        board[3][6]='P';
        board[3][7]='P';
        moves=k2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),5);
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
