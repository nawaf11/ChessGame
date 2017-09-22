import java.awt.Image;

public abstract class  Piece {
	protected int position;
	protected final char Color;	
	public Piece(int pos , char Color ){
		position=pos;
		this.Color=Color;		
	}
	public abstract Image getImage();
    public abstract LinkedList getLegalMove();
    public abstract LinkedList getLegalKillMove();
    
    //Setter & Getters
    public char getColor() {
		return Color;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	

    
}
