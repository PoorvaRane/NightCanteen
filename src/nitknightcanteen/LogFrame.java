/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nitknightcanteen;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class LogFrame extends JFrame
{
    JLabel lblogin = new JLabel("User Login", JLabel.CENTER);
    JLabel luser = new JLabel("  Username");
    JLabel lpass = new JLabel("  Password");
    
    JTextField txuser = new JTextField(15);
    JPasswordField pass = new JPasswordField(15);
    
    JButton blogin = new JButton("Login");
    
    public LogFrame()
    {
        setTitle("User Login");
        setSize(300,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        add("North",lblogin);
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,2));
        p.add(luser);
        p.add(txuser);
        p.add(lpass);
        p.add(pass);
        
        add("Center",p);
        
        p = new JPanel();
        p.add(blogin);
        add("South",p);
        
        blogin.addActionListener(new btn());
    }
    
    class btn implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String puname = txuser.getText();
            String ppaswd = pass.getText();
            if(puname.equals("test") && ppaswd.equals("12345")) 
            {
                NewFrame regFace;
                try {
                    regFace = new NewFrame();
                    regFace.setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LogFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                dispose();   
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Wrong Password / Username");
                txuser.setText("");
                pass.setText("");
                txuser.requestFocus();
            }
        }
    }
    

}

    