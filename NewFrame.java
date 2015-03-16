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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class NewFrame extends JFrame {
    private JTextPane updateItems;
    JPanel panel = new JPanel();
    private JPanel receipt;
    private FileWriter writer;
    private BufferedReader reader;
    private BufferedWriter writer1;
    private String fstr;
    private Scanner s;
    private boolean success;
    private boolean success1;

NewFrame() throws FileNotFoundException
{

    getContentPane().add(panel);
    panel.setLayout(new BorderLayout());

    panel.add(getUpdate());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setSize(1370,740);
    setTitle("NITK NIGHT CANTEEN");
    setBackground(Color.WHITE);
    showUpdate();

}


private void showUpdate()
{
    File f=new File("update.txt");
    
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
    updateItems.setText(str);
}
private JPanel getUpdate() throws FileNotFoundException {
                receipt = new JPanel();
		JLabel label = new JLabel("Orders in Queue:");
		receipt.setLayout(new BorderLayout());
                updateItems=new JTextPane();
		receipt.add(updateItems);
                fileUpdate();
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BorderLayout());
		
		receipt.add(lowerPanel,BorderLayout.SOUTH);
		receipt.add(label, BorderLayout.NORTH);
                JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0,1));
		
		centerPanel.add(updateItems);
		
		updateItems.setEditable(false);
		
		JScrollPane centerPanelScroller = new JScrollPane(centerPanel);
		receipt.add(centerPanelScroller, BorderLayout.CENTER);
		
		
		
		JButton Jupdate = new JButton("Update Order");
		
		
		Jupdate.setPreferredSize(new Dimension(30,50));
		
		
		centerPanel.setBackground(Color.LIGHT_GRAY);
		Jupdate.setForeground(Color.BLUE);
		
		
		Jupdate.setFont(new Font ("Times New Roman", Font.BOLD,40));
		
		
		
		
		Jupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                            // dispose();
                            File ufile = new File("update.txt");
                            File temp = new File("temp.txt");
                            try {
                                                          
                                reader = new BufferedReader(new FileReader(ufile));
                                writer1 = new BufferedWriter(new FileWriter(temp));
                                String currentLine;
                                currentLine = reader.readLine();
                                
                                while((currentLine = reader.readLine()) != null) {
                                writer1.write(currentLine + System.getProperty("line.separator"));
                            }
                                
                                writer1.close(); 
                                reader.close(); 
                                boolean s1 = ufile.delete();
                                System.out.println(s1);
                                boolean successful = temp.renameTo(ufile);
                                System.out.println(successful);
                                fileUpdate();

                                
                            } catch (IOException ex) {
                                Logger.getLogger(NewFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            
			}
			
		});
		/**
		 * Adding to the panel
		 */
                JButton logOut= new JButton("Log Out");
		logOut.setPreferredSize(new Dimension(30,50));
		logOut.setForeground(Color.RED);
		logOut.setFont(new Font ("Times New Roman", Font.BOLD,40));
		logOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                            try {
                                // dispose();
                                FirstFrame frameagain = new FirstFrame();
                                dispose();
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(NewFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
			
		});
		/**
		 * Adding to the panel
		 */
		
		lowerPanel.add(Jupdate, BorderLayout.NORTH);
		
		lowerPanel.add(logOut, BorderLayout.SOUTH);
		
		lowerPanel.setBackground(Color.LIGHT_GRAY);
		receipt.setBackground(Color.WHITE);
		return receipt;
		
	}
}