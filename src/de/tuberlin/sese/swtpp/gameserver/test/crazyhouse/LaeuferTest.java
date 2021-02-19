package de.tuberlin.sese.swtpp.gameserver.test.crazyhouse;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.*;
public class LaeuferTest {

    Laeufer l1= new Laeufer("w");
    Laeufer l2= new Laeufer("b");
    char[][] board = new char[8][8];
    ArrayList<String> moves= new ArrayList<String>();
    ArrayList<String>testmoves=new ArrayList<String>();
    @Test
    public void testConstructor()
    {
        assertTrue(l1.getValidmove()!=null);
        assertFalse(l1.getPlayer().isEmpty());
        assertTrue(l1.getPlayer()=="w");
        assertTrue(l2.getPlayer()=="b");
    }

    @Test(expected = java.lang.Exception.class)
    public void testwrongPositionWhite() throws Exception
    {
        l1.validMoves(board, 8,8);

    }

    @Test
    public void testValidMoves() throws Exception
    {
        //test Exception wenn übergebene Position nicht auf dem Feld liegt

        // Laeufer weiß im Spielfeld
        board[3][2]='k';
        board[2][1]='p';
        board[1][0]='p';
        board[3][4]='q';
        board[2][5]='p';
        board[1][6]='p';
        board[0][7]='p';
        board[5][2]='p';
        board[6][1]='p';
        board[7][0]='p';
        board[5][4]='p';
        board[6][5]='p';
        board[7][6]='p';
        moves=l1.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),3);
        boardClear();
        // Laeufer weiß am linken Rand
        board[3][1]='k';
        board[2][3]='p';
        board[1][4]='p';
        board[0][5]='p';
        board[5][1]='p';
        board[6][2]='p';
        board[7][3]='p';
        moves=l1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),7);
        boardClear();
        // Laeufer weiß am rechten Rand
        board[3][6]='k';
        board[2][5]='p';
        board[1][4]='p';
        board[0][3]='p';
        board[5][6]='p';
        board[6][5]='p';
        board[7][4]='p';
        moves=l1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),7);
        boardClear();

        // Laeufer schwarz im Spielfeld
        board[3][2]='K';
        board[2][1]='P';
        board[1][0]='P';
        board[3][4]='P';
        board[2][5]='P';
        board[1][6]='P';
        board[0][7]='P';
        board[5][2]='P';
        board[6][1]='P';
        board[7][0]='P';
        board[5][4]='P';
        board[6][5]='P';
        board[7][6]='P';
        moves=l2.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),3);
        boardClear();
        // Laeufer schwarz am linken Rand
        board[3][1]='K';
        board[2][3]='P';
        board[1][4]='P';
        board[0][5]='P';
        board[5][1]='P';
        board[6][2]='P';
        board[7][3]='P';
        moves=l2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),2);
        boardClear();
        // Laeufer schwarz am rechten Rand
        board[3][6]='K';
        board[2][5]='P';
        board[1][4]='P';
        board[0][3]='P';
        board[5][6]='P';
        board[6][5]='P';
        board[7][4]='P';
        moves=l2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),2);
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
