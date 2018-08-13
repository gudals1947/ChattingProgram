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

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class BookForm extends JPanel {

	JPanel plbooks[] = new JPanel[5];
	JPanel plbooksContents = new JPanel();
	JEditorPane lbbookstitle[] = new JEditorPane[5];
	JEditorPane lbbookscontents[] = new JEditorPane[5];
	JEditorPane lbbooksbotton[] = new JEditorPane[5];
	JLabel lbNumber[];
	JPanel plBotton = new JPanel();
	ButtonGroup group = new ButtonGroup();
	int check;
	ChattingForm form;
	KeyBoardClass keyBoardClass;
	JRadioButton rbSim = new JRadioButton("정확도 순");
	JRadioButton rbSort = new JRadioButton("최신 순");

	public BookForm(KeyBoardClass keyboardclass, ChattingForm form, int count, int check) {
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

		JLabel lbBlog = new JLabel("백과사전");
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
				keyboardclass.booksetting(0);
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
				keyboardclass.booksetting(1);
				keyboardclass.setting();
				rbSort.removeActionListener(this);
			}
		});

		plbooksContents.setBackground(Color.white);
		plbooksContents.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		add(plbooksContents, BorderLayout.CENTER);
		plbooksContents.setLayout(new GridLayout(0, 1, 0, 0));

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
			lbNumber[i].addMouseListener(new ChoiceEvent(form, this, i, 2));
			plBotton.add(lbNumber[i]);
		}

		for (int i = 0; i < plbooks.length; i++) {
			plbooks[i] = new JPanel(new BorderLayout());
			lbbookstitle[i] = new JEditorPane();
			lbbookscontents[i] = new JEditorPane();
			lbbooksbotton[i] = new JEditorPane();

			lbbookstitle[i].setContentType("text/html");
			lbbookstitle[i].setEditable(false);
			lbbookscontents[i].setContentType("text/html");
			lbbookscontents[i].setEditable(false);
			lbbooksbotton[i].setContentType("text/html");
			lbbooksbotton[i].setEditable(false);

			plbooks[i].add(lbbookstitle[i], BorderLayout.NORTH);
			plbooks[i].add(lbbookscontents[i], BorderLayout.CENTER);
			plbooks[i].add(lbbooksbotton[i], BorderLayout.WEST);
			plbooksContents.add(plbooks[i]);
			
			lbbookstitle[i].addMouseListener(new MouseClickEvent2(this, i));
		}
	}
}

class HyperlinkClass3 implements HyperlinkListener {
	int number;
	BookForm form;

	public HyperlinkClass3(BookForm form, int number) {
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
		form.lbbookstitle[number].removeHyperlinkListener(this);
	}
}

class MouseClickEvent2 extends MouseAdapter {
	int number;
	BookForm form;

	public MouseClickEvent2(BookForm form, int number) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.form = form;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		form.lbbookstitle[number].addHyperlinkListener(new HyperlinkClass3(form, this.number));
		super.mousePressed(e);
	}
}
