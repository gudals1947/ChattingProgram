package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;

class ChattingForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChattingForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 924, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 153));
		panel_1.setBounds(0, 0, 357, 94);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbchat = new JLabel();
		lbchat.setBounds(0, 0, 165, 58);
		lbchat.setIcon(new ImageIcon("images/Chat.png"));
		panel_1.add(lbchat);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		panel_2.setBounds(0, 93, 357, 588);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblFriend = new JLabel("Friend");
		lblFriend.setForeground(new Color(255, 255, 255));
		lblFriend.setFont(new Font("Agency FB", Font.BOLD, 32));
		lblFriend.setIcon(new ImageIcon("images/friendship.png"));
		lblFriend.setBounds(0, 112, 357, 70);
		panel_2.add(lblFriend);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 189, 357, 14);
		panel_2.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 94, 357, 14);
		panel_2.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 284, 357, 14);
		panel_2.add(separator_2);
		
		JLabel lblChat = new JLabel("Chat");
		lblChat.setForeground(Color.WHITE);
		lblChat.setFont(new Font("Agency FB", Font.BOLD, 32));
		lblChat.setBounds(0, 207, 357, 70);
		lblChat.setIcon(new ImageIcon("images/laugh.png"));
		panel_2.add(lblChat);
		this.setVisible(true);
	}
}
