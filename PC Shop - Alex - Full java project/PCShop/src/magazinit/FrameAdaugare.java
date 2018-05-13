package magazinit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;

public class FrameAdaugare extends JFrame{
    private final JButton exit = new JButton("exit");
    private final JButton insert = new JButton("insert");

    private final JTextField cod = new JTextField();
    private final JTextField marca = new JTextField();
    private final JTextField categorie = new JTextField();
    private final JTextField pret = new JTextField();
    private final JTextField an = new JTextField();
    private final JTextField garantie = new JTextField();
    private final JTextField producator = new JTextField();
    private final JTextField tara = new JTextField();
    private final JTextField stoc = new JTextField();

    private final JLabel codLabel = new JLabel("Cod: ");
    private final JLabel marcaLabel = new JLabel("Marca: ");
    private final JLabel categorieLabel = new JLabel("Categorie: ");
    private final JLabel pretLabel = new JLabel("Pret: ");
    private final JLabel anLabel = new JLabel("An: ");
    private final JLabel garantieLabel = new JLabel("Garantie: ");
    private final JLabel producatorLabel = new JLabel("Producator: ");
    private final JLabel taraLabel = new JLabel("Tara: ");
    private final JLabel stocLabel = new JLabel("Stoc: ");
    
    
    public FrameAdaugare(){
        setTitle("AdaugareProdus");
        setSize(400,400);
        setLocation(800,300);
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
         try{
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("adaugare.jpg")))));
        }catch(IOException e)
        {
            System.out.println("Imageine nesuportate");
        }
        pack();
        
        initComponent();
        initEvent();
    }
     private void initComponent(){
        exit.setBounds(300,330,80,25);
        insert.setBounds(300,300,80,25);

        add(exit);
        add(insert);

        cod.setBounds(100,10, 100,20);
        codLabel.setBounds(20,10,100,20);
        marca.setBounds(100,40,100,20);
        marcaLabel.setBounds(20,40,100,20);
        categorie.setBounds(100,70,100,20);
        categorieLabel.setBounds(20,70,100,20);
        pret.setBounds(100, 100, 120, 20);
        pretLabel.setBounds(20,100,120,20);
        an.setBounds(100,130,120,20);
        anLabel.setBounds(20,130,120,20);
        garantie.setBounds(100,160,120,20);
        garantieLabel.setBounds(20,160,120,20);
        producator.setBounds(100,190,120,20);
        producatorLabel.setBounds(20,190,120,20);
        tara.setBounds(100,220,120,20);
        taraLabel.setBounds(20,220,120,20);
        stoc.setBounds(100,250,120,20);
        stocLabel.setBounds(20,250,120,20);

        add(cod);
        add(codLabel);
        add(marca);
        add(marcaLabel);
        add(categorie);
        add(categorieLabel);
        add(an);
        add(anLabel);
        add(garantie);
        add(garantieLabel);
        add(producator);
        add(producatorLabel);
        add(tara);
        add(taraLabel);
        add(stoc);
        add(stocLabel);
        add(pret);
        add(pretLabel);
        
    }
      private void initEvent(){
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insert(e);
            }
        });
    }
      private void insert(ActionEvent e){
        try{
            String codField = cod.getText();
            String marcaField = marca.getText();
            String categorieField = categorie.getText();
            String pretField = pret.getText();
            String anField = an.getText();
            String garantieField = garantie.getText();
            String producatorField = producator.getText();
            String taraField = tara.getText();
            String stocField = stoc.getText();
            Connection con = DBUtil.getConnection(DBType.MYSQLDB);
            String sql = "insert into componenta values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,codField);
            pstmt.setString(2, marcaField);
            pstmt.setString(3, categorieField);
            pstmt.setString(4, pretField);
            pstmt.setString(5, anField);
            pstmt.setString(6, garantieField);
            pstmt.setString(7, producatorField);
            pstmt.setString(8, taraField);
            pstmt.setString(9, stocField);
           // pstmt.setString(10, "");
            pstmt.execute();

            JOptionPane.showMessageDialog(null, "row successfully inserted", "Insert", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     /* public static void main(String[] args) {
        FrameAdaugare f = new FrameAdaugare();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
