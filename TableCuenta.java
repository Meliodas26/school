import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TableCuenta{
  JTable table;
  DefaultTableModel model = new DefaultTableModel();
  TableColumn col;
  DefaultTableCellRenderer render = new DefaultTableCellRenderer();

  public TableCuenta(){
  	render.setHorizontalAlignment(SwingConstants.CENTER);

    render.setBackground(Color.blue);
    render.setForeground(Color.white);
    model.addColumn("id");
    model.addColumn("Nombre");
    model.addColumn("Saldo");
    table = new JTable(model);
    	
    table.getColumnModel().getColumn(0).setPreferredWidth(110);
    table.getColumnModel().getColumn(0).setMaxWidth(110);
    table.getColumnModel().getColumn(0).setCellRenderer(render);

    table.getColumnModel().getColumn(1).setPreferredWidth(150);
    table.getColumnModel().getColumn(1).setMaxWidth(150);
    table.getColumnModel().getColumn(1).setCellRenderer(render);

    table.getColumnModel().getColumn(2).setPreferredWidth(150);
    table.getColumnModel().getColumn(2).setMaxWidth(150);
    table.getColumnModel().getColumn(2).setCellRenderer(render);
	}

  public JTable getTable(){
    return table;
  }

  public void putData(Cuenta cuenta){
    int nAccount = table.getRowCount();
    for (int i=nAccount-1; i>=0; i--)
      model.removeRow(i);

    for(int i=0; i<cuenta.nCuenta; i++)
      model.addRow(new String [] {
        cuenta.id[i]+"",cuenta.name[i],cuenta.saldo[i]+""
      });
  }

}