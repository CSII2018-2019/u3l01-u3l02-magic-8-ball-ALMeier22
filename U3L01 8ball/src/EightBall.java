import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class EightBall extends JFrame {

	public EightBall(){	
		
		initGUI();
		
		setTitle("8 Ball");
		setResizable(false);
		pack(); //pack means pack tightly -- override the sizes 
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initGUI(){
		
		JLabel messageLabel = new JLabel("It is certain");
		//customize the label 
		Font titlefount = new Font (Font.SERIF, Font.BOLD + Font.ITALIC, 64);
		messageLabel.setFont(titlefount);
		messageLabel.setForeground(new Color(4,222,248));
		messageLabel.setBackground(new Color(3,27,197));
		messageLabel.setOpaque(true);
		
		add(messageLabel,BorderLayout.PAGE_START);
		messageLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.white);
		
		JButton shakeButton = new JButton("Shake"); 
		shakeButton.setBackground(Color.black);
		shakeButton.setForeground(Color.white);
		shakeButton.setSize(50,50);
		bottomPanel.add(shakeButton,BorderLayout.CENTER);
		
		add(bottomPanel);
	}
	
	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new EightBall();
            }   
        });
	
	}

}
