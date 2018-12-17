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

import LogicObject.DataProcessing;
import LogicObject.bookitem;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class Title_Querying_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 772, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		contentPane.add(panel, BorderLayout.NORTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 100, 5);
		panel.setLayout(fl_panel);
		setResizable(false);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("书名");
		comboBox.addItem("ISBN");
		comboBox.addItem("作者");
		comboBox.addItem("All");
		panel.add(comboBox);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(30);
		table = new JTable();
		table.setEnabled(false);
		table .getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			null,new String[] {
				"\u4E66\u53F7", "ISBN", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u51FA\u7248\u65F6\u95F4"}
		));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.menu);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(100);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		panel_1.add(button_1);
		
		JButton button = new JButton("\u67E5\u8BE2\u56FE\u4E66");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				SearchBooks(comboBox.getSelectedIndex(),textField.getText());
			}			
		});
		panel_1.add(button);
	}
	public void SearchBooks(int i,String str){
		Enumeration<bookitem> En;
		En = DataProcessing.getAllBook();
		bookitem temp;
		List<Object[]> list = new ArrayList<Object[]>();
		if(i==0)
		{
			while(En.hasMoreElements())
			{
				temp=En.nextElement();
				if(temp.getBookname().equals(str))
					list.add(temp.getObject());
			}
		}
		else if(i==1)
		{
			while(En.hasMoreElements())
			{
				temp=En.nextElement();
				if(temp.getBookisbn().equals(str))
					list.add(temp.getObject());
			}
		}
		else if(i==2)
		{
			while(En.hasMoreElements())
			{
				temp=En.nextElement();
				if(temp.getAuthor().equals(str))
					list.add(temp.getObject());
			}
		}
		else
		{
			while(En.hasMoreElements())
			{
				temp=En.nextElement();
				list.add(temp.getObject());
			}
		}
		Object data[][]=new Object[list.size()][];
		list.toArray(data);
	String[] column= {"\u4E66\u53F7", "ISBN", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u51FA\u7248\u65F6\u95F4",};
	table = new JTable(data,column);
	table .getTableHeader().setReorderingAllowed(false);
	scrollPane.setViewportView(table);
	}

}
