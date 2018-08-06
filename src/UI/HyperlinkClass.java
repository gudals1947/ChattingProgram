package UI;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

class HyperlinkClass extends MouseAdapter {
	int cheak;
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
		if (name.equals("블로그")) {
			if (e.getSource() == form.lbBlogTitle[cheak]) {
				form.lbBlogTitle[cheak].addHyperlinkListener(new HyperlinkListener() {
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
						form.lbBlogTitle[cheak].removeHyperlinkListener(this);
					}
				});
			} else if (e.getSource() == form.lbBlogbotton[cheak]) {
				form.lbBlogbotton[cheak].addHyperlinkListener(new HyperlinkListener() {
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
						form.lbBlogbotton[cheak].removeHyperlinkListener(this);
					}
				});
			}
		}

		super.mousePressed(e);
	}
}