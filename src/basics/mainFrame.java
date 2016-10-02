
package basics;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class mainFrame extends JFrame implements ActionListener{
    
    private JButton readOfferBt;
    private JButton writeOfferBt;
    private JButton readRequestBt;
    private JButton writeRequestBt;
    private JButton showMatchingBt;
    private JButton saveMatchingBt;
    
    private JLabel offerLb;
    private JLabel requestLb;
    private JLabel matchingLb;
    
    public mainFrame() {
        this.setTitle("~MAIN~");
        this.setSize(250,148);
        this.setVisible(true);
        this.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        //this.pack();
        Container contentPn = this.getContentPane();
        contentPn.setLayout(new FlowLayout());
        
        offerLb = new JLabel("OFFER");
        contentPn.add(offerLb);
        readOfferBt = new JButton("READ");
        readOfferBt.addActionListener(this);
        contentPn.add(readOfferBt);
        writeOfferBt = new JButton("WRITE");
        writeOfferBt.addActionListener(this);
        contentPn.add(writeOfferBt);
        requestLb = new JLabel("REQUEST");
        contentPn.add(requestLb);
        readRequestBt = new JButton("READ");
        readRequestBt.addActionListener(this);
        contentPn.add(readRequestBt);
        writeRequestBt = new JButton("WRITE");
        writeRequestBt.addActionListener(this);
        contentPn.add(writeRequestBt);
        matchingLb = new JLabel("MATCHINGS");
        contentPn.add(matchingLb);
        showMatchingBt = new JButton("SHOW");
        showMatchingBt.addActionListener(this);
        contentPn.add(showMatchingBt);
        saveMatchingBt = new JButton("SAVE");
        saveMatchingBt.addActionListener(this);
        contentPn.add(saveMatchingBt);
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == readOfferBt) {  
            readOfferGui readOffer = new readOfferGui();
        }
        else if (evt.getSource() == writeOfferBt) {
            writeOfferGui detailsForOffer = new writeOfferGui();
        }
        else if (evt.getSource() == readRequestBt) {
            readRequestGui readRequest = new readRequestGui();
        }
        else if (evt.getSource() == writeRequestBt) {
            writeRequestGui detailsForRequest = new writeRequestGui();
        }
        else if (evt.getSource() == showMatchingBt) {
            showMatchingsGui showMatchings = new showMatchingsGui();
        }
        else if (evt.getSource() == saveMatchingBt) {
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
            saveMatchingsGui saveMatchings = new saveMatchingsGui();
        }
    }
}
