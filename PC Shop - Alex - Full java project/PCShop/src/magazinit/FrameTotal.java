
package magazinit;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;

public class FrameTotal extends JFrame{
   
    private final JButton exit = new JButton("exit");
    private final JButton show = new JButton("show");
    
    private final JTextField categorie = new JTextField();
    private final JLabel categorieLabel = new JLabel("Categorie: ");
    
    public FrameTotal()
    {
        setTitle("Pretul total al unei categori");
        setSize(400,400);
        setLocation(800,300);
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("total.jpg")))));
        }catch(IOException e)
        {
            System.out.println("Imageine nesuportate");
        }
        pack();
        setVisible(true);
        
        initEvent();
        InitComponente();
    }
   
    private void InitComponente()
    {
        show.setBounds(280,350,100,20);
        exit.setBounds(280,300,100,20);
        
        categorie.setBounds(100,10, 100,20);
        categorieLabel.setBounds(20,10,100,20);
        
        
        add(categorie);
        add(categorieLabel);
        add(exit);
        add(show);
            
    }
    
    
    private void initEvent()
    {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show(e);
            }
        });
    }
    
    private void show (ActionEvent e)
    {
        try{
        String categorieField = categorie.getText();
        Connection con = DBUtil.getConnection(DBType.MYSQLDB);
       
        String sql = "SELECT  sum(pret*stoc)  FROM componenta WHERE categorie = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        pstmt.setString(1,categorieField);
        ResultSet rs= pstmt.executeQuery();
        while (rs.next())
        {
            JOptionPane.showMessageDialog(null, rs.getString(1), "Totalul este", JOptionPane.INFORMATION_MESSAGE);
        }
       
       
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}

