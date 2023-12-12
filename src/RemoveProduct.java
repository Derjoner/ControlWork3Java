import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveProduct extends JFrame{
    private JPanel removePanel;
    private JLabel removeLabel;
    private JLabel labelName;
    private JTextField nameInput;
    private JButton removeButton;
    private JButton exitButton;
    RemoveProduct(Canteen canteen){
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
                ProductsGUI productsGUI = new ProductsGUI(canteen);
                dispose();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameInput.getText();
                boolean flag=false;
                if(canteen.getProducts().isEmpty()){
                    JOptionPane.showMessageDialog( null, "Список продуктов пуст" , "Удаление",
                            JOptionPane.INFORMATION_MESSAGE );
                }else {
                for(Products product : canteen.getProducts()){
                    if(name.equals(product.nameProduct)){
                        canteen.removeProduct(product);
                    JOptionPane.showMessageDialog( null, "Продукт «" + name + "» удалён." , "Удаление",
                            JOptionPane.INFORMATION_MESSAGE ); flag=true; break;}
                }
                if(!flag){
                    JOptionPane.showMessageDialog( null, "Продукт «" + name + "» не найден." , "Удаление",
                            JOptionPane.INFORMATION_MESSAGE );
                }
                nameInput.setText("");
                }
            }
        });
    }
}
