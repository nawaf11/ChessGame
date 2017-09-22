
public class Player {
	private boolean isFirstMove;
	private char color;
	public Player(char color){
		this.color=color;
		isFirstMove=true;
	}
	public Piece [] getPieces(){
		if(color=='W')
			return Board.Wp;
		else
			return Board.Bp;
	}
	public boolean isFirstMove() {
		return isFirstMove;
	}
	public void setFirstMove(boolean isFirstMove) {
		this.isFirstMove = isFirstMove;
	}
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	

}
