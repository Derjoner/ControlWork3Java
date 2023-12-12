import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductAddGUI extends JFrame{
    private JPanel productAddPanel;
    private JLabel labelAdd;
    private JLabel labelType;
    private JComboBox typeInput;
    private JLabel labelName;
    private JTextField nameInput;
    private JLabel weightProductlabel;
    private JSpinner weightInput;
    private JLabel labelDelivery;
    private JTextField deliveryInput;
    private JLabel expirationLabel;
    private JTextField expirationInput;
    private JButton addButton;
    private JButton exitButton;

    ProductAddGUI(Canteen canteen){
        setTitle("Столовая");
        setContentPane(productAddPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=300;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductsGUI productsGUI = new ProductsGUI(canteen);
                dispose();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameInput.getText();
                String type = (String) typeInput.getSelectedItem();
                int weight = (int) weightInput.getValue();
                String[] deliveryS = deliveryInput.getText().split("\\.");
                int[] delivery = new int[3];
                for(int i=0; i<3; i++){ delivery[i] = Integer.parseInt(deliveryS[i]);}
                String[] expirationS = expirationInput.getText().split("\\.");
                int[] expiration = new int[3];
                for(int i=0; i<3; i++){ expiration[i] = Integer.parseInt(expirationS[i]);}
                Products product = new Products(type, name, weight, delivery[0], delivery[1], delivery[2],
                        expiration[0], expiration[1], expiration[2]);
                JOptionPane.showMessageDialog( null, product.Output() , "Продукт добавлен",
                        JOptionPane.INFORMATION_MESSAGE );
                canteen.addProduct(product);
                ProductsGUI productsGUI = new ProductsGUI(canteen);
                dispose();
            }
        });
    }
}
