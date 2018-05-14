
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

public class FrameSetStoc extends JFrame{
   
    private final JButton exit = new JButton("exit");
    private final JButton set = new JButton("Set");
    
    private final JTextField cod = new JTextField();
    private final JLabel codLabel = new JLabel("Cod: ");
    private final JTextField stoc= new JTextField();
    private final JLabel stocLabel = new JLabel("Stoc Nou: ");
    
    public FrameSetStoc()
    {
        setTitle("Seteaza stocul");
        setSize(400,400);
        setLocation(800,300);
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
           setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("stoc.jpg")))));
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
        set.setBounds(280,350,100,20);
        exit.setBounds(280,300,100,20);
        
        cod.setBounds(100,10, 100,20);
        codLabel.setBounds(20,10,100,20);
        stoc.setBounds(100,40,100,20);
        stocLabel.setBounds(20,40,100,20);
        
        add(cod);
        add(codLabel);
        add(stoc);
        add(stocLabel);
        add(exit);
        add(set);
            
    }
    
    
    private void initEvent()
    {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               stoc(e);
            }
        });
    }
    
    private void stoc (ActionEvent e)
    {
        try{
        String codField = cod.getText();
        String stocField = stoc.getText();
        Connection con = DBUtil.getConnection(DBType.MYSQLDB);
        String sql = "UPDATE componenta SET stoc = ? WHERE cod_produs = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,stocField);
        pstmt.setString(2,codField);
        pstmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Stoc updated", "Insert", JOptionPane.INFORMATION_MESSAGE);
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}

