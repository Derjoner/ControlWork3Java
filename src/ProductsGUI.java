import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductsGUI extends JFrame{
    private JPanel productsPanel;
    private JLabel labelProducts;
    private JButton createProductButton;
    private JButton removeButton;
    private JButton infoButton;
    private JButton exitButton;
    ProductsGUI(Canteen canteen){
        setTitle("Столовая");
        setContentPane(productsPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=500, height=300;
        setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkingCanteenGUI workingCanteenGUI = new WorkingCanteenGUI(canteen);
                dispose();
            }
        });
        createProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductAddGUI productAddGUI = new ProductAddGUI(canteen);
                dispose();
            }
        });
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllProducts allProducts = new AllProducts(canteen);
                dispose();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveProduct removeProduct = new RemoveProduct(canteen);
                dispose();
            }
        });
    }
}
