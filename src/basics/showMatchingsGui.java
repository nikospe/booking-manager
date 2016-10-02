
package basics;

import basics.Offer;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class showMatchingsGui extends JFrame implements ActionListener{
    
    private JTextArea txtReadMatchingsAr;
    private JScrollPane scrollMatchingsPn;
    private JButton cancelBt;
    private int i;
    
    public showMatchingsGui() {
    
        this.setTitle("~MATCHINGS~");
        this.setSize(700,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        //this.pack();
        Container contentPn = this.getContentPane();
        contentPn.setLayout(new FlowLayout());
        
        cancelBt = new JButton("BACK");
        cancelBt.addActionListener(this);
        contentPn.add(cancelBt);
        i=1;
        txtReadMatchingsAr = new JTextArea(10,60);
        txtReadMatchingsAr.setLineWrap(true);
        scrollMatchingsPn = new JScrollPane(txtReadMatchingsAr);
        scrollMatchingsPn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ArrayList<Offer> offers = null;
        try {
            offers = Control.readOffersFromFile("Offers.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        ArrayList<Request> requests = null;
        try {
            requests = Control.readRequestsFromFile("Requests.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        Control.findMatchings(offers,requests);
        try {
            File  matchingFileIn= new File("output.txt");
            Scanner matchingScan = new Scanner(matchingFileIn);
            while(matchingScan.hasNextLine()) {
                txtReadMatchingsAr.append(matchingScan.nextLine());
                txtReadMatchingsAr.append("\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
        contentPn.add(scrollMatchingsPn);
        
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource()==cancelBt) {
            setVisible(false);
        }
    }

}
