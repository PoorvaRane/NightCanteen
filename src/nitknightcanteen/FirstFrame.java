/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nitknightcanteen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * This class creates the order frame and serves as the primary interface
 * We employ inheritance to absorb the features of JFrame while adding our own
 * It allows the user to pick between 3 choices
 * a) Place an order
 * b) View order status
 * c) Ad-min log in so as to view pending orders and update them
 */
public class FirstFrame extends JFrame {

	private final JButton btn1;
        private final JButton btn2;
        private final JButton btn3;

	public FirstFrame() throws FileNotFoundException {
		
		setSize(1500,1500);
		setTitle("NITK NIGHT CANTEEN");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                setLayout(new BorderLayout());
                JLabel background=new JLabel(new ImageIcon("Canteen.jpg"));
                add(background);
                background.setLayout(new FlowLayout());
               
                setLayout(new FlowLayout());
                btn1=new JButton("PLACE ORDER");
               
                btn1.setSize(30,60);
                btn2=new JButton("CHECK ORDER STATUS");
                btn1.setVisible(true);
                btn2.setVisible(true);
                btn2.setSize(30,60);
                
                
                btn3=new JButton("ADMIN LOGIN");
                btn3.setVisible(true);
                btn3.setSize(30,60);
                
		setVisible(true);
                background.add(btn1);
                background.add(btn2);
                background.add(btn3);
                
                PlaceOrder po = new PlaceOrder();
                this.btn1.addActionListener(po);
                CheckOrder co = new CheckOrder();
                this.btn2.addActionListener(co);
                AdminLogin al = new AdminLogin();
                this.btn3.addActionListener(al);
                
                
	}
        private class PlaceOrder implements ActionListener {
        
            
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                     String input = "menu.txt";
                     File inputFile = new File(input);
                     MainFrame guiFrame = new MainFrame(inputFile);
                     
                    }
                catch(FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null,"Error! Menu File not found!", "Please reinput", JOptionPane.ERROR_MESSAGE);
		}
    }
        }
            private class CheckOrder implements ActionListener {
        
            
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    OrderFrame gui;
                    gui = new OrderFrame();
                    dispose();
                    }
                catch(FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null,"Error! Menu File not found!", "Please reinput", JOptionPane.ERROR_MESSAGE);
		}
    }
            }
            private class AdminLogin implements ActionListener {
        
            
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                     
                     LogFrame log = new LogFrame();
                     dispose();
                    
    }
}
}     
            
