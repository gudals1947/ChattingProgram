package UI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import ChattingSouce.APIExamSearchBlog;
import ChattingSouce.APIExamSearchNews;

public class KeyBoardClass extends KeyAdapter {
	ChattingForm superClass;
	APIExamSearchBlog apiExamSearchBlog;
	APIExamSearchNews apiExamSearchNews;
	
	ArrayList<String> bloggerTitle = new ArrayList<String>(); //블로그
	ArrayList<String> bloggerPostDate = new ArrayList<String>();
	ArrayList<String> bloggerContents = new ArrayList<String>();
	ArrayList<String> bloggerlink = new ArrayList<String>();
	ArrayList<String> bloggername = new ArrayList<String>();
	ArrayList<String> link = new ArrayList<String>();
	
	ArrayList<String> newsTitle = new ArrayList<>();
	ArrayList<String> originallink = new ArrayList<>();
	ArrayList<String> newsdescription = new ArrayList<>();
	



	public KeyBoardClass(ChattingForm chattingForm, APIExamSearchBlog apiExamSearchBlog,APIExamSearchNews apiExamSearchNews) {
		// TODO Auto-generated constructor stub
		this.superClass = chattingForm;
		this.apiExamSearchBlog = apiExamSearchBlog;
		this.apiExamSearchNews = apiExamSearchNews;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Removelist();
			apiExamSearchBlog.searchBlog(superClass.tfSearch.getText());
			apiExamSearchNews.searchNews(superClass.tfSearch.getText());
			
			bloggerTitle = apiExamSearchBlog.getTitle();
			bloggerPostDate = apiExamSearchBlog.getPostdate();
			bloggerContents = apiExamSearchBlog.getContents();
			bloggername = apiExamSearchBlog.getBloggername();
			bloggerlink = apiExamSearchBlog.getBloggerlink();
			link = apiExamSearchBlog.getLink();
			
			newsTitle = apiExamSearchNews.getTitle();
			originallink =apiExamSearchNews.getOriginallink();
			newsdescription = apiExamSearchNews.getDescription();
			
			for (int i = 0; i < superClass.lbBlogTitle.length; i++) {
				superClass.lbBlogTitle[i].setText("<html><body><a href='" + link.get(i) + "'>" + bloggerTitle.get(i)
						+ "</a><b style='color:gray'> &nbsp; &nbsp;" + bloggerPostDate.get(i) + "</b></body></html>");
				superClass.lbBlogContents[i].setText("<html><body>" + bloggerContents.get(i) + "</body></html>");
				superClass.lbBlogbotton[i].setText(
						"<html><body><a href='" + link.get(i) + "' style='text-decoration:none'><b style='color:gray'>"
								+ bloggername.get(i) + "</b>&nbsp;</a><a href='" + link.get(i)
								+ "' style='text-decoration:none'><b style='color:green'>" + bloggerlink.get(i)
								+ "</b></a></body></html>");
			}
			
			for (int i = 0 ; i < superClass.lbNewTitle.length ; i++) {
				superClass.lbNewTitle[i].setText("<html><body><a href='"+ originallink.get(i)+ "'>"+newsTitle.get(i)+"</a></body></html>");
				superClass.lbNewContents[i].setText("<html><body>"+newsdescription.get(i)+"</body></html>");
			}
			
		}
		super.keyReleased(e);
	}

	private void Removelist() {
		// TODO Auto-generated method stub
		bloggerTitle.removeAll(bloggerTitle);
		bloggerPostDate.removeAll(bloggerPostDate);
		bloggerContents.removeAll(bloggerContents);
		bloggerlink.removeAll(bloggerlink);
		bloggername.removeAll(bloggername);
		link.removeAll(link);
		
		newsTitle.removeAll(newsTitle);
		originallink.removeAll(originallink);
		newsdescription.removeAll(newsdescription);
	}

}
