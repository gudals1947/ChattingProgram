package ChattingSouce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class APIExamSearchNews {
	private ArrayList<String> title = new ArrayList<String>();
	private ArrayList<String> originallink = new ArrayList<String>();
	private ArrayList<String> description = new ArrayList<String>();
	private ArrayList<String> pubDate = new ArrayList<String>();
	private ArrayList<String> totalDate = new ArrayList<String>();
	
	
	private SimpleDateFormat dateformat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z",new Locale("en", "US"));
	
	
	public APIExamSearchNews() {
		// TODO Auto-generated constructor stub

	}

	public void searchNews(String search) {
		// TODO Auto-generated method stub

		String clientId = "2j2upZhjOkmF_S7DA3lX";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "_f3QPIbUxO";// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode(search, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/news?query=" + text; // json 결과
			// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
			// // xml 결과
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine + "\n");
				System.out.println(response);
			}
			String s = response.toString();
			Object obj = JSONValue.parse(s);
			JSONObject object = (JSONObject) obj;
			

			JSONArray array = (JSONArray) object.get("items");
			for (int i = 0; i < array.size(); i++) {
				JSONObject object2 = (JSONObject) array.get(i);
				String s1 = (String) object2.get("title");
				title.add(s1.replace("<b>", "").replace("</b>", "").replace("&quot;", ""));
				originallink.add((String)object2.get("originallink"));
				description.add((String)object2.get("description").toString());
				pubDate.add((String)object2.get("pubDate"));
			}
			calDateBetweenAandB();
			System.out.println("totalDate: "+totalDate);
//			System.out.println("originallink:"+originallink);
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<String> getTitle() {
		return title;
	}
	public ArrayList<String> getOriginallink() {
		return originallink;
	}
	public ArrayList<String> getDescription() {
		return description;
	}
	public void calDateBetweenAandB() {
		Date date;
		Date nowDate;
		for(int i = 0; i < pubDate.size();i++) {
			try {
				date = dateformat.parse(pubDate.get(i));
				nowDate = dateformat.parse(dateformat.format(new Date()));
				if((date.getYear()-nowDate.getYear())!=0) {
					totalDate.add(Math.abs(date.getYear()-nowDate.getYear())+"년 전");
					continue;
				}
				else if((date.getMonth()-nowDate.getMonth())!=0) {
					totalDate.add(Math.abs(date.getMonth()-nowDate.getMonth())+"달 전");
					continue;
				}
				else if((date.getDay()-nowDate.getDay())!=0) {
					totalDate.add(Math.abs(date.getDay()-nowDate.getDay())+"일 전");
					continue;
				}
				else if((date.getHours()-nowDate.getHours())!=0) {
					totalDate.add(Math.abs(date.getHours()-nowDate.getHours())+"시간 전");
					continue;
				}
				else if((date.getMinutes()-nowDate.getMonth())!=0) {
					totalDate.add(Math.abs(date.getMinutes()-nowDate.getMinutes())+"분 전");
					continue;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}