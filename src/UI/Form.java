package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Panel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JCheckBox;

public class Form extends JFrame implements ActionListener {

	JPanel panel = new JPanel();
	JPanel_1 jPanel_1 = new JPanel_1();
	JPanel panel_2 = new JPanel();
	JPanel_2 jPanel_2 = new JPanel_2();
	private final JLabel lblNewLabel = new JLabel("");
	private final JLabel lblPlaySoccer = new JLabel("Play Soccer");
	private final JLabel lblc = new JLabel("Copyright ⓒ 2018 by 김형민");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Form() {
		jPanel_2.setBounds(0, 0, 1, 643);
		jPanel_1.setBounds(0, 0, 370, 643);


		panel.add(jPanel_1);
		panel.add(jPanel_2);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 732);
		getContentPane().setLayout(null);

		panel.setBounds(0, 0, 876, 644);
		getContentPane().add(panel);
		panel.setLayout(null);

		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(367, 0, 509, 643);
		panel.add(panel_2);
		panel_2.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(Form.class.getResource("/images/football2.png")));
		lblNewLabel.setBounds(130, 142, 288, 276);
		
		panel_2.add(lblNewLabel);
		lblPlaySoccer.setFont(new Font("AmeriGarmnd BT", Font.BOLD, 32));
		lblPlaySoccer.setBounds(140, 413, 295, 79);
		
		panel_2.add(lblPlaySoccer);
		lblc.setFont(new Font("굴림", Font.BOLD, 17));
		lblc.setBounds(253, 608, 239, 35);
		
		panel_2.add(lblc);

		start();
		this.setDefaultLookAndFeelDecorated(true);

		setVisible(true);

	}

	private void start() {
		// TODO Auto-generated method stub
		jPanel_1.btnSingUp.addActionListener(this);
		jPanel_1.btnStart.addActionListener(this);
		jPanel_2.btnBack.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jPanel_1.btnSingUp || e.getSource() == jPanel_2.btnBack) {
			GoThread thread1 = new GoThread(this, e.getActionCommand());
			GoThread2 thread2 = new GoThread2(this, e.getActionCommand());
			thread1.setName("로그인화면");
			thread2.setName("회원가입화면");
			thread1.start();
			thread2.start();
		}
		else if(e.getSource() == jPanel_1.btnStart) {
			new ChattingForm();
			this.setVisible(false);
		}
	}
}

class JPanel_2 extends JPanel {
	private JTextField textField_2;
	private JPasswordField tfpasswordfield;
	private JPasswordField tfRepasswordfield;
	private JTextField textField_5;
	JButton btnBack = new JButton("Back");
	JButton btnJoin = new JButton("Join");

	public JPanel_2() {
		// TODO Auto-generated constructor stub
		this.setBackground(new Color(240, 128, 128));
		this.setLayout(null);

		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setForeground(new Color(255, 255, 255));
		lblSignUp.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblSignUp.setBounds(19, 25, 352, 57);
		this.add(lblSignUp);

		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setForeground(new Color(255, 255, 255));
		lblId_1.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblId_1.setBounds(19, 120, 137, 35);
		this.add(lblId_1);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblPassword.setBounds(19, 204, 227, 35);
		this.add(lblPassword);

		JLabel lblRepassword = new JLabel("REPASSWORD");
		lblRepassword.setForeground(new Color(255, 255, 255));
		lblRepassword.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblRepassword.setBounds(19, 288, 321, 35);
		this.add(lblRepassword);

		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblName.setBounds(19, 370, 137, 35);
		this.add(lblName);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 193, 371, 2);
		this.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 279, 372, 171);
		this.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 363, 372, 87);
		this.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 445, 372, 5);
		this.add(separator_3);

		textField_2 = new JTextField();
		textField_2.setBounds(19, 163, 321, 29);
		this.add(textField_2);
		textField_2.setColumns(10);

		tfpasswordfield = new JPasswordField();
		tfpasswordfield.setColumns(10);
		tfpasswordfield.setBounds(19, 250, 321, 29);
		this.add(tfpasswordfield);

		tfRepasswordfield = new JPasswordField();
		tfRepasswordfield.setColumns(10);
		tfRepasswordfield.setBounds(19, 334, 321, 29);
		this.add(tfRepasswordfield);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(19, 416, 321, 29);
		this.add(textField_5);
		// panel_1.add(textField_5tor
		btnBack.setBounds(19, 575, 155, 43);
		btnBack.setBackground(new Color(240, 128, 128));
		this.add(btnBack);
		btnBack.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnBack.setForeground(Color.WHITE);

		btnJoin.setBounds(180, 575, 174, 43);
		btnJoin.setBackground(new Color(240, 128, 128));
		this.add(btnJoin);
		btnJoin.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnJoin.setForeground(Color.WHITE);

		separator_2 = new JSeparator();

	}
}

class JPanel_1 extends JPanel {
	JLabel lblChattingProgram = new JLabel("Chatting Program");
	JLabel lblPw = new JLabel("PW");
	JButton btnStart = new JButton("Get started");
	JButton btnSingUp = new JButton("Sign up");
	JPanel contentPane;
	JPasswordField textField;
	JTextField textField_1;
	JLabel lblLogin = new JLabel("LOGIN");
	JLabel lblId = new JLabel("ID");
	Separator separator = new Separator();
	Separator separator_2 = new Separator();
	Separator separator_1 = new Separator();

	public JPanel_1() {
		// TODO Auto-generated constructor stub

		this.setBackground(new Color(231, 73, 134));
		this.setLayout(null);

		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Agency FB", Font.BOLD, 29));
		lblLogin.setBounds(27, 118, 308, 57);
		this.add(lblLogin);

		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Agency FB", Font.PLAIN, 26));
		lblId.setBounds(27, 204, 137, 35);
		this.add(lblId);

		separator.setBounds(27, 267, 297, 19);
		this.add(separator);

		separator_1.setBounds(27, 344, 297, 19);
		this.add(separator_1);

		lblPw.setForeground(new Color(255, 255, 255));
		lblPw.setFont(new Font("Agency FB", Font.PLAIN, 26));
		lblPw.setBounds(27, 281, 137, 35);
		this.add(lblPw);

		btnStart.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnStart.setForeground(new Color(255, 255, 255));
		btnStart.setBackground(new Color(231, 73, 134));
		btnStart.setBounds(38, 549, 297, 43);
		this.add(btnStart);

		separator_2.setBounds(38, 599, 297, 19);
		this.add(separator_2);

		textField = new JPasswordField();
		textField.setBackground(new Color(231, 73, 134));
		textField.setBounds(27, 324, 297, 19);
		this.add(textField);
		textField.setColumns(10);
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField_1.setBackground(new Color(231, 73, 134));
		textField_1.setBounds(27, 247, 297, 19);
		this.add(textField_1);

		lblChattingProgram.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblChattingProgram.setForeground(new Color(255, 255, 255));
		lblChattingProgram.setBounds(0, 0, 370, 73);
		this.add(lblChattingProgram);

		// btnSingUp.addActionListener(this);

		btnSingUp.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnSingUp.setForeground(Color.WHITE);
		btnSingUp.setBackground(new Color(231, 73, 134));
		btnSingUp.setBounds(38, 498, 297, 43);
		this.add(btnSingUp);

	}

	
}

class GoThread extends Thread {
	Form form;
	Object object;

	public GoThread(Form form2, Object object) {
		// TODO Auto-generated constructor stub
		this.form = form2;
		this.object = object;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 370; i >= -30; i = i - 15) {
			try {
				if (Thread.currentThread().getName().equals("로그인화면")) {
					Thread.sleep(10);
					if (object.equals("Back")) {
						form.jPanel_1.setBounds(form.jPanel_1.getBounds().x, form.jPanel_1.getBounds().y,
								(370 - i) + 4, form.jPanel_1.getBounds().height);
					} else {
						form.jPanel_1.setBounds(form.jPanel_1.getBounds().x, form.jPanel_1.getBounds().y, i,
								form.jPanel_1.getBounds().height);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		super.run();
	}
}

class GoThread2 extends Thread {
	Form form;
	Object object;

	public GoThread2(Form form2, Object object) {
		// TODO Auto-generated constructor stub
		this.form = form2;
		this.object = object;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(object);
		for (int i = -30; i <= 370; i = i + 15) {
			try {
				form.jPanel_2.setDoubleBuffered(true);
				form.jPanel_1.setDoubleBuffered(true);

				
				if (Thread.currentThread().getName().equals("회원가입화면")) {
					Thread.sleep(10);
					if (object.equals("Back")) {
						form.jPanel_2.setBounds(form.jPanel_2.getBounds().x, form.jPanel_2.getBounds().y,
								(370 - i) - 15, form.jPanel_2.getBounds().height);
					} else {
						form.jPanel_2.setBounds(form.jPanel_2.getBounds().x, form.jPanel_2.getBounds().y, i,
								form.jPanel_1.getBounds().height);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		super.run();
	}
}
