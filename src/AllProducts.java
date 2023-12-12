import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllProducts extends JFrame{
    private JPanel AllPanel;
    private JLabel labelAll;
    private JTable tableProducts;
    private JButton buttonExit;
    private JScrollPane Scroll;
    private JButton isButton;

    AllProducts(Canteen canteen){
        setTitle("Столовая");
        setContentPane(AllPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=650, height=300;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        String[] columnsHeader = new String[]{"Тип", "Название",
                "Количество (кг)", "Дата поставки", "Срок годности"};
        int i=0;
        String[][] data = new String[canteen.getProducts().size()][];
        for (Products product : canteen.getProducts()){
            data[i] = new String[]{product.getType(), product.getNameProduct(), String.valueOf(product.getWeightProduct()),
                    product.getDeliveryDateString(), product.getExpirationDateString()};
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(data, columnsHeader);
        tableProducts.setModel(model);
        tableProducts.setDefaultEditor(Object.class, null);
        tableProducts.getTableHeader().setReorderingAllowed(false);

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductsGUI productsGUI = new ProductsGUI(canteen);
                dispose();
            }
        });
        isButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columnsHeader = new String[]{"Тип", "Название",
                        "Количество (кг)", "Дата поставки", "Срок годности", "Истёк/Не истёк"};
                int i=0;
                String[][] data = new String[canteen.getProducts().size()][];
                for (Products product : canteen.getProducts()){
                    data[i] = new String[]{product.getType(), product.getNameProduct(), String.valueOf(product.getWeightProduct()),
                            product.getDeliveryDateString(), product.getExpirationDateString(), product.chekingExpiration()};
                    i++;
                }
                DefaultTableModel model = new DefaultTableModel(data, columnsHeader);
                tableProducts.setModel(model);repaint(); revalidate();
            }
        });
    }
}
