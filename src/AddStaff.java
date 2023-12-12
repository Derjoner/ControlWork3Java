import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStaff extends JFrame{
    private JPanel addStaffPanel;
    private JLabel labelAdd;
    private JLabel labelLastName;
    private JTextField lastNameInput;
    private JLabel lableName;
    private JTextField nameInput;
    private JLabel lableMiddle;
    private JTextField middleInput;
    private JLabel lableGender;
    private JRadioButton genderM;
    private JRadioButton genderW;
    private JLabel lableAge;
    private JSpinner ageInput;
    private JLabel positionLable;
    private JTextField positionInput;
    private JLabel salaryLable;
    private JSpinner salaryInput;
    private JLabel workingLable;
    private JTextField workingInput;
    private JButton Addbutton;
    private JButton exitButton;
    AddStaff(Canteen canteen){
        setTitle("Столовая");
        setContentPane(addStaffPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=350;
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
        Addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastName = lastNameInput.getText();
                String name = nameInput.getText();
                String middleName = middleInput.getText();
                String gender;
                if(genderM.isSelected()){ gender="Мужской";} else gender="Женский";
                int age = (int) ageInput.getValue();
                String position = positionInput.getText();
                int salary = (int) salaryInput.getValue();
                String[] workingHours = workingInput.getText().replace(' ', ':').split(":");
                int[] workingHoursInt = new int[4];
                for(int i=0; i<4; i++){ workingHoursInt[i] = Integer.parseInt(workingHours[i]);}
                Staff staff = new Staff(lastName, name, middleName, gender, age, position,
                salary, workingHoursInt[0], workingHoursInt[1], workingHoursInt[2], workingHoursInt[3]);
                JOptionPane.showMessageDialog( null, staff.Output() , "Сотрудник добавлен",
                        JOptionPane.INFORMATION_MESSAGE );
                canteen.addStaff(staff);
                StaffGUI staffGUI = new StaffGUI(canteen);
                dispose();
            }
        });
    }
}
