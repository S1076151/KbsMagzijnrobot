/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tspsysteem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author TimRoskam
 */
    public class TSPGUI extends JFrame implements ActionListener {
    private JTextField jtAantal;
    private JButton   jbShuffle;
    
    public TSPGUI() {
    setTitle("Shufflen Pakketten");    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new FlowLayout(FlowLayout.CENTER,10, 20));
    setSize(1920, 1080);   
    PaintPanel panel = new PaintPanel(40, 40);
    add(panel);
    
    jtAantal = new JTextField(6);
    add(jtAantal);
    jbShuffle = new JButton("Shufflen Pakketten");
    add(jbShuffle);
    
      setVisible(true);   
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       
        
    }
    
}
