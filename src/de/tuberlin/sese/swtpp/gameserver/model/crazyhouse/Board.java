package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.ArrayList;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Pferd;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Bauer;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Dame;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Koenig;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Laeufer;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Turm;

public class Board{
    char [][] board;
    String Spare_parts;

// constructor creates 8x8 matrix with Matrix [y][x] and Spare_parts String
    public Board(String b){
        char [][] board= new char[8][8];
        int cnt= b.length();
        int j = 0;
        int i= 0;
        while ( i<8){
            while (j<8){
                char temp= b.charAt(b.length()-cnt);
                if(temp=='/'){
                    i++;
                    break;
                }
                if((int) temp>48 && (int) temp <58){
                    int cur = (int) temp -48;
                    if(j+cur>7){
                        i++;
                        j= cur-(7-j);
                        cnt --;
                    }
                    else {
                        j+=cur;
                        cnt--;
                    }
                }
                else{
                    board[i][j] = temp;
                    cnt --;
                    j++;
                }
            }
        }
        Spare_parts = new String();
        for(i=b.length()-cnt; i< b.length(); i++){
            Spare_parts += b.charAt(i);
        }

    }
    //checks if move is valid; if yes: does move, if no: throws runtimeexception
    public void checkMove(String move, String player) throws Exception {
    	char figure;
    	char [][] dest = board.clone();
    	//figur aus spare parts string
    	if(move.length()==4) {
    		figure= move.charAt(0);
    		if(player=="b" & ((int) figure)<97) throw new Exception("not your token");
    		if(player=="w" & ((int) figure)>90) throw new Exception("not your token");
    		int dest_x = (((int) move.charAt(2))-97);
        	int dest_y = (((int) move.charAt(3))-49);
        	if(dest[dest_y][dest_x]!='0') throw new Exception("invalid move!");
        	dest = board.clone();
        	dest [dest_y][dest_x] = figure;
        	try {
        		takeSpare_part(figure);
        	} catch(Exception e) {
        		throw new Exception("invalid move");
        	}
    		
        	board=dest;
        	}
    	
    	//figur aus feld
    	else {
    		int x = ((int) move.charAt(0))-97;
    		int y = 7-(((int) move.charAt(1))-49);
    		figure = board[y][x];
    		if(figure=='0') throw new Exception("no token chosen");
    		if(player=="b" & ((int) figure)<97) throw new Exception("not your token");
    		if(player=="w" & ((int) figure)>90) throw new Exception("not your token");
    		
    		
    		ArrayList<String> val_moves= new ArrayList<>();
    		
    		//figur aufrufen(player übergeben als String)
    		if(figure=='k' || figure=='K') {
    			Koenig k = new Koenig(player);
    			val_moves= k.validMoves(board, y, x);
    		}
    		if(figure=='q' || figure=='Q') {
    			Dame d = new Dame(player);
    			val_moves= d.validMoves(board, y, x);
    		}
    		
    		if(figure=='B' || figure=='b') {
    			Laeufer l= new Laeufer(player);
    			val_moves = l.validMoves(board, y, x);
    		}
    		if(figure=='n' || figure=='N') {
    			Pferd p = new Pferd(player);
    			val_moves = p.validMoves(board, y, x);
    		}
    		if(figure=='r' || figure=='R') {
    			Turm t = new Turm(player);
    			val_moves = t.validMoves(board, y, x);
    		}
    		if(figure=='p' || figure=='P') {
    			Bauer b = new Bauer(player);
    			val_moves = b.validMoves(board, y, x);
    			
    		}
    		//züge vergleichen
    		if(!val_moves.contains(move)) throw new Exception("No valid move");
    		else this.doMoveBoard(move, x, y, figure);
    	}
    	
    	
    }
    private void doMoveBoard(String move, int x, int y, char figure) {
    	//figur ziehen
    	char [][] dest = board.clone();
		dest[y][x]=0;
		int dest_x = (((int) move.charAt(3))-97);
		int dest_y = (((int) move.charAt(4))-49);
		//ggf geschlagene figur zu spareparts hinzufügen
		if(dest[dest_y][dest_x]!='0') {
			char temp =dest[dest_y][dest_x];
			if( temp<97) temp += 32;
			if(temp> 90) temp -= 32;
			addSpare_part(dest[dest_y][dest_x]); 
		}
		if(figure=='P' & dest_y==7) {
			figure= 'Q';
		}
		if(figure== 'p' & dest_y ==0) {
			figure= 'q';
		}
		dest [dest_y][dest_x] = figure;
		board = dest;
    }
    
    //figur aus spare parts nehmen
    private void takeSpare_part(char f) throws Exception {
    	int i = 0;
    	while(i<Spare_parts.length()) {
    		if(f== Spare_parts.charAt(i)) break;
    		i++;
    	}
    	if(i==Spare_parts.length()) {
    		throw new Exception("Unvalid move!");
    	}
    	String temp = Spare_parts.substring(0, i);
    	if(i<Spare_parts.length()-1) temp += Spare_parts.substring(i+1);
    	this.Spare_parts=temp;
    }
    
    //fügt figur zu spare parts hinzu
    private void addSpare_part(char f) {
    	int val = (int) f;
    	int s = (int) Spare_parts.charAt(0);
    	int i = 0;
    	while(val<s) {
    		i++;
    		s= (int) Spare_parts.charAt(i);
    	}
    	String temp = Spare_parts.substring(0,i) + f + Spare_parts.substring(i);
    	Spare_parts = temp;
    	
    }
   //gibt objekt board als string zurück
    public String BoardToString() {
    	String b_String="";
    	int cnt=0;
    	char tmp=9;
    	for(int y=0; y<8; y++) {
    		for(int x=0; x<8; x++) {
    			tmp = board[y][x];
       			if(tmp=='0') cnt++;
    			if(tmp!='0' &cnt==0)b_String+=tmp;
    			if(tmp!='0' &cnt>0) {
    				b_String += Character.forDigit(cnt,10);
    				b_String += tmp;
    				cnt=0;
    			}
        		if(x==7 & tmp=='0') b_String += Character.forDigit(cnt,10);
        	}
    		b_String+='/';
    	}
    	b_String += Spare_parts;
    	return b_String;	
    }
    
    //getters
    public char[][] getBoard(){return board;}
    public String getSpare_parts() {
        return Spare_parts;
    }
}
