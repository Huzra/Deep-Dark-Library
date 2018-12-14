package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;

public class Title_Querying_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Title_Querying_Frame frame = new Title_Querying_Frame();
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
	public Title_Querying_Frame() {
		setTitle("\u67E5\u8BE2\u4E66\u76EE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		contentPane.add(panel, BorderLayout.NORTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 100, 5);
		panel.setLayout(fl_panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("书名");
		comboBox.addItem("ISBN");
		comboBox.addItem("作者");
		panel.add(comboBox);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(30);
		
		table = new JTable();
		table.setBackground(SystemColor.control);
		contentPane.add(table, BorderLayout.CENTER);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ISBN", "\u4E66\u540D", "\u4F5C\u8005", "\u51FA\u7248\u5546", "\u51FA\u7248\u65F6\u95F4"},
				{"1", "2", null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ISBN", "Name", "Author", "Press", "New column"
			}
		));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(100);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		panel_1.add(button_1);
		
		JButton button = new JButton("\u67E5\u8BE2\u501F\u9605\u4FE1\u606F");
		panel_1.add(button);
	}

}
