import java.awt.Image;

import javax.swing.ImageIcon;

public class Bishop extends Piece{

	public Bishop(int pos, char Color ) {
		super(pos, Color );
	}

	@Override
	public Image getImage() {
		if (Color == 'W') {
			Image im = new ImageIcon(this.getClass().getResource("image/bishopW.png")).getImage();
			return im;
		} else {
			Image im = new ImageIcon(this.getClass().getResource("image/bishopB.png")).getImage();
			return im;
		}
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
		LinkedList ud =getUpLeft().merge(getDownRight());
		LinkedList lf =getUpRight().merge(getDownLeft());
		if(ud==null&&lf==null)
		{	ud=new LinkedList();
		ud.insert(-1);
		return ud;
		}
		if(ud==null)
		 return lf.merge(ud) ;
		else
		return ud.merge(lf);
	}

	@Override
	public LinkedList getLegalKillMove() {
		return getLegalMove();
	}

}
