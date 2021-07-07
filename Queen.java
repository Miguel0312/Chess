import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

public class Queen extends Piece{
	public Queen(char c, int[] position){
		super('Q', c, position);
		}
		
	//Tests if the move is possible
	public boolean isMovePossible(int[] position, Board b){
		int x0 = this.getPosition()[0], y0 = this.getPosition()[1];
		int x1 = position[0], y1 = position[1];
		
		//For the queen, it can move like a rook or like a bishop
		
		if(b.hasPieceIn(position) && b.getPieceIn(position).getColor() == this.getColor())
			return false;
		
		if(x0==x1){
			int senseY = (y1-y0)/Math.abs(y1-y0);
			for(int j = y1 - senseY; j!= y0; j-=senseY)
				if(b.hasPieceIn(new int[]{x0,j}))
					return false;
			return true;
			}
			
		else if(y0==y1){
			int senseX = (x1-x0)/Math.abs(x1-x0);
			for(int j = x1 - senseX; j!= x0; j-=senseX)
				if(b.hasPieceIn(new int[]{j,y0}))
					return false;
			return true;
			}
			
		else if((Math.abs(x1-x0) == Math.abs(y1-y0))){
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
		
	//Draw the queen piece
	public void drawPiece(DrawGame d, Graphics g){
		int squareSide = d.getHeight()/8, pieceSide = squareSide*3/4;
		int x = this.getPosition()[0], y = this.getPosition()[1];		
			if(this.getColor() == 'W'){
					try{
						Image img = ImageIO.read(new File("Images/WhiteQueen.png"));
						g.drawImage(img, x*squareSide + squareSide/2 - pieceSide/2,y*squareSide+squareSide/2 - pieceSide/2, pieceSide, pieceSide, d); 
					}catch(IOException i){}
				}
			else{
				try{
						Image img = ImageIO.read(new File("Images/BlackQueen.png"));
						g.drawImage(img, x*squareSide + squareSide/2 - pieceSide/2,y*squareSide+squareSide/2 - pieceSide/2, pieceSide, pieceSide, d); 
					}catch(IOException i){}
				}
				
			}
	}
