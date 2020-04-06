import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class MostraOrdem {
	public static void MostrarObj(Object[][] bolas_1) {
		String[] tituloColunas = {"Concurso", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12", "B13", "B14", "B15"};
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 740, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		
		JTable table = new JTable(bolas_1, tituloColunas);
		
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();				//Cria um objeto centralizado
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);							//Define o objeto centralizado com coordenadas centrais
		
		for (int i = 0; i < 16; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(50); 
			table.getColumnModel().getColumn(i).setCellRenderer(centralizado);
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setEnabled(false);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(700, 400));
		panel.add(scrollPane);
	}
}