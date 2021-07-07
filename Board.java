import java.util.ArrayList;

public class Board{
	ArrayList<Piece> board = new ArrayList<Piece>();
	
	//When the board is initialized, it adds all the initial pieces of the game
	Board(){
		for(int j = 0; j<8; j++)
			this.board.add(new Pawn('W', new int[]{j, 6}));
		for(int j = 0; j<8; j++)
			this.board.add(new Pawn('B', new int[]{j, 1}));
			
		//Black Pieces
		this.board.add(new Rook('B', new int[]{0,0}));
		this.board.add(new Knight('B', new int[]{1,0}));
		this.board.add(new Bishop('B', new int[]{2,0}));
		this.board.add(new Queen('B', new int[]{3,0}));
		this.board.add(new King('B', new int[]{4,0}));
		this.board.add(new Bishop('B', new int[]{5,0}));
		this.board.add(new Knight('B', new int[]{6,0}));
		this.board.add(new Rook('B', new int[]{7,0}));
		
		//White Pieces
		this.board.add(new Rook('W', new int[]{0,7}));
		this.board.add(new Knight('W', new int[]{1,7}));
		this.board.add(new Bishop('W', new int[]{2,7}));
		this.board.add(new Queen('W', new int[]{3,7}));
		this.board.add(new King('W', new int[]{4,7}));
		this.board.add(new Bishop('W', new int[]{5,7}));
		this.board.add(new Knight('W', new int[]{6,7}));
		this.board.add(new Rook('W', new int[]{7,7}));
		}
		
	public ArrayList<Piece> getBoard(){
		return this.board;
		}
		
	//Removes the piece in a specific position
	private void removePiece(int[] position){
		for(Piece p:this.board){
			if(p.getPosition()[0] == position[0] && p.getPosition()[1] ==position[1]){
				this.board.remove(p);
				break;
				}
			}
		}
	
	//Remove a piece of its current square and puts it in the desired square
	public void movePiece(Piece p, int[] position){
		this.removePiece(p.getPosition());
		char t = p.getType();
		switch(t){
			case 'P':
				this.board.add(new Pawn(p.getColor(),position));
				break;
			case 'R':
				this.board.add(new Rook(p.getColor(),position));
				break;
			case 'N':
				this.board.add(new Knight(p.getColor(),position));
				break;
			case 'B':
				this.board.add(new Bishop(p.getColor(),position));
				break;
			case 'Q':
				this.board.add(new Queen(p.getColor(),position));
				break;
			case 'K':
				this.board.add(new King(p.getColor(),position));
				break;
			}
		}
		
	public void capturePiece(int[] position){
		this.removePiece(position);
		}
		
	//Tests if a determined square has a piece in it
	public boolean hasPieceIn(int[] position){
		for(Piece p:this.board){
			if(p.getPosition()[0] == position[0] && p.getPosition()[1] ==position[1]){
				return true;
				}
			}
		return false;
		}
		
	//Makes a move
	public void makeMove(Piece p, int[] position, DrawGame d){
		try{
				//If the square is empty or there is a piece of the other color, we can make the move
				if(!this.hasPieceIn(position) || this.getPieceIn(position).getColor() != p.getColor()){
					this.capturePiece(d.getSelected());
					this.movePiece(p, d.getSelected());
					d.setSelected(new int[]{-1,-1});
					}
				//If the piece is of the same color, selects the new piece
				else
					d.setSelected(position);
				}catch(NullPointerException n){
					d.setSelected(new int[]{-1,-1});
					}
		}
	
	//Returns the piece in a specific position. If there isn't any, return null.
	public Piece getPieceIn(int[] position){
		for(Piece p:this.board)
			if(p.getPosition()[0] == position[0] && p.getPosition()[1] == position[1])
				return p;
		return null;
		}
	}
