import java.awt.Graphics;

//Abstract super class for all the pieces in the game
public abstract class Piece{
	//type is a char that designates the type of the piece(pawn, rook, bishop...)
	//color is a char that designates the color(white or black)
	char type, color;
	//Every piece has one position
	int[] position = new int[2];
	public Piece(char t, char c, int[] p){
		this.type = t;
		this.color = c;
		this.position = p;
		}
		
	public char getType(){
		return this.type;
	}
		
	public char getColor(){
		return this.color;
	}
		
	public int[] getPosition(){
		return this.position;
	}
	
	public void setPosition(int[] p){
		this.position = p;
		}
		
	//Abstract method that test if the move is possible. This depends of the piece.
	public abstract boolean isMovePossible(int[] position, Board b);
	
	//Abstract method to draw the pieces. This depends of the piece
	public abstract void drawPiece(DrawGame d, Graphics g);
		 
	}
