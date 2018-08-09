package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import ChattingSouce.APIExamSearchBlog;
import ChattingSouce.APIExamSearchNews;
import ChattingSouce.APIExamSearchencyc;

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
	boolean[] boolcheck = new boolean[] { true, false, false, false };
	
	int key = 0;
	JTextField tfSearch;
	JLabel label_1 = new JLabel("KHMCS");
	JLabel lbBarBlog = new JLabel("블로그");
	JLabel lbBarNew = new JLabel("뉴스");
	JLabel lbBarBook = new JLabel("백과사전");
	JPanel plBar = new JPanel();
	JPanel plContent = new JPanel();
	JPanel plBlog = new JPanel();
	JPanel plNews = new JPanel();
	JPanel plBooks = new JPanel();

	JLabel lbBarSearch = new JLabel("통합검색");
	JLabel lbBlog = new JLabel("블로그");
	JLabel lbNews = new JLabel("뉴스");
	JLabel lbBook = new JLabel("백과사전");
	JEditorPane edNews = new JEditorPane();
	JEditorPane edBook = new JEditorPane();
	JPanel plBlogContent = new JPanel();
	JPanel plNewContent = new JPanel();
	JPanel plBookContent = new JPanel();

	JPanel plBlogContents[] = new JPanel[2];
	JEditorPane lbBlogTitle[] = new JEditorPane[2];
	JEditorPane lbBlogContents[] = new JEditorPane[2];
	JEditorPane lbBlogbotton[] = new JEditorPane[2];

	JPanel plNewContents[] = new JPanel[2];
	JEditorPane lbNewTitle[] = new JEditorPane[2];
	JEditorPane lbNewContents[] = new JEditorPane[2];
	JEditorPane lbNewbotton[] = new JEditorPane[2];

	JPanel plBookContents[] = new JPanel[2];
	JEditorPane lbBookTitle[] = new JEditorPane[2];
	JEditorPane lbBookContents[] = new JEditorPane[2];
	JEditorPane lbBookimage[] = new JEditorPane[2];

	JPanel panel = new JPanel();
	BlogForm blogform[];

	public ChattingForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 1391);
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
		// System.out.println(this.getBounds().height);

		pl_left.setBounds(0, 53, 0, this.getBounds().height);
		contentPane.add(pl_left);
		pl_left.setLayout(null);
		label.setForeground(Color.WHITE);

		label.setFont(new Font("굴림", Font.PLAIN, 15));
		label.setBounds(4, 203, 137, 35);
		pl_left.add(label);

		JPanel pl_home = new JPanel();
		pl_home.setBackground(Color.WHITE);
		pl_home.setBounds(0, 53, 1038, 1250);
		contentPane.add(pl_home);
		pl_home.setLayout(null);

		tfSearch = new JTextField();
		tfSearch.setHorizontalAlignment(SwingConstants.LEFT);
		tfSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		tfSearch.setBorder(new LineBorder(new Color(50, 205, 50), 2, true));
		tfSearch.setBounds(219, 70, 552, 41);
		pl_home.add(tfSearch);
		tfSearch.setColumns(10);
		tfSearch.addKeyListener(new KeyBoardClass(this, new APIExamSearchBlog(), new APIExamSearchNews(), new APIExamSearchencyc(),boolcheck));
		
		label_1.setForeground(new Color(50, 205, 50));
		label_1.setFont(new Font("굴림", Font.PLAIN, 35));
		label_1.setBounds(46, 73, 123, 35);

		pl_home.add(label_1);

		JPanel plSearch = new JPanel();
		plSearch.setBackground(new Color(50, 205, 50));
		plSearch.setBorder(new LineBorder(new Color(50, 205, 50), 2, true));
		plSearch.setBounds(770, 70, 53, 41);
		pl_home.add(plSearch);
		plSearch.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lbsearch = new JLabel("");
		lbsearch.addMouseListener(new MouseMotionClass(this, new APIExamSearchBlog()));
		lbsearch.setIcon(new ImageIcon(ChattingForm.class.getResource("/images/search.png")));
		plSearch.add(lbsearch);

		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 0, 0);
		pl_home.add(panel);
		panel.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 964, 2);
		panel.add(separator);
		plBar.setBounds(0, 0, 964, 53);
		panel.add(plBar);
		plBar.setBackground(new Color(255, 255, 255));
		plBar.setLayout(new GridLayout(1, 0, 10, 0));

		plBar.add(lbBarSearch);
		lbBarSearch.setFont(new Font("HY엽서M", Font.PLAIN, 30));
		lbBarSearch.setForeground(new Color(50, 205, 50));
	

		plBar.add(lbBarBlog);
		lbBarBlog.setForeground(new Color(0, 0, 0));
		lbBarBlog.setFont(new Font("HY엽서M", Font.PLAIN, 30));


		plBar.add(lbBarNew);
		lbBarNew.setForeground(new Color(0, 0, 0));
		lbBarNew.setFont(new Font("HY엽서M", Font.PLAIN, 30));

		plBar.add(lbBarBook);
		lbBarBook.setForeground(new Color(0, 0, 0));
		lbBarBook.setFont(new Font("HY엽서M", Font.PLAIN, 30));

		plContent.setBounds(0, 53, 964, 1067);
		panel.add(plContent);
		plContent.setBackground(new Color(255, 255, 255));
		plContent.setLayout(new GridLayout(0, 1, 0, 0));
		plBlog.setBackground(new Color(255, 255, 255));

		plContent.add(plBlog);
		plBlog.setLayout(null);
		lbBlog.setFont(new Font("굴림", Font.PLAIN, 27));
		lbBlog.setBounds(0, 0, 137, 35);

		plBlog.add(lbBlog);

		JEditorPane edBlog = new JEditorPane();
		edBlog.setFont(new Font("굴림", Font.PLAIN, 17));
		edBlog.setBounds(802, 272, 162, 35);
		edBlog.setContentType("text/html");
		edBlog.setEditable(false);
		edBlog.setText("<html><body><a href=http:블로그 더보기>블로그 더보기</body></html>");
		plBlog.add(edBlog);

		plBlogContent.setBackground(Color.WHITE);
		plBlogContent.setBounds(0, 65, 964, 204);
		plBlog.add(plBlogContent);
		plBlogContent.setLayout(new GridLayout(0, 1, 0, 0));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 964, 2);
		plBlog.add(separator_1);
		plNews.setBackground(new Color(255, 255, 255));

		plContent.add(plNews);
		plNews.setLayout(null);
		lbNews.setFont(new Font("굴림", Font.PLAIN, 27));
		lbNews.setBounds(0, 0, 137, 35);

		plNews.add(lbNews);
		edNews.setFont(new Font("굴림", Font.PLAIN, 17));
		edNews.setContentType("text/html");
		edNews.setEditable(false);
		edNews.setText("<html><body><a href=http:뉴스 더보기>뉴스 더보기</body></html>");
		edNews.setBounds(802, 272, 162, 35);

		plNews.add(edNews);

		plNewContent.setBackground(Color.WHITE);
		plNewContent.setBounds(0, 60, 953, 204);
		plNews.add(plNewContent);
		plNewContent.setLayout(new GridLayout(0, 1, 0, 0));
		plBooks.setBackground(new Color(255, 255, 255));

		plContent.add(plBooks);
		plBooks.setLayout(null);
		lbBook.setFont(new Font("굴림", Font.PLAIN, 27));
		lbBook.setBounds(0, 0, 137, 35);

		plBooks.add(lbBook);
		edBook.setFont(new Font("굴림", Font.PLAIN, 17));
		edBook.setContentType("text/html");
		edBook.setEditable(false);
		edBook.setText("<html><body><a href=http:사전 더보기>사전 더보기</body></html>");
		edBook.setBounds(802, 272, 162, 35);

		plBooks.add(edBook);
		plBookContent.setBackground(Color.WHITE);
		plBookContent.setBounds(0, 43, 953, 204);

		plBooks.add(plBookContent);
		plBookContent.setLayout(new GridLayout(0, 1, 0, 0));

		blogSetting();
		newSetting();
		bookSetting();

		start();
		this.setVisible(true);
	}

	private void bookSetting() {
		// TODO Auto-generated method stub
		for (int i = 0; i < plBookContents.length; i++) { // 백과사전 api따오기
			plBookContents[i] = new JPanel(new BorderLayout());
			plBookContents[i].setBackground(Color.white);
			lbBookTitle[i] = new JEditorPane();
			lbBookContents[i] = new JEditorPane();
			lbBookimage[i] = new JEditorPane();

			plBookContents[i].add(lbBookTitle[i], BorderLayout.NORTH);
			plBookContents[i].add(lbBookContents[i], BorderLayout.CENTER);
			plBookContents[i].add(lbBookimage[i], BorderLayout.WEST);

			plBookContent.add(plBookContents[i]);

			lbBookTitle[i].setContentType("text/html");
			lbBookTitle[i].setEditable(false);

			lbBookContents[i].setContentType("text/html");
			lbBookContents[i].setEditable(false);

			lbBookimage[i].setContentType("text/html");
			lbBookimage[i].setEditable(false);

		}
	}

	private void newSetting() {
		// TODO Auto-generated method stub
		for (int i = 0; i < plBlogContents.length; i++) { // 뉴스 api따오기
			plNewContents[i] = new JPanel(new BorderLayout());
			plNewContents[i].setBackground(Color.white);
			lbNewTitle[i] = new JEditorPane();
			lbNewContents[i] = new JEditorPane();
			lbNewbotton[i] = new JEditorPane();

			plNewContents[i].add(lbNewTitle[i], BorderLayout.NORTH);
			plNewContents[i].add(lbNewContents[i], BorderLayout.CENTER);
			plNewContents[i].add(lbNewbotton[i], BorderLayout.SOUTH);

			plNewContent.add(plNewContents[i]);

			lbNewTitle[i].setContentType("text/html");
			lbNewTitle[i].setEditable(false);

			lbNewContents[i].setContentType("text/html");
			lbNewContents[i].setEditable(false);

			lbNewbotton[i].setContentType("text/html");
			lbNewbotton[i].setEditable(false);

		}
	}

	private void blogSetting() {
		// TODO Auto-generated method stub
		for (int i = 0; i < plBlogContents.length; i++) { // 블로그 api따오기
			plBlogContents[i] = new JPanel(new GridLayout(3, 1, 0, 0));
			plBlogContents[i].setBackground(Color.white);
			lbBlogTitle[i] = new JEditorPane();
			lbBlogContents[i] = new JEditorPane();
			lbBlogbotton[i] = new JEditorPane();

			plBlogContents[i].add(lbBlogTitle[i]);
			plBlogContents[i].add(lbBlogContents[i]);
			plBlogContents[i].add(lbBlogbotton[i]);

			plBlogContent.add(plBlogContents[i]);

			lbBlogTitle[i].setContentType("text/html");
			lbBlogTitle[i].setEditable(false);

			lbBlogContents[i].setContentType("text/html");
			lbBlogContents[i].setEditable(false);

			lbBlogbotton[i].setContentType("text/html");
			lbBlogbotton[i].setEditable(false);
		}
	}

	private void start() {
		// TODO Auto-generated method stub
		lblist.addMouseListener(this);

		for (int i = 0; i < upLable.length; i++) {
			upLable[i].addMouseListener(this);
			upLable[i].setName("위쪽상단아이콘");
		}

		for (int i = 0; i < lbBlogTitle.length; i++) {
			lbBlogTitle[i].setName("블로그");
			lbBlogbotton[i].setName("블로그");
			lbBlogTitle[i].addMouseListener(new HyperlinkClass(this, i, lbBlogTitle[i].getName()));
			lbBlogbotton[i].addMouseListener(new HyperlinkClass(this, i, lbBlogbotton[i].getName()));
		}

		for (int i = 0; i < lbNewTitle.length; i++) {
			lbNewTitle[i].setName("뉴스");
			lbNewTitle[i].addMouseListener(new HyperlinkClass(this, i, lbNewTitle[i].getName()));
		}
		for (int i = 0; i < lbBookTitle.length; i++) {
			lbBookTitle[i].setName("백과사전");
			lbBookTitle[i].addMouseListener(new HyperlinkClass(this, i, lbBookTitle[i].getName()));
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < upLable.length; i++) { // 위쪽상단바
			if (e.getSource() == upLable[i] && upLable[i].getName().equals("위쪽상단아이콘") && boolIcon[i] == false
					&& e.getSource() != lblist) {
				upLable[i].setIcon(new ImageIcon(ChattingForm.class.getResource("/images/" + iconpath[i] + "(2).png")));
				upPanel[i].setBackground(Color.CYAN);
				boolIcon[i] = true;
			} else if (e.getSource() != upLable[i] && e.getSource() != lblist) {
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
			for (int i = 0; i < 214; i = i + 15) {
				try {
					Thread.sleep(10);
					chattingForm.pl_left.setSize(i, chattingForm.getBounds().height);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (key == 0) {
			for (int i = chattingForm.pl_left.getWidth(); i >= 0; i = i - 15) {
				try {
					Thread.sleep(10);
					chattingForm.pl_left.setSize(i, chattingForm.getBounds().height);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		super.run();
	}
}
