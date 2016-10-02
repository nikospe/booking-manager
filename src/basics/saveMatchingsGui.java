
package basics;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class saveMatchingsGui extends JFrame implements ActionListener{
    
    private JButton cancelBt;
    
    private JLabel matchingsSaved;
    
    public saveMatchingsGui() {
    
        this.setTitle("~MATCHINGS~");
        this.setSize(280,90);
        this.setVisible(true);
        this.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        //this.pack();
        Container contentPn = this.getContentPane();
        contentPn.setLayout(new FlowLayout());

        
        matchingsSaved = new JLabel("The matchings have been saved!");
        contentPn.add(matchingsSaved);
        cancelBt = new JButton("OK");
        cancelBt.addActionListener(this);
        contentPn.add(cancelBt);
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource()==cancelBt) {
            setVisible(false);
        }
    }
}
