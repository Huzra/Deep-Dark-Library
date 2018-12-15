package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicObject.DataProcessing;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField idField;
	private JTextField depField;
	private JTextField pasField;
	private JTextField majField;
	private JTextField dirField;
	private JLabel label_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTabbedPane tabbedPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Frame frame = new Add_Frame();
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
	public Add_Frame() {
		setResizable(false);
		setTitle("\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 543, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\u501F\u9605\u8005", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D:");
		lblNewLabel.setBounds(59, 33, 72, 18);
		panel.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(163, 28, 171, 24);
		panel.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(59, 84, 72, 18);
		panel.add(lblId);
		
		idField = new JTextField();
		idField.setBounds(163, 80, 171, 24);
		panel.add(idField);
		idField.setColumns(10);
		
		JLabel label = new JLabel("\u5B66\u9662:");
		label.setBounds(59, 135, 72, 18);
		panel.add(label);
		
		depField = new JTextField();
		depField.setBounds(163, 132, 171, 24);
		panel.add(depField);
		depField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801:");
		label_1.setBounds(59, 186, 72, 18);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u7C7B\u578B:");
		label_2.setBounds(59, 237, 72, 18);
		panel.add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBox.getSelectedIndex()==1)
				{
					label_4.setEnabled(true);
					dirField.setEnabled(true);
				}
				else
				{
					label_4.setEnabled(false);
					dirField.setEnabled(false);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u672C\u79D1\u751F", "\u7814\u7A76\u751F"}));
		comboBox.setBounds(163, 236, 171, 24);
		panel.add(comboBox);
		
		pasField = new JTextField();
		pasField.setBounds(163, 184, 171, 24);
		panel.add(pasField);
		pasField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4E13\u4E1A:");
		label_3.setBounds(59, 288, 72, 18);
		panel.add(label_3);
		
		majField = new JTextField();
		majField.setBounds(163, 288, 171, 24);
		panel.add(majField);
		majField.setColumns(10);
		
		label_4 = new JLabel("\u5BFC\u5E08:");
		label_4.setEnabled(false);
		label_4.setBounds(59, 339, 72, 18);
		panel.add(label_4);
		
		dirField = new JTextField();
		dirField.setEnabled(false);
		dirField.setBounds(163, 340, 171, 24);
		panel.add(dirField);
		dirField.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=nameField.getText();
				String ID=idField.getText();
				String department=depField.getText();
				String pas=pasField.getText();
				String major=majField.getText();
				if(comboBox.getSelectedIndex()==0)
				{
					try {
						if(DataProcessing.insertborrower(name,ID,department,pas,true,major))
							JOptionPane.showMessageDialog(null, "添加成功");
						else
							JOptionPane.showMessageDialog(null, "添加失败");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					try {
						if(DataProcessing.insertborrower(name,ID,department,pas,false,major,dirField.getText()))
							JOptionPane.showMessageDialog(null, "添加成功");
						else
							JOptionPane.showMessageDialog(null, "添加失败");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button.setBounds(383, 182, 113, 27);
		panel.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(383, 335, 113, 27);
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u56FE\u4E66\u7BA1\u7406\u5458", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(49, 85, 72, 18);
		panel_1.add(lblId_1);
		
		textField = new JTextField();
		textField.setBounds(132, 81, 147, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u59D3\u540D:");
		label_5.setBounds(49, 188, 72, 18);
		panel_1.add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 186, 147, 24);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5BC6\u7801:");
		label_6.setBounds(49, 291, 72, 18);
		panel_1.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(132, 291, 147, 24);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_2 = new JButton("\u6DFB\u52A0");
		button_2.setBounds(383, 182, 113, 27);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("\u8FD4\u56DE");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(383, 335, 113, 27);
		panel_1.add(button_3);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u4E66\u7C4D", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(59, 41, 72, 18);
		panel_2.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(171, 36, 135, 24);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(59, 100, 72, 18);
		panel_2.add(lblIsbn);
		
		textField_4 = new JTextField();
		textField_4.setBounds(171, 96, 135, 24);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_7 = new JLabel("\u4E66\u540D:");
		label_7.setBounds(59, 159, 72, 18);
		panel_2.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(171, 156, 135, 24);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_8 = new JLabel("\u4EF7\u683C:");
		label_8.setBounds(59, 218, 72, 18);
		panel_2.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(171, 216, 135, 24);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_9 = new JLabel("\u4F5C\u8005:");
		label_9.setBounds(59, 277, 72, 18);
		panel_2.add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setBounds(171, 276, 135, 24);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_10 = new JLabel("\u51FA\u7248\u65E5\u671F:");
		label_10.setBounds(59, 336, 72, 18);
		panel_2.add(label_10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(171, 336, 135, 24);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		JButton button_4 = new JButton("\u6DFB\u52A0");
		button_4.setBounds(383, 182, 113, 27);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("\u8FD4\u56DE");
		button_5.setBounds(383, 335, 113, 27);
		panel_2.add(button_5);
	}
	public void ChangePage(int a)
	{
		this.tabbedPane.setSelectedIndex(a);
	}
}
