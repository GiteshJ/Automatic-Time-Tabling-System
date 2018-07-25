package phoenix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class View extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setToolTipText("");
		table.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 15));
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, null));
		table.setBackground(new Color(255, 255, 255));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Day", "1st", "2nd", "3rd", "4th", "Break", "5th", "6th", "7th"},
				{"Tuesday", "M(CS)491", "M(CS)401", "M(CS)401", "CS402", "Break", "HU481", "HU481", "CS401"},
				{null, "sck", "sck", "sck", "sns", null, "sg", "sg", "sck"},
				{null, "CSELab Zone1", "CSELab Zone1", "CSELab Zone1", "4.2", null, "4.2", "4.2", "4.2"},
				{"Wed", "Eco", "Java", "Algo", "Maths", "Break", "Algo lab", "Algo lab", "Algo lab"},
				{null, "sk", "sck", "sg", "kb", null, "sg", "sg", "sg"},
				{"Thr", "eco", "java", "maths", "microprocessor", "Break", "algo", "maths", "java"},
				{null, "sk", "won", "kb", "akd", null, "sns", "akd", "sck"},
				{"Fri", "Mixcropr lab", "Mixcropr lab", "Mixcropr lab", "algo", "Break", "c++", "c++", "c++"},
				{null, "akd", "akd", "akd", "st", null, "ft", "ft", "ft"},
				{"Sat", "algo", "java", "maths", "java", "Break", "project", "project", "project"},
				{null, "ob", "sck", "akd", "wong", null, "un", "un", "un"},
			},
			new String[] {
				"Day", "1st", "2nd", "3rd", "4th", "Break", "5th", "6th", "7th"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(0).setMaxWidth(15);
		contentPane.add(table, BorderLayout.NORTH);
	}
}
