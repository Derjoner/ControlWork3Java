import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class WordWrapRenderer extends JTextArea implements TableCellRenderer
{
    WordWrapRenderer()
    {
        setLineWrap(true);
        setWrapStyleWord(true);
        setBackground(new Color(113, 109, 169));
        setForeground(new Color(231, 239, 255));
        setFont(new Font("Courier New", Font.PLAIN, 14));
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        setText( (value == null) ? "" : value.toString() );
        setSize(table.getColumnModel().getColumn(column).getWidth(), table.getRowHeight(row));

        int preferredHeight = getPreferredSize().height;

        if (table.getRowHeight(row) != preferredHeight)
        {
            table.setRowHeight(row, preferredHeight);
        }

        return this;
    }
}