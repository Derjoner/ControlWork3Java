import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffGUI extends JFrame{
    private JPanel staffPanel;
    private JLabel staffLabel;
    private JButton addButton;
    private JButton removeButton;
    private JButton staffButton;
    private JButton exitButton;
    StaffGUI(Canteen canteen){
        setTitle("Столовая");
        setContentPane(staffPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=300;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkingCanteenGUI workingCanteenGUI = new WorkingCanteenGUI(canteen);
                dispose();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStaff addStaff = new AddStaff(canteen);
                dispose();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveStaffGUI removeStaffGUI = new RemoveStaffGUI(canteen);
                dispose();
            }
        });
        staffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoStaffGUI infoStaffGUI = new InfoStaffGUI(canteen);
                dispose();
            }
        });
    }
}
