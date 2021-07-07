import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

public class King extends Piece{
	public King(char c, int[] position){
		super('K', c, position);
		}
		
	//Tests if the move is possible
	public boolean isMovePossible(int[] position, Board b){
		int x0 = this.getPosition()[0], y0 = this.getPosition()[1];
		int x1 = position[0], y1 = position[1];
		
		//There can't be a piece of the same color in the destination
		if(b.hasPieceIn(position) && b.getPieceIn(position).getColor() == this.getColor())
			return false;		
		
		//It can move only 0 or 1 squares in each direction
		if(Math.abs(x1-x0)<=1 && Math.abs(y1-y0)<=1)
			return true;
		return false;
		}
		
		
	//Draw the king piece
	public void drawPiece(DrawGame d, Graphics g){
		int squareSide = d.getHeight()/8, pieceSide = squareSide*3/4;
		int x = this.getPosition()[0], y = this.getPosition()[1];		
			if(this.getColor() == 'W'){
					try{
						Image img = ImageIO.read(new File("Images/WhiteKing.png"));
						g.drawImage(img, x*squareSide + squareSide/2 - pieceSide/2,y*squareSide+squareSide/2 - pieceSide/2, pieceSide, pieceSide, d); 
					}catch(IOException i){}
				}
			else{
				try{
						Image img = ImageIO.read(new File("Images/BlackKing.png"));
						g.drawImage(img, x*squareSide + squareSide/2 - pieceSide/2,y*squareSide+squareSide/2 - pieceSide/2, pieceSide, pieceSide, d); 
					}catch(IOException i){}
				}
				
			}
	}
