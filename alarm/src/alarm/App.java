package alarm;

import java.util.Formatter;
import org.json.simple.JSONObject;
//import java.net.HttpURLConnection;

public class App {

	public static StringBuffer prtFormat(Weather weather, Dust dust) throws Exception {
		StringBuffer stringBuffer = new StringBuffer();
		Formatter formatter = new Formatter(stringBuffer);
		JSONObject rstObject;

		rstObject = dust.getResult();
		formatter.format("미세먼지 농도 - %s\n", dust.gradeConvert((String) rstObject.get("pm10Grade1h")));
		formatter.format("초미세먼지 농도 - %s\n", dust.gradeConvert((String) rstObject.get("pm25Grade1h")));
		formatter.format("강수 확률 - %d%%\n\n", weather.getFcstvalue());

		if (weather.getFcstvalue() >= 40) {
			formatter.format("우산을 챙기세요.\n");
		}

		if (dust.getGrade()) {
			formatter.format("마스크를 챙기세요.\n");
		}

		return stringBuffer;
	}

	public static void main(String[] args) throws Exception {
		Telegram telegram = new Telegram();
		Weather weather = new Weather();
		Dust dust = new Dust();

		weather.getData();
		dust.getData();

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer = prtFormat(weather, dust);

		telegram.sendMessage(stringBuffer);
	}
}