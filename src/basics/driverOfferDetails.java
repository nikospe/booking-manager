
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


public class driverOfferDetails extends JFrame implements ActionListener{

    private JTextField txtName;
    private JTextField txtSex;
    private JTextField txtComNumber;
    private JTextField txtEMail;
    private JTextField txtExpYears;
    
    private JButton cancelBt;
    private JButton saveBt;
    
    private JLabel nameLb;
    private JLabel sexLb;
    private JLabel comNumberLb;
    private JLabel eMailLb;
    private JLabel expYearsLb;
    
    public driverOfferDetails() {
    
        this.setTitle("~DRIVER~");
        this.setSize(250,320);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        //this.pack();
        Container contentPn = this.getContentPane();
        contentPn.setLayout(new FlowLayout());
        
        nameLb = new JLabel("Name :");
        contentPn.add(nameLb);
        txtName = new JTextField(20);
        contentPn.add(txtName);
        sexLb = new JLabel("Sex :");
        contentPn.add(sexLb);
        txtSex = new JTextField(20);
        contentPn.add(txtSex);
        comNumberLb = new JLabel("Com/tion number :");
        contentPn.add(comNumberLb);
        txtComNumber = new JTextField(20);
        contentPn.add(txtComNumber);
        eMailLb = new JLabel("E-mail :");
        contentPn.add(eMailLb);
        txtEMail = new JTextField(20);
        contentPn.add(txtEMail);
        expYearsLb = new JLabel("Experience years :");
        contentPn.add(expYearsLb);
        txtExpYears = new JTextField(20);
        contentPn.add(txtExpYears);
        saveBt = new JButton("OK");
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
            String name = txtName.getText();
            String sex = txtSex.getText();
            String comNumber = txtComNumber.getText();
            String eMail = txtEMail.getText();
            String expYears = txtExpYears.getText();
            try {
                FileWriter out = new FileWriter("Offers.txt",true);
                out.write(name+";");
                out.write(sex+";");
                out.write(comNumber+";");
                out.write(eMail+";");
                out.write(expYears+"\n");
                out.close();
            } catch (IOException ex) {
                System.out.println("File not found!");
            }
            setVisible(false);
        }
    }
}

