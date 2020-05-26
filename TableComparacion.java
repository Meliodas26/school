import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TableComparacion{
  JTable table;
  DefaultTableModel model = new DefaultTableModel();
  TableColumn col;
  DefaultTableCellRenderer render = new DefaultTableCellRenderer();

  public TableComparacion(){
  	render.setHorizontalAlignment(SwingConstants.CENTER);

    render.setBackground(Color.orange);
    render.setForeground(Color.white);
    model.addColumn("Tipo");
    model.addColumn("Tiempo");
    model.addRow(new String [] {
      "Tipo","Tiempo"+""
    });
    model.addRow(new String [] {
      "Secuencial","0"+""
    });
    model.addRow(new String [] {
      "Concurrente","0"+""
    });

    table = new JTable(model);
    	
    table.getColumnModel().getColumn(0).setPreferredWidth(100);
    table.getColumnModel().getColumn(0).setMaxWidth(100);
    table.getColumnModel().getColumn(0).setCellRenderer(render);

    table.getColumnModel().getColumn(1).setPreferredWidth(75);
    table.getColumnModel().getColumn(1).setMaxWidth(75);
    table.getColumnModel().getColumn(1).setCellRenderer(render);
	}

  public JTable getTable(){
    return table;
  }

  public void putData(int metodo, int duracion){
    if(metodo == 1)
      table.setValueAt(duracion, 0, 1);
    else
      table.setValueAt(duracion, 1, 1);
  } 

}