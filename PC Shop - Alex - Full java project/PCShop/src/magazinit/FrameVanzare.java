
package magazinit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;

public class FrameVanzare extends JFrame{
   
    private final JButton exit = new JButton("exit");
    private final JButton vinde = new JButton("Vinde");
    
    private final JTextField cod = new JTextField();
    private final JLabel codLabel = new JLabel("Cod: ");
    
    public FrameVanzare()
    {
        setTitle("Vinde produsul");
        setSize(400,400);
        setLocation(800,300);
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("vanzare.jpg")))));
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
        vinde.setBounds(280,350,100,20);
        exit.setBounds(280,300,100,20);
        
        cod.setBounds(100,10, 100,20);
        codLabel.setBounds(20,10,100,20);
        
        
        add(cod);
        add(codLabel);
        add(exit);
        add(vinde);
            
    }
    
    
    private void initEvent()
    {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        vinde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vinde(e);
            }
        });
    }
    
    private void vinde (ActionEvent e)
    {
        try{
        String codField = cod.getText();
        Connection con = DBUtil.getConnection(DBType.MYSQLDB);
        String sql = "UPDATE componenta SET stoc = stoc - 1 WHERE cod_produs = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,codField);
        pstmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Item successfully sold", "Insert", JOptionPane.INFORMATION_MESSAGE);
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}

