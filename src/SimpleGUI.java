import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel labelText;
    private JLabel labelL;
    private JButton createCanteen;
    private JLabel nameLabel;

    SimpleGUI(){
        setTitle("Столовая");
        setContentPane(mainPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=300;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        createCanteen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateGUI createGUI = new CreateGUI();
                dispose();
            }
        });
    }
}
