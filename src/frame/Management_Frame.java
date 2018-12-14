package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class Management_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField textField_2;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management_Frame frame = new Management_Frame();
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
	public Management_Frame() {
		setTitle("\u7BA1\u7406\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 621, 543);
		contentPane.add(tabbedPane);
		
		JPanel Borrower_panel = new JPanel();
		tabbedPane.addTab("������", null, Borrower_panel, null);
		Borrower_panel.setLayout(null);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setBounds(69, 13, 113, 27);
		Borrower_panel.add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.setBounds(251, 13, 113, 27);
		Borrower_panel.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(122, 98, 305, 24);
		Borrower_panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(14, 98, 37, 24);
		Borrower_panel.add(comboBox);
		
		JButton button_2 = new JButton("\u67E5\u8BE2");
		button_2.setBounds(489, 97, 113, 27);
		Borrower_panel.add(button_2);
		
		table = new JTable();
		table.setBounds(14, 130, 588, 368);
		Borrower_panel.add(table);
		
		JButton button_3 = new JButton("\u5220\u9664");
		button_3.setBounds(433, 13, 113, 27);
		Borrower_panel.add(button_3);
		
		JPanel Librarian_panel = new JPanel();
		Librarian_panel.setLayout(null);
		tabbedPane.addTab("ͼ�����Ա", null, Librarian_panel, null);
		
		JButton button_8 = new JButton("\u6DFB\u52A0");
		button_8.setBounds(69, 13, 113, 27);
		Librarian_panel.add(button_8);
		
		JButton button_9 = new JButton("\u4FEE\u6539");
		button_9.setBounds(251, 13, 113, 27);
		Librarian_panel.add(button_9);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 98, 305, 24);
		Librarian_panel.add(textField_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(14, 98, 37, 24);
		Librarian_panel.add(comboBox_2);
		
		JButton button_10 = new JButton("\u67E5\u8BE2");
		button_10.setBounds(489, 97, 113, 27);
		Librarian_panel.add(button_10);
		
		table_2 = new JTable();
		table_2.setBounds(14, 130, 588, 368);
		Librarian_panel.add(table_2);
		
		JButton button_11 = new JButton("\u5220\u9664");
		button_11.setBounds(433, 13, 113, 27);
		Librarian_panel.add(button_11);
		
		JPanel Title_panel = new JPanel();
		Title_panel.setLayout(null);
		tabbedPane.addTab("�鼮", null, Title_panel, null);
		
		JButton button_4 = new JButton("\u6DFB\u52A0");
		button_4.setBounds(69, 13, 113, 27);
		Title_panel.add(button_4);
		
		JButton button_5 = new JButton("\u4FEE\u6539");
		button_5.setBounds(251, 13, 113, 27);
		Title_panel.add(button_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 98, 305, 24);
		Title_panel.add(textField_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(14, 98, 37, 24);
		Title_panel.add(comboBox_1);
		
		JButton button_6 = new JButton("\u67E5\u8BE2");
		button_6.setBounds(489, 97, 113, 27);
		Title_panel.add(button_6);
		
		table_1 = new JTable();
		table_1.setBounds(14, 130, 588, 368);
		Title_panel.add(table_1);
		
		JButton button_7 = new JButton("\u5220\u9664");
		button_7.setBounds(433, 13, 113, 27);
		Title_panel.add(button_7);
	}
}
