package de.tuberlin.sese.swtpp.gameserver.test.crazyhouse;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Board;

public class BoardTestTest {

	@Test
	public void testBoard() {
		/*Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/");
		char[][] M_b = {{'r','n','b','q','k','b','n','r'},{'p','p','p','p','p','p','p','p'},{'0','0','0','0','0','0','0','0'},{'0','0','0','0','0','0','0','0'},{'0','0','0','0','0','0','0','0'},{'0','0','0','0','0','0','0','0'},{'P','P','P','P','P','P','P','P'},{'R','N','B','Q','K','B','N','R'}};
		String S_b = new String("");
		for(int i = 0 ; i<8; i++) {
			assertTrue( "1board false", M_b[i].equals(b.getBoard()[i]));
			
		}
		assertEquals("1Spare parts not correct!",S_b, b.getSpare_parts());
		*/
		Board b1 = new Board("rnbQ2Q1/pppp3p/6k1/8/1P6/8/Pn1pPKPP/RNB2BNR/BPQRppq");
		char [][] M_b1= {{'r','n','b','Q','0','0','Q','0'},{'p','p','p','p','0','0','0','p'},{'0','0','0','0','0','0','k','0'},{'0','0','0','0','0','0','0','0'},{'0','P','0','0','0','0','0','0'},{'0','0','0','0','0','0','0','0'},{'P','n','0','p','P','K','P','P'},{'R','N','B','0','0','B','N','R'}};
		for(char[] c:M_b1) {
			System.out.println(c);
		}
		System.out.println();
		String S_b="BPQRppq";
		System.out.println(S_b);
		for(int i = 0 ; i<8; i++) {
			System.out.println(S_b);
			assertTrue( "2board false", M_b1[i].equals(b1.getBoard()[i]));
			System.out.println(M_b1);
			System.out.println(b1.getBoard()[i]);
			
		}
		assertEquals("2Spare parts not correct!",S_b, b1.getSpare_parts());
		
		
	}

	@Test
	public void testCheckMove() {
		Board b = new Board("rnbQ2Q1/pppp3p/6k1/8/1P6/8/Pn1pPKPP/RNB2BNR/BPQRppq");
		for(char [] i : b.getBoard()) {
			System.out.println(i);
		}
		try{
			int v=4;
			b.checkMove("g2-g3", "w");
			}catch(Exception e) {
				System.out.println("Hier sollte keine Exception sein!");
			}
		char [][] comp_M = {{'r','n','b','q','k','b','n','r'},{'p','p','p','p','p','p','p','p'},{'0','0','0','0','0','0','0','0'},{'0','0','0','0','0','0','0','0'},{'0','0','0','0','0','0','0','0'},{'0','0','0','0','0','0','P','0'},{'P','P','P','P','P','P','0','P'},{'R','N','B','Q','K','B','N','R'}};
		for (int i = 0; i<8; i++) {
			assertTrue(comp_M[i].equals(b.getBoard()[i]));
		}
		
		b =new Board("rnbQ2Q1/pppp3p/6k1/8/1P6/8/Pn1pPKPP/RNB2BNR/BPQRppq");
		try{
			b.checkMove("g2-e3", "w");
			}catch(Exception e) {
				System.out.println("Nice, es sollte eine exception geben");
			}
		char [][] comp_M1 = 	{{'r','n','b','Q','0','0','Q','0'},{'p','p','p','p','0','0','0','p'},{'0','0','0','0','0','0','k','0'},{'0','0','0','0','0','0','0','0'},{'0','P','0','0','0','0','0','0'},{'0','0','0','0','0','0','0','0'},{'P','n','0','p','P','K','P','P'},{'R','N','B','0','0','B','N','R'}};
		for (int i = 0; i<8; i++) {
			assertTrue(comp_M1[i].equals(b.getBoard()[i]));
		}
		
		
	}

	/*@Test
	public void testBoardToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpare_parts() {
		fail("Not yet implemented");
	}*/

}
