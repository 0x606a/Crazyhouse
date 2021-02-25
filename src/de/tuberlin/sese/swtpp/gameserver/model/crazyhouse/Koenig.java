package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.ArrayList;

public class Koenig extends Figur
{
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
}