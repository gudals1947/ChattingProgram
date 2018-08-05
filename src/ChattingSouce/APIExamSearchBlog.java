package ChattingSouce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class APIExamSearchBlog {
	private ArrayList<String> title = new ArrayList<String>();
	private ArrayList<String> postdate = new ArrayList<String>();
	private ArrayList<String> contents = new ArrayList<String>();
	private ArrayList<String> bloggerlink = new ArrayList<String>();
	private ArrayList<String> bloggername = new ArrayList<String>();
	private ArrayList<String> link = new ArrayList<String>();


     public APIExamSearchBlog() {
		// TODO Auto-generated constructor stub

    }
     public void searchBlog(String search) {
		// TODO Auto-generated method stub
    		
         String clientId = "2j2upZhjOkmF_S7DA3lX";//애플리케이션 클라이언트 아이디값";
         String clientSecret = "_f3QPIbUxO";//애플리케이션 클라이언트 시크릿값";
         try {
             String text = URLEncoder.encode(search, "UTF-8");
             String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
             //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
             URL url = new URL(apiURL);
             HttpURLConnection con = (HttpURLConnection)url.openConnection();
             con.setRequestMethod("GET");
             con.setRequestProperty("X-Naver-Client-Id", clientId);
             con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
             int responseCode = con.getResponseCode();
             BufferedReader br;
             if(responseCode==200) { // 정상 호출
                 br = new BufferedReader(new InputStreamReader(con.getInputStream()));
             } else {  // 에러 발생
                 br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
             }
             String inputLine;
             StringBuffer response = new StringBuffer();
             while ((inputLine = br.readLine()) != null) {
                 response.append(inputLine+"\n");
                 
             }
             String s = response.toString();
             Object obj = JSONValue.parse(s);
             JSONObject object = (JSONObject)obj;
             
             JSONArray array = (JSONArray)object.get("items");
             for(int i = 0 ; i < array.size() ; i++) {
             	JSONObject object2 =(JSONObject)array.get(i);
             	String s1 = (String) object2.get("title");
             	title.add(s1.replace("<b>","").replace("</b>","").replace("&quot;",""));
             	contents.add((String)object2.get("description"));
             	bloggerlink.add(object2.get("bloggerlink").toString().replace("http://", ""));
             	bloggername.add(object2.get("bloggername").toString());
             	postdate.add(DuringDate((String) object2.get("postdate")));
             	link.add((String)object2.get("link"));
             }
             System.out.println(postdate);
             
             br.close();
         } catch (Exception e) {
             System.out.println(e);
         }
	}
     String DuringDate(String date) {
    	 int startYear = Integer.parseInt(date.substring(0,4));
         int startMonth= Integer.parseInt(date.substring(4,6));
         int startDate = Integer.parseInt(date.substring(6,8));
         
         Calendar cal = Calendar.getInstance();
         cal.set(startYear, startMonth -1, startDate);
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         return sdf.format(cal.getTime());
         
     }
    
     public ArrayList<String> getTitle() {
		return title;
	}
     public ArrayList<String> getPostdate() {
		return postdate;
	}
     public ArrayList<String> getContents() {
		return contents;
	}
     public ArrayList<String> getBloggerlink() {
		return bloggerlink;
	}
     public ArrayList<String> getBloggername() {
		return bloggername;
	}
     public ArrayList<String> getLink() {
		return link;
	}
}