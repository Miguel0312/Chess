import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TurnError extends JFrame{
	public TurnError(char c){
		this.setTitle("Error");
		this.setSize(200, 70);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		JLabel message = new JLabel();
		if(c=='W')
			message.setText("It is white's turn");
		else
			message.setText("It is black's turn");
		JPanel panel = new JPanel();
		panel.add(message);
		this.setContentPane(panel);
		this.setVisible(true);
		} 
	}
