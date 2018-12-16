package frame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicObject.Librarian;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibAdmin_MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibAdmin_MainFrame frame = new LibAdmin_MainFrame(null);
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
	public LibAdmin_MainFrame(Librarian librarian) {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u5458\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 538);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Logout = new JMenu("\u6CE8\u9500");
		Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginFrame frame = new LoginFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(Logout);
		
		JMenu Borrow = new JMenu("\u501F\u51FA");
		Borrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Title_Borrowing_Frame frame=new Title_Borrowing_Frame();
				frame.setVisible(true);
			}
		});
		menuBar.add(Borrow);
		
		JMenu Return = new JMenu("\u5F52\u8FD8");
		Return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Title_Returning_Frame frame=new Title_Returning_Frame();
				frame.setVisible(true);
			}
		});
		menuBar.add(Return);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 63));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWelcome, BorderLayout.CENTER);
	}

}
