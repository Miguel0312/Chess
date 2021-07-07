import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class DrawGame extends JPanel{
	private static final long serialVersionUID = 1L;
	//Colors of the squares
	Color light = new Color(226,216,179);
	Color dark = new Color(51, 116, 49);
	//Square selected to make a move
	private int[] selected = new int[]{-1,-1};
	//Pieces
	private Board b;
	
	public DrawGame(Board board){
		this.b = board;
		}
		
	public void setBoard(Board board){
		this.b = board;
		}
		
	//Draw the squares of the board
	public void drawBoard(Graphics g){
		//Square side
		int squareSide = this.getHeight()/8;
		for(int i = 0; i<8;i++)
			for(int j = 0; j<8;j++){
				if((i+j)%2 == 0)
					g.setColor(light);
				else
					g.setColor(dark);
				g.fillRect(j*squareSide, i*squareSide, squareSide, squareSide);
				}
		}
		
	//Draws the pieces
	public void drawPieces(Board board, Graphics g){
		
		//Uses the drawPiece method from Piece to draw the pieces
		for(Piece p : board.getBoard()){
			p.drawPiece(this, g);
		}
	}
		
	//Analyzes to which squares the piece cn move and puts a circle in them to make
	//visualization easier
	private void possibleMoves(Piece p, Graphics g){
		g.setColor(Color.BLUE);
		int side = this.getHeight()/8, radius = side*1/5;
		for(int i = 0; i<8; i++)
			for(int j = 0; j<8;j++)
				if(p.isMovePossible(new int[]{i,j}, this.b))
					g.fillOval(i*side + side/2 - radius, j*side + side/2 - radius, 2*radius, 2*radius);
		}
		
	//Changes the selected square that will be painted in red
	public void setSelected(int[] s){
		this.selected = s;
		}
		
	public int[] getSelected(){
		return this.selected;
		}
	
	//Paints in red the selected square
	private void paintSelected(Graphics g){
		int squareSide = this.getHeight()/8;
		int i = this.selected[0], j = this.selected[1];
		g.setColor(Color.RED);
		g.fillRect(i*squareSide, j*squareSide, squareSide, squareSide);
	}
	
	//Checks if some piece is selected
	public boolean isPieceSelected(){
			return this.getPieceSelected()!=null;
		}
		
	//Returns the piece in the current square. If there is none, returns null
	public Piece getPieceSelected(){
		for(Piece p:this.b.getBoard()){
			if(p.getPosition()[0] == this.selected[0] && p.getPosition()[1] == this.selected[1])
				return p;
			}
		return null;
		}
		
		
	//Uses the functions above to finish painting the board
	public void paintComponent(Graphics g){
		drawBoard(g);
		paintSelected(g);
		drawPieces(b, g);
		if(this.isPieceSelected())
			possibleMoves(this.getPieceSelected(), g);
		}
		

	}
