import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Fenetre extends JFrame implements MouseListener{
	//Board size
	public int side = 600;
	//Pieces
	private Board b;
	//Panel to draw the game
	private DrawGame d = new DrawGame(b);
	private char turn = 'W';
	
	public Fenetre(Board board){
		b = board;
		d.setBoard(b);
		this.setTitle("Chess");
		this.setSize(side,side);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(d);
		this.setVisible(true);
		this.addMouseListener(this);
		}
		
	//Mouse commands: What to do when the user clicks in a square
	public void mouseClicked(MouseEvent e){
		//x and y store the position of the click
		int x = e.getX();
		int y = e.getY();
		int side = this.getHeight()/8;
		
		//If there is no piece selected, try to select the piece in the selected square
		if(!(d.isPieceSelected())){
			d.setSelected(new int[]{(x+15)/side,(y-15)/side});
			//Try selecting the piece
			try{
			//If it is not your turn, return error message
			if(d.getPieceSelected().getColor() != turn){
				new TurnError(turn);
				d.setSelected(new int[]{-1,-1});
				}
			//If there is no piece in the square, catch eception and don't select anything
			}catch(NullPointerException n){
				d.setSelected(new int[]{-1,-1});
				}
		}
		
		//If a piece is already selected, try to move it
		else if(d.isPieceSelected()){
			Piece p = d.getPieceSelected();
			d.setSelected(new int[]{(x+15)/side,(y-15)/side});
			
			//What to do if the move is allowed
			if(p.isMovePossible(d.getSelected(), b)){
				try{
				//If the king is captured, check mate
				if(b.getPieceIn(d.getSelected()).getType() == 'K'){
					new EndGame(turn);
				}}catch(NullPointerException n){}
				//Move the piece
				b.makeMove(p, d.getSelected(), d);
				
				//Change the color moving in next turn
				if(turn == 'W')
					turn = 'B';
				else
					turn = 'W';
			}
			
			//If the piece selected is of the same color of the previous one, select the new piece
			//instead of making a move
			else if(this.b.hasPieceIn(d.getSelected()) && p.getColor() == d.getPieceSelected().getColor()){
				d.setSelected(new int[] {(x+15)/side, (y-15)/side});
				}
			
			//If the move is not possible, return an error message
			else{
				new MoveError();
				d.setSelected(new int[]{-1,-1});
				}
			}
		//Refresh the screen
		d.repaint();
		}
		

	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	}
