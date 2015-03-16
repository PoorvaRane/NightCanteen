/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nitknightcanteen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.io.FileNotFoundException;
import java.io.File;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
/**
 * This class creates the main frame and serves as the primary interface
 * We employ inheritance to absorb the features of JFrame while adding our own
 * We split the frame into one horizontal panel on the right for displaying items ordered
 * A main/center panel for displaying all the menu items
 * A lower panel for placing orders/clearing orders
 */
public class OrderFrame extends JFrame {

	private BigDecimal totalCost;
	private MenuReader OrdersRead;
	private JPanel receipt;
	private JPanel centerPanel;
	private JTextField orderPrice;
	private JTextPane orderItems;
	private String itemInformation;
	
	public OrderFrame() throws FileNotFoundException{		
		File orders;
                orders = new File("update.txt");
                JPanel OrderPanel = new JPanel();
                getContentPane().add(OrderPanel);
                OrderPanel.setLayout(new BorderLayout());
		OrderPanel.add(getOrders());
		fileUpdate();
		setSize(1370,740);
		setTitle("NITK NIGHT CANTEEN");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
        
        private void fileUpdate() throws FileNotFoundException
{
    File updateFile = new File("update.txt");
    Scanner f;
    f = new Scanner(updateFile);
    String str = "";
    while(f.hasNextLine())
    {
        str = str + f.nextLine() + "\n\n\n";
    }
    f.close();
   orderItems.setText(str);
}
        private JPanel getOrders() throws FileNotFoundException {
		
		receipt = new JPanel();
		JLabel label = new JLabel("Customer Order:");
		receipt.setLayout(new BorderLayout());
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BorderLayout());
		
		receipt.add(lowerPanel,BorderLayout.SOUTH);
		receipt.add(label, BorderLayout.NORTH);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0,1));
		
		orderItems = new JTextPane();
		centerPanel.add(orderItems);
	
		orderItems.setEditable(false);
		
		JScrollPane centerPanelScroller = new JScrollPane(centerPanel);
		receipt.add(centerPanelScroller, BorderLayout.CENTER);
		
		
		
		JButton placeOrder = new JButton("Go Back To Order");
		
		
		placeOrder.setPreferredSize(new Dimension(30,50));
		
		
		centerPanel.setBackground(Color.LIGHT_GRAY);
		placeOrder.setForeground(Color.BLUE);
		
		
		placeOrder.setFont(new Font ("Times New Roman", Font.BOLD,40));
		
		
		
		
		placeOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                            try {
                                /**
                                 * We call menu read and log our order. Also display an option pane to notify.
                                 * If there is no order, then an option pane will notify a user that there is not one
                                 * 
                                 */
                                FirstFrame fra=new FirstFrame();
                                dispose();
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(OrderFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
				
			}
			
		});
		/**
		 * Adding to the panel
		 */
		
		lowerPanel.add(placeOrder, BorderLayout.NORTH);
		
		lowerPanel.setBackground(Color.LIGHT_GRAY);
		receipt.setBackground(Color.WHITE);
                return receipt;
		
	}
}

    
