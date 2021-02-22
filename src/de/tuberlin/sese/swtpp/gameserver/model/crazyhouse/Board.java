package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;

import java.util.ArrayList;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Springer;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Bauer;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Dame;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Koenig;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Laeufer;
import de.tuberlin.sese.swtpp.gameserver.model.crazyhouse.Turm;

public class Board implements Serializable{
    
	private static final long serialVersionUID = -7251893373315958898L;
	private char [][] board;
    private String Spare_parts;

// constructor creates 8x8 matrix with Matrix [y][x] and Spare_parts String 

    public Board(String b){
        board= new char[8][8];
        int cnt= b.length();
        
        for (int i=0; i<8;i++) {
        	for(int j=0;j<8;j++) {
        		board[i][j]='\0';
        	}
        }
        
        int i= 0;
        while ( i<8){
        	int j = 0;
            while (true){
            	char temp= b.charAt(b.length()-cnt);
                if(temp=='/'){
                    i++;
                    cnt--;
                    break;
                }
                if((int) temp>48 && (int) temp <58){
                    int cur = (int) temp -48;
                    if(j+cur>7){
                        
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
        
        Spare_parts = new String("");
        if(b.length()-cnt <b.length()) {
        	for(i=b.length()-cnt; i< b.length(); i++){
        		Spare_parts += b.charAt(i);
        	}
        }
       

    }
    //checks if move is valid; if yes: does move, if no: throws runtimeexception
    public boolean checkMove(String move, String player) throws Exception {
    	char figure='0';
    	int [] co;
    	char [][] dest = new char[8][8];
    	for(int i= 0; i<8; i++) {
    		dest[i] = this.getBoard()[i].clone();
    	}
    	 
    	//figur aus spare parts string
    	
    	if(move.length()==4) {
    		figure= move.charAt(0);
    		if(player=="b" & ((int) figure)<97) {System.out.println("Nicht deine Figur!"); return false;}
    		if(player=="w" & ((int) figure)>90) {System.out.println("Nicht deine Figur!"); return false;}
    		try {co = dest_coord(move.substring(3));} catch(Exception e) {throw new Exception("invalid String!}");}
    		int dest_x = co[0];
    		int dest_y = co[1];
        	if(dest[dest_y][dest_x]!='\0') { System.out.println("auf dem ausgewählten Feld steht bereits eine Figur!");return false;}
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
    	if(move.length()==5) {
    		int x = ((int) move.charAt(0))-97;
    		int y = 7-(((int) move.charAt(1))-49);
    		figure = board[y][x];
    		if(figure=='\0') throw new Exception("no token chosen");
    		if(player=="b" & ((int) figure)<97) throw new Exception("not your token");
    		if(player=="w" & ((int) figure)>90) throw new Exception("not your token");
    		
    		
    		ArrayList<String> val_moves;
    		
    		//figur aufrufen(player Ã¼bergeben als String)
    		Figur f= switchFigur(figure, player);
    		val_moves= f.validMoves(board, y, x);
    		for(int s = 0;s<val_moves.size(); s++) {
    			String temp=""+ move.charAt(0)+move.charAt(1)+'-'+ val_moves.get(s);
    			val_moves.set(s, temp);
    		}
    		for(String s: val_moves) {
    			System.out.println(s);
    		}
    		//zÃ¼ge vergleichen
    		if(!val_moves.contains(move)) return false;
    		else { 
    				this.doMoveBoard(move, x, y, figure);
    				return true;
    			}
    		
    	}
    	else {return false; }
    	
    	
    }
    private void doMoveBoard(String move, int x, int y, char figure) {
    	//figur ziehen
    	char [][] dest = new char[8][8];
    	for(int i= 0; i<8; i++) {
    		dest[i] = this.getBoard()[i].clone();
    	}
		dest[y][x]='\0';
		int dest_x = (((int) move.charAt(3))-97);
		int dest_y = Math.abs((((int) move.charAt(4))-48)-8);
		//ggf geschlagene figur zu spareparts hinzufÃ¼gen
		if(dest[dest_y][dest_x]!='\0') {
			char temp =dest[dest_y][dest_x];
			if( temp<97) { temp += 32;}
			else { temp -= 32;}
			addSpare_part(temp); 
		}
		if(figure=='P' & dest_y==0) {
			figure= 'Q';
		}
		if(figure== 'p' & dest_y ==7) {
			figure= 'q';
		}
		dest [dest_y][dest_x] = figure;
		this.board = dest;
		
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
    	else {
    	String temp = Spare_parts.substring(0, i);
    	if(i<Spare_parts.length()-1) temp += Spare_parts.substring(i+1);
    	this.Spare_parts=temp;
    }}
    
    //fÃ¼gt figur zu spare parts hinzu 
    private void addSpare_part(char f) 
    {
    	if(Spare_parts.isEmpty()) { Spare_parts=""+f;}
    	else 
    	{
    		int val = (int) f;
	    	int s = (int) Spare_parts.charAt(0);
	    	int i = 0;
	    	while(val>s && i<Spare_parts.length()) {
	    		s= (int) Spare_parts.charAt(i);
	    		i++;
	    	}
	    	String temp = Spare_parts.substring(0,i) + f + Spare_parts.substring(i);
	    	Spare_parts = temp;
    	}
    }
    
   //gibt objekt board als string zurÃ¼ck
    public String BoardToString() {
    	String b_String="";
    	
    	char tmp;
    	for(int y=0; y<8; y++) {
    		int cnt=0;
    		for(int x=0; x<8; x++) {
    			tmp = board[y][x];
       			if(tmp=='\0') cnt++;
    			if(tmp!='\0' &cnt==0)b_String+=tmp;
    			if(tmp!='\0' &cnt>0) {
    				b_String += Character.forDigit(cnt,10);
    				b_String += tmp;
    				cnt=0;
    			}
        		if(x==7 & tmp=='\0') b_String += Character.forDigit(cnt,10);
        	}
    		b_String+='/';
    	}
    	String temp = b_String.concat(Spare_parts);
    	return temp;	
    }
    public Figur switchFigur(char figure, String player) {
    	if(figure=='k' || figure=='K') {
			return new Koenig(player);
			
		}
		if(figure=='q' || figure=='Q') {
			return new Dame(player);
			
		}
		
		if(figure=='B' || figure=='b') {
			return new Laeufer(player);
		}
		if(figure=='n' || figure=='N') {
			return new Springer(player);
		}
		if(figure=='r' || figure=='R') {
			return new Turm(player);
		}
		else {
			return new Bauer(player);
		}
    }
    //getters
    public char[][] getBoard(){return this.board;}
    public String getSpare_parts() {
        return Spare_parts;
    }
    private int[] dest_coord(String co) throws Exception{
    	if(((int)co.charAt(0) < 97)||((int)co.charAt(0)) > 104 ) throw new Exception("invalid String");
    	if(((int)co.charAt(1) < 49)||((int)co.charAt(1)) > 56 ) throw new Exception("invalid String");
    	int [] c= new int[2];
    	c[0] = ((int) co.charAt(0))-97;
		c[1] = 7-(((int) co.charAt(1))-49);
		return c;
    }
    public String xytoString(int x, int y) {
    	String pos =new String("");
    	//char tmp;
    	pos+= ((char) (x+97));
    	pos+= ((char) (56-y));
    	return pos;
    }
    public boolean Check(String player, boolean checkmate) throws Exception{
    	ArrayList<String> poss_Moves=new ArrayList<>();
    	Koenig k;
    	ArrayList<String> k_Moves = new ArrayList<>();
    	int x=0,y=0;
    	k= new Koenig(player);
    	
    	for(int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if((board[i][j]=='K' & player=="w") || (board[i][j]=='k' & player =="b")) {
					x=j;
					y=i;			
				}
			}
		}
    	k_Moves = k.validMoves(board, y, x);
    	String co = xytoString(x,y);
    	try {
    		return isCheck(poss_Moves,k_Moves, player, co, checkmate);
    	} catch (Exception e) {
    		throw new Exception("irgendwas kaputt");
    	}
    	
    }
    private boolean isCheck(ArrayList<String> poss_Moves, ArrayList<String> k_Moves, String player, String co, boolean checkmate)throws Exception {
    	int [] coordinates;
    	try{coordinates= dest_coord(co);} catch(Exception e) {
    		throw new Exception("invalid coordinates");
    	}
    	int x= coordinates[0];
    	int y= coordinates[1];
    	for(int pos_y=0; pos_y<7; pos_y++) {
    		for(int pos_x=0; pos_x<7;pos_x++) {
    			char figure= board[pos_y][pos_x];
    			if((player=="w" & ((int)figure)>96) || player=="b" & ((int)figure)<90 &((int)figure)>10) {
    				Figur cur= switchFigur(figure, player);
    				for(String p:cur.validMoves(board, pos_y, pos_x)) {
    		    		System.out.println(cur.getClass() +" "+p);
    		    	}
    				poss_Moves.addAll(cur.validMoves(board, pos_y, pos_x));
    			}
    		}
    	}
    	System.out.println(xytoString(x,y));
    	
    	if(poss_Moves.contains(xytoString(x,y))) {
    	  	if(checkmate) return isCheckMate(k_Moves, poss_Moves);
    		return true;
    	}
    	return false;
    	
    }
    private boolean isCheckMate(ArrayList<String> k_Moves, ArrayList<String> poss_Moves) {
    	int cnt = 0;
    	for(String m:k_Moves) {
			if(poss_Moves.contains(m)) cnt++;
			
		}
    	if(cnt==k_Moves.size()) return true;
    	else return false;
    }
   
        
}

