package tictactoe;

import java.util.ArrayList;
import java.util.Iterator;

public class Checker {
		public static ArrayList<Marker> checkWin(Marker[][] markers){
			ArrayList<Marker> match;
			
			for (int i = 0; i < Main.SIZE; i++) {
				int x = i % Main.ROWS;
				int y = i / Main.ROWS;
				
				//diagonal bottom left and top right 
				match = checkMatch(x, y, 1, -1, i, markers);
				

				//diagonal top left and bottom right 
				if(match == null){
					match = checkMatch(x, y, 1, 1, i, markers);
				}
				
				//horizontal
				if(match == null){
					match = checkMatch(x, y, 1, 0, i, markers);
				}
				
				//vertical
				if(match == null){
					match = checkMatch(x, y, 0, 1, i, markers);
				}
				
				if(match != null) {
					return match;
				}
				
				
			}
			
			
			return null;
		}
		
		
		private static ArrayList<Marker> checkMatch(int x, int y, int dX, int dY, int index, Marker[][] markers){

			ArrayList<Marker> match = new ArrayList<Marker>(Main.MATCH);
			
			int type = -1;
			int checkCount = 0;
			
			while(checkCount < Main.ROWS && index < Main.SIZE && x >= 0 && x<=Main.ROWS - 1 && 
					y>=0 && y<=Main.ROWS - 1) {
				
				boolean found= false;
				Marker marker = markers[x][y]; 
				
				if(marker!= null) {
					if(type == -1) {
						type = marker.getType();
					}
					
					if(marker.getType()==type) {
						match.add(marker);
						found = true;
					}
				}
				
				
//				the second condition means if the border is of 5 then 5 match must be there not 3
				if(!found && match.size() < Main.MATCH) {
					match.clear();
					type = -1;
				}
				
				
				x+=dX;
				y+=dY;
				index++;
				checkCount++;
				
			}
			
			return match.size() >= Main.MATCH ? match : null; 
		}
}
