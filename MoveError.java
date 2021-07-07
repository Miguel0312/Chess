import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MoveError extends JFrame{
	public MoveError(){
		this.setTitle("Error");
		this.setSize(200, 70);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		JLabel message = new JLabel("Invalid move");
		JPanel panel = new JPanel();
		panel.add(message);
		this.setContentPane(panel);
		this.setVisible(true);
		} 
	}
