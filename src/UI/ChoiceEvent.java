package UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoiceEvent extends MouseAdapter {
	JPanel plform;
	int count;
	ChattingForm form;
	JPanel panel[];
	int choice;

	public ChoiceEvent(ChattingForm form, JPanel plform, int count, int choice) {
		// TODO Auto-generated constructor stub
		this.form = form;
		this.plform = plform;
		this.count = count;
		this.choice = choice;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("클릭댐");
		// System.out.println("count:"+count);
		ArrayList<JPanel[]> objects = new ArrayList<>();
		objects.add(form.blogform);
		objects.add(form.newsform);
		objects.add(form.bookform);
		form.panel.removeAll();
		form.panel.add(form.plBar);
		for (int i = 0; i < objects.size(); i++) {
			if (choice == i) {
				objects.get(i)[count].setBounds(0, 53, 964, 1067);
				form.panel.add(objects.get(i)[count]);
			}
		}
		form.panel.updateUI();
		super.mouseClicked(e);
	}
}
