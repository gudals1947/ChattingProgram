package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;

public class Form extends JFrame {

	private JPanel contentPane;
	private JPasswordField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Form() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 732);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 907, 644);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(231,73,134));
		panel_1.setBounds(0, 0, 370, 643);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Agency FB", Font.BOLD, 29));
		lblLogin.setBounds(27, 118, 308, 57);
		panel_1.add(lblLogin);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Agency FB", Font.PLAIN, 26));
		lblId.setBounds(27, 204, 137, 35);
		panel_1.add(lblId);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 267, 297, 19);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 344, 297, 19);
		panel_1.add(separator_1);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setForeground(new Color(255, 255, 255));
		lblPw.setFont(new Font("Agency FB", Font.PLAIN, 26));
		lblPw.setBounds(27, 281, 137, 35);
		panel_1.add(lblPw);
		
		JButton btnNewButton = new JButton("Get started");
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(231,73,134));
		btnNewButton.setBounds(38, 549, 297, 43);
//		btnNewButton.setOpaque(false);
		panel_1.add(btnNewButton);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(38, 599, 297, 19);
		panel_1.add(separator_2);
		
		textField = new JPasswordField();
		textField.setBackground(new Color(231,73,134));
		textField.setBounds(27, 324, 297, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField_1.setBackground(new Color(231,73,134));
		textField_1.setBounds(27, 247, 297, 19);
		panel_1.add(textField_1);
		
		JLabel lblChattingProgram = new JLabel("Chatting Program");
		lblChattingProgram.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblChattingProgram.setForeground(new Color(255, 255, 255));
		lblChattingProgram.setBounds(0, 0, 370, 73);
		panel_1.add(lblChattingProgram);
		
		JButton btnSingUp = new JButton("Sing up");
		btnSingUp.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnSingUp.setForeground(Color.WHITE);
		btnSingUp.setBackground(new Color(231, 73, 134));
		btnSingUp.setBounds(38, 498, 297, 43);
		panel_1.add(btnSingUp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(371, -24, 536, 667);
		panel.add(panel_2);
		panel_2.setLayout(null);

		setVisible(true);
	}
}
