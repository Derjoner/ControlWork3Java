import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInfo extends JFrame{
    private JPanel menuInfoPanel;
    private JLabel labelInfo;
    private JScrollPane scroll;
    private JTable tableMenu;
    private JButton buttonExit;
    MenuInfo(Canteen canteen){
        setTitle("Столовая");
        setContentPane(menuInfoPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=600, height=350;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        String[] columnsHeader = new String[]{"Категория", "Название", "Состав"};
        int i=0;
        String[][] data = new String[canteen.getMenu().size()][];
        for (Menu menu : canteen.getMenu()){
            data[i] = new String[]{menu.getCategory(), menu.getNameDish(), menu.getCompositionString(0)};
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(data, columnsHeader);
        tableMenu.setModel(model);
        tableMenu.setDefaultEditor(Object.class, null);
        tableMenu.getTableHeader().setReorderingAllowed(false);
        tableMenu.getColumnModel().getColumn(2).setCellRenderer(new WordWrapRenderer());
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGUI menuGUI = new MenuGUI(canteen);
                dispose();
            }
        });
    }
}
