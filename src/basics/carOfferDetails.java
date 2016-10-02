
package basics;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class carOfferDetails extends JFrame implements ActionListener{

    private JTextField txtBrand;
    private JTextField txtModel;
    private JTextField txtBoardNumber;
    private JTextField txtTotalSeats;
    private JTextField txtAvailableSeats;
    
    private JButton cancelBt;
    private JButton saveBt;
    
    private JLabel brandLb;
    private JLabel modelLb;
    private JLabel boardNumberLb;
    private JLabel totalSeatsLb;
    private JLabel availableSeatsLb;
    
    public carOfferDetails(){
        
        this.setTitle("~CAR~");
        this.setSize(250,310);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        //this.pack();
        Container contentPn = this.getContentPane();
        contentPn.setLayout(new FlowLayout());
        
        brandLb = new JLabel("Brand :");
        contentPn.add(brandLb);
        txtBrand = new JTextField(20);
        contentPn.add(txtBrand);
        modelLb = new JLabel("Model :");
        contentPn.add(modelLb);
        txtModel = new JTextField(20);
        contentPn.add(txtModel);
        boardNumberLb = new JLabel("Board number :");
        contentPn.add(boardNumberLb);
        txtBoardNumber= new JTextField(20);
        contentPn.add(txtBoardNumber);
        totalSeatsLb = new JLabel("Total seats :");
        contentPn.add(totalSeatsLb);
        txtTotalSeats = new JTextField(20);
        contentPn.add(txtTotalSeats);
        availableSeatsLb = new JLabel("Available seats :");
        contentPn.add(availableSeatsLb);
        txtAvailableSeats = new JTextField(20);
        contentPn.add(txtAvailableSeats);
        saveBt = new JButton("GO TO DRIVER");
        saveBt.addActionListener(this);
        contentPn.add(saveBt);
        cancelBt = new JButton("CANCEL");
        cancelBt.addActionListener(this);
        contentPn.add(cancelBt);
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource()==cancelBt) {
            setVisible(false);
        }
        else if (evt.getSource()==saveBt) {
            String brand = txtBrand.getText();
            String model = txtModel.getText();
            String boardNumber = txtBoardNumber.getText();
            String totalSeats = txtTotalSeats.getText();
            String availableSeats = txtAvailableSeats.getText();
            try {
                FileWriter out = new FileWriter("Offers.txt",true);
                out.write(brand+";");
                out.write(model+";");
                out.write(boardNumber+";");
                out.write(totalSeats+";");
                out.write(availableSeats+"\n");
                out.close();
            } catch (IOException ex) {
                System.out.println("File not found!");
            }
            driverOfferDetails driverOffer = new driverOfferDetails();
            setVisible(false);
        }
    }
}
