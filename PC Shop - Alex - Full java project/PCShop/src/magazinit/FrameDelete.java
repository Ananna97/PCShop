
package magazinit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;

public class FrameDelete extends JFrame{
   
    private final JButton exit = new JButton("exit");
    private final JButton delete = new JButton("delete");
    
    private final JTextField cod = new JTextField();
    private final JLabel codLabel = new JLabel("Cod: ");
    
    public FrameDelete()
    {
        setTitle("Stergere");
        setSize(400,400);
        setLocation(800,300);
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("delete.jpg")))));
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
        delete.setBounds(280,350,100,20);
        exit.setBounds(280,300,100,20);
        
        cod.setBounds(100,10, 100,20);
        codLabel.setBounds(20,10,100,20);
        
        add(cod);
        add(codLabel);
        add(exit);
        add(delete);
            
    }
    
    
    private void initEvent()
    {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(e);
            }
        });
    }
    
    private void delete(ActionEvent e)
    {
        try{
        String codField = cod.getText();
        Connection con = DBUtil.getConnection(DBType.MYSQLDB);
        String sql = "DELETE FROM componenta WHERE cod_produs = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,codField);
        pstmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "row successfully deleted", "Insert", JOptionPane.INFORMATION_MESSAGE);
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}

