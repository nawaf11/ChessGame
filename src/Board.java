public class Board  {
	public static Location [] locs;
	private int nb;
	public static int turn=1;
	private static Player p1,p2;
	
	//0 king ,1 queen ,2+3 bishop ,4+5 castle,6+7 knight, 8-15 pawn
	public static Piece [] Bp;
	public static Piece [] Wp;
    public void clearBoard(){
    	for(int i=0;i<64;i++){
    		if(!Board.locs[i].isEmpty())
			Board.locs[i].removeMyPiece();
		}
    	nb=0;
    	p1=new Player('B');
        p2=new Player('W');
    	Bp= new Piece[16];
    	Wp= new Piece[16];
    	AddPieces();
    	turn=1;
    	
    }
    public Board(){
    	locs=new Location[64];
    	nb=0;
    	p1=new Player('B');
    	p2=new Player('W');
    	Bp= new Piece[16];
    	Wp= new Piece[16];
    }
  
 
	public static boolean isLegal(LinkedList l,int val){
    	l.findFirst();
    	while(!l.last()){
    		if(val==l.retrieve())return true;
    		l.findNext();
    	}
    	if(val==l.retrieve())return true; 
    	else return false;
    }
   /* public static boolean isLegal(int [] moveThis , int toThis){
    	if(moveThis==null)
    		return false;
    	int arr [] = moveThis;
    	boolean result=false;
    	for (int i = 0; i < arr.length; i++) {
			if(toThis==arr[i]){
				result=true;}
		}
    	return result;
    }*/
	public static void changeTurn(){
		if(turn==1){
			turn=2;
			Window.panelBoard.removeAll();
	    	 for (int i = 63; i >= 0; i--) {
	    		 Window.panelBoard.add(Window.bts[i]);
	 		}
	    	 Window.panelBoard.repaint();
		}
		
		else{
			turn=1;
			Window.panelBoard.removeAll();
		   	 for (int i = 0; i < 64; i++) {
		   		Window.panelBoard.add(Window.bts[i]);
				}
		   	Window.panelBoard.repaint();
		}
	}
    public static Player getCurrentPlayer(){
    	if(turn==1)
    		return p1;
    	else
    		return p2;
    }
	
	public void addLocation(){
		
		locs[nb]=new Location(nb);
		nb++;
	}
	public int getPos() {
		return nb;
	}
	public void AddPieces(){
    Bp[0]= new King(60, 'B');locs[60].addPiece(Bp[0]);
    Bp[1]= new Queen(59, 'B');locs[59].addPiece(Bp[1]);
	Bp[2]= new Bishop(61, 'B');locs[61].addPiece(Bp[2]);
	Bp[3]= new Bishop(58, 'B');locs[58].addPiece(Bp[3]);
    Bp[4]= new Castle(56, 'B');locs[56].addPiece(Bp[4]);
    Bp[5]= new Castle(63, 'B');locs[63].addPiece(Bp[5]);
    Bp[6]= new Knight(62, 'B');locs[62].addPiece(Bp[6]);
	Bp[7]= new Knight(57, 'B');locs[57].addPiece(Bp[7]);
		//another color ..
	Wp[0]= new King(4, 'W');locs[4].addPiece(Wp[0]);      
	Wp[1]= new Queen(3, 'W');locs[3].addPiece(Wp[1]);
	Wp[2]= new Bishop(2, 'W');locs[2].addPiece(Wp[2]);
	Wp[3]= new Bishop(5, 'W');locs[5].addPiece(Wp[3]);
    Wp[4]= new Castle(0, 'W');locs[0].addPiece(Wp[4]);
    Wp[5]= new Castle(7, 'W');locs[7].addPiece(Wp[5]);
    Wp[6]= new Knight(1, 'W');locs[1].addPiece(Wp[6]);
	Wp[7]= new Knight(6, 'W');locs[6].addPiece(Wp[7]);
		//Add Pawns
		int k=48,j=8;
		for (int i = 0; i < 8; i++,k++,j++) {
			Wp[j]=new Pawn(j, 'W');locs[j].addPiece(Wp[j]);
			Bp[j]=new Pawn(k, 'B');locs[k].addPiece(Bp[j]);
		}
	}
	
	
}

	


