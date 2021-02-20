package de.tuberlin.sese.swtpp.gameserver.test.crazyhouse;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.*;
public class SpringerTest {

    Springer s1= new Springer("w");
    Springer s2= new Springer("b");
    char[][] board = new char[8][8];
    ArrayList<String> moves= new ArrayList<String>();
    ArrayList<String>testmoves=new ArrayList<String>();
    
    @Test
    public void testConstructor()
    {
        assertTrue(s1.getValidmove()!=null);
        assertFalse(s1.getPlayer().isEmpty());
        assertTrue(s1.getPlayer()=="w");
        assertTrue(s2.getPlayer()=="b");
    }


    @Test
    public void testValidMoves() throws Exception
    {
        //test Exception wenn uebergebene Position nicht auf dem Feld liegt

        //Test Figur schlagen
    	
    	// springer weiß im Spielfeld
    	
        board[3][1]='k';
        board[3][5]='q';
        board[2][2]='p';
        board[2][4]='p';
        board[5][1]='p';
        board[5][5]='p';
        board[6][2]='p';
        board[6][4]='p';
        moves=s1.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),8);
        boardClear();
        
        // springer weiß am linken Rand
        
        board[2][1]='k';
        board[6][1]='p';
        board[3][2]='p';
        board[5][2]='p';
        moves=s1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        
        // springer weiß am linken zweiten Rand
        
        board[2][2]='k';
        board[6][2]='p';
        board[3][3]='p';
        board[5][3]='p';
        board[2][0]='p';
        board[6][0]='p';
        moves=s1.validMoves(board, 4, 1);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        
        // springer weiß am rechten Rand
        
        board[2][6]='k';
        board[3][5]='p';
        board[5][5]='p';
        board[6][6]='p';
        moves=s1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        
        // springer weiß am zweiten rechten Rand
        
        board[2][5]='k';
        board[3][4]='p';
        board[5][4]='p';
        board[6][5]='p';
        board[2][7]='p';
        board[6][7]='p';
        moves=s1.validMoves(board, 4, 6);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        
        // springer schwarz im Spielfeld
        
        board[3][1]='P';
        board[3][5]='P';
        board[2][2]='P';
        board[2][4]='P';
        board[5][1]='P';
        board[5][5]='P';
        board[6][2]='P';
        board[6][4]='P';
        moves=s2.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),8);
        boardClear();
        
        // springer schwarz am linken Rand
        
        board[2][1]='P';
        board[6][1]='P';
        board[3][2]='P';
        board[5][2]='P';
        moves=s2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        
        // springer schwarz am linken zweiten Rand
        
        board[2][2]='P';
        board[6][2]='P';
        board[3][3]='P';
        board[5][3]='P';
        board[2][0]='P';
        board[6][0]='P';
        moves=s2.validMoves(board, 4, 1);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        
        // springer schwarz am rechten Rand
        
        board[2][6]='P';
        board[3][5]='P';
        board[5][5]='P';
        board[6][6]='P';
        moves=s2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        
        // springer schwarz am zweiten rechten Rand
        
        board[2][5]='P';
        board[3][4]='P';
        board[5][4]='P';
        board[6][5]='P';
        board[2][7]='P';
        board[6][7]='P';
        moves=s2.validMoves(board, 4, 6);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        
        // Test auf leeres feld bewegen
        
        // springer weiß im Spielfeld
    	
        board[3][1]='\0';
        board[3][5]='\0';
        board[2][2]='\0';
        board[2][4]='\0';
        board[5][1]='\0';
        board[5][5]='\0';
        board[6][2]='\0';
        board[6][4]='\0';
        moves=s1.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),8);
        boardClear();
        
        // springer weiß am linken Rand
        
        board[2][1]='\0';
        board[6][1]='\0';
        board[3][2]='\0';
        board[5][2]='\0';
        moves=s1.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        
        // springer weiß am linken zweiten Rand
        
        board[2][2]='\0';
        board[6][2]='\0';
        board[3][3]='\0';
        board[5][3]='\0';
        board[2][0]='\0';
        board[6][0]='\0';
        moves=s1.validMoves(board, 4, 1);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        
        // springer weiß am rechten Rand
        
        board[2][6]='\0';
        board[3][5]='\0';
        board[5][5]='\0';
        board[6][6]='\0';
        moves=s1.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        
        // springer weiß am zweiten rechten Rand
        
        board[2][5]='\0';
        board[3][4]='\0';
        board[5][4]='\0';
        board[6][5]='\0';
        board[2][7]='\0';
        board[6][7]='\0';
        moves=s1.validMoves(board, 4, 6);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        
        // springer schwarz im Spielfeld
        
        board[3][1]='\0';
        board[3][5]='\0';
        board[2][2]='\0';
        board[2][4]='\0';
        board[5][1]='\0';
        board[5][5]='\0';
        board[6][2]='\0';
        board[6][4]='\0';
        moves=s2.validMoves(board, 4,3);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),8);
        boardClear();
        
        // springer schwarz am linken Rand
        
        board[2][1]='\0';
        board[6][1]='\0';
        board[3][2]='\0';
        board[5][2]='\0';
        moves=s2.validMoves(board, 4, 0);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        
        // springer schwarz am linken zweiten Rand
        
        board[2][2]='\0';
        board[6][2]='\0';
        board[3][3]='\0';
        board[5][3]='\0';
        board[2][0]='\0';
        board[6][0]='\0';
        moves=s2.validMoves(board, 4, 1);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
        boardClear();
        
        // springer schwarz am rechten Rand
        
        board[2][6]='\0';
        board[3][5]='\0';
        board[5][5]='\0';
        board[6][6]='\0';
        moves=s2.validMoves(board, 4, 7);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),4);
        boardClear();
        
        // springer schwarz am zweiten rechten Rand
        
        board[2][5]='\0';
        board[3][4]='\0';
        board[5][4]='\0';
        board[6][5]='\0';
        board[2][7]='\0';
        board[6][7]='\0';
        moves=s2.validMoves(board, 4, 6);
        assertFalse(moves.isEmpty());
        assertEquals(moves.size(),6);
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
