package UI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ChattingSouce.APIExamSearchBlog;
import ChattingSouce.APIExamSearchNews;
import ChattingSouce.APIExamSearchencyc;

public class PanelchangeEvent extends MouseAdapter {
	ChattingForm superclass;
	int count;
	String choiceString;
	JPanel form;

	public PanelchangeEvent(ChattingForm form, int count, String addexample) {
		// TODO Auto-generated constructor stub
		superclass = form;
		this.count = count;
		choiceString = addexample;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (choiceString.equals("통합검색")) {
			superclass.panel.removeAll();
			superclass.panel.add(superclass.plBar);
			KeyBoardClass keyBoardClass =new KeyBoardClass(superclass, new APIExamSearchBlog(),new APIExamSearchNews(), new APIExamSearchencyc(), superclass.boolcheck, "sim");
			keyBoardClass.totalsetting("sim");
			keyBoardClass.blogsetting(0);
			keyBoardClass.Newssetting(0);
			keyBoardClass.booksetting(0);
			keyBoardClass.setting();
			
			// superclass.panel.add(superclass.separator);
		}
		JLabel lb[] = { superclass.lbBarSearch, superclass.lbBarBlog, superclass.lbBarNew, superclass.lbBarBook };
		ArrayList<JPanel> addPanel = new ArrayList<JPanel>();
		addPanel.add(superclass.plContent);
		addPanel.add(superclass.blogform[0]);
		addPanel.add(superclass.newsform[0]);
		addPanel.add(superclass.bookform[0]);
		for (int i = 0; i < superclass.boolcheck.length; i++) {
			if (count == i) {
				lb[i].setForeground(Color.green);
				superclass.boolcheck[i] = true;
			} else {
				lb[i].setForeground(Color.BLACK);
				superclass.boolcheck[i] = false;
			}
		}

		try {
			for (int i = 0; i < addPanel.size(); i++) {
				if (superclass.panel.getBounds().height != 0) {
					if (superclass.boolcheck[i] == true) {
						superclass.panel.removeAll();
						superclass.panel.add(superclass.plBar);
						addPanel.get(i).setBounds(0, 53, 964, 1067);
						superclass.panel.add(addPanel.get(i));
						superclass.panel.updateUI();
					}

				}
			}
		} catch (Exception e5) {
			// TODO: handle exception
			System.out.println(e5);
		}

		super.mouseClicked(e);
	}

}
