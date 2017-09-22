import java.awt.Image;

import javax.swing.ImageIcon;

public class King extends Piece{

	public boolean isInDanger;
	public King(int pos, char Color) {
		super(pos, Color);
		isInDanger=false;
		// TODO Auto-generated constructor stub
	}
private int  getUp(){
	   if(position>=0&&position<=7) return -1;
	   if(!Board.locs[position -8].isEmpty()&&Color==Board.locs[position -8].getPiece().getColor())
			return -1;
	   else return position-8;
      }
private int getDown(){
	  if(position>=56&&position<=63) return -1;
	  if(!Board.locs[position +8].isEmpty()&&Color==Board.locs[position +8].getPiece().getColor())
			return -1;
	   else return position+8;
}
private int getLeft(){
	  if(position==0||position==8||position==16||position==24||position==32||position==40||position==48||position==56)
		  return -1;
	  if(!Board.locs[position -1].isEmpty()&&Color==Board.locs[position -1].getPiece().getColor())
			return -1;
	   else return position-1;
}
private int getRight(){
if(position==7||position==15||position==23||position==31||position==39||position==47||position==55||position==63)
		  return -1;
if(!Board.locs[position +1].isEmpty()&&Color==Board.locs[position +1].getPiece().getColor())
	return -1;
	   else return position+1;
}
private int getUpLeft(){
if ((position>=0&&position<= 7)||(position==8||position==16||position==24||position==32||position==40||position==48||position==56))
return -1;
if(!Board.locs[position-9].isEmpty()&&Color==Board.locs[position -9].getPiece().getColor())
	return -1;
else
	return position-9;
}
private int getUpRight(){
	if ((position>=0&&position<= 7)||(position==15||position==23||position==31||position==39||position==47||position==55))
return -1;
	if(!Board.locs[position -7].isEmpty()&&Color==Board.locs[position -7].getPiece().getColor())
		return -1;
	else return position-7;
}
private int getDownLeft(){
	if ((position>=56&&position<= 63)||(position==0||position==8||position==16||position==24||position==32||position==40||position==48))
return -1;
	if(!Board.locs[position +7].isEmpty()&&Color==Board.locs[position +7].getPiece().getColor())
		return -1;
	else
		return position+7;
}
private int getDownRight(){
	if ((position>=56&&position<=63)||(position==7||position==15||position==23||position==31||position==39||position==47||position==55))
return -1;
	if(!Board.locs[position +9].isEmpty()&&Color==Board.locs[position +9].getPiece().getColor())
		return -1;
	else return position+9;
}
	@Override
	public Image getImage() {
		
		if (Color == 'W') {
			Image im = new ImageIcon(this.getClass().getResource("image/kingW.png")).getImage();
			return im;
		} else {
			Image im = new ImageIcon(this.getClass().getResource("image/kingB.png")).getImage();
			return im;
		}
		
	}

	@Override
	public LinkedList getLegalMove() {
		LinkedList res =new LinkedList();
			if((getUp()!=-1 ) && ( getUp()>=0&&getUp()<=63) )res.insert(getUp());
			if(getDown()!=-1 && ( getDown()>=0&&getDown()<=63) )res.insert(getDown());
			if(getLeft()!=-1 && ( getLeft()>=0&&getLeft()<=63) )	res.insert(getLeft());
			if(getRight()!=-1 && ( getRight()>=0&&getRight()<=63) )res.insert(getRight());
			if(getUpLeft()!=-1 && ( getUpLeft()>=0&&getUpLeft()<=63) )res.insert(getUpLeft());
			if(getUpRight()!=-1 && ( getUpRight()>=0&&getUpRight()<=63) )res.insert(getUpRight());
			if(getDownLeft()!=-1 && ( getDownLeft()>=0&&getDownLeft()<=63) )res.insert(getDownLeft());
			if(getDownRight()!=-1 && ( getDownRight()>=0&&getDownRight()<=63) )res.insert(getDownRight());
			if(res.empty())res.insert(-1);
		return res;
	}

	@Override
	public LinkedList getLegalKillMove() {
		return getLegalMove();
	}

}
