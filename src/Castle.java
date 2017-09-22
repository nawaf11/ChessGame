import java.awt.Image;

import javax.swing.ImageIcon;

public class Castle extends Piece {

	public Castle(int pos, char Color) {
		super(pos, Color);
	}

	@Override
	public Image getImage() {
		if (Color == 'W') {
			Image im = new ImageIcon(this.getClass().getResource("image/castleW.png")).getImage();
			return im;
		} else {
			Image im = new ImageIcon(this.getClass().getResource("image/castleB.png")).getImage();
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


	@Override
	public LinkedList getLegalMove() {
		
		LinkedList ud = getUpMove().merge(getDownMove());
		LinkedList lf = getLeftMove().merge(getRightMove());
		if(ud==null)
		{	ud=new LinkedList();
		ud.insert(-1);
		}
		LinkedList res= ud.merge(lf);
		return res;
		 
	}

	@Override
	public LinkedList getLegalKillMove() {
		return getLegalMove();

	}

}
