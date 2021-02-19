package de.tuberlin.sese.swtpp.gameserver.test.crazyhouse;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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
        assertFalse(d1.getPlayer()=="b");
    }

    @Test
    public void testValidMoves() throws Exception
    {

        //Test Figur schlagen

        // Dame weiß im Spielfeld

        //diagonal
        board[2][1]='p';
        board[6][1]='p';
        board[2][5]='q';
        board[6][5]='p';
        //gerade
        board[2][3]='k';
        board[6][3]='p';
        board[4][1]='p';
        board[4][5]='q';
        moves=d1.validMoves(board, 4,3);
        assertEquals(moves.size(),16);
        boardClear();
        // Dame weiß am linken Rand
        //diagonal
        board[2][2]='p';
        board[6][2]='p';
        //gerade
        board[2][0]='k';
        board[6][0]='p';
        board[4][5]='p';
        moves=d1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),13);
        boardClear();
        // Dame weiß am rechten Rand
        //diagonal
        board[2][5]='p';
        board[6][5]='p';
        //gerade
        board[2][7]='k';
        board[6][7]='p';
        board[4][5]='p';
        moves=d1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),10);
        boardClear();

        // Dame schwarz im Spielfeld

        //diagonal
        board[2][1]='P';
        board[6][1]='P';
        board[2][5]='P';
        board[6][5]='P';
        //gerade
        board[2][3]='P';
        board[6][3]='P';
        board[4][1]='P';
        board[4][5]='P';
        moves=d2.validMoves(board, 4,3);
        assertEquals(moves.size(),16);
        boardClear();
        // Dame schwarz am linken Rand
        //diagonal
        board[2][2]='P';
        board[6][2]='P';
        //gerade
        board[2][0]='P';
        board[6][0]='P';
        board[4][5]='P';
        moves=d2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),13);
        boardClear();
        // Dame schwarz am rechten Rand
        //diagonal
        board[2][5]='P';
        board[6][5]='P';
        //gerade
        board[2][7]='P';
        board[6][7]='P';
        board[4][5]='P';
        moves=d2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),10);
        boardClear();

        // Test auf eigene Figur im Weg

        //weiss
        //diagonal
        board[2][1]='P';
        board[6][1]='P';
        board[2][5]='P';
        board[6][5]='P';
        //gerade
        board[2][3]='P';
        board[6][3]='P';
        board[4][1]='P';
        board[4][5]='P';
        moves=d1.validMoves(board, 4,3);
        assertEquals(moves.size(),8);
        boardClear();
        // Dame weiß am linken Rand
        //diagonal
        board[2][2]='P';
        board[6][2]='P';
        //gerade
        board[2][0]='P';
        board[6][0]='P';
        board[4][5]='P';
        moves=d1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),8);
        boardClear();
        // Dame weiß am rechten Rand
        //diagonal
        board[2][5]='P';
        board[6][5]='P';
        //gerade
        board[2][7]='P';
        board[6][7]='P';
        board[4][5]='P';
        moves=d1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),5);
        boardClear();

        //schwarz
        //diagonal
        board[2][1]='p';
        board[6][1]='p';
        board[2][5]='p';
        board[6][5]='p';
        //gerade
        board[2][3]='p';
        board[6][3]='p';
        board[4][1]='p';
        board[4][5]='p';
        moves=d2.validMoves(board, 4,3);
        assertEquals(moves.size(),8);
        boardClear();
        // Dame schwarz am linken Rand
        //diagonal
        board[2][2]='p';
        board[6][2]='p';
        //gerade
        board[2][0]='p';
        board[6][0]='p';
        board[4][5]='p';
        moves=d2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),8);
        boardClear();
        // Dame schwarz am rechten Rand
        //diagonal
        board[2][5]='p';
        board[6][5]='p';
        //gerade
        board[2][7]='p';
        board[6][7]='p';
        board[4][5]='p';
        moves=d2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),5);
        boardClear();


        // Test auf leeres Feld

        //diagonal
        board[2][1]='\0';
        board[6][1]='\0';
        board[2][5]='\0';
        board[6][5]='\0';
        //gerade
        board[2][3]='\0';
        board[6][3]='\0';
        board[4][1]='\0';
        board[4][5]='\0';
        moves=d1.validMoves(board, 4,3);
        assertEquals(moves.size(),27);
        boardClear();
        // Dame weiß am linken Rand
        //diagonal
        board[2][2]='\0';
        board[6][2]='\0';
        //gerade
        board[2][0]='\0';
        board[6][0]='\0';
        board[4][5]='\0';
        moves=d1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),21);
        boardClear();
        // Dame weiß am rechten Rand
        //diagonal
        board[2][5]='\0';
        board[6][5]='\0';
        //gerade
        board[2][7]='\0';
        board[6][7]='\0';
        board[4][5]='\0';
        moves=d1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),21);
        boardClear();

        //diagonal
        board[2][1]='\0';
        board[6][1]='\0';
        board[2][5]='\0';
        board[6][5]='\0';
        //gerade
        board[2][3]='\0';
        board[6][3]='\0';
        board[4][1]='\0';
        board[4][5]='\0';
        moves=d2.validMoves(board, 4,3);
        assertEquals(moves.size(),27);
        boardClear();
        // Dame weiß am linken Rand
        //diagonal
        board[2][2]='\0';
        board[6][2]='\0';
        //gerade
        board[2][0]='\0';
        board[6][0]='\0';
        board[4][5]='\0';
        moves=d2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),21);
        boardClear();
        // Dame weiß am rechten Rand
        //diagonal
        board[2][5]='\0';
        board[6][5]='\0';
        //gerade
        board[2][7]='\0';
        board[6][7]='\0';
        board[4][5]='\0';
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
