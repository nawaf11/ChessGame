import java.awt.Image;

import javax.swing.ImageIcon;

public class Queen extends Piece{

	public Queen(int pos, char Color) {
		super(pos, Color);
	}

	@Override
	public Image getImage() {
		if (Color == 'W') {
			Image im = new ImageIcon(this.getClass().getResource("image/queenW.png")).getImage();
			return im;
		} else {
			Image im = new ImageIcon(this.getClass().getResource("image/queenB.png")).getImage();
			return im;
		}
	}
	private LinkedList getDownMove() {
		LinkedList up = new LinkedList();
		if (position >= 56 && position <= 63)
			{ 
			return up; }
		else
			for (int i = 0, p = position; i < 7; i++) {
				if (p + 8 >= 0 && p + 8 <= 63 && Board.locs[p + 8].isEmpty()) {
					up.insert(p+8);
					p += 8;
} else if (p + 8 >= 0 && p + 8 <= 63 && !Board.locs[p + 8].isEmpty()&&Color!=Board.locs[p + 8].getPiece().getColor()) {
					up.insert(p+8);
					break;
				}
 else if (p + 8 >= 0 && p + 8 <= 63 && !Board.locs[p + 8].isEmpty()&&Color==Board.locs[p + 8].getPiece().getColor())
	break;
			} // loop
	
		return up;
	}

	private LinkedList getUpMove() {
		LinkedList up = new LinkedList();
		if (position >= 0 && position <= 7)
			{
			return up ;}
		else
			for (int i = 0, p = position; i < 7; i++) {
				if (p - 8 >= 0 && p - 8 <= 63 && Board.locs[p - 8].isEmpty()) {
					up.insert(p-8);
					p -= 8;
				} else if (p - 8 >= 0 && p - 8 <= 63 && !Board.locs[p - 8].isEmpty()&&Color!=Board.locs[p - 8].getPiece().getColor()) {
					up.insert(p-8);
					break;
				}
			 else if (p - 8 >= 0 && p - 8 <= 63 && !Board.locs[p - 8].isEmpty()&&Color==Board.locs[p - 8].getPiece().getColor()) {
				 break;
			 }
			} // loop
		
		return up;
	}

	private LinkedList getRightMove() {
		LinkedList up = new LinkedList();
		if (position == 7 || position == 15 || position == 23 || position == 31 || position == 39 || position == 47
				|| position == 55 || position == 63)
		{	
		return up;}
		else
			for (int i = 0, p = position; i < 7; i++) {
				if (p+1 == 7 || p+1 == 15 || p+1 == 23 || p+1 == 31 || p+1 == 39 || p+1 == 47
						  || p+1 == 55 || p+1 == 63){
					up.insert(p+1);break;
				}
				if (p + 1 >= 0 && p +1 <= 63 && Board.locs[p +1].isEmpty()) {
					up.insert(p+1);
					p += 1;
} else if (p +1 >= 0 && p +1 <= 63 && !Board.locs[p +1].isEmpty()&&Color!=Board.locs[p + 1].getPiece().getColor()) {
					up.insert(p+1);
					break;
				}
else if (p +1 >= 0 && p +1 <= 63 && !Board.locs[p +1].isEmpty()&&Color==Board.locs[p + 1].getPiece().getColor()) {
	break;
}
			} // loop
		
		return up;
	}

	private LinkedList getLeftMove(){
		LinkedList up = new LinkedList();
		if (position == 0 || position == 8 || position == 16 || position == 24 || position == 32 || position == 40
				|| position == 48 || position == 56)
			{
			return up ;}
		else
			for (int i = 0, p = position; i < 7; i++) {
				if (p-1 == 0 || p-1 == 8 || p-1 == 16 || p-1 == 24 || p-1 == 32 || p-1 == 40
						  || p-1 == 48 || p-1 == 56){
					up.insert(p-1);break;}
				
				if (p - 1 >= 0 && p -1 <= 63 && Board.locs[p-1].isEmpty()) {
					up.insert(p-1);
					p-= 1;
} else if (p-1 >= 0 && p-1 <= 63 && !Board.locs[p-1].isEmpty()&&Color!=Board.locs[p - 1].getPiece().getColor()) {
					up.insert(p-1);
					break;
				}
else if (p-1 >= 0 && p-1 <= 63 && !Board.locs[p-1].isEmpty()&&Color==Board.locs[p - 1].getPiece().getColor()) {
	break;
} 
				}// loop
		
		return up;
           }


    
	private LinkedList getUpLeft() {
		LinkedList up = new LinkedList();
if ((position>=0&&position<= 7)||(position==8||position==16||position==24||position==32||position==40||position==48||position==56))
			{  return up;}
		else{
			for (int i = 0, p = position; i < 7; i++) {
				//16−24−32−40−48−56
				if (p-9 == 16 || p-9 == 24 || p-9 == 32 || p-9 == 40 || p-9 == 48 || p-9 == 56){
					up.insert(p-9);break;
				}
				if (p -9 >= 0 && p-9 <= 63 && Board.locs[p-9].isEmpty()) {
					up.insert(p-9);
					p -= 9;
				} else if (p-9 >= 0 && p-9<= 63 && !Board.locs[p-9].isEmpty()&&Color!=Board.locs[p-9].getPiece().getColor()) {
					up.insert(p-9);
					break;
				} else if (p-9 >= 0 && p-9<= 63 && !Board.locs[p-9].isEmpty()&&Color==Board.locs[p-9].getPiece().getColor()) {
                   break;
				} else if(!(p-9 >= 0 && p-9<= 63))
				  break;
					else 
						up.insert(p-9);
			} // loop
		return up;
	}}
    private LinkedList getDownRight(){
		LinkedList up = new LinkedList();
if ((position>=56&&position<=63)||(position==7||position==15||position==23||position==31||position==39||position==47||position==55))
			{
			return up;
			}
		else{
			for (int i = 0, p = position; i < 7; i++) {
				//7−15−23−31−39−47−55−63
				if (p+9 == 7 || p+9 == 15 || p+9 == 23 || p+9 == 31 || p+9 == 39 || p+9 == 47){
					up.insert(p+9);;break;
				}
				if (p +9 >= 0 && p+9 <= 63 && Board.locs[p+9].isEmpty()) {
					up.insert(p+9);
					p += 9;
				} else if (p+9 >= 0 && p+9<= 63 && !Board.locs[p+9].isEmpty()&&Color!=Board.locs[p+9].getPiece().getColor()) {
					up.insert(p+9);
					break;
				}
			 else if (p+9 >= 0 && p+9<= 63 && !Board.locs[p+9].isEmpty()&&Color==Board.locs[p+9].getPiece().getColor()) 
              break;   
			 else if(!(p+9 >= 0 && p+9<= 63))
				  break;
			} // loop
		return up;}
    }
    private LinkedList getUpRight(){
		LinkedList up = new LinkedList();
if ((position>=0&&position<= 7)||(position==15||position==23||position==31||position==39||position==47||position==55||position==63))
			{
            return up;
            }
 		else{
			for (int i = 0, p = position; i < 7; i++) {
				//15−23−31−39−47−55−63
	if (p-7 == 7||p-7 == 15 || p-7 == 23 || p-7 == 31 || p-7 == 39 || p-7 == 47 || p-7 == 63|| p-7 == 55){
					up.insert(p-7);break;
				}
				if (p -7 >= 0 && p-7 <= 63 && Board.locs[p-7].isEmpty()) {
					up.insert(p-7);
					p -= 7;
				} else if (p-7 >= 0 && p-7<= 63 && !Board.locs[p-7].isEmpty()&&Color!=Board.locs[p-7].getPiece().getColor()) {
					up.insert(p-7);
					break;
				}
			 else if (p-7 >= 0 && p-7<= 63 && !Board.locs[p-7].isEmpty()&&Color==Board.locs[p-7].getPiece().getColor() )
               break;
			 else if(!(p-7 >= 0 && p-7<= 63))
				  break;
			} // loop
		return up;
    } }
    private LinkedList getDownLeft(){
		LinkedList up = new LinkedList();
if ((position>=56&&position<= 63)||(position==0||position==8||position==16||position==24||position==32||position==40||position==48||position==56))
			{
			
		    return up;
			}
		else{
			for (int i = 0, p = position; i < 7; i++) {
				//8−16−24−32−40−48−56
				if (p+7 == 8||p+7 == 16 || p+7 == 24 || p+7 == 32 || p+7 == 40 || p+7 == 48 || p+7 == 56|| p+7 == 0){
					up.insert(p+7);break;
				}
				if (p+7 >= 0 && p+7 <= 63 && Board.locs[p+7].isEmpty()) {
					up.insert(p+7);
					p += 7;
				} else if (p+7 >= 0 && p+7<= 63 && !Board.locs[p+7].isEmpty()&&Color!=Board.locs[p+7].getPiece().getColor()) {
					up.insert(p+7);
					break;
				} 
				else if (p+7 >= 0 && p+7<= 63 && !Board.locs[p+7].isEmpty()&&Color==Board.locs[p+7].getPiece().getColor()) 
               break;
				else if(!(p+7>= 0 && p+7<= 63))
					  break;
               } // loop
		return up;
		}
    }
    
	
    @Override
	public LinkedList getLegalMove() {
		LinkedList res=new LinkedList();
		LinkedList ud = getUpLeft().merge(getDownRight());
		LinkedList lf =getUpRight().merge(getDownLeft());
		LinkedList ud1 =getUpMove().merge(getDownMove());
		LinkedList lf1 =getLeftMove().merge(getRightMove());
		if(ud!=null&&lf!=null&&ud1!=null&&lf1!=null){
			System.out.println("1");

			return ud.merge(ud1).merge(lf).merge(lf1);
		}
		if(ud==null&&lf==null&&ud1==null&&lf1==null){
			System.out.println("2");

			res.insert(-1);
			return res;
		}
		if( (ud1==null || lf1==null) && ( ud!=null && lf!=null ) ){
			System.out.println("3");
		LinkedList Fud=ud.merge(ud1);
		LinkedList Flf=lf.merge(lf1);
		return Fud.merge(Flf);
		 
		            }
		if( (ud==null || lf==null) && ( ud1!=null && lf1!=null ) ){
			System.out.println("4");
			LinkedList Fud=ud1.merge(ud);
			LinkedList Flf=lf1.merge(lf);
			return Fud.merge(Flf);
			 			        
		}
		if( (ud1==null || lf==null) && ( ud!=null && lf1!=null ) ){
			System.out.println("4");
			LinkedList Fud=ud.merge(ud1);
			LinkedList Flf=lf1.merge(lf);
			return Fud.merge(Flf);
			 			        
		}
		if( (ud==null || lf1==null) && ( ud1!=null && lf!=null ) ){
			System.out.println("4");
			LinkedList Fud=ud1.merge(ud);
			LinkedList Flf=lf.merge(lf1);
			return Fud.merge(Flf);
			 			        
		}
		if( (lf==null || lf1==null) && ( ud!=null && ud1!=null ) ){
			System.out.println("4");
			LinkedList Fud=ud.merge(lf);
			LinkedList Flf=ud1.merge(lf1);
			return Fud.merge(Flf);
			 			        
		}
		if( (ud==null || ud1==null) && ( lf!=null && lf1!=null ) ){
			System.out.println("4");
			LinkedList Fud=lf.merge(ud);
			LinkedList Flf=lf1.merge(ud1);
			return Fud.merge(Flf);
			 			        
		}
		
		if( ud==null && lf==null && ud1==null ){
			System.out.println("5");
            return lf1;
          }
	if( ud==null && lf1==null && ud1==null ){
		System.out.println("6");
		return lf;
          }

	if( lf1==null && lf==null && ud1==null ){
		System.out.println("7");
		return ud;
          }

	else 
		System.out.println("8");
		return ud1;
          
	}

	@Override
	public LinkedList getLegalKillMove() {
		return getLegalMove();
	}

}
