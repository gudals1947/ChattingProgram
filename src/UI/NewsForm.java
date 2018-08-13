package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class NewsForm extends JPanel {

	JPanel plNews[] = new JPanel[5];
	JPanel plNewsContents = new JPanel();
	JEditorPane lbNewstitle[] = new JEditorPane[5];
	JEditorPane lbNewscontents[] = new JEditorPane[5];
	JEditorPane lbNewsbotton[] = new JEditorPane[5];
	JLabel lbNumber[];
	JPanel plBotton = new JPanel();
	ButtonGroup group = new ButtonGroup();
	int check;
	ChattingForm form;
	KeyBoardClass keyBoardClass;
	JRadioButton rbSim = new JRadioButton("정확도 순");
	JRadioButton rbSort = new JRadioButton("최신 순");
	int number;

	public NewsForm(KeyBoardClass keyboardclass, ChattingForm form, int count, int check) {
		this.keyBoardClass = keyboardclass;
		this.form = form;
		lbNumber = new JLabel[count];
		this.check = check;
		setting();

		setBackground(Color.WHITE);
		this.setBounds(0, 172, 964, 1078);
		setLayout(new BorderLayout(0, 0));

		JPanel plTop = new JPanel();
		plTop.setForeground(Color.DARK_GRAY);
		plTop.setBackground(Color.WHITE);
		add(plTop, BorderLayout.NORTH);
		plTop.setLayout(new BorderLayout(0, 0));

		JLabel lbBlog = new JLabel("뉴스");
		lbBlog.setFont(new Font("굴림", Font.BOLD, 27));
		lbBlog.setHorizontalAlignment(SwingConstants.LEFT);
		plTop.add(lbBlog, BorderLayout.WEST);

		JPanel plRadioButton = new JPanel();
		plRadioButton.setBackground(Color.WHITE);
		plTop.add(plRadioButton, BorderLayout.EAST);

		rbSim.setSelected(true);
		rbSim.setFont(new Font("굴림", Font.BOLD, 21));
		rbSim.setBackground(Color.WHITE);
		plRadioButton.add(rbSim);
		group.add(rbSim);
		rbSim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				keyboardclass.totalsetting("sim");
				keyboardclass.Newssetting(0);
				keyboardclass.setting();
				rbSim.removeActionListener(this);
			}
		});

		rbSort.setFont(new Font("굴림", Font.BOLD, 21));
		rbSort.setBackground(Color.WHITE);
		plRadioButton.add(rbSort);
		group.add(rbSort);
		rbSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				keyboardclass.totalsetting("date");
				keyboardclass.Newssetting(1);
				keyboardclass.setting();
				rbSort.removeActionListener(this);
			}
		});

		plNewsContents.setBackground(Color.white);
		plNewsContents.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		add(plNewsContents, BorderLayout.CENTER);
		plNewsContents.setLayout(new GridLayout(0, 1, 0, 0));

		plBotton.setBackground(Color.WHITE);
		add(plBotton, BorderLayout.SOUTH);

		start();

	}

	private void start() {
		// TODO Auto-generated method stub
		for (int i = 0; i < lbNewstitle.length; i++) {
			lbNewstitle[i].setName("블로그");
			lbNewstitle[i].addMouseListener(new MouseClickEvent(this,i));
		}
	}

	private void setting() {
		// TODO Auto-generated method stub
		for (int i = 0; i < lbNumber.length; i++) {
			lbNumber[i] = new JLabel("" + (i + 1));
			lbNumber[i].setFont(new Font("굴림", Font.BOLD, 20));
			if (check == i) {
				lbNumber[check].setForeground(Color.green);
				lbNumber[check].setBorder(BorderFactory.createLineBorder(Color.green, 3));
			}
			lbNumber[i].addMouseListener(new ChoiceEvent(form, this, i, 1));
			plBotton.add(lbNumber[i]);
		}

		for (int i = 0; i < plNews.length; i++) {
			plNews[i] = new JPanel(new GridLayout(3, 1, 0, 0));
			lbNewstitle[i] = new JEditorPane();
			lbNewscontents[i] = new JEditorPane();
			lbNewsbotton[i] = new JEditorPane();

			lbNewstitle[i].setContentType("text/html");
			lbNewstitle[i].setEditable(false);
			lbNewscontents[i].setContentType("text/html");
			lbNewscontents[i].setEditable(false);
			lbNewsbotton[i].setContentType("text/html");
			lbNewsbotton[i].setEditable(false);

			plNews[i].add(lbNewstitle[i]);
			plNews[i].add(lbNewscontents[i]);
			plNews[i].add(lbNewsbotton[i]);
			plNewsContents.add(plNews[i]);
		}
	}
}

class Hyperlink2Class implements HyperlinkListener {
	int number;
	NewsForm form;
	public Hyperlink2Class(NewsForm form, int number) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.form = form;
	}

	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		// TODO Auto-generated method stub
		URI uri;
		try {
			uri = new URI(e.getURL().toString());
			Desktop.getDesktop().browse(uri);
		} catch (IOException | URISyntaxException e2) {
			// TODO: handle exception
		}
		form.lbNewstitle[number].removeHyperlinkListener(this);		
	}
}

class MouseClickEvent extends MouseAdapter{
	int number;
	NewsForm form;
	public MouseClickEvent(NewsForm form,int number) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.form = form;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		form.lbNewstitle[number].addHyperlinkListener(new Hyperlink2Class(form,this.number));
		super.mouseClicked(e);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		form.lbNewstitle[number].addHyperlinkListener(new Hyperlink2Class(form,this.number));
		super.mousePressed(e);
	}
}