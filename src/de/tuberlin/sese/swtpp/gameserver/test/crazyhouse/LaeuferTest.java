package de.tuberlin.sese.swtpp.gameserver.test.crazyhouse;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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

    @Test
    public void testValidMoves() throws Exception
    {
        //test Exception wenn übergebene Position nicht auf dem Feld liegt
    	
    	//Test Figur schlagen
    	
        // Laeufer weiß im Spielfeld
    	
        board[2][1]='p';
        board[5][2]='p';
        board[2][5]='q';
        board[7][6]='p';
        moves=l1.validMoves(board, 4,3);
        assertEquals(moves.size(),8);
        boardClear();
        // Laeufer weiß am linken Rand
        board[1][3]='p';
        board[7][3]='p';
        moves=l1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        // Laeufer weiß am rechten Rand
        board[0][3]='p';
        board[7][4]='p';
        moves=l1.validMoves(board, 4, 7);
        assertEquals(moves.size(),7);
        boardClear();

        // Laeufer schwarz im Spielfeld
        board[2][1]='P';
        board[5][2]='P';
        board[2][5]='P';
        board[7][6]='P';
        moves=l2.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),8);
        boardClear();
        // Laeufer schwarz am linken Rand
        board[1][3]='P';
        board[7][3]='P';
        moves=l2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        // Laeufer schwarz am rechten Rand
        board[0][3]='P';
        board[7][4]='P';
        moves=l2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),7);
        boardClear();
        
        // Test auf eigene Figur im Weg
        
        // Laeufer weiß im Spielfeld
        board[2][1]='P';
        board[5][2]='P';
        board[2][5]='P';
        board[7][6]='P';
        moves=l1.validMoves(board, 4,3);
        assertEquals(moves.size(),4);
        boardClear();
        // Laeufer weiß am linken Rand
        board[1][3]='P';
        board[7][3]='P';
        moves=l1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        // Laeufer weiß am rechten Rand
        board[0][3]='P';
        board[7][4]='P';
        moves=l1.validMoves(board, 4, 7);
        assertEquals(moves.size(),5);
        boardClear();

        // Laeufer schwarz im Spielfeld
        board[2][1]='p';
        board[5][2]='p';
        board[2][5]='p';
        board[7][6]='p';
        moves=l2.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        // Laeufer schwarz am linken Rand
        board[1][3]='p';
        board[7][3]='p';
        moves=l2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        // Laeufer schwarz am rechten Rand
        board[0][3]='p';
        board[7][4]='p';
        moves=l2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),5);
        boardClear();
        
        // Test auf leeres Feld
        
        // Laeufer weiß im Spielfeld
        board[3][2]='\0';
        board[2][1]='\0';
        board[1][0]='\0';
        board[3][4]='\0';
        board[2][5]='\0';
        board[1][6]='\0';
        board[0][7]='\0';
        board[5][2]='\0';
        board[6][1]='\0';
        board[7][0]='\0';
        board[5][4]='\0';
        board[6][5]='\0';
        board[7][6]='\0';
        moves=l1.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),13);
        boardClear();
        // Laeufer weiß am linken Rand
        board[3][1]='\0';
        board[2][3]='\0';
        board[1][4]='\0';
        board[0][5]='\0';
        board[5][1]='\0';
        board[6][2]='\0';
        board[7][3]='\0';
        moves=l1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),7);
        boardClear();
        // Laeufer weiß am rechten Rand
        board[3][6]='\0';
        board[2][5]='\0';
        board[1][4]='\0';
        board[0][3]='\0';
        board[5][6]='\0';
        board[6][5]='\0';
        board[7][4]='\0';
        moves=l1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),7);
        boardClear();

        // Laeufer schwarz im Spielfeld
        board[3][2]='\0';
        board[2][1]='\0';
        board[1][0]='\0';
        board[3][4]='\0';
        board[2][5]='\0';
        board[1][6]='\0';
        board[0][7]='\0';
        board[5][2]='\0';
        board[6][1]='\0';
        board[7][0]='\0';
        board[5][4]='\0';
        board[6][5]='\0';
        board[7][6]='\0';
        moves=l2.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),13);
        boardClear();
        // Laeufer schwarz am linken Rand
        board[3][1]='\0';
        board[2][3]='\0';
        board[1][4]='\0';
        board[0][5]='\0';
        board[5][1]='\0';
        board[6][2]='\0';
        board[7][3]='\0';
        moves=l2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),7);
        boardClear();
        // Laeufer schwarz am rechten Rand
        board[3][6]='\0';
        board[2][5]='\0';
        board[1][4]='\0';
        board[0][3]='\0';
        board[5][6]='\0';
        board[6][5]='\0';
        board[7][4]='\0';
        moves=l2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),7);
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
