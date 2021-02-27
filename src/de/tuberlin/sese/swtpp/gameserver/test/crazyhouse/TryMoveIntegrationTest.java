package de.tuberlin.sese.swtpp.gameserver.test.crazyhouse;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.tuberlin.sese.swtpp.gameserver.control.GameController;
import de.tuberlin.sese.swtpp.gameserver.model.Game;
import de.tuberlin.sese.swtpp.gameserver.model.Player;
import de.tuberlin.sese.swtpp.gameserver.model.User;

public class TryMoveIntegrationTest {

	User user1 = new User("Alice", "alice");
	User user2 = new User("Bob", "bob");

	Player whitePlayer = null;
	Player blackPlayer = null;
	Game game = null;
	GameController controller;

	@Before
	public void setUp() throws Exception {
		controller = GameController.getInstance();
		controller.clear();

		int gameID = controller.startGame(user1, "", "crazyhouse");

		game =  controller.getGame(gameID);
		whitePlayer = game.getPlayer(user1);

	}

	public void startGame() {
		controller.joinGame(user2, "crazyhouse");
		blackPlayer = game.getPlayer(user2);
	}

	public void startGame(String initialBoard, boolean whiteNext) {
		startGame();

		game.setBoard(initialBoard);
		game.setNextPlayer(whiteNext? whitePlayer:blackPlayer);
	}

	public void assertMove(String move, boolean white, boolean expectedResult) {
		if (white)
			assertEquals(expectedResult, game.tryMove(move, whitePlayer));
		else
			assertEquals(expectedResult,game.tryMove(move, blackPlayer));
	}

	public void assertGameState(String expectedBoard, boolean whiteNext, boolean finished, boolean whiteWon) {
		String board = game.getBoard().replaceAll("e", "");

		assertEquals(expectedBoard,board);
		assertEquals(finished, game.isFinished());

		if (!game.isFinished()) {
			assertEquals(whiteNext, game.getNextPlayer() == whitePlayer);
		} else {
			assertEquals(whiteWon, whitePlayer.isWinner());
			assertEquals(!whiteWon, blackPlayer.isWinner());
		}
	}


	/*******************************************
	 * !!!!!!!!! To be implemented !!!!!!!!!!!!
	 *******************************************/


	@Test
	public void MoveStringNotOkTest() {

		// length != 3
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("b2-b3-2",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		// FEN.length != 2
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("b25-b3",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		// FEN-char not in map
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("z2-b3",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		// FEN-number not in map (x-coordinates)
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("b9-b3",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		// FEN-number not in map (y-coordinates)
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("b2-b9",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		// FEN-number not in map (x- & y-coordinates)
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("b9-b9",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		// FEN-number not in map (x-coordinates)
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("b9-b3",false,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false,false,false);

	}

	@Test
	public void NotPlayersTurnTest() {

		// white's turn, but black's playing
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("b7-b6",false,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		// white's turn, but whites playing
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("b7-b6",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		// black's turn, but white's playing
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("b2-b3",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false,false,false);

		// black's turn, but white's playing
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("b2-b3",false,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false,false,false);


		// white's turn, not a figure
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("f4-f5",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		// black's turn, not a figure
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("f5-f4",false,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false,false,false);

	}

	@Test
	public void CheckMateTest() {

		// Game finished by white
		startGame("rnbq1bnr/pp4pp/2ppp3/3k4/2p5/P3P3/PQP1PPPP/RNB1KBNR/",true); // falsches Testfeld (Bauer auf e5 kann nach vorne laufen und verhindert damit Schachmatt)
		assertMove("b2-d4",true,true);
		assertGameState("rnbq1bnr/pp4pp/2ppp3/3k4/2pQ4/P3P3/P1P1PPPP/RNB1KBNR/",false,true,true);

	}
	@Test
	public void GameFinishedTest() {

		// Game finished by white
		startGame("rnbq1bnr/pppppppp/8/8/3k4/4P3/PPPP1PPP/RNBQKBNR/",true);
		assertMove("e3-d4",true,true);
		assertGameState("rnbq1bnr/pppppppp/8/8/3P4/8/PPPP1PPP/RNBQKBNR/K",false,true,true);

		// Game not finished by white
		startGame("rnbqkbnr/pppp1ppp/8/4p3/3K4/8/PPPPPPPP/RNBQ1BNR/",false);
		assertMove("e5-d4",false,true);
		assertGameState("rnbqkbnr/pppp1ppp/8/8/3p4/8/PPPPPPPP/RNBQ1BNR/k",true,true,false);
	}

	@Test
	public void SparePartsTest() {

		//put figur back to board white
		startGame("rnbqkbnr/2pppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/PP",true);
		assertMove("P-d4",true,true);
		assertGameState("rnbqkbnr/2pppppp/8/8/3P4/8/PPPPPPPP/RNBQKBNR/P",false,false,false);

		//put figur back to board black
		startGame("rnbqkbnr/pppppppp/8/8/8/8/2PPPPPP/RNBQKBNR/pp",false);
		assertMove("p-d4",false,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/3p4/8/2PPPPPP/RNBQKBNR/p",true,false,false);

		//put figur back to spare black
		startGame("rnbqkbnr/1pp1pppp/3p4/8/3R4/8/PPPPPPPP/1NBQKBNR/P",true);
		assertMove("d4-d6",true,true);
		assertGameState("rnbqkbnr/1pp1pppp/3R4/8/8/8/PPPPPPPP/1NBQKBNR/PP",false,false,false);

		//put figur back to spare white
		startGame("rnb1kbnr/pppppppp/8/8/3q4/8/1PPPPPPP/RNBQKBNR/p",false);
		assertMove("d4-b2",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/8/8/1qPPPPPP/RNBQKBNR/pp",true,false,false);

		//put figur back to board error
		startGame("rnbqkbnr/2pppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/PP",true);
		assertMove("Q-d4",true,false);
		assertGameState("rnbqkbnr/2pppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/PP",true,false,false);

		//put figur back to board black big
		startGame("rnbqkbnr/2pppppp/8/8/8/8/PPPPPPPP/RNB1KBNR/PPq",false);
		assertMove("q-d4",false,true);
		assertGameState("rnbqkbnr/2pppppp/8/8/3q4/8/PPPPPPPP/RNB1KBNR/PP",true,false,false);

		//add figur back to board black big
		startGame("rnb1kbnr/2pppppp/8/2q5/8/4B3/PPPPPPPP/RNB1K1NR/PP",false);
		assertMove("c5-e3",false,true);
		assertGameState("rnb1kbnr/2pppppp/8/8/8/4q3/PPPPPPPP/RNB1K1NR/PPb",true,false,false);


		//put figur back to board white error last field
		startGame("1nbqkbnr/2pppppp/8/3r4/8/8/PPPPPPPP/RNBQKBNR/PP",true);
		assertMove("P-a8",true,false);
		assertGameState("1nbqkbnr/2pppppp/8/3r4/8/8/PPPPPPPP/RNBQKBNR/PP",true,false,false);

		//put figur back to board black error last field
		startGame("rnbqkbnr/pppppppp/8/4P3/8/4R3/2PPPPP1/RNBQKBN1/pp",false);
		assertMove("p-h1",false,false);
		assertGameState("rnbqkbnr/pppppppp/8/4P3/8/4R3/2PPPPP1/RNBQKBN1/pp",false,false,false);

		//put figur back to board error own figure
		startGame("1nbqkbnr/2pppppp/8/3r4/8/8/PPPPPPPP/RNBQKBNR/PP",true);
		assertMove("P-d2",true,false);
		assertGameState("1nbqkbnr/2pppppp/8/3r4/8/8/PPPPPPPP/RNBQKBNR/PP",true,false,false);

		//put figur back to board black error wrong color
		startGame("1nbqkbnr/2pppppp/8/3r4/8/8/PPPPPPPP/RNBQKBNR/PP",false);
		assertMove("P-g4",false,false);
		assertGameState("1nbqkbnr/2pppppp/8/3r4/8/8/PPPPPPPP/RNBQKBNR/PP",false,false,false);

		//put figur back to board black error last field
		startGame("rnbqkbnr/pppppppp/8/4P3/8/4R3/2PPPPP1/RNBQKBN1/pp",true);
		assertMove("p-g5",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/4P3/8/4R3/2PPPPP1/RNBQKBN1/pp",true,false,false);
	}

	@Test
	public void therealCrayzGameTest() {

		//Bauer Dame Tausch white
		startGame("rnbqkbnr/pppppppp/PPPPPPPP/pppppppp/PPPPPPPP/pppppppp/PPPPPPPP/RNBQKBNR/",true);
		assertMove("d4-e5",true,true);
		assertGameState("rnbqkbnr/pppppppp/PPPPPPPP/ppppPppp/PPP1PPPP/pppppppp/PPPPPPPP/RNBQKBNR/P",false,false,false);
	}

	@Test
	public void BauerRuleTest() {

		//Bauer Dame Tausch black
		startGame("rnbqkbnr/pp1ppppp/8/4P3/6K1/8/PPPPpPPP/RNBQ1BNR/",false);
		assertMove("e2-e1",false,true);
		assertGameState("rnbqkbnr/pp1ppppp/8/4P3/6K1/8/PPPP1PPP/RNBQqBNR/",true,false,false);

		//Bauer Dame Tausch white
		startGame("rn1qkbnr/ppPppppp/8/8/bp6/8/PPPP1PPP/RNBQKBNR/",true);
		assertMove("c7-c8",true,true);
		assertGameState("rnQqkbnr/pp1ppppp/8/8/bp6/8/PPPP1PPP/RNBQKBNR/",false,false,false);
	}

	@Test
	public void BauerBigMoveTest() {

		//Bauer Doppelschritt white
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("a2-a4",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/P7/8/1PPPPPPP/RNBQKBNR/",false,false,false);

		//Bauer Doppelschritt white
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("h2-h4",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/7P/8/PPPPPPP1/RNBQKBNR/",false,false,false);

		//Bauer Doppelschritt fail white
		startGame("rnbqkbnr/1ppppppp/8/8/8/p7/PPPPPPPP/RNBQKBNR/",true);
		assertMove("a2-a4",true,false);
		assertGameState("rnbqkbnr/1ppppppp/8/8/8/p7/PPPPPPPP/RNBQKBNR/",true,false,false);

		//Bauer Doppelschritt fail white
		startGame("rnbqkbnr/ppppppp1/8/8/8/7p/PPPPPPPP/RNBQKBNR/",true);
		assertMove("h2-h4",true,false);
		assertGameState("rnbqkbnr/ppppppp1/8/8/8/7p/PPPPPPPP/RNBQKBNR/",true,false,false);

		//Bauer Doppelschritt black
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("a7-a5",false,true);
		assertGameState("rnbqkbnr/1ppppppp/8/p7/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//Bauer Doppelschritt black
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("h7-h5",false,true);
		assertGameState("rnbqkbnr/ppppppp1/8/7p/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//Bauer Doppelschritt fail black
		startGame("rnbqkbnr/pppppppp/P7/8/8/8/1PPPPPPP/RNBQKBNR/",true);
		assertMove("a7-a5",true,false);
		assertGameState("rnbqkbnr/pppppppp/P7/8/8/8/1PPPPPPP/RNBQKBNR/",true,false,false);

		//Bauer Doppelschritt fail black
		startGame("rnbqkbnr/pppppppp/7P/8/8/8/1PPPPPPP/RNBQKBNR/",true);
		assertMove("h7-h5",true,false);
		assertGameState("rnbqkbnr/pppppppp/7P/8/8/8/1PPPPPPP/RNBQKBNR/",true,false,false);

	}

	@Test
	public void TurmWhiteUpMoveTest() {

		//move ok up
		startGame("rnbqkbnr/pppppppp/8/8/3R4/8/PPPPPPPP/1NBQKBNR/",true);
		assertMove("d4-d6",true,true);
		assertGameState("rnbqkbnr/pppppppp/3R4/8/8/8/PPPPPPPP/1NBQKBNR/",false,false,false);

		//move ok, enemy on destination up
		startGame("rnbqkbnr/ppp1pppp/3p4/8/3R4/8/PPPPPPPP/1NBQKBNR/",true);
		assertMove("d4-d6",true,true);
		assertGameState("rnbqkbnr/ppp1pppp/3R4/8/8/8/PPPPPPPP/1NBQKBNR/P",false,false,false);

		//move ok down
		startGame("rnbqkbnr/pppppppp/3R4/8/8/8/PPPPPPPP/1NBQKBNR/",true);
		assertMove("d6-d4",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/3R4/8/PPPPPPPP/1NBQKBNR/",false,false,false);

		//move ok, enemy on destination down
		startGame("rnbqkbnr/1ppppppp/3R4/8/3p4/8/PPPPPPPP/1NBQKBNR/",true);
		assertMove("d6-d4",true,true);
		assertGameState("rnbqkbnr/1ppppppp/8/8/3R4/8/PPPPPPPP/1NBQKBNR/P",false,false,false);

	}

	@Test
	public void TurmWhiteSideMoveTest() {

		//move ok left
		startGame("rnbqkbnr/pppppppp/8/8/3R4/8/PPPPPPPP/1NBQKBNR/",true);
		assertMove("d4-a4",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/R7/8/PPPPPPPP/1NBQKBNR/",false,false,false);

		//move ok, enemy on destination left
		startGame("rnbqkbnr/ppp1pppp/8/8/1p1R4/8/PPPPPPPP/1NBQKBNR/",true);
		assertMove("d4-b4",true,true);
		assertGameState("rnbqkbnr/ppp1pppp/8/8/1R6/8/PPPPPPPP/1NBQKBNR/P",false,false,false);

		//move ok right
		startGame("rnbqkbnr/pppppppp/8/8/R7/8/PPPPPPPP/1NBQKBNR/",true);
		assertMove("a4-d4",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/3R4/8/PPPPPPPP/1NBQKBNR/",false,false,false);

		//move ok, enemy on destination right
		startGame("rnbqkbnr/1ppppppp/8/8/R2p4/8/PPPPPPPP/1NBQKBNR/",true);
		assertMove("a4-d4",true,true);
		assertGameState("rnbqkbnr/1ppppppp/8/8/3R4/8/PPPPPPPP/1NBQKBNR/P",false,false,false);

		//move not ok own figure up
		startGame("rnbqkbnr/1ppppppp/8/8/3P4/3R4/1PPPPPPP/1NBQKBNR/",true);
		assertMove("d3-d4",true,false);
		assertGameState("rnbqkbnr/1ppppppp/8/8/3P4/3R4/1PPPPPPP/1NBQKBNR/",true,false,false);

		//move not ok own figure left
		startGame("rnbqkbnr/pppppppp/8/8/1P1R4/8/1PPPPPPP/1NBQKBNR/",true);
		assertMove("d4-b4",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/1P1R4/8/1PPPPPPP/1NBQKBNR/",true,false,false);

		//move not ok own figure left
		startGame("rnbqkbnr/pppppppp/8/8/3R1P2/8/1PPPPPPP/1NBQKBNR/",true);
		assertMove("d4-g4",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/3R1P2/8/1PPPPPPP/1NBQKBNR/",true,false,false);

	}

	@Test
	public void TurmBlackUpMoveTest() {

		//move ok up
		startGame("1nbqkbnr/pppppppp/8/8/3r4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-d6",false,true);
		assertGameState("1nbqkbnr/pppppppp/3r4/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination up
		startGame("1nbqkbnr/pppppppp/3P4/8/3r4/8/1PPPPPPP/RNBQKBNR/",false);
		assertMove("d4-d6",false,true);
		assertGameState("1nbqkbnr/pppppppp/3r4/8/8/8/1PPPPPPP/RNBQKBNR/p",true,false,false);

		//move ok down
		startGame("1nbqkbnr/pppppppp/3r4/8/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d6-d4",false,true);
		assertGameState("1nbqkbnr/pppppppp/8/8/3r4/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination down
		startGame("1nbqkbnr/pppppppp/3r4/8/3P4/8/1PPPPPPP/RNBQKBNR/",false);
		assertMove("d6-d4",false,true);
		assertGameState("1nbqkbnr/pppppppp/8/8/3r4/8/1PPPPPPP/RNBQKBNR/p",true,false,false);

	}

	@Test
	public void TurmBlackSideMoveTest() {

		//move ok left
		startGame("1nbqkbnr/pppppppp/8/8/3r4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-a4",false,true);
		assertGameState("1nbqkbnr/pppppppp/8/8/r7/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination left
		startGame("1nbqkbnr/pppppppp/8/8/1P1r4/8/1PPPPPPP/RNBQKBNR/",false);
		assertMove("d4-b4",false,true);
		assertGameState("1nbqkbnr/pppppppp/8/8/1r6/8/1PPPPPPP/RNBQKBNR/p",true,false,false);

		//move ok right
		startGame("1nbqkbnr/pppppppp/8/8/r7/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("a4-d4",false,true);
		assertGameState("1nbqkbnr/pppppppp/8/8/3r4/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination right
		startGame("1nbqkbnr/pppppppp/8/8/r2P4/8/1PPPPPPP/RNBQKBNR/",false);
		assertMove("a4-d4",false,true);
		assertGameState("1nbqkbnr/pppppppp/8/8/3r4/8/1PPPPPPP/RNBQKBNR/p",true,false,false);

		//move not ok own figure up
		startGame("rnbqkbn1/ppp1pppp/3r4/3p4/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d6-d4",false,false);
		assertGameState("rnbqkbn1/ppp1pppp/3r4/3p4/8/8/PPPPPPPP/RNBQKBNR/",false,false,false);

		//move not ok own figure left
		startGame("rnbqkbn1/ppp1pppp/8/8/2pr4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-b4",false,false);
		assertGameState("rnbqkbn1/ppp1pppp/8/8/2pr4/8/PPPPPPPP/RNBQKBNR/",false,false,false);

		//move not ok own figure left
		startGame("rnbqkbn1/ppp1pppp/8/8/3r1p2/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-g4",false,false);
		assertGameState("rnbqkbn1/ppp1pppp/8/8/3r1p2/8/PPPPPPPP/RNBQKBNR/",false,false,false);

	}

	@Test
	public void BauerMoveTest() {

		//white player

		//move ok
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",true);
		assertMove("b2-b3",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/1P6/P1PPPPPP/RNBQKBNR/",false,false,false);

		//move ok, enemy on destination left
		startGame("rnbqkbnr/1ppppppp/8/8/8/6p1/PPPPPPPP/RNBQKBNR/",true);
		assertMove("h2-g3",true,true);
		assertGameState("rnbqkbnr/1ppppppp/8/8/8/6P1/PPPPPPP1/RNBQKBNR/P",false,false,false);

		//move ok, enemy on destination right
		startGame("rnbqkbnr/1ppppppp/8/8/8/1p6/PPPPPPPP/RNBQKBNR/",true);
		assertMove("a2-b3",true,true);
		assertGameState("rnbqkbnr/1ppppppp/8/8/8/1P6/1PPPPPPP/RNBQKBNR/P",false,false,false);

		//black player

		//move ok
		startGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("b7-b6",false,true);
		assertGameState("rnbqkbnr/p1pppppp/1p6/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination left
		startGame("rnbqkbnr/pppppppp/1P6/8/8/8/1PPPPPPP/RNBQKBNR/",false);
		assertMove("a7-b6",false,true);
		assertGameState("rnbqkbnr/1ppppppp/1p6/8/8/8/1PPPPPPP/RNBQKBNR/p",true,false,false);

		//move ok, enemy on destination right
		startGame("rnbqkbnr/pppppppp/6P1/8/8/8/PP1PPPPP/RNBQKBNR/",false);
		assertMove("h7-g6",false,true);
		assertGameState("rnbqkbnr/ppppppp1/6p1/8/8/8/PP1PPPPP/RNBQKBNR/p",true,false,false);
	}

	@Test
	public void KoenigWhiteLeftMoveTest() {

		//move ok
		startGame("rnbqkbnr/pppppppp/8/8/3K4/8/PPPPPPPP/RNBQ1BNR/",true);
		assertMove("d4-d3",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/3K4/PPPPPPPP/RNBQ1BNR/",false,false,false);

		//move ok, enemy on destination unten
		startGame("rnbqkbnr/1ppppppp/8/8/3K4/3p4/PPPPPPPP/RNBQ1BNR/",true);
		assertMove("d4-d3",true,true);
		assertGameState("rnbqkbnr/1ppppppp/8/8/8/3K4/PPPPPPPP/RNBQ1BNR/P",false,false,false);

		//move ok, enemy on destination links unten
		startGame("rnbqkbnr/pp1ppppp/8/8/3K4/2p5/PPPPPPPP/RNBQ1BNR/",true);
		assertMove("d4-c3",true,true);
		assertGameState("rnbqkbnr/pp1ppppp/8/8/8/2K5/PPPPPPPP/RNBQ1BNR/P",false,false,false);

		//move ok, enemy on destination links
		startGame("rnbqkbnr/pp1ppppp/8/8/2pK4/8/PPPPPPPP/RNBQ1BNR/",true);
		assertMove("d4-c4",true,true);
		assertGameState("rnbqkbnr/pp1ppppp/8/8/2K5/8/PPPPPPPP/RNBQ1BNR/P",false,false,false);

		//move ok, enemy on destination links oben
		startGame("rnbqkbnr/pp1ppppp/8/2p5/3K4/8/PPPPPPPP/RNBQ1BNR/",true);
		assertMove("d4-c5",true,true);
		assertGameState("rnbqkbnr/pp1ppppp/8/2K5/8/8/PPPPPPPP/RNBQ1BNR/P",false,false,false);

	}

	@Test
	public void KoenigWhiteRightMoveTest() {

		//move ok, enemy on destination oben
		startGame("rnbqkbnr/ppppppp1/8/3p4/3K4/8/PPPPPPPP/RNBQ1BNR/",true);
		assertMove("d4-d5",true,true);
		assertGameState("rnbqkbnr/ppppppp1/8/3K4/8/8/PPPPPPPP/RNBQ1BNR/P",false,false,false);

		//move ok, enemy on destination rechts oben
		startGame("rnbqkbnr/pppp1ppp/8/4p3/3K4/8/PPPPPPPP/RNBQ1BNR/",true); // funktioniert im Spiel
		assertMove("d4-e5",true,true);
		assertGameState("rnbqkbnr/pppp1ppp/8/4K3/8/8/PPPPPPPP/RNBQ1BNR/P",false,false,false);

		//move ok, enemy on destination rechts
		startGame("rnbqkbnr/pppp1ppp/8/8/3Kp3/8/PPPPPPPP/RNBQ1BNR/",true);
		assertMove("d4-e4",true,true);
		assertGameState("rnbqkbnr/pppp1ppp/8/8/4K3/8/PPPPPPPP/RNBQ1BNR/P",false,false,false);

		//move ok, enemy on destination rechts unten
		startGame("rnbqkbnr/pppp1ppp/8/8/3K4/4p3/PPPPPPPP/RNBQ1BNR/",true);
		assertMove("d4-e3",true,true);
		assertGameState("rnbqkbnr/pppp1ppp/8/8/8/4K3/PPPPPPPP/RNBQ1BNR/P",false,false,false);

	}

	@Test
	public void KoenigBlackLeftMoveTest() {

		//move ok
		startGame("rnbq1bnr/pppppppp/8/8/3k4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-d5",false,true);
		assertGameState("rnbq1bnr/pppppppp/8/3k4/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination unten
		startGame("rnbq1bnr/pppppppp/8/2k5/2P5/8/PPP1PPPP/RNBQKBNR/",false);
		assertMove("c5-c4",false,true);
		assertGameState("rnbq1bnr/pppppppp/8/8/2k5/8/PPP1PPPP/RNBQKBNR/p",true,false,false);

		//move ok, enemy on destination links unten
		startGame("rnbq1bnr/pppppppp/8/2k5/1P6/8/PPP1PPPP/RNBQKBNR/",false);
		assertMove("c5-b4",false,true);
		assertGameState("rnbq1bnr/pppppppp/8/8/1k6/8/PPP1PPPP/RNBQKBNR/p",true,false,false);

		//move ok, enemy on destination links
		startGame("rnbq1bnr/pppppppp/8/8/2Pk4/8/PPP1PPPP/RNBQKBNR/",false);
		assertMove("d4-c4",false,true);
		assertGameState("rnbq1bnr/pppppppp/8/8/2k5/8/PPP1PPPP/RNBQKBNR/p",true,false,false);

		//move ok, enemy on destination links oben
		startGame("rnbq1bnr/pppppppp/8/2P5/3k4/8/PPP1PPPP/RNBQKBNR/",false);
		assertMove("d4-c5",false,true);
		assertGameState("rnbq1bnr/pppppppp/8/2k5/8/8/PPP1PPPP/RNBQKBNR/p",true,false,false);

	}

	@Test
	public void KoenigBlackRightMoveTest() {

		//move ok, enemy on destination oben
		startGame("rnbq1bnr/pppppppp/8/1P6/1k6/8/PPP1PPPP/RNBQKBNR/",false);
		assertMove("b4-b5",false,true);
		assertGameState("rnbq1bnr/pppppppp/8/1k6/8/8/PPP1PPPP/RNBQKBNR/p",true,false,false);

		//move ok, enemy on destination rechts oben
		startGame("rnbq1bnr/pppppppp/8/4P3/3k4/8/PPP1PPPP/RNBQKBNR/",false);
		assertMove("d4-e5",false,true);
		assertGameState("rnbq1bnr/pppppppp/8/4k3/8/8/PPP1PPPP/RNBQKBNR/p",true,false,false);

		//move ok, enemy on destination rechts
		startGame("rnbq1bnr/pppppppp/8/8/3kP3/8/PPP1PPPP/RNBQKBNR/",false);
		assertMove("d4-e4",false,true);
		assertGameState("rnbq1bnr/pppppppp/8/8/4k3/8/PPP1PPPP/RNBQKBNR/p",true,false,false);

		//move ok, enemy on destination rechts unten
		startGame("rnbq1bnr/pppppppp/8/1k6/2P5/8/PPP1PPPP/RNBQKBNR/",false);
		assertMove("b5-c4",false,true);
		assertGameState("rnbq1bnr/pppppppp/8/8/2k5/8/PPP1PPPP/RNBQKBNR/p",true,false,false);

	}

	@Test
	public void LaeuferWhiteUpMoveTest() {

		//move ok left up
		startGame("rnbqkbnr/pppppppp/8/8/3B4/8/PPPPPPPP/RN1QKBNR/",true);
		assertMove("d4-b6",true,true);
		assertGameState("rnbqkbnr/pppppppp/1B6/8/8/8/PPPPPPPP/RN1QKBNR/",false,false,false);

		//move ok, enemy on destination left up
		startGame("rnbqkbnr/p1pppppp/1p6/8/3B4/8/PPPPPPPP/RN1QKBNR/",true);
		assertMove("d4-b6",true,true);
		assertGameState("rnbqkbnr/p1pppppp/1B6/8/8/8/PPPPPPPP/RN1QKBNR/P",false,false,false);

		//move ok right up
		startGame("rnbqkbnr/pppppppp/8/8/3B4/8/PPPPPPPP/RN1QKBNR/",true);
		assertMove("d4-f6",true,true);
		assertGameState("rnbqkbnr/pppppppp/5B2/8/8/8/PPPPPPPP/RN1QKBNR/",false,false,false);

		//move ok, enemy on destination right up
		startGame("rnbqkbnr/ppppp1pp/5p2/8/3B4/8/PPPPPPPP/RN1QKBNR/",true);
		assertMove("d4-f6",true,true);
		assertGameState("rnbqkbnr/ppppp1pp/5B2/8/8/8/PPPPPPPP/RN1QKBNR/P",false,false,false);

	}

	@Test
	public void LaeuferWhiteDownMoveTest() {

		//move ok left down
		startGame("rnbqkbnr/pppppppp/8/8/3B4/8/PPPPPPPP/RN1QKBNR/",true);
		assertMove("d4-c3",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/2B5/PPPPPPPP/RN1QKBNR/",false,false,false);

		//move ok, enemy on destination left down
		startGame("rnbqkbnr/1ppppppp/8/8/3B4/2p5/PPPPPPPP/RN1QKBNR/",true);
		assertMove("d4-c3",true,true);
		assertGameState("rnbqkbnr/1ppppppp/8/8/8/2B5/PPPPPPPP/RN1QKBNR/P",false,false,false);

		//move ok right down
		startGame("rnbqkbnr/pppppppp/8/8/3B4/8/PPPPPPPP/RN1QKBNR/",true);
		assertMove("d4-e3",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/4B3/PPPPPPPP/RN1QKBNR/",false,false,false);

		//move ok, enemy on destination right down
		startGame("rnbqkbnr/1ppppppp/8/8/3B4/4p3/PPPPPPPP/RN1QKBNR/",true);
		assertMove("d4-e3",true,true);
		assertGameState("rnbqkbnr/1ppppppp/8/8/8/4B3/PPPPPPPP/RN1QKBNR/P",false,false,false);

		//move not ok own figure left
		startGame("rnbqkbnr/1ppppppp/8/8/3P4/4B3/RPPPPPPP/1N1QKBNR/",true);
		assertMove("e3-c5",true,false);
		assertGameState("rnbqkbnr/1ppppppp/8/8/3P4/4B3/RPPPPPPP/1N1QKBNR/",true,false,false);

		//move not ok own figure right
		startGame("rnbqkbnr/1ppppppp/8/8/5P2/4B3/RPPPPPPP/1N1QKBNR/",true);
		assertMove("e3-g5",true,false);
		assertGameState("rnbqkbnr/1ppppppp/8/8/5P2/4B3/RPPPPPPP/1N1QKBNR/",true,false,false);

	}

	@Test
	public void LaeuferBlackUpMoveTest() {

		//move ok left up
		startGame("rn1qkbnr/pppppppp/8/8/3b4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-b6",false,true);
		assertGameState("rn1qkbnr/pppppppp/1b6/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination left up
		startGame("rnbqk1nr/pppppppp/1P6/8/3b4/8/P1PPPPPP/RNBQKBNR/",false);
		assertMove("d4-b6",false,true);
		assertGameState("rnbqk1nr/pppppppp/1b6/8/8/8/P1PPPPPP/RNBQKBNR/p",true,false,false);

		//move ok right up
		startGame("rn1qkbnr/pppppppp/8/8/3b4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-f6",false,true);
		assertGameState("rn1qkbnr/pppppppp/5b2/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination right up
		startGame("rnbqk1nr/pppppppp/5P2/8/3b4/8/P1PPPPPP/RNBQKBNR/",false);
		assertMove("d4-f6",false,true);
		assertGameState("rnbqk1nr/pppppppp/5b2/8/8/8/P1PPPPPP/RNBQKBNR/p",true,false,false);

	}

	@Test
	public void LaeuferBlackDownMoveTest() {

		//move ok left down
		startGame("rn1qkbnr/pppppppp/8/8/3b4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-c3",false,true);
		assertGameState("rn1qkbnr/pppppppp/8/8/8/2b5/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination left down
		startGame("rnbqk1nr/pppppppp/8/8/3b4/2P5/P1PPPPPP/RNBQKBNR/",false);
		assertMove("d4-c3",false,true);
		assertGameState("rnbqk1nr/pppppppp/8/8/8/2b5/P1PPPPPP/RNBQKBNR/p",true,false,false);

		//move ok right down
		startGame("rn1qkbnr/pppppppp/8/8/3b4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-e3",false,true);
		assertGameState("rn1qkbnr/pppppppp/8/8/8/4b3/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination right down
		startGame("rnbqk1nr/pppppppp/8/8/3b4/4P3/P1PPPPPP/RNBQKBNR/",false);
		assertMove("d4-e3",false,true);
		assertGameState("rnbqk1nr/pppppppp/8/8/8/4b3/P1PPPPPP/RNBQKBNR/p",true,false,false);

		//move not ok own figure left
		startGame("rn1qkbnr/ppppp1pp/3b4/2p5/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d6-b4",false,false);
		assertGameState("rn1qkbnr/ppppp1pp/3b4/2p5/8/8/PPPPPPPP/RNBQKBNR/",false,false,false);

		//move not ok own figure right
		startGame("rn1qkbnr/ppppp1pp/3b4/4p3/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d6-e4",false,false);
		assertGameState("rn1qkbnr/ppppp1pp/3b4/4p3/8/8/PPPPPPPP/RNBQKBNR/",false,false,false);

	}

	@Test
	public void DameWhiteUpMoveTest() {

		//move ok up
		startGame("rnbqkbnr/pppppppp/8/8/3Q4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-d6",true,true);
		assertGameState("rnbqkbnr/pppppppp/3Q4/8/8/8/PPPPPPPP/RNB1KBNR/",false,false,false);

		//move ok, enemy on destination up
		startGame("rnbqkbnr/ppp1pppp/3p4/8/3Q4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-d6",true,true);
		assertGameState("rnbqkbnr/ppp1pppp/3Q4/8/8/8/PPPPPPPP/RNB1KBNR/P",false,false,false);

		//move ok down
		startGame("rnbqkbnr/pppppppp/3Q4/8/8/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d6-d4",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/3Q4/8/PPPPPPPP/RNB1KBNR/",false,false,false);

		//move ok, enemy on destination down
		startGame("rnbqkbnr/ppp1pppp/3Q4/8/3p4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d6-d4",true,true);
		assertGameState("rnbqkbnr/ppp1pppp/8/8/3Q4/8/PPPPPPPP/RNB1KBNR/P",false,false,false);

	}

	@Test
	public void DameWhiteSideMoveTest() {

		//move ok left
		startGame("rnbqkbnr/pppppppp/8/8/3Q4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-a4",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/Q7/8/PPPPPPPP/RNB1KBNR/",false,false,false);

		//move ok, enemy on destination left
		startGame("rnbqkbnr/ppp1pppp/8/8/1p1Q4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-b4",true,true);
		assertGameState("rnbqkbnr/ppp1pppp/8/8/1Q6/8/PPPPPPPP/RNB1KBNR/P",false,false,false);

		//move ok right
		startGame("rnbqkbnr/pppppppp/8/8/Q7/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("a4-d4",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/3Q4/8/PPPPPPPP/RNB1KBNR/",false,false,false);

		//move ok, enemy on destination right
		startGame("rnbqkbnr/ppp1pppp/8/8/Q2p4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("a4-d4",true,true);
		assertGameState("rnbqkbnr/ppp1pppp/8/8/3Q4/8/PPPPPPPP/RNB1KBNR/P",false,false,false);

	}

	@Test
	public void DameWhiteDiagonalMoveTest() {

		//move ok left up
		startGame("rnbqkbnr/pppppppp/8/8/3Q4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-b6",true,true);
		assertGameState("rnbqkbnr/pppppppp/1Q6/8/8/8/PPPPPPPP/RNB1KBNR/",false,false,false);

		//move ok, enemy on destination left up
		startGame("rnbqkbnr/p1pppppp/1p6/8/3Q4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-b6",true,true);
		assertGameState("rnbqkbnr/p1pppppp/1Q6/8/8/8/PPPPPPPP/RNB1KBNR/P",false,false,false);

		//move ok right up
		startGame("rnbqkbnr/pppppppp/8/8/3Q4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-f6",true,true);
		assertGameState("rnbqkbnr/pppppppp/5Q2/8/8/8/PPPPPPPP/RNB1KBNR/",false,false,false);

		//move ok, enemy on destination right up
		startGame("rnbqkbnr/ppppp1pp/5p2/8/3Q4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-f6",true,true);
		assertGameState("rnbqkbnr/ppppp1pp/5Q2/8/8/8/PPPPPPPP/RNB1KBNR/P",false,false,false);

		//move ok left down
		startGame("rnbqkbnr/pppppppp/8/8/3Q4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-c3",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/2Q5/PPPPPPPP/RNB1KBNR/",false,false,false);

		//move ok, enemy on destination left down
		startGame("rnbqkbnr/pp1ppppp/8/8/3Q4/2p5/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-c3",true,true);
		assertGameState("rnbqkbnr/pp1ppppp/8/8/8/2Q5/PPPPPPPP/RNB1KBNR/P",false,false,false);

		//move ok right down
		startGame("rnbqkbnr/pppppppp/8/8/3Q4/8/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-e3",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/4Q3/PPPPPPPP/RNB1KBNR/",false,false,false);

		//move ok, enemy on destination right down
		startGame("rnbqkbnr/pppp1ppp/8/8/3Q4/4p3/PPPPPPPP/RNB1KBNR/",true);
		assertMove("d4-e3",true,true);
		assertGameState("rnbqkbnr/pppp1ppp/8/8/8/4Q3/PPPPPPPP/RNB1KBNR/P",false,false,false);

	}

	@Test
	public void DameOwnFigureMoveTest() {

		//move not ok own figure up left
		startGame("rnbqkbnr/pppppppp/8/2P5/3Q4/8/PPPPP1PP/RNB1KBNR/",true);
		assertMove("d4-b6",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/2P5/3Q4/8/PPPPP1PP/RNB1KBNR/",true,false,false);

		//move not ok own figure up
		startGame("rnbqkbnr/pppppppp/8/3P4/3Q4/8/PPPPP1PP/RNB1KBNR/",true);
		assertMove("d4-d6",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/3P4/3Q4/8/PPPPP1PP/RNB1KBNR/",true,false,false);

		//move not ok own figure up right
		startGame("rnbqkbnr/pppppppp/8/4P3/3Q4/8/PPPPP1PP/RNB1KBNR/",true);
		assertMove("d4-f6",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/4P3/3Q4/8/PPPPP1PP/RNB1KBNR/",true,false,false);

		//move not ok own figure right
		startGame("rnbqkbnr/pppppppp/8/8/3QP3/8/PPPPP1PP/RNB1KBNR/",true);
		assertMove("d4-f4",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/3QP3/8/PPPPP1PP/RNB1KBNR/",true,false,false);

		//move not ok own figure down right
		startGame("rnbqkbnr/pppppppp/8/8/3Q4/4P3/PPPPP1PP/RNB1KBNR/",true);
		assertMove("d4-f2",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/3Q4/4P3/PPPPP1PP/RNB1KBNR/",true,false,false);

		//move not ok own figure down
		startGame("rnbqkbnr/pppppppp/8/8/3Q4/3P4/PPP1PPPP/RNB1KBNR/",true);
		assertMove("d4-d2",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/3Q4/3P4/PPP1PPPP/RNB1KBNR/",true,false,false);

		//move not ok own figure down left
		startGame("rnbqkbnr/pppppppp/8/8/4Q3/3P4/PP1PPPPP/RNB1KBNR/",true);
		assertMove("e4-b2",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/4Q3/3P4/PP1PPPPP/RNB1KBNR/",true,false,false);

		//move not ok own figure left
		startGame("rnbqkbnr/pppppppp/8/8/2PQ4/8/PP2PPPP/RNB1KBNR/",true);
		assertMove("d4-b4",true,false);
		assertGameState("rnbqkbnr/pppppppp/8/8/2PQ4/8/PP2PPPP/RNB1KBNR/",true,false,false);
	}

	@Test
	public void DameBlackUpMoveTest() {

		//move ok up
		startGame("rnb1kbnr/pppppppp/8/8/3q4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-d6",false,true);
		assertGameState("rnb1kbnr/pppppppp/3q4/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination up
		startGame("rnb1kbnr/pppppppp/3Q4/8/3q4/8/PPPPPPPP/RNB1KBNR/",false);
		assertMove("d4-d6",false,true);
		assertGameState("rnb1kbnr/pppppppp/3q4/8/8/8/PPPPPPPP/RNB1KBNR/q",true,false,false);

		//move ok down
		startGame("rnb1kbnr/pppppppp/3q4/8/8/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d6-d4",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/3q4/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination down
		startGame("rnb1kbnr/pppppppp/3q4/8/3Q4/8/PPPPPPPP/RNB1KBNR/",false);
		assertMove("d6-d4",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/3q4/8/PPPPPPPP/RNB1KBNR/q",true,false,false);

	}

	@Test
	public void DameBlackSideMoveTest() {

		//move ok left
		startGame("rnb1kbnr/pppppppp/8/8/3q4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-a4",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/q7/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination left
		startGame("rnb1kbnr/pppppppp/8/8/1Q1q4/8/PPPPPPPP/RNB1KBNR/",false);
		assertMove("d4-b4",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/1q6/8/PPPPPPPP/RNB1KBNR/q",true,false,false);

		//move ok right
		startGame("rnb1kbnr/pppppppp/8/8/q7/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("a4-d4",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/3q4/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination right
		startGame("rnb1kbnr/pppppppp/8/8/q2Q4/8/PPPPPPPP/RNB1KBNR/",false);
		assertMove("a4-d4",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/3q4/8/PPPPPPPP/RNB1KBNR/q",true,false,false);

	}

	@Test
	public void DameBlackDiagonalMoveTest() {

		//move ok left up
		startGame("rnb1kbnr/pppppppp/8/8/3q4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-b6",false,true);
		assertGameState("rnb1kbnr/pppppppp/1q6/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination left up
		startGame("rnb1kbnr/pppppppp/1Q6/8/3q4/8/PPPPPPPP/RNB1KBNR/",false);
		assertMove("d4-b6",false,true);
		assertGameState("rnb1kbnr/pppppppp/1q6/8/8/8/PPPPPPPP/RNB1KBNR/q",true,false,false);

		//move ok right up
		startGame("rnb1kbnr/pppppppp/8/8/3q4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-f6",false,true);
		assertGameState("rnb1kbnr/pppppppp/5q2/8/8/8/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination right up
		startGame("rnb1kbnr/pppppppp/5Q2/8/3q4/8/PPPPPPPP/RNB1KBNR/",false);
		assertMove("d4-f6",false,true);
		assertGameState("rnb1kbnr/pppppppp/5q2/8/8/8/PPPPPPPP/RNB1KBNR/q",true,false,false);

		//move ok left down
		startGame("rnb1kbnr/pppppppp/8/8/3q4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-c3",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/8/2q5/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination left down
		startGame("rnb1kbnr/pppppppp/8/8/3q4/2Q5/PPPPPPPP/RNB1KBNR/",false);
		assertMove("d4-c3",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/8/2q5/PPPPPPPP/RNB1KBNR/q",true,false,false);

		//move ok right down
		startGame("rnb1kbnr/pppppppp/8/8/3q4/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d4-e3",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/8/4q3/PPPPPPPP/RNBQKBNR/",true,false,false);

		//move ok, enemy on destination right down
		startGame("rnb1kbnr/pppppppp/8/8/3q4/4Q3/PPPPPPPP/RNB1KBNR/",false);
		assertMove("d4-e3",false,true);
		assertGameState("rnb1kbnr/pppppppp/8/8/8/4q3/PPPPPPPP/RNB1KBNR/q",true,false,false);
	}
	@Test
	public void DameBlackOwnFigureMoveTest() {

		//move not ok own figure left
		startGame("rnb1kbnr/pp5p/8/2pqp3/2ppp3/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d5-b5",false,false);
		assertGameState("rnb1kbnr/pp5p/8/2pqp3/2ppp3/8/PPPPPPPP/RNBQKBNR/",false,false,false);

		//move not ok own figure down left
		startGame("rnb1kbnr/pp5p/8/2pqp3/2ppp3/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d5-b3",false,false);
		assertGameState("rnb1kbnr/pp5p/8/2pqp3/2ppp3/8/PPPPPPPP/RNBQKBNR/",false,false,false);

		//move not ok own figure down
		startGame("rnb1kbnr/pp5p/8/2pqp3/2ppp3/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d5-d3",false,false);
		assertGameState("rnb1kbnr/pp5p/8/2pqp3/2ppp3/8/PPPPPPPP/RNBQKBNR/",false,false,false);

		//move not ok own figure down right
		startGame("rnb1kbnr/pp5p/8/2pqp3/2ppp3/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d5-f3",false,false);
		assertGameState("rnb1kbnr/pp5p/8/2pqp3/2ppp3/8/PPPPPPPP/RNBQKBNR/",false,false,false);

		//move not ok own figure right
		startGame("rnb1kbnr/pp5p/8/2pqp3/2ppp3/8/PPPPPPPP/RNBQKBNR/",false);
		assertMove("d5-f5",false,false);
		assertGameState("rnb1kbnr/pp5p/8/2pqp3/2ppp3/8/PPPPPPPP/RNBQKBNR/",false,false,false);
	}

	@Test
	public void SpringerMoveOkTest() {

		//move ok left up 1
		startGame("rnbqkbnr/pppppppp/8/8/3N4/2P1P3/PP1P1PPP/RNBQKB1R/",true);
		assertMove("d4-b5",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/1N6/8/2P1P3/PP1P1PPP/RNBQKB1R/",false,false,false);

		//move ok left up 2
		startGame("rnbqkbnr/pppppppp/8/8/3N4/2P1P3/PP1P1PPP/RNBQKB1R/",true);
		assertMove("d4-c6",true,true);
		assertGameState("rnbqkbnr/pppppppp/2N5/8/8/2P1P3/PP1P1PPP/RNBQKB1R/",false,false,false);

		//move ok right up 1
		startGame("rnbqkbnr/pppppppp/8/8/3N4/2P1P3/PP1P1PPP/RNBQKB1R/",true);
		assertMove("d4-e6",true,true);
		assertGameState("rnbqkbnr/pppppppp/4N3/8/8/2P1P3/PP1P1PPP/RNBQKB1R/",false,false,false);

		//move ok right up 2
		startGame("rnbqkbnr/pppppppp/8/8/3N4/2P1P3/PP1P1PPP/RNBQKB1R/",true);
		assertMove("d4-f5",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/5N2/8/2P1P3/PP1P1PPP/RNBQKB1R/",false,false,false);

		//move ok right down 1
		startGame("rnbqkbnr/pppppppp/8/8/3N4/2P1P3/PP1P1PPP/RNBQKB1R/",true);
		assertMove("d4-f3",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/2P1PN2/PP1P1PPP/RNBQKB1R/",false,false,false);

		//move ok right down 2
		startGame("rnbqkbnr/pppppppp/8/8/3N4/2P1P3/PP1P1PPP/RNBQKB1R/",true);
		assertMove("d4-e2",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/2P1P3/PP1PNPPP/RNBQKB1R/",false,false,false);

		//move ok left down 1
		startGame("rnbqkbnr/pppppppp/8/8/3N4/2P1P3/PP1P1PPP/RNBQKB1R/",true);
		assertMove("d4-c2",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/2P1P3/PPNP1PPP/RNBQKB1R/",false,false,false);

		//move ok left down 2
		startGame("rnbqkbnr/pppppppp/8/8/3N4/2P1P3/PP1P1PPP/RNBQKB1R/",true);
		assertMove("d4-b3",true,true);
		assertGameState("rnbqkbnr/pppppppp/8/8/8/1NP1P3/PP1P1PPP/RNBQKB1R/",false,false,false);
	}

	@Test
	public void SpringerEnemyOkTest() {

		//move ok left up 1
		startGame("rnbqkbnr/8/2p1p3/1p3p2/3N4/1pP1Pp2/PPpPpPPP/RNBQKB1R/",true);
		assertMove("d4-b5",true,true);
		assertGameState("rnbqkbnr/8/2p1p3/1N3p2/8/1pP1Pp2/PPpPpPPP/RNBQKB1R/P",false,false,false);

		//move ok left up 2
		startGame("rnbqkbnr/8/2p1p3/1p3p2/3N4/1pP1Pp2/PPpPpPPP/RNBQKB1R/",true);
		assertMove("d4-c6",true,true);
		assertGameState("rnbqkbnr/8/2N1p3/1p3p2/8/1pP1Pp2/PPpPpPPP/RNBQKB1R/P",false,false,false);

		//move ok right up 1
		startGame("rnbqkbnr/8/2p1p3/1p3p2/3N4/1pP1Pp2/PPpPpPPP/RNBQKB1R/",true);
		assertMove("d4-e6",true,true);
		assertGameState("rnbqkbnr/8/2p1N3/1p3p2/8/1pP1Pp2/PPpPpPPP/RNBQKB1R/P",false,false,false);

		//move ok right up 2
		startGame("rnbqkbnr/8/2p1p3/1p3p2/3N4/1pP1Pp2/PPpPpPPP/RNBQKB1R/",true);
		assertMove("d4-f5",true,true);
		assertGameState("rnbqkbnr/8/2p1p3/1p3N2/8/1pP1Pp2/PPpPpPPP/RNBQKB1R/P",false,false,false);

		//move ok right down 1
		startGame("rnbqkbnr/8/2p1p3/1p3p2/3N4/1pP1Pp2/PPpPpPPP/RNBQKB1R/",true);
		assertMove("d4-f3",true,true);
		assertGameState("rnbqkbnr/8/2p1p3/1p3p2/8/1pP1PN2/PPpPpPPP/RNBQKB1R/P",false,false,false);

		//move ok right down 2
		startGame("rnbqkbnr/8/2p1p3/1p3p2/3N4/1pP1Pp2/PPpPpPPP/RNBQKB1R/",true);
		assertMove("d4-e2",true,true);
		assertGameState("rnbqkbnr/8/2p1p3/1p3p2/8/1pP1Pp2/PPpPNPPP/RNBQKB1R/P",false,false,false);

		//move ok left down 1
		startGame("rnbqkbnr/8/2p1p3/1p3p2/3N4/1pP1Pp2/PPpPpPPP/RNBQKB1R/",true);
		assertMove("d4-c2",true,true);
		assertGameState("rnbqkbnr/8/2p1p3/1p3p2/8/1pP1Pp2/PPNPpPPP/RNBQKB1R/P",false,false,false);

		//move ok left down 2
		startGame("rnbqkbnr/8/2p1p3/1p3p2/3N4/1pP1Pp2/PPpPpPPP/RNBQKB1R/",true);
		assertMove("d4-b3",true,true);
		assertGameState("rnbqkbnr/8/2p1p3/1p3p2/8/1NP1Pp2/PPpPpPPP/RNBQKB1R/P",false,false,false);

	}
}
