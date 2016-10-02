
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


public class readOfferGui extends JFrame implements ActionListener{
    
    private JTextArea txtReadOfferAr;
    private JScrollPane scrollOffersPn;
    private JButton cancelBt;
    private int i;
    
    public readOfferGui() {
    
        this.setTitle("~OFFER~");
        this.setSize(700,260);
        this.setVisible(true);
        this.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        //this.pack();
        Container contentPn = this.getContentPane();
        contentPn.setLayout(new FlowLayout());
        i=1;
        cancelBt = new JButton("BACK");
        cancelBt.addActionListener(this);
        contentPn.add(cancelBt);
        
        txtReadOfferAr = new JTextArea(10,60);
        txtReadOfferAr.setLineWrap(true);
        scrollOffersPn = new JScrollPane(txtReadOfferAr);
        scrollOffersPn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        try {
            File  offerFileIn= new File("Offers.txt");
            Scanner offerScan = new Scanner(offerFileIn);
            while(offerScan.hasNextLine()) {
                txtReadOfferAr.append("Offer :"+i+"\n");
                txtReadOfferAr.append("Route :");
                txtReadOfferAr.append(offerScan.nextLine());
                txtReadOfferAr.append("\n");
                txtReadOfferAr.append("Car :");
                txtReadOfferAr.append(offerScan.nextLine());
                txtReadOfferAr.append("\n");
                txtReadOfferAr.append("Driver :");
                txtReadOfferAr.append(offerScan.nextLine());
                txtReadOfferAr.append("\n\n");
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
        contentPn.add(scrollOffersPn);
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == cancelBt) {
            setVisible(false);
        }
    }  
}
