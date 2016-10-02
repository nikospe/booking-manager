
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

public class routeOfferDetails extends JFrame implements ActionListener{
    
    private JTextField txtLeaveFromTown; 
    private JTextField txtGoToTown; 
    private JTextField txtDepartureDay; 
    private JTextField txtEarlyDepTime; 
    private JTextField txtLateDepTime; 
    private JTextField txtPitStops; 
    
    private JButton cancelBt;
    private JButton saveBt;
    
    private JLabel leaveFromTownLb;
    private JLabel goToTownLb;
    private JLabel departureDayLb;
    private JLabel earlyDepTimeLb;
    private JLabel lateDepTimeLb;
    private JLabel pitStopsLb;
    
       
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
    
    public routeOfferDetails() {
        this.setTitle("~ROUTE~");
        this.setSize(260,360);
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
        //readOfferBt.addActionListener(this);
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
        lateDepTimeLb = new JLabel("Late departure time :");
        contentPn.add(lateDepTimeLb);
        lateHourModel = new SpinnerNumberModel(12, 1, 24, 1);
        lateHourSpinner = new JSpinner(lateHourModel);
        lateMinutesModel = new SpinnerNumberModel(30, 0, 60, 1);
        lateMinutesSpinner = new JSpinner(lateMinutesModel);
        contentPn.add(lateHourSpinner);
        contentPn.add(lateMinutesSpinner);

        pitStopsLb = new JLabel("Pit stops :");
        contentPn.add(pitStopsLb);
        txtPitStops = new JTextField(20);
        contentPn.add(txtPitStops);
        saveBt = new JButton("GO TO CAR");
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
            
            String leaveFromTown = txtLeaveFromTown.getText();
            String goToTown = txtGoToTown.getText();
            String depDate = null;
            String earlyDepTime = null;
            String lateDepTime = null;
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
            String pitStopGui = txtPitStops.getText();
            try {
                FileWriter out = new FileWriter("Offers.txt",true);
                out.write(leaveFromTown+";");
                out.write(goToTown+";");
                out.write(depDate+";");
                out.write(earlyDepTime+";");
                out.write(lateDepTime+";");
                out.write(pitStopGui+"\n");
                out.close();
            } catch (IOException ex) {
                System.out.println("File not found!");
            }
            carOfferDetails carOffer = new carOfferDetails();
            setVisible(false);
        }
    }
}