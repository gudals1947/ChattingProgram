package ChattingSouce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class APIExamSearchencyc {
	ArrayList<String> title = new ArrayList<>();
	ArrayList<String> link = new ArrayList<>();
	ArrayList<String> description = new ArrayList<>();
	ArrayList<String> thumnail = new ArrayList<>();
	private String sort = "sim";
	

	public APIExamSearchencyc() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<String> getThumnail() {
		return thumnail;
	}
	public ArrayList<String> getTitle() {
		return title;
	}
	public ArrayList<String> getLink() {
		return link;
	}
	public ArrayList<String> getDescription() {
		return description;
	}

	public void SearchEncyc(String search) {
		// TODO Auto-generated method stub
		String clientId = "2j2upZhjOkmF_S7DA3lX";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "_f3QPIbUxO";// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode(search, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/encyc?query=" + text + "&sort="+sort; // json 결과
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
			}
			br.close();
//			System.out.println(response.toString());
			Object object = (Object) JSONValue.parse(response.toString());
			JSONObject jsonobject = (JSONObject) object;
			JSONArray jsonarray = (JSONArray) jsonobject.get("items");
			for (int i = 0; i < jsonarray.size(); i++) {
				JSONObject object2 = (JSONObject) jsonarray.get(i);
				title.add(object2.get("title").toString().replace("<b>", "").replace("</b>", "").replace("&quot;", ""));
				description.add(object2.get("description").toString());
				link.add(object2.get("link").toString());
				thumnail.add(object2.get("thumbnail").toString());
			}
//			System.out.println(thumnail);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
