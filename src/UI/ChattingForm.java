package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChattingSouce.ChattingMain;

import java.awt.Color;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JSeparator;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;

class ChattingForm extends JFrame implements MouseListener {

	private JPanel contentPane;
	JPanel pl_North = new JPanel();
	JLabel lblHyungminkim = new JLabel("KHMCS");
	JPanel plLogout = new JPanel();
	JPanel ploption = new JPanel();
	JPanel plchat = new JPanel();
	JPanel plHome = new JPanel();
	JLabel lbfreind = new JLabel("");
	JLabel lbLogout = new JLabel("");
	JLabel lboption = new JLabel("");
	JLabel lbchat = new JLabel("");
	JLabel lbhome = new JLabel("");
	JPanel pl_left = new JPanel();
	JLabel label = new JLabel("회원이름적는곳");
	JPanel plfriend = new JPanel();

	JLabel[] upLable = new JLabel[] { lbchat, lbfreind, lbhome, lboption, lbLogout };
	JPanel[] upPanel = new JPanel[] { plchat, plfriend, plHome, ploption, plLogout };
	String[] iconpath = new String[] {"chat","support","home","settings-work-tool","logout"};
	boolean[] boolIcon = new boolean[] {false,false,false,false,false};

	public ChattingForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 975);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		plchat.setBackground(Color.BLACK);
		pl_North.setBackground(new Color(0, 0, 0));
		pl_North.setBounds(0, 0, 964, 53);
		contentPane.add(pl_North);
		pl_North.setLayout(null);

		lblHyungminkim.setFont(new Font("굴림", Font.PLAIN, 35));
		lblHyungminkim.setForeground(new Color(255, 255, 255));
		lblHyungminkim.setBounds(15, 9, 199, 35);
		pl_North.add(lblHyungminkim);

		plLogout.setBackground(new Color(0, 0, 0));
		plLogout.setBounds(912, 0, 52, 53);
		pl_North.add(plLogout);

		plLogout.add(lbLogout);
		lbLogout.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/logout.png")));

		ploption.setBackground(Color.BLACK);
		ploption.setBounds(862, 0, 52, 53);
		pl_North.add(ploption);

		ploption.add(lboption);
		lboption.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/settings-work-tool.png")));

		plchat.setBounds(811, 0, 52, 53);
		pl_North.add(plchat);

		plchat.add(lbchat);
		lbchat.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/chat.png")));

		plfriend.setBackground(Color.BLACK);
		plfriend.setBounds(760, 0, 52, 53);
		pl_North.add(plfriend);

		plfriend.add(lbfreind);
		lbfreind.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/support.png")));

		plHome.setBackground(Color.BLACK);
		plHome.setBounds(709, 0, 52, 53);
		pl_North.add(plHome);

		plHome.add(lbhome);
		lbhome.setBackground(new Color(255, 255, 255));
		lbhome.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/home.png")));

		pl_left.setBounds(0, 53, 214, 834);
		contentPane.add(pl_left);
		pl_left.setLayout(null);

		label.setFont(new Font("굴림", Font.PLAIN, 15));
		label.setBounds(4, 203, 137, 35);
		pl_left.add(label);

		// lbfreind.addMouseListener(this);
		// lbLogout.addMouseListener(this);
		// lboption.addMouseListener(this);
		// lbchat.addMouseListener(this);
		// lbhome.addMouseListener(this);
		start();
		this.setVisible(true);
	}

	private void start() {
		// TODO Auto-generated method stub
		for (int i = 0; i < upLable.length; i++) {
			upLable[i].addMouseListener(this);
			upLable[i].setName("위쪽상단아이콘");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int check = -1;	
		for (int i = 0; i < upLable.length; i++) { // 위쪽상단바
			if (e.getSource() == upLable[i] && upLable[i].getName().equals("위쪽상단아이콘")&& boolIcon[i]== false) {
				upLable[i].setIcon(new ImageIcon(ChattingForm.class.getResource("/images/"+iconpath[i]+"(2).png")));
				upPanel[i].setBackground(Color.CYAN);
				boolIcon[i] = true;
			}
			else if (e.getSource() != upLable[i] ) {
				upLable[i].setIcon(new ImageIcon(ChattingForm.class.getResource("/images/"+iconpath[i]+".png")));
				upPanel[i].setBackground(Color.black);
				boolIcon[i] = false;
			}
			
		}
		if(e.getSource()==lbLogout) {
			new Form();
			setVisible(false);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < upLable.length; i++) { // 위쪽상단바
			if (e.getSource() == upLable[i] && upLable[i].getName().equals("위쪽상단아이콘") && boolIcon[i] == false) {
				upPanel[i].setBackground(Color.lightGray);
				break;
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {

		for (int i = 0; i < upLable.length; i++) { // 위쪽상단바
			if (e.getSource() == upLable[i] && upLable[i].getName().equals("위쪽상단아이콘") && boolIcon[i] == false) {
				upPanel[i].setBackground(Color.black);

				break;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
