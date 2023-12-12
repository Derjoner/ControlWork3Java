import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame{
    private JPanel menuPanel;
    private JLabel menuLable;
    private JButton Addbutton;
    private JButton Removebutton;
    private JButton Infobutton;
    private JButton buttonExit;

    MenuGUI(Canteen canteen){
        setTitle("Столовая");
        setContentPane(menuPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=350;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkingCanteenGUI workingCanteenGUI = new WorkingCanteenGUI(canteen);
                dispose();
            }
        });
        Addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDishGUI addDishGUI = new AddDishGUI(canteen);
                dispose();
            }
        });
        Removebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveMenuGUI removeMenuGUI = new RemoveMenuGUI(canteen);
                dispose();
            }
        });
        Infobutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuInfo menuInfo = new MenuInfo(canteen);
                dispose();
            }
        });
    }
}
