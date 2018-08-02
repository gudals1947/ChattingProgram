package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChattingSouce.*;
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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import javax.swing.JSlider;
import javax.swing.JEditorPane;

class MouseMotionClass extends MouseAdapter{
	ChattingForm superClass;
	APIExamSearchBlog apiExamSearchBlog;
	public MouseMotionClass(ChattingForm chattingForm, APIExamSearchBlog apiExamSearchBlog) {
		// TODO Auto-generated constructor stub
		this.superClass = chattingForm;
		this.apiExamSearchBlog = apiExamSearchBlog;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		apiExamSearchBlog.searchBlog(superClass.tfSearch.getText());
		
		super.mouseClicked(e);
	}
}

public class ChattingForm extends JFrame implements MouseListener {

	JPanel contentPane;
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
	JLabel lblist = new JLabel("");

	JLabel[] upLable = new JLabel[] { lbchat, lbfreind, lbhome, lboption, lbLogout };
	JPanel[] upPanel = new JPanel[] { plchat, plfriend, plHome, ploption, plLogout };
	String[] iconpath = new String[] { "chat", "support", "home", "settings-work-tool", "logout" };
	boolean[] boolIcon = new boolean[] { false, false, true, false, false };
	int key = 0;
	JTextField tfSearch;
	private final JLabel label_1 = new JLabel("KHMCS");
	private final JLabel label_3 = new JLabel("블로그");
	private final JLabel label_4 = new JLabel("뉴스");
	private final JLabel label_5 = new JLabel("책");
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JPanel panel_5 = new JPanel();
	private final JLabel lblNewLabel = new JLabel("블로그");
	private final JLabel label_6 = new JLabel("뉴스");
	private final JLabel label_7 = new JLabel("책");
	private final JEditorPane editorPane_1 = new JEditorPane();
	private final JEditorPane editorPane_2 = new JEditorPane();

	public ChattingForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 1285);
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
		lblHyungminkim.setBounds(91, 9, 123, 35);
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

		plHome.setBackground(Color.CYAN);
		plHome.setBounds(709, 0, 52, 53);
		pl_North.add(plHome);

		plHome.add(lbhome);
		lbhome.setBackground(new Color(255, 255, 255));
		lbhome.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/home(2).png")));

		lblist.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/list-menu.png")));
		lblist.setBounds(17, 9, 37, 35);
		pl_North.add(lblist);
		pl_left.setBackground(Color.BLACK);
//		System.out.println(this.getBounds().height);

		pl_left.setBounds(0, 53, 0, this.getBounds().height);
		contentPane.add(pl_left);
		pl_left.setLayout(null);
		label.setForeground(Color.WHITE);

		label.setFont(new Font("굴림", Font.PLAIN, 15));
		label.setBounds(4, 203, 137, 35);
		pl_left.add(label);
		
		JPanel pl_home = new JPanel();
		pl_home.setBackground(Color.WHITE);
		pl_home.setBounds(0, 53, 1038, 1144);
		contentPane.add(pl_home);
		pl_home.setLayout(null);
		
		tfSearch = new JTextField();
		tfSearch.setHorizontalAlignment(SwingConstants.LEFT);
		tfSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		tfSearch.setBorder(new LineBorder(new Color(50, 205, 50), 2, true));
		tfSearch.setBounds(219, 70, 552, 41);
		pl_home.add(tfSearch);
		tfSearch.setColumns(10);
		label_1.setForeground(new Color(50, 205, 50));
		label_1.setFont(new Font("굴림", Font.PLAIN, 35));
		label_1.setBounds(46, 73, 123, 35);
		
		pl_home.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 205, 50));
		panel.setBorder(new LineBorder(new Color(50, 205, 50), 2, true));
		panel.setBounds(770, 70, 53, 41);
		pl_home.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbsearch = new JLabel("");
		lbsearch.addMouseListener(new MouseMotionClass(this,new APIExamSearchBlog()));
		lbsearch.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/search.png")));
		panel.add(lbsearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 172, 964, 2);
		pl_home.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 223, 964, 2);
		pl_home.add(separator_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 172, 964, 53);
		
		pl_home.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel label_2 = new JLabel("통합검색");
		panel_1.add(label_2);
		label_2.setFont(new Font("HY엽서M", Font.PLAIN, 30));
		label_2.setForeground(new Color(50, 205, 50));
		panel_1.add(label_3);
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("HY엽서M", Font.PLAIN, 30));
		panel_1.add(label_4);
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setFont(new Font("HY엽서M", Font.PLAIN, 30));
		panel_1.add(label_5);
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setFont(new Font("HY엽서M", Font.PLAIN, 30));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 223, 964, 921);
		
		pl_home.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		panel_3.setBackground(new Color(255, 255, 255));
		
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 27));
		lblNewLabel.setBounds(0, 25, 137, 35);
		
		panel_3.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("굴림", Font.PLAIN, 17));
		editorPane.setText("블로그 더보기");
		editorPane.setBounds(802, 272, 162, 35);
		editorPane.setContentType("text/html");
		editorPane.setEditable(false);
		editorPane.setText("<html><body><a href=http:블로그 더보기>블로그 더보기</body></html>");
		panel_3.add(editorPane);
		panel_4.setBackground(new Color(255, 255, 255));
		
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		label_6.setFont(new Font("굴림", Font.PLAIN, 27));
		label_6.setBounds(0, 25, 137, 35);
		
		panel_4.add(label_6);
		editorPane_1.setText("뉴스 더보기");
		editorPane_1.setFont(new Font("굴림", Font.PLAIN, 17));
		editorPane_1.setContentType("text/html");
		editorPane_1.setEditable(false);
		editorPane_1.setText("<html><body><a href=http:뉴스 더보기>뉴스 더보기</body></html>");
		editorPane_1.setBounds(802, 272, 162, 35);
		
		panel_4.add(editorPane_1);
		panel_5.setBackground(new Color(255, 255, 255));
		
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		label_7.setFont(new Font("굴림", Font.PLAIN, 27));
		label_7.setBounds(0, 25, 137, 35);
		
		panel_5.add(label_7);
		editorPane_2.setText("책 더보기");
		editorPane_2.setFont(new Font("굴림", Font.PLAIN, 17));
		editorPane_2.setContentType("text/html");
		editorPane_2.setEditable(false);
		editorPane_2.setText("<html><body><a href=http:책 더보기>책 더보기</body></html>");
		editorPane_2.setBounds(802, 272, 162, 35);
		
		panel_5.add(editorPane_2);

		start();
		this.setVisible(true);
	}

	private void start() {
		// TODO Auto-generated method stub
		for (int i = 0; i < upLable.length; i++) {
			upLable[i].addMouseListener(this);
			upLable[i].setName("위쪽상단아이콘");
		}
		lblist.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < upLable.length; i++) { // 위쪽상단바
			if (e.getSource() == upLable[i] && upLable[i].getName().equals("위쪽상단아이콘") && boolIcon[i] == false&&e.getSource()!=lblist) {
				upLable[i].setIcon(new ImageIcon(ChattingForm.class.getResource("/images/" + iconpath[i] + "(2).png")));
				upPanel[i].setBackground(Color.CYAN);
				boolIcon[i] = true;
			} else if (e.getSource() != upLable[i]&&e.getSource()!=lblist) {
				upLable[i].setIcon(new ImageIcon(ChattingForm.class.getResource("/images/" + iconpath[i] + ".png")));
				upPanel[i].setBackground(Color.black);
				boolIcon[i] = false;
			}
		}

		if (e.getSource() == lbLogout) { // 로그아웃버튼 클릭시
			new Form();
			setVisible(false);
		} else if (e.getSource() == lblist) // 리스트 클릭시
		{
			switch (key) {
			case 0:
				lblist.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/cancel-music.png")));
				key = 1;
				break;

			default:
				lblist.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/list-menu.png")));
				key = 0;
				break;
			}
			LeftThread thread = new LeftThread(this, key);
			thread.start();
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

class LeftThread extends Thread {
	ChattingForm chattingForm;
	int key;

	public LeftThread(ChattingForm chattingForm, int key) {
		// TODO Auto-generated constructor stub
		this.chattingForm = chattingForm;
		this.key = key;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (key == 1) {
			for (int i = 0; i < 214; i = i+15) {
				try {
					Thread.sleep(10);
					chattingForm.pl_left.setSize(i, chattingForm.getBounds().height);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (key == 0) {
			for (int i = chattingForm.pl_left.getWidth(); i >=0; i = i-15) {
				try {
					Thread.sleep(10);
					chattingForm.pl_left.setSize(i, chattingForm
							.getBounds().height);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		super.run();
	}
}

