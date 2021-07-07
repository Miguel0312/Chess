import java.lang.Math;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

public class Pawn extends Piece{
	public Pawn(char c, int[] position){
		super('P', c, position);
		}
		
	//Tests if the move is possible
	public boolean isMovePossible(int[] position, Board b){
		int x = this.getPosition()[0];
		
		//If we try to move to a square with a piece of the same color, returns false
		if(b.hasPieceIn(position) && b.getPieceIn(position).getColor() == this.getColor())
			return false;
		
		//If the square is free and it is on the same x position and has an absolute difference
		//of 1 in the y position and the sign of this difference is suitable to the color of the
		//pawn, then it can move
		if((!b.hasPieceIn(position) && (position[0]==this.getPosition()[0] && 
		this.getPosition()[1] + (this.getColor()=='W'? -1:1) == position[1])))
			return true;
		
		//If the pawn is in its initial position, he can move two squares at once
		if((position[1] == (this.getColor()=='W'?4:3)) && !b.hasPieceIn(position) &&
		!b.hasPieceIn(new int[]{x, (this.getColor()=='W'? 5:2)}) && 
		this.getPosition()[1]==(this.getColor() == 'W'?6:1) && position[0]==x)
			return true;
		
		//The pawn can only capture in diagonal
		if(b.hasPieceIn(position) && Math.abs(this.getPosition()[0] - position[0]) == 1 && 
		this.getPosition()[1] + (this.getColor()=='W'? -1:1) == position[1])
			return true;
		return false;
		}
		
	//Draw the pawn image
	public void drawPiece(DrawGame d, Graphics g){
		int squareSide = d.getHeight()/8, pieceSide = squareSide*3/4;
		int x = this.getPosition()[0], y = this.getPosition()[1];		
			if(this.getColor() == 'W'){
					try{
						Image img = ImageIO.read(Pawn.class.getResource("WhitePawn.png"));
						g.drawImage(img, x*squareSide + squareSide/2 - pieceSide/2,y*squareSide+squareSide/2 - pieceSide/2, pieceSide, pieceSide, d); 
					}catch(IOException i){}
				}
			else{
				try{
						Image img = ImageIO.read(new File("Images/BlackPawn.png"));
						g.drawImage(img, x*squareSide + squareSide/2 - pieceSide/2,y*squareSide+squareSide/2 - pieceSide/2, pieceSide, pieceSide, d); 
					}catch(IOException i){}
				}
				
			}
	}
