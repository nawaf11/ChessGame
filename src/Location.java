import javax.swing.ImageIcon;

public class Location {
	private final int pos;
	private Piece piece;

	public Location(int pos) {
		this.pos = pos;
		piece = null;
	}

	public void addPiece(Piece p) {
		
		
		piece = p;
		piece.position = this.pos;
		Window.bts[pos].setIcon(new ImageIcon(p.getImage()));
		
	}

	public void moveMyPieceTo(Location target) {
		if (piece.Color == Board.getCurrentPlayer().getColor()) {
			Board.getCurrentPlayer().setFirstMove(false);
		}
		Piece p1;
		if(piece instanceof Pawn)       p1 = new Pawn(piece.position, piece.Color);
		else if(piece instanceof Castle)p1 = new Castle(piece.position, piece.Color);
		else if(piece instanceof Knight)p1 = new Knight(piece.position, piece.Color);
		else if(piece instanceof King)p1 = new King(piece.position, piece.Color);
		else if(piece instanceof Queen)p1 = new Queen(piece.position, piece.Color);
		else if(piece instanceof Bishop)p1 = new Bishop(piece.position, piece.Color);
		else p1 = null;
		target.addPiece(p1);
		removeMyPiece();
		Board.changeTurn();

	}

	public void removeMyPiece() {
		piece.position = -1;
		Window.bts[pos].setIcon(null);
	}

	// Setters & Getters
	public boolean isEmpty() {
		if (piece == null || piece.position == -1 || piece.position != pos)
			return true;
		else
			return false;
	}

	public int getPos() {
		return pos;
	}

	public Piece getPiece() {
		return piece;
	}

}
