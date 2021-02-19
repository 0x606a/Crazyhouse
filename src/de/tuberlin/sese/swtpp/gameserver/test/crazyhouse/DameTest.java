package de.tuberlin.sese.swtpp.gameserver.test.crazyhouse;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.*;
public class DameTest {

    Dame d1= new Dame("w");
    Dame d2= new Dame("b");
    char[][] board = new char[8][8];
    ArrayList<String> moves= new ArrayList<String>();
    ArrayList<String>testmoves=new ArrayList<String>();
    @Test
    public void testConstructor()
    {
        assertTrue(d1.getValidmove()!=null);
        assertFalse(d1.getPlayer().isEmpty());
        assertTrue(d1.getPlayer()=="w");
        assertTrue(d2.getPlayer()=="b");
    }

    @Test(expected = java.lang.Exception.class)
    public void testwrongPositionWhite() throws Exception
    {
        d1.validMoves(board, 8,8);

    }

    @Test
    public void testValidMoves() throws Exception
    {
        //test Exception wenn übergebene Position nicht auf dem Feld liegt

        // Dame weiß im Spielfeld
        //diagonal
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
        //gerade
        board[3][3]='k';
        board[2][3]='p';
        board[1][3]='p';
        board[0][3]='q';
        board[5][3]='p';
        board[6][3]='p';
        board[7][3]='p';
        board[4][2]='p';
        board[4][1]='p';
        board[4][0]='p';
        board[4][4]='p';
        board[4][5]='p';
        board[4][6]='p';
        board[4][7]='p';
        moves=d1.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),27);
        boardClear();
        // Dame weiß am linken Rand
        //diagonal
        board[3][1]='q';
        board[2][2]='p';
        board[1][3]='p';
        board[0][4]='p';
        board[5][1]='p';
        board[6][2]='p';
        board[7][3]='p';
        //gerade
        board[3][0]='k';
        board[2][0]='p';
        board[1][0]='p';
        board[0][0]='q';
        board[5][0]='p';
        board[6][0]='p';
        board[7][0]='p';
        board[4][1]='p';
        board[4][2]='p';
        board[4][3]='p';
        board[4][4]='p';
        board[4][5]='p';
        board[4][6]='p';
        board[4][7]='p';
        moves=d1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),21;
        boardClear();
        // Dame weiß am rechten Rand
        //diagonal
        board[3][6]='q';
        board[2][5]='p';
        board[1][4]='p';
        board[0][3]='p';
        board[5][6]='p';
        board[6][5]='p';
        board[7][4]='p';
        //gerade
        board[3][7]='k';
        board[2][7]='p';
        board[1][7]='p';
        board[0][7]='q';
        board[5][7]='p';
        board[6][7]='p';
        board[7][7]='p';
        board[4][1]='p';
        board[4][2]='p';
        board[4][3]='p';
        board[4][4]='p';
        board[4][5]='p';
        board[4][6]='p';
        board[4][7]='p';
        moves=d1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),21);
        boardClear();

        // Dame schwarz im Spielfeld
        //diagonal
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
        //gerade
        board[3][3]='K';
        board[2][3]='P';
        board[1][3]='P';
        board[0][3]='P';
        board[5][3]='p';
        board[6][3]='P';
        board[7][3]='P';
        board[4][2]='P';
        board[4][1]='P';
        board[4][0]='P';
        board[4][4]='P';
        board[4][5]='P';
        board[4][6]='P';
        board[4][7]='P';
        moves=d2.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),27);
        boardClear();
        // Dame schwarz am linken Rand
        //diagonal
        board[3][1]='K';
        board[2][2]='P';
        board[1][3]='P';
        board[0][4]='P';
        board[5][1]='P';
        board[6][2]='P';
        board[7][3]='P';
        //gerade
        board[3][0]='k';
        board[2][0]='P';
        board[1][0]='P';
        board[0][0]='P';
        board[5][0]='P';
        board[6][0]='P';
        board[7][0]='P';
        board[4][1]='P';
        board[4][2]='P';
        board[4][3]='P';
        board[4][4]='P';
        board[4][5]='P';
        board[4][6]='P';
        board[4][7]='P';
        moves=d2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),21);
        boardClear();
        // Dame schwarz am rechten Rand
        //diagonal
        board[3][6]='P';
        board[2][5]='P';
        board[1][4]='P';
        board[0][3]='P';
        board[5][6]='P';
        board[6][5]='P';
        board[7][4]='P';
        //gerade
        board[3][7]='K';
        board[2][7]='P';
        board[1][7]='P';
        board[0][7]='P';
        board[5][7]='P';
        board[6][7]='P';
        board[7][7]='P';
        board[4][1]='P';
        board[4][2]='P';
        board[4][3]='P';
        board[4][4]='P';
        board[4][5]='P';
        board[4][6]='P';
        board[4][7]='P';
        moves=d2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),21);
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
