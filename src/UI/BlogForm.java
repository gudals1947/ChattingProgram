package UI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import java.awt.Font;

public class BlogForm extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel plblog[] = new JPanel[5];
	JPanel plBlogContents = new JPanel();
	JEditorPane lbblogtitle[] = new JEditorPane[5];
	JEditorPane lbblogcontents[] = new JEditorPane[5];
	JEditorPane lbblogbotton[] = new JEditorPane[5];
	JLabel lbNumber[];
	JPanel plBotton = new JPanel();
	ButtonGroup group = new ButtonGroup();
	int check;

	public BlogForm(int count,int check) {
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

		JRadioButton rbSim = new JRadioButton("정확도 순");
		rbSim.setSelected(true);
		rbSim.setFont(new Font("굴림", Font.BOLD, 21));
		rbSim.setBackground(Color.WHITE);
		plRadioButton.add(rbSim);
		group.add(rbSim);
		
		JRadioButton rbSort = new JRadioButton("최신 순");
		rbSort.setFont(new Font("굴림", Font.BOLD, 21));
		rbSort.setBackground(Color.WHITE);
		plRadioButton.add(rbSort);
		group.add(rbSort);
		
		plBlogContents.setBackground(Color.white);
		plBlogContents.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		add(plBlogContents, BorderLayout.CENTER);
		plBlogContents.setLayout(new GridLayout(0, 1, 0, 0));

		plBotton.setBackground(Color.WHITE);
		add(plBotton, BorderLayout.SOUTH);

		// plBotton.add(lbNumber);

	}

	private void setting() {
		// TODO Auto-generated method stub
		for (int i = 0; i < lbNumber.length; i++) {
			lbNumber[i] = new JLabel(""+(i+1));
			lbNumber[i].setFont(new Font("굴림", Font.BOLD, 20));
			plBotton.add(lbNumber[i]);
			if(check==i) {
				lbNumber[check].setForeground(Color.green);
				lbNumber[check].setBorder(BorderFactory.createLineBorder(Color.green, 3));
			}
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
		}
	}
}
