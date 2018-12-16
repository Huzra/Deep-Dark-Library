package frame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicObject.Administrator;
import LogicObject.Borrower;
import LogicObject.DataProcessing;
import LogicObject.Librarian;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(null);
		contentPane.add(MainPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("用户名:");
		label.setBounds(82, 30, 75, 30);
		MainPanel.add(label);
		
		JLabel label_1 = new JLabel("密码:");
		label_1.setBounds(82, 70, 75, 30);
		MainPanel.add(label_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(239, 30, 100, 30);
		MainPanel.add(usernameField);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(239, 70, 100, 30);
		MainPanel.add(passwordField);
		
		JRadioButton Borrower_Login_Button = new JRadioButton("借阅者");
		Borrower_Login_Button.setBounds(167, 130, 87, 27);
		MainPanel.add(Borrower_Login_Button);
		
		JRadioButton LibAdmin_Login_Button = new JRadioButton("图书管理员");
		LibAdmin_Login_Button.setBounds(286, 130, 103, 27);
		MainPanel.add(LibAdmin_Login_Button);
		
		JRadioButton SysAdmin_Login_Button = new JRadioButton("系统管理员");
		SysAdmin_Login_Button.setBounds(32, 130, 103, 27);
		MainPanel.add(SysAdmin_Login_Button);
		
		JPanel ButtonPanel = new JPanel();
		contentPane.add(ButtonPanel, BorderLayout.SOUTH);
		ButtonPanel.setLayout(new FlowLayout());
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Borrower_Login_Button.isSelected()&&!LibAdmin_Login_Button.isSelected()&&!SysAdmin_Login_Button.isSelected())
				{
					String ID=usernameField.getText();
					String password=passwordField.getText();
					Borrower temp;
					if((temp=DataProcessing.searchBorrower(ID, password))!=null) {
						Borrower_MainFrame frame=new Borrower_MainFrame(temp);
						frame.setVisible(true);
						dispose();
					}
				}
				else if(LibAdmin_Login_Button.isSelected()&&!Borrower_Login_Button.isSelected()&&!SysAdmin_Login_Button.isSelected())
				{
					String ID=usernameField.getText();
					String password=passwordField.getText();
					Librarian temp=null;
					if((temp=DataProcessing.searchlibrarian(ID,password))!=null) {
						LibAdmin_MainFrame frame=new LibAdmin_MainFrame(temp);					
						frame.setVisible(true);
						dispose();
					}
				}
				else if(SysAdmin_Login_Button.isSelected()&&!Borrower_Login_Button.isSelected()&&!LibAdmin_Login_Button.isSelected())
				{
					String ID=usernameField.getText();
					String password=passwordField.getText();
					Administrator temp=null;
					if((temp=DataProcessing.searchadministrator(ID,password))!=null) {
						SysAdmin_MainFrame frame=new SysAdmin_MainFrame(temp);
						frame.setVisible(true);
						dispose();
					}
				}
			}
		});
		ButtonPanel.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonPanel.add(button_1);
	}

}
