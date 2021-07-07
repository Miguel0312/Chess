import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class EndGame extends JFrame{
	public EndGame(char c){
		this.setTitle("End Game");
		this.setSize(200, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		JLabel message = new JLabel();
		if(c == 'W')
			message.setText("Check Mate. \n White wins!");
		if(c == 'B')
			message.setText("Check Mate. \n Black wins!");
		panel.add(message);
		this.setContentPane(panel);
		this.setVisible(true);
		}
	}
