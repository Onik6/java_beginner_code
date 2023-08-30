package gui_testing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class my_Button_Frame extends JFrame implements ActionListener{
	
	JButton button;
	my_Button_Frame(){
		
		ImageIcon icon= new ImageIcon("sample_images/poo.png");
		
	    button= new JButton();
		button.setBounds(150, 150, 200, 200);
		button.addActionListener(this);
		button.setText("myButton");
	    button.setFocusable(false);
	    button.setIcon(icon);
	    button.setHorizontalTextPosition(JButton.CENTER);
	    button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("Comic Sans",Font.BOLD,25));
		button.setIconTextGap(-8);
		button.setForeground(Color.cyan);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBorder(BorderFactory.createEtchedBorder());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		this.add(button);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			
			System.out.println("i love pizza");
		}
		
	}
 
}
