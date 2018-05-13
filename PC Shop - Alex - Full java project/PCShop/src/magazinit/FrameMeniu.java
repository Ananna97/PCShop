
package magazinit;

import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FrameMeniu extends JFrame{

     private final JButton adauga = new JButton("Adauga");
     private final JButton exit = new JButton("Iesire");
    
    public FrameMeniu() {
        setTitle("MAGAZIN IT");
        setSize(800,450);
        setLocation(100,100);
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("sapphire.jpg")))));
        }catch(IOException e)
        {
            System.out.println("Imageine nesuportate");
        }
        pack();
        
        initEvent();
        InitComponente();
    }
    
    private void InitComponente(){
       adauga.setBounds(300,30,200,50);
       exit.setBounds(700,400,80,25);
       
       
       add(adauga);
       add(exit);

}
    
    private void initEvent()
    {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        adauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               FrameAdaugare f2 = new FrameAdaugare();
               
            }
        });
    }
   public static void main(String[] args) {
       
        FrameMeniu meniu = new FrameMeniu();
        meniu.setVisible(true);
        meniu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
