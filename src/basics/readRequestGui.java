
package basics;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class readRequestGui extends JFrame implements ActionListener{
    
    private JTextArea txtReadRequestAr;
    private JScrollPane scrollRequestsPn;
    private JButton cancelBt;
    private int i;
    
    public readRequestGui() {
    
        this.setTitle("~REQUEST~");
        this.setSize(700,260);
        this.setVisible(true);
        this.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        //this.pack();
        Container contentPn = this.getContentPane();
        contentPn.setLayout(new FlowLayout());
        cancelBt = new JButton("BACK");
        cancelBt.addActionListener(this);
        contentPn.add(cancelBt);
        i=1;
        txtReadRequestAr = new JTextArea(10,60);
        txtReadRequestAr.setLineWrap(true);
        scrollRequestsPn = new JScrollPane(txtReadRequestAr);
        scrollRequestsPn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        try {
            File requestFileIn = new File("Requests.txt");
            Scanner requestScan = new Scanner(requestFileIn);
            while(requestScan.hasNextLine()) {
                txtReadRequestAr.append("Request :"+i+"\n");
                txtReadRequestAr.append(requestScan.nextLine());
                txtReadRequestAr.append("\n\n");
                i++;
            }
        }catch(FileNotFoundException fnfex){
                System.out.println("File not found!");
            } 
        contentPn.add(scrollRequestsPn);
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource()==cancelBt) {
            setVisible(false);   
        }
    }
}
