package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicObject.Borrower;

import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Borrower_MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrower_MainFrame frame = new Borrower_MainFrame(null);
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
	public Borrower_MainFrame(Borrower borrower) {
		setTitle("\u501F\u9605\u8005\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 671, 538);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6CE8\u9500");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame frame = new LoginFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("\u67E5\u8BE2\u4E66\u76EE");
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u67E5\u8BE2\u4E2A\u4EBA\u4FE1\u606F");
		menu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Info_Frame frame=new Info_Frame();
				frame.setTitle("ΩË‘ƒ’ﬂ–≈œ¢");
				frame.setText(borrower.GetAllInfo());
				frame.setVisible(true);
			}
		});
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("\u67E5\u8BE2\u501F\u9605\u60C5\u51B5");
		menuBar.add(menu_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("Welcome");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 63));
		contentPane.add(label);
	}

}
