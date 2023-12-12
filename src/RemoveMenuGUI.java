import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveMenuGUI extends JFrame {
    private JPanel removePanel;
    private JLabel labelRem;
    private JLabel labelName;
    private JTextField nameInput;
    private JButton buttonRemove;
    private JButton exitButton;
    RemoveMenuGUI(Canteen canteen){
        setTitle("Столовая");
        setContentPane(removePanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=350;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGUI menuGUI = new MenuGUI(canteen);
                dispose();
            }
        });
        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameInput.getText();
                boolean flag=false;
                if(canteen.getMenu().isEmpty()){
                    JOptionPane.showMessageDialog( null, "Список блюд пуст" , "Удаление",
                            JOptionPane.INFORMATION_MESSAGE );
                }else{
                    for (Menu menu : canteen.getMenu()){
                        if(menu.getNameDish().equals(name)){
                            canteen.removeMenu(menu);
                            JOptionPane.showMessageDialog( null,
                                    "<Блюдо «" + name + "» удалено" , "Удаление",
                                    JOptionPane.INFORMATION_MESSAGE ); flag=true; break;
                        }
                    }
                    if(!flag){
                        JOptionPane.showMessageDialog( null,
                                "<Блюдо «" + name + "» не найдено" , "Удаление",
                                JOptionPane.INFORMATION_MESSAGE );
                    }
                }
                nameInput.setText("");
            }
        });
    }
}
