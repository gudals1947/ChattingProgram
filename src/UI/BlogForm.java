package UI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import java.awt.Font;

public class BlogForm extends JPanel {

	JPanel plblog[] = new JPanel[5];
	JPanel plBlogContents = new JPanel();
	JEditorPane lbblogtitle[] = new JEditorPane[5];
	JEditorPane lbblogcontents[] = new JEditorPane[5];
	JEditorPane lbblogbotton[] = new JEditorPane[5];
	JLabel lbNumber[];
	JPanel plBotton = new JPanel();
	ButtonGroup group = new ButtonGroup();
	int check;
	ChattingForm form;
	KeyBoardClass keyBoardClass;
	JRadioButton rbSim = new JRadioButton("정확도 순");
	JRadioButton rbSort = new JRadioButton("최신 순");

	public BlogForm(KeyBoardClass keyboardclass, ChattingForm form, int count, int check) {
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

		JLabel lbBlog = new JLabel("블로그");
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
				keyboardclass.blogsetting(0);
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
				keyboardclass.blogsetting(1);
				keyboardclass.setting();
				rbSort.removeActionListener(this);
			}
		});

		plBlogContents.setBackground(Color.white);
		plBlogContents.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		add(plBlogContents, BorderLayout.CENTER);
		plBlogContents.setLayout(new GridLayout(0, 1, 0, 0));

		plBotton.setBackground(Color.WHITE);
		add(plBotton, BorderLayout.SOUTH);

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
			lbNumber[i].addMouseListener(new ChoiceEvent(form, this, i, 0));
			plBotton.add(lbNumber[i]);
		}

		for (int i = 0; i < plblog.length; i++) {
			plblog[i] = new JPanel(new GridLayout(3, 1, 0, 0));
			lbblogtitle[i] = new JEditorPane();
			lbblogcontents[i] = new JEditorPane();
			lbblogbotton[i] = new JEditorPane();

			lbblogtitle[i].setContentType("text/html");
			lbblogtitle[i].setEditable(false);
			lbblogcontents[i].setContentType("text/html");
			lbblogcontents[i].setEditable(false);
			lbblogbotton[i].setContentType("text/html");
			lbblogbotton[i].setEditable(false);

			plblog[i].add(lbblogtitle[i]);
			plblog[i].add(lbblogcontents[i]);
			plblog[i].add(lbblogbotton[i]);
			plBlogContents.add(plblog[i]);
			
			lbblogtitle[i].addMouseListener(new MouseClickEvent3(this, i));
			lbblogbotton[i].addMouseListener(new MouseClickEvent3(this, i));
		}
	}

}

class HyperlinkClass4 implements HyperlinkListener {
	int number;
	BlogForm form;

	public HyperlinkClass4(BlogForm form, int number) {
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
		form.lbblogtitle[number].removeHyperlinkListener(this);
		form.lbblogbotton[number].removeHyperlinkListener(this);
	}
}

class MouseClickEvent3 extends MouseAdapter {
	int number;
	BlogForm form;

	public MouseClickEvent3(BlogForm form, int number) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.form = form;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		form.lbblogtitle[number].addHyperlinkListener(new HyperlinkClass4(form, this.number));
		form.lbblogbotton[number].addHyperlinkListener(new HyperlinkClass4(form, this.number));
		super.mousePressed(e);
	}
}
