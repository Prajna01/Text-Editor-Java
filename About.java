package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    JButton b1;
    About(){
        setBounds(600, 200 ,700,600);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/windows.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(150,40,400,80);
        add(l1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notebook-removebg-preview.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(50,200,50,50);
        add(l2);
        JLabel l3 = new JLabel("<html>Project for java<br>Centurion University <br> TextPad, All Rights Reserved <br> Textpad is the word processing program<br> which allows changing of text compiler file, <br> Textpad is simple text editor for basic text editing program<br> which enables computer used to create documents</html>");
        l3.setBounds(150, 130, 500, 300);
        l3.setFont(new Font("SAN_SERIF",Font.PLAIN, 18));
        add(l3);
        b1 = new JButton("OK");
        b1.setBounds(580,500,80,25);
        b1.addActionListener(this);
        add(b1);

    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new About().setVisible(true);
    }
}
