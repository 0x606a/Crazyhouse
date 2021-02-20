package de.tuberlin.sese.swtpp.gameserver.test.crazyhouse;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.*;
public class BauerTest {

	Bauer bauer1=new Bauer("w");
	Bauer bauer2=new Bauer("b");
	char[][] board = new char[8][8];
	ArrayList<String> moves= new ArrayList<String>();
	ArrayList<String>testmoves=new ArrayList<String>();
	@Test
	public void testConstructor()
	{
		assertTrue(bauer1.getValidmove()!=null);
		assertFalse(bauer1.getPlayer().isEmpty());
		assertTrue(bauer1.getPlayer()=="w");
		assertTrue(bauer2.getPlayer()=="b");
	}
	
	@Test 
	public void testValidMoves() throws Exception
	{
		//test Exception wenn übergebene Position nicht auf dem Feld liegt
		
		// bauer weiß im Spielfeld
		board[3][2]='k';
		board[3][4]='q';
		moves=bauer1.validMoves(board, 4,3);
		assertFalse(moves.isEmpty());
		assertEquals(moves.size(),3);  
		boardClear();
		// bauer weiß am linken Rand
		board[3][1]='k';
		moves=bauer1.validMoves(board, 4, 0);
		assertFalse(moves.isEmpty());
		assertEquals(moves.size(),2);  
		boardClear();
		// bauer weiß am rechten Rand
		board[3][6]='k';
		moves=bauer1.validMoves(board, 4, 7);
		assertFalse(moves.isEmpty());
		assertEquals(moves.size(),2);  
		boardClear();
		
		//Bauer schwarz im Spielfeld
		board[5][2]='K';
		board[5][4]='Q';
		moves=bauer2.validMoves(board, 4,3);
		assertFalse(moves.isEmpty());
		assertEquals(moves.size(),3);  
		boardClear();
		// bauer schwarz am linken Rand
		board[5][1]='K';
		moves=bauer2.validMoves(board, 4, 0);
		assertFalse(moves.isEmpty());
		assertEquals(moves.size(),2);  
		boardClear();
		// bauer schwarz am rechten Rand
		board[5][6]='K';
		moves=bauer2.validMoves(board, 4, 7);
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
