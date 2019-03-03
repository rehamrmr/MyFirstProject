/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarcipher;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author munerahbalhareth
 */
public class CaesarCipher extends JFrame implements ActionListener
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
     static JLabel frstlbl = new JLabel("choose the cryptosystem you like:");
     static JLabel scndlbl = new JLabel("Enter plaintext:");
     static JLabel thrdlbl = new JLabel("enter shift key:");
     static JLabel forthlbl = new JLabel("Enter cipher text:");
     static JLabel fifthlbl = new JLabel("enter shift key:");
     static JLabel encresltlbl = new JLabel("The ciphertext is:");
     static JLabel decresltlbl = new JLabel("the plaintext is");
     
     static JButton encbtn =new JButton("ENCRYPT");
     static JButton decbtn =new JButton("DECRYPT");
     static JButton go1 =new JButton("GO");
     static JButton go2 =new JButton("GO");
     static JButton don1 =new JButton("DONE");
     static JButton don2 =new JButton("DONE");
     static JButton rst1 =new JButton("RESET");
     static JButton rst2 =new JButton("RESET");

     static JTextField encplaintxt= new JTextField();
     static JTextField key1= new JTextField();
     static JTextArea area1 =new JTextArea();
     static JTextField decciphertxt= new JTextField();
     static JTextField key2= new JTextField();
     static JTextArea area2 =new JTextArea();

     static JFrame frame2= new JFrame();
     static JFrame frame3= new JFrame();
    
     static JPanel pnl =new JPanel();
     static JPanel pnltwo =new JPanel();
     static JPanel pnlthree =new JPanel();
 
    public static void main(String[] args)
    {
        CaesarCipher frm=new CaesarCipher();       
        frm.setTitle("CaesarCipher");        
        frm.setSize(300, 400);
        frm.setLayout(new FlowLayout());        
        frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frm.setVisible(true);   
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS)); 
        pnl.add(frstlbl);
        pnl.add(encbtn);
        pnl.add(decbtn);
        frm.add(pnl);
        encbtn.addActionListener(frm);
        decbtn.addActionListener(frm);
        go1.addActionListener(frm);
        go2.addActionListener(frm);
        don1.addActionListener(frm);
        don2.addActionListener(frm);
        rst1.addActionListener(frm);
        rst2.addActionListener(frm);
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        JLabel enclbl = new JLabel("ENCRYPTION!!!!");
enclbl.setFont(new Font("Tahoma", Font.BOLD, 13));
enclbl.setHorizontalAlignment(SwingConstants.CENTER);
enclbl.setBounds(121, 11, 132, 20);
pnltwo.add(enclbl);
pnltwo.add(scndlbl);
pnltwo.add(encplaintxt);
pnltwo.add(thrdlbl);
pnltwo.add(key1);
pnltwo.add(go1);
pnltwo.add(encresltlbl);
pnltwo.add(area1);
pnltwo.add(don1);
pnltwo.add(rst1);
frame2.add(pnltwo);
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        JLabel declbl = new JLabel("DECRYPTION!!!!");
declbl.setFont(new Font("Tahoma", Font.BOLD, 13));
declbl.setHorizontalAlignment(SwingConstants.CENTER);
declbl.setBounds(121, 11, 132, 20);
pnlthree.add(declbl);
pnlthree.add(forthlbl);
pnlthree.add(decciphertxt);
pnlthree.add(fifthlbl);
pnlthree.add(key2);
pnlthree.add(go2);
pnlthree.add(decresltlbl);
pnlthree.add(area2);
pnlthree.add(don2);
pnlthree.add(rst2);
frame3.add(pnlthree);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==encbtn){    
        frame2.setTitle("ENCRYPTION");        
        frame2.setSize(300, 400);
        frame2.setLayout(new FlowLayout());        
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setVisible(true);   
        pnltwo.setLayout(new BoxLayout(pnltwo, BoxLayout.Y_AXIS));
        }
            if(e.getSource()==go1){
                String plainText= encplaintxt.getText();
                int shiftKey=Integer.parseInt(key1.getText());
                String result=encrypt(plainText,shiftKey);
                area1.setText(result);
              }else if(e.getSource()==don1){
                  frame2.dispose();
                  encplaintxt.setText("");
                  key1.setText("");
                  area1.setText("");
              }else if(e.getSource()==rst1){
                  encplaintxt.setText("");
                  key1.setText("");
                  area1.setText("");
              }
          else if(e.getSource()==decbtn){    
        frame3.setTitle("DECRYPTION");        
        frame3.setSize(300, 400);
        frame3.setLayout(new FlowLayout());        
        frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame3.setVisible(true); 
        pnlthree.setLayout(new BoxLayout(pnlthree, BoxLayout.Y_AXIS));
        }
         if(e.getSource()==go2){
                String cipherText2= decciphertxt.getText();
                int shiftKey2=Integer.parseInt(key2.getText());
                String decresult=decrypt(cipherText2,shiftKey2);
                area2.setText(decresult);  
              }else if(e.getSource()==don2){
                 frame3.dispose();
                 decciphertxt.setText("");
                  key2.setText("");
                  area2.setText("");
              }else if(e.getSource()==rst2){
                  decciphertxt.setText("");
                  key2.setText("");
                  area2.setText("");
              }   
}   
public static String encrypt(String plainText, int Key)
    {
        plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++)
        {
            int Position = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (Key + Position) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }
 
    public static String decrypt(String cipherText2, int Key2)
    {
        cipherText2 = cipherText2.toLowerCase();
        String plainText2 = "";
        for (int i = 0; i < cipherText2.length(); i++)
        {
            int Position = ALPHABET.indexOf(cipherText2.charAt(i));
            int keyVal = (Position - Key2) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText2 += replaceVal;
        }
        return plainText2;
    }
}




