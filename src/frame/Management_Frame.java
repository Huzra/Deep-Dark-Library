package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LogicObject.Borrower;
import LogicObject.DataProcessing;
import LogicObject.bookitem;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Management_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField textField_2;
	private JTable table_2;
	private JScrollPane scrollPane;
	JTabbedPane tabbedPane;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 621, 543);
		contentPane.add(tabbedPane);
		
		JPanel Borrower_panel = new JPanel();
		tabbedPane.addTab("借阅者", null, Borrower_panel, null);
		Borrower_panel.setLayout(null);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_Frame frame=new Add_Frame();
				frame.setVisible(true);
			}
		});
		button.setBounds(69, 13, 113, 27);
		Borrower_panel.add(button);
		
		textField = new JTextField();
		textField.setBounds(122, 98, 305, 24);
		Borrower_panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5168\u90E8", "ID"}));
		comboBox.setBounds(14, 98, 59, 24);
		Borrower_panel.add(comboBox);
		
		JButton button_2 = new JButton("\u67E5\u8BE2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBorrower(comboBox.getSelectedIndex());
			}
		});
		button_2.setBounds(489, 97, 113, 27);
		Borrower_panel.add(button_2);
		
		JButton button_3 = new JButton("\u5220\u9664");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=(String)table.getValueAt(table.getSelectedRow(),0);
				try {
					if(DataProcessing.deleteborrower(ID))
						JOptionPane.showMessageDialog(null, "删除成功");
					else
						JOptionPane.showMessageDialog(null, "删除失败");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(433, 13, 113, 27);
		Borrower_panel.add(button_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 130, 588, 318);
		Borrower_panel.add(scrollPane);
		table = new JTable();
		table.setEnabled(false);
		table .getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			null,new String[] {
				"ID","姓名","学院"}
		));
		scrollPane.setViewportView(table);
		
		JButton button_12 = new JButton("\u8BE6\u7EC6\u4FE1\u606F");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=(String)table.getValueAt(table.getSelectedRow(),0);
				Borrower borrower=DataProcessing.searchBorrower(ID);
				Info_Frame frame=new Info_Frame();
				frame.setTitle("借阅者信息");
				frame.setText(borrower.GetAllInfo());
				frame.setVisible(true);
			}
		});
		button_12.setBounds(489, 471, 113, 27);
		Borrower_panel.add(button_12);
		
		JButton button_13 = new JButton("\u8FD4\u56DE");
		button_13.setBounds(14, 471, 113, 27);
		Borrower_panel.add(button_13);
		
		JPanel Librarian_panel = new JPanel();
		Librarian_panel.setLayout(null);
		tabbedPane.addTab("图书管理员", null, Librarian_panel, null);
		
		JButton button_8 = new JButton("\u6DFB\u52A0");
		button_8.setBounds(69, 13, 113, 27);
		Librarian_panel.add(button_8);
		
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
		tabbedPane.addTab("书籍", null, Title_panel, null);
		
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
	public void ChangePage(int a)
	{
		this.tabbedPane.setSelectedIndex(a);
	}
	public void searchBorrower(int i)
	{
		Enumeration<Borrower> En;
		En = DataProcessing.getAllBorrower();
		Borrower temp;
		List<Object[]> list = new ArrayList<Object[]>();
		if(i==0)
		{
			while(En.hasMoreElements())
			{
				temp=En.nextElement();
				Object[] tmp= {temp.getBorrowerID(),temp.getName(),temp.getDepartment()};
					list.add(tmp);
			}
		}
		if(i==1)
		{
			while(En.hasMoreElements())
			{
				
				temp=En.nextElement();
				if(temp.getBorrowerID().equals(textField.getText()))
				{
					Object[] tmp= {temp.getBorrowerID(),temp.getName(),temp.getDepartment()};
					list.add(tmp);
				}
			}
		}
		Object data[][]=new Object[list.size()][];
		list.toArray(data);
		String[] column= {"ID","姓名","学院"};
		table = new JTable(data,column);
		table .getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
	}
}
