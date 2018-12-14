package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Title_Returning_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Title_Returning_Frame frame = new Title_Returning_Frame();
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
	public Title_Returning_Frame() {
		setTitle("\u5F52\u8FD8\u4E66\u76EE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u53F7:");
		label.setBounds(100, 52, 72, 18);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(186, 49, 146, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u5F52\u8FD8");
		button.setBounds(139, 150, 113, 27);
		panel.add(button);
	}
}
