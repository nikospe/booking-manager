
package basics;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class writeOfferGui extends JFrame implements ActionListener{
    
    private JButton routeOfferBt;
    private JButton driverOfferBt;
    private JButton carOfferBt;
    private JButton cancelBt;
 
    
    public writeOfferGui() {
        this.setTitle("~OFFER~");
        this.setSize(250,120);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        //this.pack();
        Container contentPn = this.getContentPane();
        contentPn.setLayout(new FlowLayout());
        

        routeOfferBt = new JButton("GO TO ROUTE");
        routeOfferBt.addActionListener(this);
        contentPn.add(routeOfferBt);
        cancelBt = new JButton("CANCEL");
        cancelBt.addActionListener(this);
        contentPn.add(cancelBt);
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == routeOfferBt) {
            routeOfferDetails routeOffer = new routeOfferDetails();
            setVisible(false);
        }
        else if (evt.getSource()==cancelBt) {
            setVisible(false);
        }
    } 
}