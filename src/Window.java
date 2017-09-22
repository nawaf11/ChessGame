import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Window {

	private JFrame frame;
	public  static JPanel panelBoard;
	private Board br;
	public static JButton bts[] = new JButton[64];
	private static boolean statusSelectPieceToMove = true;
	private int moveThisPiece = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		try{
		initialize();
		}catch(NullPointerException e){
			System.out.println("method initialize() error");
			e.printStackTrace();
			
			
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
    private void naturalBoard(){
    int darkF=0;
   for (int i = 0; i < bts.length; i++) {
	   final int dex=i;
		if (darkF == 0)
			DarkFirst( dex);
		else
			LightFirst( dex);
		if (dex % 8 == 0) {

			if (darkF == 0) {
				bts[dex].setBackground(new Color(255, 200, 100));
				darkF = 1;
			} else {
				bts[dex].setBackground(new Color(150, 50, 30));
				darkF = 0;
			}
		}
		
}

    }
    private void setGreen(LinkedList arr){
    	
    	if(Board.locs[moveThisPiece].getPiece() instanceof Pawn  ){
  LinkedList ar1=Board.locs[moveThisPiece].getPiece().getLegalMove().mergeP(Board.locs[moveThisPiece].getPiece().getLegalKillMove() );
  ar1.findFirst();
  ar1.display();
  while(!ar1.last() ){
	  if(ar1.retrieve()>=0&&arr.retrieve()<=63){
   if(Board.locs[ar1.retrieve()].isEmpty())
	    	bts[ar1.retrieve()].setBackground(new Color(29, 44,178));
else if(!Board.locs[ar1.retrieve()].isEmpty() && Board.locs[ar1.retrieve()].getPiece().getColor()!=Board.getCurrentPlayer().getColor())
bts[ar1.retrieve()].setBackground(new Color(29, 44,178));
  }ar1.findNext();
}
  if(ar1.retrieve()>=0&&arr.retrieve()<=63){
  if(Board.locs[ar1.retrieve()].isEmpty())
  	bts[ar1.retrieve()].setBackground(new Color(29, 44,178));
else if(!Board.locs[ar1.retrieve()].isEmpty() && Board.locs[ar1.retrieve()].getPiece().getColor()!=Board.getCurrentPlayer().getColor())
bts[ar1.retrieve()].setBackground(new Color(29, 44,178));
	} }
      
    	
    	else {
    		arr.display();
    		arr.findFirst();
    		 while(!arr.last() ){
    			 if(arr.retrieve()>=0&&arr.retrieve()<=63){
    	            if(Board.locs[arr.retrieve()].isEmpty())
    	    		    	bts[arr.retrieve()].setBackground(new Color(29, 44,178));
    	 else  if(!Board.locs[arr.retrieve()].isEmpty() && Board.locs[arr.retrieve()].getPiece().getColor()!=Board.getCurrentPlayer().getColor())
  	bts[arr.retrieve()].setBackground(new Color(29, 44,178));
	  
    	               }
    			 arr.findNext(); }//while
    		 if(arr.retrieve()>=0&&arr.retrieve()<=63){
	            if(Board.locs[arr.retrieve()].isEmpty())
	    		    	bts[arr.retrieve()].setBackground(new Color(29, 44,178));
	        else if(!Board.locs[arr.retrieve()].isEmpty() && Board.locs[arr.retrieve()].getPiece().getColor()!=Board.getCurrentPlayer().getColor())
		    	bts[arr.retrieve()].setBackground(new Color(29, 44,178));}
		}
    }
    private void LightFirst(int dex) {
		if (dex % 2 == 0) {
			bts[dex].setBackground(new Color(255, 200, 100));
		}

		else {
			bts[dex].setBackground(new Color(150, 50, 30));
		}

	}

	private void DarkFirst( int dex) {

		if (dex % 2 == 0) {
			bts[dex].setBackground(new Color(150, 50, 30));
		}

		else {
			bts[dex].setBackground(new Color(255, 200, 100));
		}

	}

	private void addBts() {
		int darkF = 0;
		for (int i = 0; i < 64; i++) {
			final int dex = i;
			bts[dex] = new JButton();
			bts[dex].setSize(50, 50);
			//bts[dex].setText("" + dex);
			panelBoard.add(bts[dex]);
			br.addLocation();
			if (darkF == 0)
				DarkFirst( dex);
			else
				LightFirst( dex);
			if (dex % 8 == 0) {

				if (darkF == 0) {
					bts[dex].setBackground(new Color(255, 200, 100));
					darkF = 1;
				} else {
					bts[dex].setBackground(new Color(150, 50, 30));
					darkF = 0;
				}
			}
			bts[dex].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				
					if (statusSelectPieceToMove && Board.locs[dex].isEmpty())
						{naturalBoard();
						return;}
					
					if (statusSelectPieceToMove && !Board.locs[dex].isEmpty()
							&& Board.locs[dex].getPiece().getColor() != Board.getCurrentPlayer().getColor())
						{naturalBoard();
						return;}
						if (moveThisPiece == dex) {
							setGreen(Board.locs[moveThisPiece].getPiece().getLegalMove());

							return;
						}
					if (moveThisPiece != -1 && !Board.locs[moveThisPiece].isEmpty() && !Board.locs[dex].isEmpty()
							&& Board.locs[moveThisPiece].getPiece().getColor() ==Board.locs[dex].getPiece().getColor()) {
						naturalBoard();
						moveThisPiece=dex;
						setGreen(Board.locs[moveThisPiece].getPiece().getLegalMove());
						statusSelectPieceToMove=false;
						return;
					} // if same color case
					
					if (statusSelectPieceToMove && !Board.locs[dex].isEmpty()) {
						moveThisPiece = dex;
						setGreen(Board.locs[moveThisPiece].getPiece().getLegalMove());
						statusSelectPieceToMove = false;
						return;
					}
					if (!statusSelectPieceToMove && Board.locs[dex].isEmpty()) {
						if(!Board.isLegal(Board.locs[moveThisPiece].getPiece().getLegalMove(), dex)){
							statusSelectPieceToMove = true;
							naturalBoard();
							moveThisPiece = -1;
						}
						else{
						Board.locs[moveThisPiece].moveMyPieceTo(Board.locs[dex]);
						statusSelectPieceToMove = true;
						naturalBoard();
						moveThisPiece = -1;
						}
					}
					// (kill)
					if (!statusSelectPieceToMove && ! Board.locs[dex].isEmpty()){
							if(!Board.isLegal(Board.locs[moveThisPiece].getPiece().getLegalKillMove(), dex)){
								statusSelectPieceToMove = true;
								naturalBoard();
								moveThisPiece = -1;
							}
							else{
							Board.locs[moveThisPiece].moveMyPieceTo(Board.locs[dex]);
							statusSelectPieceToMove = true;
							naturalBoard();
							moveThisPiece = -1;
							}
						}
				}
			});
		}
	}
     
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Chess Game");
		frame.setBounds(0, 0, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		Image bc=new ImageIcon(this.getClass().getResource("image/bk.jpg")).getImage();
		frame.setContentPane(new JLabel(new ImageIcon(bc)));
		br = new Board();
		panelBoard = new JPanel();
		//panelBoard.setBounds(25, 12, 800, 620);
		panelBoard.setBounds(25, 12, 750, 630);
		panelBoard.setLayout(new GridLayout(8, 8));
		addBts();
		br.AddPieces();
		frame.getContentPane().add(panelBoard);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(871, 52, 117, 33);
		btnNewGame.setBackground(new Color(32,32,32));
		btnNewGame.setForeground(Color.white);
		btnNewGame.setFont(new Font("Serif",  Font.BOLD, 13));
		frame.getContentPane().add(btnNewGame);
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 br.clearBoard();
			 naturalBoard();
				statusSelectPieceToMove=true;
				moveThisPiece=-1;
				Board.turn=1;
				Window.panelBoard.removeAll();
			   	 for (int i = 0; i < 64; i++) {
			   		Window.panelBoard.add(Window.bts[i]);
					}
			   	Window.panelBoard.repaint();
			}
		});
			
		
	}
}
