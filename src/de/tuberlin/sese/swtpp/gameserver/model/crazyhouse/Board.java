package de.tuberlin.sese.swtpp.gameserver.model.crazyhouse;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

    //converts board string to matrix and a string with spare parts
//
public class Board{
    char [][] board;
    String Spare_parts;


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
    public void moveBoard(String move) {
    	if
    	//finde figur b3-c4
    	//a=97 h=104
    	int x = ((int) move.charAt(0))-97;
    	int y = 7-(((int) move.charAt(1))-49);
    	char figure = board[y][x];
    	
    	//figur aufrufen(player übergeben als String)
    	
    	
    	//züge vergleichen
    	int dest_x = (((int) move.charAt(3))-97);
    	int dest_y = (((int) move.charAt(4))-49);
    	char [][] dest = board.clone();
    	if(dest[dest_y][dest_x]!='0') 
    	dest [dest_y][dest_x] = figure;
    	dest[y][x]=0;
    	board = dest;
    	
    	
    }
    public char[][] getBoard(){return board;}

    private void addSpare_part(char f) {
    	int val = (int) f;
    	int s = (int) Spare_parts.charAt(0);
    	int i = 0;
    	while(val<s) {
    		i++;
    		s= (int) Spare_parts.charAt(i);
    	}
    	
    }
    public String getSpare_parts() {
        return Spare_parts;
    }
}
