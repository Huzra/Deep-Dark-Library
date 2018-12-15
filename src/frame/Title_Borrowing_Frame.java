package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicObject.Borrower;
import LogicObject.DataProcessing;
import LogicObject.bookitem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Title_Borrowing_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Title_Borrowing_Frame frame = new Title_Borrowing_Frame(null);
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
	public Title_Borrowing_Frame(Borrower borrower) {
		setTitle("\u501F\u4E66\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("\u501F\u4E66\u5361\u53F7\uFF1A");
		lblid.setBounds(80, 35, 92, 21);
		panel.add(lblid);
		
		textField = new JTextField();

		textField.setBounds(220, 35, 121, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u53F7:");
		label_1.setBounds(82, 83, 53, 18);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(217, 80, 121, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u501F\u9605");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
			}
		});
		button.setBounds(144, 180, 113, 27);
		panel.add(button);
	}
	public void borroweringbook()
	{
		//DataProcessing.
	}
}
