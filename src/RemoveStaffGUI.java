import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveStaffGUI extends JFrame{
    private JPanel removePanel;
    private JLabel labelRemove;
    private JLabel removeLab;
    private JTextField removeInput;
    private JButton removeButton;
    private JButton exitButton;
    RemoveStaffGUI(Canteen canteen){
        setTitle("Столовая");
        setContentPane(removePanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=300;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffGUI staffGUI = new StaffGUI(canteen);
                dispose();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag=false;
                String[] fio = removeInput.getText().split(" ");
                if(canteen.getStaff().isEmpty()){
                    JOptionPane.showMessageDialog( null, "Список сотрудников пуст" , "Удаление",
                            JOptionPane.INFORMATION_MESSAGE );
                } else {
                for (Staff staff : canteen.getStaff()){
                    if(staff.getFio()[0].equals(fio[0]) && staff.getFio()[1].equals(fio[1]) &&
                            staff.getFio()[2].equals(fio[2])){
                        canteen.removeStaff(staff);
                        JOptionPane.showMessageDialog( null, "Сотрудник «"
                                        + fio[0] + " " + fio[1] + " " + fio[2] + "» удалён." , "Удаление",
                                JOptionPane.INFORMATION_MESSAGE );flag=true; break;
                    }
                }
                if(!flag){
                    JOptionPane.showMessageDialog( null, "Сотрудник «"
                                    + fio[0] + " " + fio[1] + " " + fio[2] + "» не найден." , "Удаление",
                            JOptionPane.INFORMATION_MESSAGE );
                }}
                removeInput.setText("");
            }
        });
    }
}
