import java.awt.Image;

import javax.swing.ImageIcon;

public class Knight extends Piece {

	public Knight(int pos, char Color) {
		super(pos, Color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Image getImage() {
		if (Color == 'W') {
			Image im = new ImageIcon(this.getClass().getResource("image/knightW.png")).getImage();
			return im;
		} else {
			Image im = new ImageIcon(this.getClass().getResource("image/knightB.png")).getImage();
			return im;
		}
	}

	private int get2UpLeft() {
		// 24−32−40−48−56
		if (position == 24 || position == 32 || position == 40 || position == 48 || position == 56||position-17<0)
			return -1;
		if(!Board.locs[position - 17].isEmpty()&&Color==Board.locs[position - 17].getPiece().getColor())
			return -1;
		return position - 17;
	}

	private int get2UpRight() {
		// 15−23−31−39−47−55−63
		if (position == 15 || position == 23 || position == 31 || position == 39 || position == 47 || position == 55
				|| position == 63||position-15<0)
			return -1;
		if(!Board.locs[position - 15].isEmpty()&&Color==Board.locs[position - 15].getPiece().getColor())
			return -1;
		return position - 15;
	}

	private int get2DownLeft() {
		// 39−31−23−15−7
		
		if (position == 39 || position == 31 || position == 23 || position == 15 || position == 7||position+17>63)
			return -1;
		if(!Board.locs[position+17].isEmpty()&&Color==Board.locs[position +17].getPiece().getColor())
			return -1;
		return position + 17;
	}

	private int get2DownRight() {
		// 48−40−32−24−16−8−0
		if (position == 48 || position == 40 || position == 32 || position == 24 || position == 16 || position == 8
				|| position == 0||position+15>63)
			return -1;
		if(!Board.locs[position + 15].isEmpty()&&Color==Board.locs[position + 15].getPiece().getColor())
			return -1;
		return position + 15;
	}

	private int getUpLeft() {
if (position == 48 || position == 40 || position == 32 || position == 24 || position == 16 || position == 56
|| position == 49|| position == 41|| position == 33|| position == 25|| position == 17|| position == 57||position-10<0)
			return -1;
if(!Board.locs[position - 10].isEmpty()&&Color==Board.locs[position - 10].getPiece().getColor())
	return -1;
		return position - 10;
	}

	private int getUpRight() {
		//6−14−22−30−38−46−54−62 and +1 for *
if (position == 6 || position == 14 || position == 22 || position == 30 || position == 38 || position == 46 || position == 54|| position == 62
   || position == 7|| position == 15|| position == 23|| position == 31|| position == 39|| position == 47 || position == 55|| position == 63||position-6<0)
		return -1;
if(!Board.locs[position - 6].isEmpty()&&Color==Board.locs[position - 6].getPiece().getColor())
	return -1;
return position - 6;
	}

	private int getDownLeft() {
//46−38−30−22−14−6 or +1 for *
if (position == 46 || position == 38 || position == 30 || position == 22 || position == 14 || position == 6
|| position == 47|| position == 39|| position == 31|| position == 23|| position == 15|| position == 7||position+10>63)
							return -1;
if(!Board.locs[position +10].isEmpty()&&Color==Board.locs[position +10].getPiece().getColor())
	return -1;
						return position + 10;
	}

	private int getDownRight() {
	//56−48−40−32−24−16−8−0 and +1 for *
		
if (position == 56 || position == 48 || position == 40 || position == 32 || position == 24 || position == 16 || position == 8|| position == 0
  || position == 57|| position == 49|| position == 41|| position == 33|| position == 25|| position == 17 || position == 9|| position == 1||position+6>63)
				return -1;
if(!Board.locs[position + 6].isEmpty()&&Color==Board.locs[position + 6].getPiece().getColor())
	return -1;
		return position + 6;
	}

	@Override
	public LinkedList getLegalMove() {
		LinkedList res=new LinkedList();
		if(get2DownLeft()!=-1&&(get2DownLeft()>=0&&get2DownLeft()<=63))res.insert(get2DownLeft());
		if(get2DownRight()!=-1&&(get2DownRight()>=0&&get2DownRight()<=63))res.insert(get2DownRight());
		if(get2UpLeft()!=-1&&(get2UpLeft()>=0&&get2UpLeft()<=63))res.insert(get2UpLeft());
		if(get2UpRight()!=-1&&(get2UpRight()>=0&&get2UpRight()<=63))res.insert(get2UpRight());
		if(getDownLeft()!=-1&&(getDownLeft()>=0&&getDownLeft()<=63))res.insert(getDownLeft());
		if(getDownRight()!=-1&&(getDownRight()>=0&&getDownRight()<=63))res.insert(getDownRight());;
		if(getUpLeft()!=-1&&(getUpLeft()>=0&&getUpLeft()<=63))res.insert(getUpLeft());
		if(getUpRight()!=-1&&(getUpRight()>=0&&getUpRight()<=63))res.insert(getUpRight());
		return res;
	}

	@Override
	public LinkedList getLegalKillMove() {
		return getLegalMove();
	}

}
