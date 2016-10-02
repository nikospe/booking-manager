
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class writeRequestGui extends JFrame implements ActionListener{
    
    private JTextField txtLeaveFromTown;
    private JTextField txtGoToTown;
    private JTextField txtEarlyDepTime;
    private JTextField txtLateDepTime;
    private JTextField txtPersonNumber;
    
    private JButton cancelBt;
    private JButton saveBt;
    
    private JLabel leaveFromTownLb;
    private JLabel goToTownLb;
    private JLabel departureDayLb;
    private JLabel earlyDepTimeLb;
    private JLabel LateDepTimeLb;
    private JLabel personNumberLb;
    
    private JSpinner daySpinner;
    private JSpinner monthSpinner;
    private JSpinner yearSpinner;
    private SpinnerNumberModel dayModel;
    private SpinnerNumberModel monthModel;
    private SpinnerNumberModel yearModel;
    private JSpinner earlyHourSpinner;
    private JSpinner earlyMinutesSpinner;
    private JSpinner lateHourSpinner;
    private JSpinner lateMinutesSpinner;
    private SpinnerNumberModel earlyMinutesModel;
    private SpinnerNumberModel earlyHourModel;
    private SpinnerNumberModel lateHourModel;
    private SpinnerNumberModel lateMinutesModel;
    
    public writeRequestGui() {
        this.setTitle("~REQUEST~");
        this.setSize(300,360);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        //this.pack();
        Container contentPn = this.getContentPane();
        contentPn.setLayout(new FlowLayout());

        leaveFromTownLb = new JLabel("Leave from town :");
        contentPn.add(leaveFromTownLb);
        txtLeaveFromTown = new JTextField(20);
        contentPn.add(txtLeaveFromTown);
        goToTownLb = new JLabel("Go to town :");
        contentPn.add(goToTownLb);
        txtGoToTown = new JTextField(20);
        contentPn.add(txtGoToTown);
        departureDayLb = new JLabel("Departure day :");
        contentPn.add(departureDayLb);

        dayModel = new SpinnerNumberModel(15, 1, 30, 1);
        daySpinner = new JSpinner(dayModel);
        contentPn.add(daySpinner);
        monthModel = new SpinnerNumberModel(6, 1, 12, 1);
        monthSpinner = new JSpinner(monthModel);
        contentPn.add(daySpinner);
        yearModel = new SpinnerNumberModel(11, 10, 12, 1);
        yearSpinner = new JSpinner(yearModel);
        contentPn.add(daySpinner);
        contentPn.add(monthSpinner);
        contentPn.add(yearSpinner);
  
        earlyDepTimeLb = new JLabel("Early departure time :");
        contentPn.add(earlyDepTimeLb);
        earlyHourModel = new SpinnerNumberModel(12, 1, 24, 1);
        earlyHourSpinner = new JSpinner(earlyHourModel);
        earlyMinutesModel = new SpinnerNumberModel(30, 0, 60, 1);
        earlyMinutesSpinner = new JSpinner(earlyMinutesModel);
        contentPn.add(earlyHourSpinner);
        contentPn.add(earlyMinutesSpinner);
        LateDepTimeLb = new JLabel("Late departure time :");
        contentPn.add(LateDepTimeLb);
      
        lateHourModel = new SpinnerNumberModel(12, 1, 24, 1);
        lateHourSpinner = new JSpinner(lateHourModel);
        lateMinutesModel = new SpinnerNumberModel(30, 0, 60, 1);
        lateMinutesSpinner = new JSpinner(lateMinutesModel);
        contentPn.add(lateHourSpinner);
        contentPn.add(lateMinutesSpinner);
        
        personNumberLb = new JLabel("Person number :");
        contentPn.add(personNumberLb);
        txtPersonNumber = new JTextField(20);
        contentPn.add(txtPersonNumber); 
        saveBt = new JButton("OK");
        saveBt.addActionListener(this);
        contentPn.add(saveBt);
        cancelBt = new JButton("CANCEL");
        cancelBt.addActionListener(this);
        contentPn.add(cancelBt);
        
        
    }
    
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==saveBt) {
            String leaveFromTown = null;
            String goToTown = null;
            String depDate = null;
            String earlyDepTime = null;
            String lateDepTime = null;
            String personNumber = null;
            leaveFromTown = txtLeaveFromTown.getText();
            goToTown = txtGoToTown.getText();
            int day = dayModel.getNumber().intValue();
            int month = monthModel.getNumber().intValue();
            int year = yearModel.getNumber().intValue();
            depDate = Integer.toString(day)+"-"+Integer.toString(month)+"-20"+Integer.toString(year);
            int eH = earlyHourModel.getNumber().intValue();
            int eM = earlyMinutesModel.getNumber().intValue();
            earlyDepTime = Integer.toString(eH)+":"+Integer.toString(eM);
            int lH = lateHourModel.getNumber().intValue();
            int lM = lateMinutesModel.getNumber().intValue();
            lateDepTime = Integer.toString(lH)+":"+Integer.toString(lM);
            personNumber = txtPersonNumber.getText();
            try {
                FileWriter out = new FileWriter("Requests.txt",true);
                out.write(leaveFromTown+";");
                out.write(goToTown+";");
                out.write(depDate+";");
                out.write(earlyDepTime+";");
                out.write(lateDepTime+";");
                out.write(personNumber+"\n");
                out.close();
                } catch (IOException ex) {
                    System.out.println("File not found!");
               }
               this.add(new JLabel("The request has been saved!"));
               setVisible(false);
            
        }
        else if (e.getSource()==cancelBt) {
            setVisible(false);
        }
    }
}
