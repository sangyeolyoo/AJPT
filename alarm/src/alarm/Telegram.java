package alarm;

import java.net.URL;
import java.net.URLEncoder;

public class Telegram {
	final String URL = "https://api.telegram.org/bot";
	final String TOKEN = "721797475:AAGoUdjQ7wmie6rGUcgYsjCa3rGfXy8W-Ac";
	String text;
	String chatId = "836717531";
	
	Api api = new Api();

	public Telegram() {

	}

	public void sendMessage(StringBuffer stringBuffer) throws Exception {
		text = URLEncoder.encode(stringBuffer.toString(), "UTF-8");

		URL url = new URL(URL + TOKEN + "/sendMessage?chat_id=" + chatId + "&text=" + text);
		api.getApiData(url);

	}

}