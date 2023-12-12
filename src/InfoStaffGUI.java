import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoStaffGUI extends JFrame{
    private JLabel labelInfo;
    private JScrollPane scroll;
    private JTable tableStaff;
    private JButton buttonExit;
    private JPanel panelStaff;

    InfoStaffGUI(Canteen canteen){
        setTitle("Столовая");
        setContentPane(panelStaff);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=650, height=300;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        String[] columnsHeader = new String[]{"Фамилия", "Имя",
                "Отчество", "Пол", "Возраст", "Должность", "Зарплата", "Часы работы"};
        int i=0;
        String[][] data = new String[canteen.getStaff().size()][];
        for (Staff staff : canteen.getStaff()){
            data[i] = new String[]{staff.getFio()[0], staff.getFio()[1], staff.getFio()[2], staff.getGender(),
            String.valueOf(staff.getAge()), staff.getPosition(), String.valueOf(staff.getSalary()), staff.getOpeningHoursString()};
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(data, columnsHeader);
        tableStaff.setModel(model);
        tableStaff.setDefaultEditor(Object.class, null);
        tableStaff.getTableHeader().setReorderingAllowed(false);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffGUI staffGUI = new StaffGUI(canteen);
                dispose();
            }
        });
    }
}
