package alarm;

import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Dust {
	final String URL = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
	JSONObject rstObject;
	String code;
	Api api = new Api();

	public Dust() {
		this.code = api.CODE;
	}

	public void getData() throws Exception {
		String text = URLEncoder.encode("서울", "UTF-8");
		URL url = new URL(URL + "?sidoName=" + text + "&pageNo=1&numOfRows=10&ServiceKey=" + code
				+ "&ver=1.3&_returnType=json");

		JSONObject obj = api.getApiData(url);
		JSONArray parseList = (JSONArray) obj.get("list");
		rstObject = (JSONObject) parseList.get(0);
	}

	public String gradeConvert(String grade) {
		String done = "";

		switch (grade) {
		case "1":
			done = "좋음";
			break;
		case "2":
			done = "보통";
			break;
		case "3":
			done = "나쁨";
			break;
		case "4":
			done = "매우나쁨";
			break;
		default:
			System.out.println("Grade가 잘못됐습니다.");
		}

		return done;
	}

	public JSONObject getResult() {
		return rstObject;

	}

	public boolean getGrade() {
		int pm10 = Integer.parseInt((String) rstObject.get("pm10Grade1h"));
		int pm25 = Integer.parseInt((String) rstObject.get("pm25Grade1h"));

		if (pm10 >= 3 || pm25 >= 3) {
			return true;
		}
		
		return false;
	}
}
