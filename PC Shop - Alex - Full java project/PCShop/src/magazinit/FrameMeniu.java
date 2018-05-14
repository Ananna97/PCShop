
package magazinit;

import java.awt.Color;
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
     private final JButton sterge = new JButton("Sterge");
     private final JButton but1 = new JButton("Vanzare");
     private final JButton but2 = new JButton("Set Stoc");
     private final JButton but3 = new JButton("Pret Total Categorie");
    
    public  FrameMeniu () {
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
       sterge.setBounds(300,90,200,50);
       but1.setBounds(300,150,200,50);
       but2.setBounds(300,210,200,50);
       but3.setBounds(300,270,200,50);
      
       
       
       add(adauga);
       add(exit);
       add(sterge);
       add(but1);
       add(but2);
       add(but3);
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
        sterge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               FrameDelete fd1 = new FrameDelete();
               
            }
        });
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               FrameVanzare fv1 = new FrameVanzare();
               
            }
        });
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               FrameSetStoc fss1 = new FrameSetStoc();
               
            }
        });
        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               FrameTotal ft1 = new FrameTotal();
               
            }
        });
         
    }
   public static void main(String[] args) {
       
        FrameMeniu meniu = new FrameMeniu();
        meniu.setVisible(true);
        meniu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
