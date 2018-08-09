package UI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ChattingSouce.APIExamSearchBlog;
import ChattingSouce.APIExamSearchNews;
import ChattingSouce.APIExamSearchencyc;

public class KeyBoardClass extends KeyAdapter {
	ChattingForm superClass;
	private SimpleDateFormat dateformat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", new Locale("en", "US"));

	APIExamSearchBlog apiExamSearchBlog;
	APIExamSearchNews apiExamSearchNews;
	APIExamSearchencyc apiExamSearchencyc;

	ArrayList<String> bloggerTitle = new ArrayList<String>(); // 블로그
	ArrayList<String> bloggerPostDate = new ArrayList<String>();
	ArrayList<String> bloggerContents = new ArrayList<String>();
	ArrayList<String> bloggerlink = new ArrayList<String>();
	ArrayList<String> bloggername = new ArrayList<String>();
	ArrayList<String> bloglink = new ArrayList<String>();

	ArrayList<String> newsTitle = new ArrayList<>();
	ArrayList<String> originallink = new ArrayList<>();
	ArrayList<String> newsdescription = new ArrayList<>();
	ArrayList<String> total = new ArrayList<>();
	ArrayList<String> newslink = new ArrayList<>();
	ArrayList<String> pubDate = new ArrayList<>();

	ArrayList<String> bookTitle = new ArrayList<>();
	ArrayList<String> bookcontents = new ArrayList<>();
	ArrayList<String> bookimages = new ArrayList<>();
	ArrayList<String> booklink = new ArrayList<>();
	ArrayList<JPanel> addPanel = new ArrayList<>();

	boolean boolcheak[];

	public KeyBoardClass(ChattingForm superClass, APIExamSearchBlog apiExamSearchBlog,
			APIExamSearchNews apiExamSearchNews, APIExamSearchencyc apiExamSearchencyc, boolean boolcheak[]) {
		// TODO Auto-generated constructor stub
		this.superClass = superClass;
		this.apiExamSearchBlog = apiExamSearchBlog;
		this.apiExamSearchNews = apiExamSearchNews;
		this.apiExamSearchencyc = apiExamSearchencyc;
		this.boolcheak = boolcheak;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			totalsetting();
			blogsetting();
			addPanel.removeAll(addPanel);

			addPanel.add(superClass.plContent);
			addPanel.add(superClass.blogform[0]);
			try {
				for (int i = 0; i < addPanel.size(); i++) {
					if (superClass.panel.getBounds().height == 0) {
						superClass.panel.setBounds(0, 130, 964, 1120);
						 superClass.plContent.setBounds(0, 53, 964, 1067);
//						superClass.plContent.setBounds(0, 0, 0, 0);
					} else if (superClass.panel.getBounds().height != 0) {
						if (boolcheak[i] == true) {
							addPanel.get(i).setBounds(0, 53, 964, 1067);
							superClass.panel.add(addPanel.get(i));
						}
						if (boolcheak[i] == false) {
							System.out.println("false값 실행:" + addPanel.get(i));
							addPanel.get(i).setBounds(0, 0, 0, 0);
							superClass.panel.remove(addPanel.get(i));
						}
					}
				}
			} catch (Exception e5) {
				// TODO: handle exception
				System.out.println(e5);
			}
			super.keyReleased(e);
		}
	}

	private void blogsetting() {
		// TODO Auto-generated method stub
		apiExamSearchBlog.searchBlog(superClass.tfSearch.getText());

		System.out.println((double)bloggerTitle.size() / 5.0);
		superClass.blogform = new BlogForm[(int) Math.ceil(bloggerTitle.size() / 5)];
		for (int i = 0; i < superClass.blogform.length; i++) {
			superClass.blogform[i] = new BlogForm((int) Math.ceil(bloggerTitle.size() / 5), i);
			try {
				for (int j = 0; j < 5; j++) {
					superClass.blogform[i].lbblogtitle[j].setText("<html><body><a href='" + bloglink.get(j) + "'>"
							+ bloggerTitle.get(j) + "</a><b style='color:gray'> &nbsp; &nbsp;" + bloggerPostDate.get(j)
							+ "</b></body></html>");
					superClass.blogform[i].lbblogcontents[j]
							.setText("<html><body>" + bloggerContents.get(j) + "</body></html>");
					superClass.blogform[i].lbblogbotton[j].setText("<html><body><a href='" + bloglink.get(j)
							+ "' style='text-decoration:none'><b style='color:gray'>" + bloggername.get(j)
							+ "</b>&nbsp;</a><a href='" + bloglink.get(j)
							+ "' style='text-decoration:none'><b style='color:green'>" + bloggerlink.get(j)
							+ "</b></a></body></html>");
				}
			} catch (Exception e1) {
				// TODO: handle exception
				
			}
		}

	}

	private void totalsetting() {
		// TODO Auto-generated method stub
		Removelist();
		apiExamSearchBlog.searchBlog(superClass.tfSearch.getText());
		apiExamSearchNews.searchNews(superClass.tfSearch.getText());
		apiExamSearchencyc.SearchEncyc(superClass.tfSearch.getText());

		bloggerTitle = apiExamSearchBlog.getTitle();
		bloggerPostDate = apiExamSearchBlog.getPostdate();
		bloggerContents = apiExamSearchBlog.getContents();
		bloggername = apiExamSearchBlog.getBloggername();
		bloggerlink = apiExamSearchBlog.getBloggerlink();
		bloglink = apiExamSearchBlog.getLink();

		newsTitle = apiExamSearchNews.getTitle();
		originallink = apiExamSearchNews.getOriginallink();
		newsdescription = apiExamSearchNews.getDescription();
		calDateBetweenAandB();
		newslink = apiExamSearchNews.getLink();
		// System.out.println(pubDate);

		bookTitle = apiExamSearchencyc.getTitle();
		bookimages = apiExamSearchencyc.getThumnail();
		booklink = apiExamSearchencyc.getLink();
		bookcontents = apiExamSearchencyc.getDescription();

		try {
			for (int i = 0; i < superClass.lbBlogTitle.length; i++) {
				superClass.lbBlogTitle[i].setText(" ");
				superClass.lbBlogbotton[i].setText(" ");
				superClass.lbBlogContents[i].setText(" ");

			}

			for (int i = 0; i < superClass.lbBlogTitle.length; i++) {

				superClass.lbBlogTitle[i].setText("<html><body><a href='" + bloglink.get(i) + "'>" + bloggerTitle.get(i)
						+ "</a><b style='color:gray'> &nbsp; &nbsp;" + bloggerPostDate.get(i) + "</b></body></html>");
				superClass.lbBlogContents[i].setText("<html><body>" + bloggerContents.get(i) + "</body></html>");
				superClass.lbBlogbotton[i].setText("<html><body><a href='" + bloglink.get(i)
						+ "' style='text-decoration:none'><b style='color:gray'>" + bloggername.get(i)
						+ "</b>&nbsp;</a><a href='" + bloglink.get(i)
						+ "' style='text-decoration:none'><b style='color:green'>" + bloggerlink.get(i)
						+ "</b></a></body></html>");
			}
		} catch (Exception e1) {
			// TODO: handle exception
		}
		try {
			for (int i = 0; i < superClass.lbBookTitle.length; i++) {
				superClass.lbNewTitle[i].setText(" ");
				superClass.lbNewContents[i].setText(" ");
				superClass.lbNewbotton[i].setText(" ");

			}

			for (int i = 0; i < superClass.lbNewTitle.length; i++) {
				superClass.lbNewTitle[i].setText("<html><body><a href='" + originallink.get(i) + "'>" + newsTitle.get(i)
						+ "</a><b style='color:gray'>&nbsp;&nbsp;" + total.get(i) + "</b>&nbsp;&nbsp;:<a href='"
						+ newslink.get(i)
						+ "' style='text-decoration:none'><b style='color:gray'>네이버 뉴스 </b></body></html>");
				superClass.lbNewContents[i].setText("<html><body>" + newsdescription.get(i) + "</body></html>");
			}
		} catch (Exception e2) {
			// TODO: handle exception

			System.out.println();
		}

		try {
			for (int i = 0; i < superClass.lbBookTitle.length; i++) {
				superClass.lbBookTitle[i].setText(" ");
				superClass.lbBookimage[i].setText(" ");
				superClass.lbBookContents[i].setText(" ");

			}

			for (int i = 0; i < superClass.lbBookTitle.length; i++) {
				if (!bookimages.get(i).equals("")) {
					superClass.lbBookTitle[i].setText(
							"<html><body><a href='" + booklink.get(i) + "'>" + bookTitle.get(i) + "</a></body></html>");
					superClass.lbBookimage[i]
							.setText("<html><body><img src='" + bookimages.get(i) + "'></body></html>");
					superClass.lbBookContents[i].setText("<html><body>" + bookcontents.get(i) + "</body></html>");
				} else {
					superClass.lbBookTitle[i].setText(
							"<html><body><a href='" + booklink.get(i) + "'>" + bookTitle.get(i) + "</a></body></html>");
					superClass.lbBookimage[i].setText("<html><body></body></html>");
					superClass.lbBookContents[i].setText("<html><body>" + bookcontents.get(i) + "</body></html>");
				}
			}
		} catch (Exception e3) {
			// TODO: handle exception
			System.out.println(e3);
		}
	}

	private void Removelist() {
		// TODO Auto-generated method stub
		// superClass.panel.setBounds(0, 0, 0, 0);

		bloggerTitle.removeAll(bloggerTitle);
		bloggerPostDate.removeAll(bloggerPostDate);
		bloggerContents.removeAll(bloggerContents);
		bloggerlink.removeAll(bloggerlink);
		bloggername.removeAll(bloggername);
		bloglink.removeAll(bloglink);

		newsTitle.removeAll(newsTitle);
		originallink.removeAll(originallink);
		newsdescription.removeAll(newsdescription);
		total.removeAll(total);
		newslink.removeAll(newslink);

		bookTitle.removeAll(bookTitle);
		bookimages.removeAll(bookimages);
		booklink.removeAll(booklink);
		bookcontents.removeAll(bookcontents);
	}

	public void calDateBetweenAandB() {
		Date date;
		Date nowDate;
		// pubDate.removeAll(pubDate);
		pubDate = apiExamSearchNews.getPubDate();

		for (int i = 0; i < pubDate.size(); i++) {
			try {
				date = dateformat.parse(pubDate.get(i));
				nowDate = dateformat.parse(dateformat.format(new Date()));
				// System.out.println("몇달:"+date.getMonth());
				if ((date.getYear() - nowDate.getYear()) != 0) {
					total.add(Math.abs(date.getYear() - nowDate.getYear()) + "년 전");
					continue;
				} else if ((date.getMonth() - nowDate.getMonth()) != 0) {
					total.add(Math.abs(date.getMonth() - nowDate.getMonth()) + "달 전");
					continue;
				} else if ((date.getDay() - nowDate.getDay()) != 0) {
					total.add(Math.abs(date.getDay() - nowDate.getDay()) + "일 전");
					continue;
				} else if ((date.getHours() - nowDate.getHours()) != 0) {
					total.add(Math.abs(date.getHours() - nowDate.getHours()) + "시간 전");
					continue;
				} else if ((date.getMinutes() - nowDate.getMinutes()) != 0) {
					total.add(Math.abs(date.getMinutes() - nowDate.getMinutes()) + "분 전");
					continue;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
