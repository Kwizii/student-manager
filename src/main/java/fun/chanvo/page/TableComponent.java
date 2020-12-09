package fun.chanvo.page;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Enumeration;

/**
 * 表格组件
 *
 * @author LGX
 */
public class TableComponent extends JTable {

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public TableComponent(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
        // 设置选中背景
        setSelectionForeground(Color.BLACK);
        // 设置选中字体样式
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        fitTableColumns();
        // 设置表格自适应
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 设置每次只能选择一行
        // 表头设置
        getTableHeader().setResizingAllowed(true);
        // 设置不允许手动改变列宽
        getTableHeader().setReorderingAllowed(false);
        // 设置不允许拖动重新排序各列
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Object.class, r);
        setVisible(true);
    }

    /**
     * 更新表格数据
     *
     * @param rowData     数据
     * @param columnNames 表名
     */
    public void updateModel(Object[][] rowData, Object[] columnNames) {
        DefaultTableModel dataModel = new DefaultTableModel(rowData, columnNames);
        setModel(dataModel);
        revalidate();
        fitTableColumns();
    }

    public void fitTableColumns() {
        JTableHeader header = getTableHeader();
        int rowCount = getRowCount();
        Enumeration<TableColumn> columns = getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(this, column.getIdentifier()
                            , false, false, -1, col).getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) getCellRenderer(row, col).getTableCellRendererComponent(this,
                        getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column);
            column.setWidth(width + getIntercellSpacing().width + 4);
        }
    }
}