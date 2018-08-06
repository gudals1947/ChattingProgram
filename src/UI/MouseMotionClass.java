package UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import ChattingSouce.APIExamSearchBlog;

class MouseMotionClass extends MouseAdapter {
	ChattingForm superClass;
	APIExamSearchBlog apiExamSearchBlog;
	ArrayList<String> title = new ArrayList<String>();

	public MouseMotionClass(ChattingForm chattingForm, APIExamSearchBlog apiExamSearchBlog) {
		// TODO Auto-generated constructor stub
		this.superClass = chattingForm;
		this.apiExamSearchBlog = apiExamSearchBlog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		title.removeAll(title);
		apiExamSearchBlog.searchBlog(superClass.tfSearch.getText());
		title = apiExamSearchBlog.getTitle();
		System.out.println("title:" + title);
		for (int i = 0; i < superClass.lbBlogTitle.length; i++) {
			superClass.lbBlogTitle[i].setText("<html><body><a href=http:책 더보기>" + title.get(i) + "</body></html>");
		}
		super.mouseClicked(e);
	}
}
