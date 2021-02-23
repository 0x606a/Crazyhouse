package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.ArrayList;

public class Springer extends Figur
{
	private ArrayList<String> validmove;
	
	public Springer(String player)
	{
		super(player);
		this.validmove = new ArrayList<String>();
	}
	public ArrayList<String> getValidmove(){return validmove;}
	
	private ArrayList<String> moveUp(char[][] board, int x, int y)
	{
		ArrayList<String> temparray= new ArrayList<String>();
		try {
			String move=this.generateString(x-2,y+1);
			temparray.add(move);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			String move=this.generateString(x-2,y-1);
			temparray.add(move);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return temparray; 
	}
	private ArrayList<String> moveDown(char[][] board, int x, int y)
	{
		ArrayList<String> temparray= new ArrayList<String>();
		try {
			String move=this.generateString(x+2,y+1);
			temparray.add(move);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			String move=this.generateString(x+2,y-1);
			temparray.add(move);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return temparray; 
	}
	private ArrayList<String> moveLeft(char[][] board, int x, int y)
	{
		ArrayList<String> temparray= new ArrayList<String>();
		try {
			String move=this.generateString(x+1,y-2);
			temparray.add(move);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			String move=this.generateString(x-1,y-2);
			temparray.add(move);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return temparray; 
	}
	private ArrayList<String> moveRight(char[][] board, int x, int y)
	{
		ArrayList<String> temparray= new ArrayList<String>();
		try {
			String move=this.generateString(x+2,y+1);
			temparray.add(move);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			String move=this.generateString(x+2,y-1);
			temparray.add(move);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return temparray; 
	}
	
	public ArrayList<String> validMoves(char[][] board, int x, int y) throws Exception 
	{
		this.validmove.addAll(moveUp(board,x,y));
		this.validmove.addAll(moveDown(board,x,y));
		this.validmove.addAll(moveRight(board,x,y));
		this.validmove.addAll(moveLeft(board,x,y));
		return this.validmove;
	}
	
	/*public ArrayList<String> validMoves(char[][] board, int x, int y) throws Exception 
	{
		this.validmove.clear();
		
	
		
		if ( this.getPlayer()=="w"){
			
			if(y>1 && y<6){ //ohne Rand
				
				//moegliche freie Felder 
				
				if(board[x-2][y+1]=='\0'){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(board[x-1][y+2]=='\0'){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(board[x+1][y+2]=='\0'){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(board[x+2][y+1]=='\0'){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				if(board[x+2][y-1]=='\0'){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(board[x+1][y-2]=='\0'){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(board[x-1][y-2]=='\0'){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(board[x-2][y-1]=='\0'){
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				
				//Moeglichkeiten zu schlagen
				
				if(Character.isLowerCase(board[x-2][y+1])){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-1][y+2])){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+1][y+2])){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+2][y+1])){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+2][y-1])){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+1][y-2])){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-1][y-2])){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-2][y-1])) {
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				
			}if(y==0) { // linker Rand
					
				//moegliche freie Felder
				
				if(board[x-2][y+1]=='\0'){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(board[x-1][y+2]=='\0'){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(board[x+1][y+2]=='\0'){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(board[x+2][y+1]=='\0'){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				
				//Moeglichkeiten zu schlagen
				
				if(Character.isLowerCase(board[x-2][y+1])){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-1][y+2])){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+1][y+2])){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+2][y+1])){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}					
			}if(y==1){ //linker zweiter Rand
				
				//moegliche freie Felder
				
				if(board[x-2][y+1]=='\0'){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(board[x-1][y+2]=='\0'){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(board[x+1][y+2]=='\0'){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(board[x+2][y+1]=='\0'){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				if(board[x+2][y-1]=='\0'){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(board[x-2][y-1]=='\0'){
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				
				//Moeglichkeiten zu schlagen
				
				if(Character.isLowerCase(board[x-2][y+1])){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-1][y+2])){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+1][y+2])){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+2][y+1])){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+2][y-1])){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-2][y-1])) {
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
			
			}if(y==7){ // rechter Rand
					
				//moegliche freie Felder
				
				if(board[x+2][y-1]=='\0'){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(board[x+1][y-2]=='\0'){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(board[x-1][y-2]=='\0'){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(board[x-2][y-1]=='\0'){
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				
				//Moeglichkeiten zu schlagen
				
				if(Character.isLowerCase(board[x+2][y-1])){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+1][y-2])){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-1][y-2])){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-2][y-1])) {
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				
			}if(y==6) { //zweiter linker Rand
				
				//moegliche freie Felder
				
				if(board[x-2][y-1]=='\0'){
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				if(board[x-1][y-2]=='\0'){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(board[x-1][y-2]=='\0'){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(board[x-2][y-1]=='\0'){
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				if(board[x-2][y+1]=='\0'){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(board[x-2][y+1]=='\0'){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				
				//Moeglichkeiten zu schlagen
				
				if(Character.isLowerCase(board[x+2][y-1])){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+1][y-2])){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-1][y-2])){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-2][y-1])) {
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x-2][y+1])){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(Character.isLowerCase(board[x+2][y+1])){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
			}
		}else{  // black player
			
			if(y>1 && y<6){ //ohne Rand
				
				//moegliche freie Felder
				
				if(board[x-2][y+1]=='\0'){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(board[x-1][y+2]=='\0'){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(board[x+1][y+2]=='\0'){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(board[x+2][y+1]=='\0'){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				if(board[x+2][y-1]=='\0'){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(board[x+1][y-2]=='\0'){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(board[x-1][y-2]=='\0'){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(board[x-2][y-1]=='\0'){
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				
				//Moeglichkeiten zu schlagen
				
				if(Character.isUpperCase(board[x-2][y+1])){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-1][y+2])){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+1][y+2])){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+2][y+1])){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+2][y-1])){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+1][y-2])){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-1][y-2])){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-2][y-1])) {
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				
			}if(y==0) { // linker Rand
					
				//moegliche freie Felder
				
				if(board[x-2][y+1]=='\0'){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(board[x-1][y+2]=='\0'){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(board[x+1][y+2]=='\0'){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(board[x+2][y+1]=='\0'){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				
				//Moeglichkeiten zu schlagen
				
				if(Character.isUpperCase(board[x-2][y+1])){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-1][y+2])){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+1][y+2])){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+2][y+1])){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}					
			}if(y==1){ //linker zweiter Rand
				
				//moegliche freie Felder
				
				if(board[x-2][y+1]=='\0'){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(board[x-1][y+2]=='\0'){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(board[x+1][y+2]=='\0'){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(board[x+2][y+1]=='\0'){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				if(board[x+2][y-1]=='\0'){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(board[x-2][y-1]=='\0'){
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				
				//Moeglichkeiten zu schlagen
				
				if(Character.isUpperCase(board[x-2][y+1])){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-1][y+2])){
					String move = this.generateString(x-1, y+2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+1][y+2])){
					String move = this.generateString(x+1, y+2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+2][y+1])){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+2][y-1])){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-2][y-1])) {
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
			
			}if(y==7){ // rechter Rand
					
				//moegliche freie Felder
				
				if(board[x+2][y-1]=='\0'){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(board[x+1][y-2]=='\0'){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(board[x-1][y-2]=='\0'){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(board[x-2][y-1]=='\0'){
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				
				//Moeglichkeiten zu schlagen
				
				if(Character.isUpperCase(board[x+2][y-1])){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+1][y-2])){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-1][y-2])){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-2][y-1])) {
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				
			}if(y==6) { //zweiter linker Rand
				
				//moegliche freie Felder
				
				if(board[x+2][y-1]=='\0'){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(board[x+1][y-2]=='\0'){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(board[x-1][y-2]=='\0'){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(board[x-2][y-1]=='\0'){
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				if(board[x-2][y+1]=='\0'){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(board[x+2][y+1]=='\0'){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
				
				//Moeglichkeiten zu schlagen
				
				if(Character.isUpperCase(board[x+2][y-1])){
					String move = this.generateString(x+2, y-1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+1][y-2])){
					String move = this.generateString(x+1, y-2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-1][y-2])){
					String move = this.generateString(x-1, y-2);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-2][y-1])) {
					String move = this.generateString(x-2, y-1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x-2][y+1])){
					String move = this.generateString(x-2, y+1);
					this.validmove.add(move);
				}
				if(Character.isUpperCase(board[x+2][y+1])){
					String move = this.generateString(x+2, y+1);
					this.validmove.add(move);
				}
			}
		}
		return validmove;
	}	*/	
}

