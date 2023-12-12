import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WorkingCanteenGUI extends JFrame{
    private JPanel workingPanel;
    private JLabel labelWorking;
    private JButton menuButton;
    private JButton staffButton;
    private JButton productsButton;
    private JButton buttonTime;
    private JButton infoButton;

    WorkingCanteenGUI(Canteen canteen){
        setTitle("Столовая");
        setContentPane(workingPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=350;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        productsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductsGUI productsGUI = new ProductsGUI(canteen);
                dispose();
            }
        });
        buttonTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
                String[] time = timeStamp.split(":");
                int t1 = Integer.parseInt(time[0]);
                int t2 = Integer.parseInt(time[1]);
                JOptionPane.showMessageDialog( null,
                        canteen.time(t1, t2), "Столовая создана",
                        JOptionPane.INFORMATION_MESSAGE );
            }
        });
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog( null, canteen.Output() , "Информация о столовой",
                        JOptionPane.INFORMATION_MESSAGE );
            }
        });
        staffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffGUI staffGUI = new StaffGUI(canteen);
                dispose();
            }
        });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGUI menuGUI = new MenuGUI(canteen);
                dispose();
            }
        });
    }
}
