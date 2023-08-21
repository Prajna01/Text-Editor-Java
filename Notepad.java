package notepad;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {
    JTextArea area;
    JScrollPane pane;
    String text;
    Notepad(){
        setBounds(0,0,1950,1050);
        JMenuBar menubar = new JMenuBar();  //create a object of menu bar
        JMenu file = new JMenu("File");  // create item in menu bar called file
        JMenuItem newdoc = new JMenuItem("New") ;// inside that file create item called new, open, save, print,exit
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); // assign a key event for particular object
        newdoc.addActionListener(this); // when we click on this it have to performed certain task

        JMenuItem opendoc = new JMenuItem("Open") ;// similarly for open file also
        opendoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        opendoc.addActionListener(this);

        JMenuItem savedoc = new JMenuItem("Save") ;
        savedoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        savedoc.addActionListener(this);

        JMenuItem printdoc = new JMenuItem("Print") ;
        printdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        printdoc.addActionListener(this);

        JMenuItem exitdoc = new JMenuItem("Exit") ;
        exitdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
        exitdoc.addActionListener(this);

        file.add(newdoc);// then we append those objects to our file object in menu bar
        file.add(opendoc);
        file.add(savedoc);
        file.add(printdoc);
        file.add(exitdoc);


        JMenu edit = new JMenu("Edit");
        JMenuItem copydoc = new JMenuItem("Copy") ;
        copydoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        copydoc.addActionListener(this);

        JMenuItem cutdoc = new JMenuItem("Cut") ;
        cutdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        cutdoc.addActionListener(this);


        JMenuItem pastedoc = new JMenuItem("Paste") ;
        pastedoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        pastedoc.addActionListener(this);

        JMenuItem selectalldoc = new JMenuItem("Select All") ;
        selectalldoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        selectalldoc.addActionListener(this);

        edit.add(copydoc);
        edit.add(cutdoc);
        edit.add(pastedoc);
        edit.add(selectalldoc);

        JMenu help = new JMenu("Help");
        JMenuItem aboutdoc = new JMenuItem("About the Notepad");
        aboutdoc.addActionListener(this);

        help.add(aboutdoc);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);
        setJMenuBar(menubar); // we set menu bar in frame
        area = new JTextArea(); // we create a text area using Jtextarea
        area.setFont((new Font(" SAN_SERIF", Font.PLAIN, 18))); // set the font style
        area.setLineWrap(true); // line not cross the width of the frame break to new row
        area.setWrapStyleWord(true); // if word not adjust in allocated area then it will comes to new row

        pane = new JScrollPane(area);// create a scrollbar
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane, BorderLayout.CENTER);



    }
    public void actionPerformed(ActionEvent ae){ // create for some action took placed when we click on objects
        if(ae.getActionCommand().equals("New")){ // if its new file then it will open a new file
            area.setText("");

        }else if (ae.getActionCommand().equals("Open")){
            JFileChooser chooser = new JFileChooser(); // it will opens directory of the system
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only.txt files", "txt");
            chooser.addChoosableFileFilter(restrict);
            int action = chooser.showOpenDialog(this);
            if (action != JFileChooser.APPROVE_OPTION){
                return;
            }
            File file = chooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                area.read(reader, null);
            }catch(Exception e){}

        }else if (ae.getActionCommand().equals("Save")){
            JFileChooser saveas = new JFileChooser();
            saveas.setApproveButtonText("Save");
            int action = saveas.showOpenDialog(this);
            if (action != JFileChooser.APPROVE_OPTION){
                return;
            }

            File filename = new File(saveas.getSelectedFile()+".txt");
            BufferedWriter outFile = null;
            try {
                outFile = new BufferedWriter(new FileWriter(filename));
                area.write(outFile);

            }catch (Exception e){}
        }else if (ae.getActionCommand().equals("Print")){
            try {
                area.print();

            }catch(Exception e){}

        }else if (ae.getActionCommand().equals("Exit")){
            System.exit(0);
        }else if (ae.getActionCommand().equals("Copy")){
            text = area.getSelectedText();


        }else if (ae.getActionCommand().equals("Paste")){
            area.insert(text, area.getCaretPosition());
        }else if (ae.getActionCommand().equals("Cut")){
            text = area.getSelectedText();
            area.replaceRange("",area.getSelectionStart(), area.getSelectionEnd());
        }else if (ae.getActionCommand().equals("Select All")){
            area.selectAll();

        }else if (ae.getActionCommand().equals("About the Notepad")){
            new About().setVisible(true);
        }

    }
    public static void main(String[] args) {

        new Notepad().setVisible(true);
    }
}
