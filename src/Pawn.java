import java.awt.Image;

import javax.swing.ImageIcon;

public class Pawn extends Piece {

	public Pawn(int pos, char Color) {
		super(pos, Color);

	}

	@Override
	public Image getImage() {
		if (Color == 'W') {
			Image im = new ImageIcon(this.getClass().getResource("image/pawnW.png")).getImage();
			return im;
		} else {
			Image im = new ImageIcon(this.getClass().getResource("image/pawnB.png")).getImage();
			return im;
		}
	}

	@Override
	public LinkedList getLegalMove() {
		LinkedList leg = new LinkedList();
		if(Color=='B'){
		if (!(position >= 0 && position <= 7)) {
			{
			if(Board.locs[position-8].isEmpty())
			leg.insert(position - 8);
			if (Board.getCurrentPlayer().isFirstMove())
				leg.insert(position - 16);
			
				}
	}}//if Color is B
		else {
				if (!(position >= 56 && position <= 63)) {
					if(Board.locs[position+8].isEmpty())
					leg.insert(position + 8);
					if (Board.getCurrentPlayer().isFirstMove())
						leg.insert(position + 16);
					
				}
		}// if Color is W
		if(leg.empty())
			leg.insert(-1);
		return leg;
	
	}//method

	public LinkedList getLegalKillMove() {
		LinkedList leg  = new LinkedList();
		if(Color=='B'){
		if (position >= 0 && position <= 7) {
			leg.insert(-1);
		return leg;
		} else if (position == 8 || position == 16 || position == 24 || position == 32 || position == 40 || position == 48
				|| position == 56) {
			if(!Board.locs[position-7].isEmpty()&&Color!=Board.locs[position-7].getPiece().getColor())
         leg.insert(position-7);
		}else if (position == 63 || position == 15 || position == 23 || position == 31 || position == 39 || position == 47
				|| position == 55) {
			if(!Board.locs[position-9].isEmpty()&&Color!=Board.locs[position-9].getPiece().getColor())
	         leg.insert(position-9);
			}
		else{
			if(!Board.locs[position-9].isEmpty()&&Color!=Board.locs[position-9].getPiece().getColor())
			leg.insert(position-9);
			if(!Board.locs[position-7].isEmpty()&&Color!=Board.locs[position-7].getPiece().getColor())
	         leg.insert(position-7);
		}
	}//if Color  is B
		else{
			if (position >= 56 && position <= 63) {
				leg.insert(-1);
			return leg;
			} else if (position == 8 || position == 16 || position == 24 || position == 32 || position == 40 || position == 48
					|| position == 56) {
				if(!Board.locs[position+9].isEmpty()&&Color!=Board.locs[position+9].getPiece().getColor())
				 leg.insert(position+9);
			}else if (position == 63 || position == 15 || position == 23 || position == 31 || position == 39 || position == 47
					|| position == 55) {
				if(!Board.locs[position+7].isEmpty()&&Color!=Board.locs[position+7].getPiece().getColor())
				leg.insert(position+7);
				}
			else{
				if(!Board.locs[position+9].isEmpty()&&Color!=Board.locs[position+9].getPiece().getColor())
				leg.insert(position+9);
				if(!Board.locs[position+7].isEmpty()&&Color!=Board.locs[position+7].getPiece().getColor())
		         leg.insert(position+7);
			}
		}//if Color is W
		if(leg.empty())	
			leg.insert(-1);
		return leg;
	}
}// class
