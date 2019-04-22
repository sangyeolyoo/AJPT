package alarm;

import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Weather {
	final String URL = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData";
	final String X = "60";
	final String Y = "127";
	final String TIME = "0200";
	String code;
	String date;
	
	JSONObject rstObject;
	
	Api api = new Api();
	SimpleDateFormat msdf1 = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);

	public Weather() {
		this.code = api.CODE;
		this.date = msdf1.format(new Date());
	}

	public void getData() throws Exception {
		URL url = new URL(URL + "?ServiceKey=" + code + 
				"&base_date=" + date + "&base_time=" + TIME
				+ "&nx=" + X + "&ny=" + Y + "&_type=json");

		JSONObject obj = api.getApiData(url);
		JSONObject parseResponse = (JSONObject) obj.get("response");
		JSONObject parseBody = (JSONObject) parseResponse.get("body");
		JSONObject parseItems = (JSONObject) parseBody.get("items");
		JSONArray parseItem = (JSONArray) parseItems.get("item");
		rstObject = (JSONObject) parseItem.get(0);
	}

	public JSONObject getResult() {
		return rstObject;
	}

	public int getFcstvalue() {
		return ((Long) rstObject.get("fcstValue")).intValue();
	}

}
