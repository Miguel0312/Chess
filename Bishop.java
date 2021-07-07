import java.lang.Math;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

public class Bishop extends Piece{
	public Bishop(char c, int[] position){
		super('B', c, position);
		}
		
	//Tests if the move is possible
	public boolean isMovePossible(int[] position, Board b){
		int x0 = this.getPosition()[0], y0 = this.getPosition()[1];
		int x1 = position[0], y1 = position[1];
		
		//If it has a piece of the same color, return false
		if(b.hasPieceIn(position) && b.getPieceIn(position).getColor() == this.getColor())
			return false;
		
		//If the position is in a diagonal of the current position and the squares in this
		//diagonal are empty, then it can move
		if((Math.abs(x1-x0) == Math.abs(y1-y0))){
			int senseX = (x1-x0)/Math.abs(x1-x0), senseY = (y1-y0)/Math.abs(y1-y0);
			for(int i = 1; i!=Math.abs(x1-x0); i++){
				int x = x1-i*senseX, y = y1 - i*senseY;
				if(b.hasPieceIn(new int[]{x,y})){
					return false;
				}
					}
			return true;
			}
		return false;
		}
		
		//Draw the bishop image
		public void drawPiece(DrawGame d, Graphics g){
		int squareSide = d.getHeight()/8, pieceSide = squareSide*3/4;
		int x = this.getPosition()[0], y = this.getPosition()[1];		
			if(this.getColor() == 'W'){
					try{
						Image img = ImageIO.read(new File("Images/WhiteBishop.png"));
						g.drawImage(img, x*squareSide + squareSide/2 - pieceSide/2,y*squareSide+squareSide/2 - pieceSide/2, pieceSide, pieceSide, d); 
					}catch(IOException i){}
				}
			else{
				try{
						Image img = ImageIO.read(new File("Images/BlackBishop.png"));
						g.drawImage(img, x*squareSide + squareSide/2 - pieceSide/2,y*squareSide+squareSide/2 - pieceSide/2, pieceSide, pieceSide, d); 
					}catch(IOException i){}
				}
				
			}
	}
