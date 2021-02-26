package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.io.Serializable;
import java.util.ArrayList;

public class Koenig extends Figur implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1696824277998864653L;
	private ArrayList<String> validmove;
	public Koenig(String player)
	{
		super(player);
		this.validmove = new ArrayList<String>();
	}
	
	
	
	private ArrayList<String> moveUp(char[][] board, int x, int y)
	{
		ArrayList<String> temparray= new ArrayList<String>();
		
			String move=this.generateString(x-1,y+1);
			temparray.add(move);
			move=this.generateString(x-1,y);
			temparray.add(move);
			move=this.generateString(x-1,y-1);
			temparray.add(move);
			
		return temparray; 
	}
	private ArrayList<String> moveDown(char[][] board, int x, int y)
	{
		ArrayList<String> temparray= new ArrayList<String>();
		String move=this.generateString(x+1,y+1);
		temparray.add(move);
		move=this.generateString(x+1,y-1);
		temparray.add(move);
		move=this.generateString(x+1,y);
		temparray.add(move);
		return temparray; 
	}
	private ArrayList<String> moveLeft(char[][] board, int x, int y)
	{
		ArrayList<String> temparray= new ArrayList<String>();
		String move=this.generateString(x+1,y-1);
		temparray.add(move);
		move=this.generateString(x-1,y-1);
		temparray.add(move);
		move=this.generateString(x,y-1);
		temparray.add(move);
		return temparray; 
	}
	private ArrayList<String> moveRight(char[][] board, int x, int y)
	{
		ArrayList<String> temparray= new ArrayList<String>();
		String move=this.generateString(x+1,y+1);
		temparray.add(move);
		move=this.generateString(x,y+1);
		temparray.add(move);
		move=this.generateString(x-1,y+1);
		temparray.add(move);
		return temparray; 
	}
	
	public ArrayList<String> validMoves(char[][] board, int x, int y) 
	{
		this.validmove.addAll(moveUp(board,x,y));
		this.validmove.addAll(moveDown(board,x,y));
		this.validmove.addAll(moveRight(board,x,y));
		this.validmove.addAll(moveLeft(board,x,y));
		this.validmove=this.sortMoves(board,validmove);
		return this.validmove;
	}
	
	/*
	public ArrayList<String> validMoves(char[][] board, int x, int y)
	{
		this.validmove.clear();

		if (this.getPlayer()=="w"){

			checkInFieldFree(board, x, y);

			checkInFieldEnemy(board, x, y);

			if(y==0){checkLBorderFree(board, x, y);}
			if(y==7){checkRBorderFree(board, x, y);}

			if(y==0) {checkLBorderEnemy(board, x, y);}
			if(y==7){checkRBorderEnemy(board, x, y);}

			return this.validmove;

		}else{ // player black

			checkInFieldBFree(board, x, y);

			checkInFieldBEnemy(board, x, y);

			if(y==0){checkLBorderBFree(board, x, y);}
			if(y==7){checkRBorderBFree(board, x, y);}

			if(y==0) {checkLBorderBEnemy(board, x, y);}
			if(y==7){checkRBorderBEnemy(board, x, y);}

			return this.validmove;
		}
	}

	public void checkInFieldFree(char[][] board, int x, int y) {

		if(board[x-1][y]=='\0'){
			String move = this.generateString(x-1, y);
			this.validmove.add(move);}

		if(board[x+1][y]=='\0'){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(board[x][y-1]=='\0'){
			String move = this.generateString(x, y-1);
			this.validmove.add(move);}

		if(board[x][y+1]=='\0'){
			String move = this.generateString(x, y+1);
			this.validmove.add(move);}

		if(board[x-1][y-1]=='\0'){
			String move = this.generateString(x-1, y-1);
			this.validmove.add(move);}

		if(board[x-1][y+1]=='\0'){
			String move = this.generateString(x-1, y+1);
			this.validmove.add(move);}

		if(board[x+1][y+1]=='\0'){
			String move = this.generateString(x+1, y+1);
			this.validmove.add(move);}

		if(board[x+1][y-1]=='\0'){
			String move = this.generateString(x+1, y-1);
			this.validmove.add(move);}
	}

	public void checkInFieldEnemy(char[][] board, int x, int y) {

		if(Character.isLowerCase(board[x-1][y])){
			String move = this.generateString(x-1, y);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x+1][y])){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x][y-1])){
			String move = this.generateString(x, y-1);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x][y+1])){
			String move = this.generateString(x, y+1);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x-1][y-1])){
			String move = this.generateString(x-1, y-1);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x-1][y+1])){
			String move = this.generateString(x-1, y+1);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x+1][y+1])){
			String move = this.generateString(x+1, y+1);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x+1][y-1])) {
			String move = this.generateString(x + 1, y - 1);
			this.validmove.add(move);}
	}

	public void checkLBorderFree(char[][] board, int x, int y) {

		//moegliche freie Felder
		if(board[x-1][y]=='\0'){
			String move = this.generateString(x-1, y);
			this.validmove.add(move);}

		if(board[x+1][y]=='\0'){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(board[x][y+1]=='\0'){
			String move = this.generateString(x, y+1);
			this.validmove.add(move);}

		if(board[x-1][y+1]=='\0'){
			String move = this.generateString(x-1, y+1);
			this.validmove.add(move);}

		if(board[x+1][y+1]=='\0'){
			String move = this.generateString(x+1, y+1);
			this.validmove.add(move);}
	}

	public void checkRBorderFree(char[][] board, int x, int y) {

		//moegliche freie Felder
		if(board[x-1][y]=='\0'){
			String move = this.generateString(x-1, y);
			this.validmove.add(move);}

		if(board[x+1][y]=='\0'){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(board[x][y-1]=='\0'){
			String move = this.generateString(x, y-1);
			this.validmove.add(move);}

		if(board[x-1][y-1]=='\0'){
			String move = this.generateString(x-1, y-1);
			this.validmove.add(move);}

		if(board[x+1][y-1]=='\0'){
			String move = this.generateString(x+1, y-1);
			this.validmove.add(move);}
	}


	public void checkLBorderEnemy(char[][] board, int x, int y) {

		//Moeglichkeiten zu schlagen
		if(Character.isLowerCase(board[x-1][y])){
			String move = this.generateString(x - 1, y);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x+1][y])){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x][y+1])){
			String move = this.generateString(x, y+1);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x-1][y+1])){
			String move = this.generateString(x-1, y+1);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x+1][y+1])){
			String move = this.generateString(x+1, y+1);
			this.validmove.add(move);}
	}

	public void checkRBorderEnemy(char[][] board, int x, int y) {

		//Moeglichkeiten zu schlagen
		if(Character.isLowerCase(board[x-1][y])){
			String move = this.generateString(x-1, y);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x+1][y])){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x][y-1])){
			String move = this.generateString(x, y-1);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x-1][y-1])){
			String move = this.generateString(x-1, y-1);
			this.validmove.add(move);}

		if(Character.isLowerCase(board[x+1][y-1])){
			String move = this.generateString(x+1, y-1);
			this.validmove.add(move);}
	}

	public void checkInFieldBFree(char[][] board, int x, int y) {

		//moegliche freie Felder
		if(board[x-1][y]=='\0'){
			String move = this.generateString(x-1, y);
			this.validmove.add(move);}

		if(board[x+1][y]=='\0'){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(board[x][y-1]=='\0'){
			String move = this.generateString(x, y-1);
			this.validmove.add(move);}

		if(board[x][y+1]=='\0'){
			String move = this.generateString(x, y+1);
			this.validmove.add(move);}

		if(board[x-1][y-1]=='\0'){
			String move = this.generateString(x-1, y-1);
			this.validmove.add(move);}

		if(board[x-1][y+1]=='\0'){
			String move = this.generateString(x-1, y+1);
			this.validmove.add(move);}

		if(board[x+1][y+1]=='\0'){
			String move = this.generateString(x+1, y+1);
			this.validmove.add(move);}

		if(board[x+1][y-1]=='\0'){
			String move = this.generateString(x+1, y-1);
			this.validmove.add(move);}
	}

	public void checkInFieldBEnemy(char[][] board, int x, int y) {

		//Moeglichkeiten zu schlagen
		if(Character.isUpperCase(board[x-1][y])){
			String move = this.generateString(x-1, y);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x+1][y])){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x][y-1])){
			String move = this.generateString(x, y-1);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x][y+1])){
			String move = this.generateString(x, y+1);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x-1][y-1])){
			String move = this.generateString(x-1, y-1);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x-1][y+1])){
			String move = this.generateString(x-1, y+1);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x+1][y+1])){
			String move = this.generateString(x+1, y+1);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x+1][y-1])){
			String move = this.generateString(x+1, y-1);
			this.validmove.add(move);}
	}

	public void checkLBorderBFree(char[][] board, int x, int y) {

		//moegliche freie Felder
		if(board[x-1][y]=='\0'){
			String move = this.generateString(x-1, y);
			this.validmove.add(move);}

		if(board[x+1][y]=='\0'){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(board[x][y+1]=='\0'){
			String move = this.generateString(x, y+1);
			this.validmove.add(move);}

		if(board[x-1][y+1]=='\0'){
			String move = this.generateString(x-1, y+1);
			this.validmove.add(move);}

		if(board[x+1][y+1]=='\0'){
			String move = this.generateString(x+1, y+1);
			this.validmove.add(move);}
	}

	public void checkRBorderBFree(char[][] board, int x, int y) {

		//moegliche freie Felder
		if(board[x-1][y]=='\0'){
			String move = this.generateString(x-1, y);
			this.validmove.add(move);}

		if(board[x+1][y]=='\0'){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(board[x][y-1]=='\0'){
			String move = this.generateString(x, y-1);
			this.validmove.add(move);}

		if(board[x-1][y-1]=='\0'){
			String move = this.generateString(x-1, y-1);
			this.validmove.add(move);}

		if(board[x+1][y-1]=='\0'){
			String move = this.generateString(x+1, y-1);
			this.validmove.add(move);}
	}

	public void checkLBorderBEnemy(char[][] board, int x, int y) {

		//Moeglichkeiten zu schlagen
		if(Character.isUpperCase(board[x-1][y])){
			String move = this.generateString(x - 1, y);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x+1][y])){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x][y+1])){
			String move = this.generateString(x, y+1);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x-1][y+1])){
			String move = this.generateString(x-1, y+1);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x+1][y+1])){
			String move = this.generateString(x+1, y+1);
			this.validmove.add(move);}
	}

	public void checkRBorderBEnemy(char[][] board, int x, int y) {

		//Moeglichkeiten zu schlagen
		if(Character.isUpperCase(board[x-1][y])){
			String move = this.generateString(x-1, y);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x+1][y])){
			String move = this.generateString(x+1, y);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x][y-1])){
			String move = this.generateString(x, y-1);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x-1][y-1])){
			String move = this.generateString(x-1, y-1);
			this.validmove.add(move);}

		if(Character.isUpperCase(board[x+1][y-1])){
			String move = this.generateString(x+1, y-1);
			this.validmove.add(move);}
	}
	*/
}

