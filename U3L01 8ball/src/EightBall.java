import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class EightBall extends JFrame {

	private JLabel messageLabel;
	private JTextField question;
	private String[] answers = {
			 "It is certain.",
			 "It is decidedly so.",
			 "Without a doubt.",
			 "Reply hazy, try again.",
			 "Ask again later.",
			 "Better not tell you now.",
			 "Don't count on it.",
			 "My reply is no.",
			 "My sources say no."
			
			
	};
	
	
	
	
	public EightBall(){	

		setPreferredSize(new Dimension(800,220));

		initGUI();
		
		setTitle("8 Ball");
		setResizable(true);
		pack(); //pack means pack tightly -- override the sizes 
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initGUI(){
		
		JTextField question = new JTextField();
		question.setPreferredSize(new Dimension(800,80));
		Font textfount = new Font (Font.SERIF, Font.BOLD + Font.ITALIC, 30);
		question.setFont(textfount);
		question.setHorizontalAlignment(JTextField.CENTER);
		add(question,BorderLayout.PAGE_START);
		
		messageLabel = new JLabel("");
		messageLabel.setPreferredSize(new Dimension(800,80));
		//customize the label 
		Font titlefount = new Font (Font.SERIF, Font.BOLD + Font.ITALIC, 64);
		messageLabel.setFont(titlefount);
		messageLabel.setForeground(new Color(4,222,248));
		messageLabel.setBackground(new Color(3,27,197));
		messageLabel.setOpaque(true);
		
		add(messageLabel,BorderLayout.PAGE_END);
		messageLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.white);
		
		JButton shakeButton = new JButton("Shake"); 
		shakeButton.setBackground(Color.black);
		shakeButton.setForeground(Color.white);
		shakeButton.setSize(50,50);
		shakeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shake();
			}
		});
		bottomPanel.add(shakeButton,BorderLayout.CENTER);
		
		add(bottomPanel);
	}
	
	public void shake() {
		int answer = ((int)(Math.random() * (answers.length-1)) + 1);
		messageLabel.setText(answers[answer]);		
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
