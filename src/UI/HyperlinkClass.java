package UI;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

class HyperlinkClass extends MouseAdapter {
	int cheak;
	int remove;
	ChattingForm form;
	String name;

	public HyperlinkClass(ChattingForm form, int cheak, String name) {
		// TODO Auto-generated constructor stub
		this.cheak = cheak;
		this.form = form;
		this.name = name;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		String str[] = { "블로그", "뉴스" ,"백과사전"};
		ArrayList<JEditorPane[]> formlb = new ArrayList();
		formlb.add(form.lbBlogTitle);
		formlb.add(form.lbBlogbotton);
		formlb.add(form.lbNewTitle);
		formlb.add(form.lbBookTitle);
//		formlb.add(form.newsform.);
//		formlb.add(form.lbNewTitle);
		
		for (int i = 0; i < str.length; i++) {
			if (name.equals(str[i])) {
				for (int j = 0; j < formlb.size(); j++) {
					if (e.getSource() == formlb.get(j)[cheak]) {
						remove = j;
						formlb.get(remove)[cheak].addHyperlinkListener(new HyperlinkListener() {
							URI uri;
							@Override
							public void hyperlinkUpdate(HyperlinkEvent e) {
								// TODO Auto-generated method stub

								try {
									uri = new URI(e.getURL().toString());
									Desktop.getDesktop().browse(uri);
								} catch (IOException | URISyntaxException e2) {
									// TODO: handle exception
								}
								formlb.get(remove)[cheak].removeHyperlinkListener(this);
							}
						});
					}
				}
			}
		}

		super.mousePressed(e);
	}
}