import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateGUI extends JFrame{
    private JLabel labelText;
    private JLabel nameCanteen;
    private JTextField nameCanteenInput;
    private JPanel createPanel;
    private JLabel dateCreation;
    private JTextField dateCreationInput;
    private JLabel workingHours;
    private JButton create;
    private JTextField workingHoursInput;

    CreateGUI(){
        setTitle("Столовая");
        setContentPane(createPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=300;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameCanteenInput.getText();
                String[] date = dateCreationInput.getText().split("\\.");
                String[] openingHours = workingHoursInput.getText().replace(' ', ':').split(":");
                Canteen canteen = new Canteen(name, Integer.parseInt(date[0]), Integer.parseInt(date[1]),
                        Integer.parseInt(date[2]), Integer.parseInt(openingHours[0]), Integer.parseInt(openingHours[1]),
                        Integer.parseInt(openingHours[2]), Integer.parseInt(openingHours[3]));
                JOptionPane.showMessageDialog( null, canteen.Output() , "Столовая создана",
                        JOptionPane.INFORMATION_MESSAGE );
                WorkingCanteenGUI workingCanteenGUI = new WorkingCanteenGUI(canteen);
                dispose();
            }
        });
    }
}
