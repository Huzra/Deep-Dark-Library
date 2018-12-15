package frame;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import LogicObject.DataProcessing;
import LogicObject.loan;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u53F7:");
		label.setBounds(93, 52, 72, 18);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(186, 49, 146, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u5F52\u8FD8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enumeration<ArrayList<loan>> ln=DataProcessing.getAllLoan();
				ArrayList<loan> temp;
				loan ltp;
				set:
				while(ln.hasMoreElements())
				{
					temp=ln.nextElement();
					for(int i=0;i<temp.size();i++)
					{
						ltp=temp.get(i);
						if(ltp.getBookitemid().equals(textField.getText())) {
							ltp.setIsreturned(true);
							temp.set(i, ltp);
							String str=ltp.getBorrowerid();
							try {
								if(DataProcessing.returnbook(str,temp,ltp.getLoanid()))
									JOptionPane.showMessageDialog(null, "还书成功");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break set;
						}
					}
				}
			}
		});
		button.setBounds(139, 150, 113, 27);
		panel.add(button);
	}
}
