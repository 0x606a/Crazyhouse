
package src.de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;
import java.io.Serializable;

import de.tuberlin.sese.swtpp.gameserver.model.Game;
import de.tuberlin.sese.swtpp.gameserver.model.Move;
import de.tuberlin.sese.swtpp.gameserver.model.Player;

public class CrazyhouseGame extends Game implements Serializable{

	private static final long serialVersionUID = 5424778147226994452L;

	/************************
	 * member
	 ***********************/

	// just for better comprehensibility of the code: assign white and black player
	private Player blackPlayer;
	private Player whitePlayer;

	// internal representation of the game state
	//private String board = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/";
	private String board = "////////";
	
	/************************
	 * constructors
	 ***********************/

	public CrazyhouseGame() {
		super();
	//this.board="rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR/";
		board="rnbq1bnr/6pp/2ppp3/2pkp3/2p5/4P3/PPPP1PPP/RNBQKBNR/";	//bauer schlagen
		 

		// TODO: initialize internal model if necessary 
	}

	public String getType() {
		return "crazyhouse";
	}

	/*******************************************
	 * Game class functions already implemented
	 ******************************************/

	@Override
	public boolean addPlayer(Player player) {
		if (!started) {
			players.add(player);

			// game starts with two players
			if (players.size() == 2) {
				started = true;
				this.whitePlayer = players.get(0);
				this.blackPlayer= players.get(1);
				nextPlayer = whitePlayer;
			}
			return true;
		}

		return false;
	}

	@Override
	public String getStatus() {
		if (error)
			return "Error";
		if (!started)
			return "Wait";
		if (!finished)
			return "Started";
		if (surrendered)
			return "Surrendered";
		if (draw)
			return "Draw";

		return "Finished";
	}

	@Override
	public String gameInfo() {
		String gameInfo = "";

		if (started) {
			if (blackGaveUp())
				gameInfo = "black gave up";
			else if (whiteGaveUp())
				gameInfo = "white gave up";
			else if (didWhiteDraw() && !didBlackDraw())
				gameInfo = "white called draw";
			else if (!didWhiteDraw() && didBlackDraw())
				gameInfo = "black called draw";
			else if (draw)
				gameInfo = "draw game";
			else if (finished)
				gameInfo = blackPlayer.isWinner() ? "black won" : "white won";
		}

		return gameInfo;
	}

	@Override
	public String nextPlayerString() {
		return isWhiteNext() ? "w" : "b";
	}

	@Override
	public int getMinPlayers() {
		return 2;
	}

	@Override
	public int getMaxPlayers() {
		return 2;
	}

	@Override
	public boolean callDraw(Player player) {

		// save to status: player wants to call draw
		if (this.started && !this.finished) {
			player.requestDraw();
		} else {
			return false;
		}

		// if both agreed on draw:
		// game is over
		if (players.stream().allMatch(Player::requestedDraw)) {
			this.draw = true;
			finish();
		}
		return true;
	}

	@Override
	public boolean giveUp(Player player) {
		if (started && !finished) {
			if (this.whitePlayer == player) {
				whitePlayer.surrender();
				blackPlayer.setWinner();
			}
			if (this.blackPlayer == player) {
				blackPlayer.surrender();
				whitePlayer.setWinner();
			}
			surrendered = true;
			finish();

			return true;
		}

		return false;
	}

	/* ******************************************
	 * Helpful stuff
	 ***************************************** */

	/**
	 *
	 * @return True if it's white player's turn
	 */
	public boolean isWhiteNext() {
		return nextPlayer == whitePlayer;
	}

	/**
	 * Ends game after regular move (save winner, finish up game state,
	 * histories...)
	 *
	 * @param winner player who won the game
	 * @return true if game was indeed finished
	 */
	public boolean regularGameEnd(Player winner) {
		// public for tests
		if (finish()) {
			winner.setWinner();
			winner.getUser().updateStatistics();
			return true;
		}
		return false;
	}

	public boolean didWhiteDraw() {
		return whitePlayer.requestedDraw();
	}

	public boolean didBlackDraw() {
		return blackPlayer.requestedDraw();
	}

	public boolean whiteGaveUp() {
		return whitePlayer.surrendered();
	}

	public boolean blackGaveUp() {
		return blackPlayer.surrendered();
	}

	/*******************************************
	 * !!!!!!!!! To be implemented !!!!!!!!!!!!
	 ******************************************/

	@Override
	public void setBoard(String state) {
		// Note: This method is for automatic testing. A regular game would not start at some artificial state.
		//       It can be assumed that the state supplied is a regular board that can be reached during a game.
		board=state;
		//Board newBoard=new Board(state);
	}

	@Override
	public String getBoard() {

		return board;
	}

	@Override
	public boolean tryMove(String moveString, Player player){

		if(player!=nextPlayer ||!checkString(moveString))return false;// �bergibt newBoard objekt den String. bekommt als Antwort 
		Board newBoard=new Board(board);
		Move move = new Move(moveString,newBoard.BoardToString(),player); // erzeuge aus dem String einen Move
		String farbe=this.nextPlayerString();
		boolean validMove = false;
		if(farbe=="w") {
				validMove=newBoard.checkMove(moveString, farbe);
				gameWon(farbe,newBoard);
				this.nextPlayer=blackPlayer;/* checke den Move auf g�ltigkeit*/
		}else{
				validMove=newBoard.checkMove(moveString, farbe);
				gameWon(farbe,newBoard);
				this.nextPlayer=whitePlayer;
		}
		if(validMove) {												// wenn Move g�ltig
			this.history.add(move);									// f�ge den Move zur History hinzu
			this.setNextPlayer(nextPlayer);
		}else{this.setNextPlayer(player);}
		
		this.board=newBoard.BoardToString();
		System.out.println(this.getBoard());
		return validMove;
	}

	// replace with real implementation
	private void gameWon(String player,Board board)
	{
			boolean var=board.Check(player, true);
			if(var) 
			{
				if(player=="w")blackPlayer.setWinner();
				else whitePlayer.setWinner();
				
				this.finished=true;
			}
			
		
	}
	public boolean checkString(String moveString) 
	{
		int a=(int)moveString.charAt(0);
		int b=(int)moveString.charAt(1);
		int c=(int)moveString.charAt(2);
		int d=(int)moveString.charAt(3);
		if(moveString.length()==5) {
			
			int e=(int)moveString.charAt(4);
			if(a >= 97&& a<= 104  && b >= 49&& b <=56 &&d >= 97&& d<= 104  && e >= 49&& e <=56){return true;}// wenn String gleich Zug auf den Board 
			
		}
		else {
			if(((a==75||a==107||a==113||a==81||a==98||a==66||a==110||a==78|| a==82||a==114||a==80||a==112)&&b==45) &&c >= 97&& c<= 104  && d >= 49&& d <=56) {return true;}	
		}

		return false;
	}
}
