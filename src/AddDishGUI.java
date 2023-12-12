import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddDishGUI extends JFrame{
    private JPanel addPanel;
    private JLabel labelAdd;
    private JLabel labelCateg;
    private JLabel labelName;
    private JButton buttonAdd;
    private JButton buttonExit;
    private JLabel labelComp;
    private JComboBox categoryInput;
    private JTextField nameInput;
    private JList listProduct;
    private JScrollPane Scroll;
    private JLabel priceLable;
    private JSpinner priceInput;

    AddDishGUI(Canteen canteen){
        setTitle("Столовая");
        setContentPane(addPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=350;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(Products product : canteen.getProducts()){
            listModel.addElement(product.getNameProduct());
        }
        listProduct.setModel(listModel);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffGUI staffGUI = new StaffGUI(canteen);
                dispose();
            }
        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String category = (String) categoryInput.getSelectedItem();
                String name = nameInput.getText();
                List comp = listProduct.getSelectedValuesList();
                int price = (int) priceInput.getValue(); int i=0;
                Products[] pp = new Products[comp.size()];
                for(Object item : comp){
                    for(Products product : canteen.getProducts()){
                        if(item.equals(product.getNameProduct())){
                            pp[i] = product; i++;
                        }
                    }
                }
                Menu menu = new Menu(category, name, pp, price);
                JOptionPane.showMessageDialog( null, menu.Output() , "Блюдо добавлено",
                        JOptionPane.INFORMATION_MESSAGE );
                canteen.addMenu(menu);
                MenuGUI menuGUI = new MenuGUI(canteen);
                dispose();
            }
        });
    }
}
