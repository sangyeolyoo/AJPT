package alarm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import java.net.HttpURLConnection;

public class Api {
	final String CODE = "JRnXD1hyDhIXsFwFZ09bYA2u8E5YtM8V4yHGcdZEiQi46Km84sD%2BzFH3GSOxKjjWOSIKInClaYAmAHDaS00BCA%3D%3D";

	public Api() {   

	}

	public JSONObject getApiData(URL url) throws Exception {
		JSONObject rstObject = null;
		InputStream is = null;

		try {
			is = url.openStream();
			BufferedReader inFile = new BufferedReader(new InputStreamReader(is));

//			GET,POST,Timeout 옵션 설정 시, 사용 
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			con.setRequestMethod("GET");
//			con.connect();		
//			BufferedReader inFile = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			con.disconnect();

			String line = "";
			String result = "";

			while ((line = inFile.readLine()) != null) {
				result = result.concat(line);
			}
			
			JSONParser parser = new JSONParser();
			rstObject = (JSONObject) parser.parse(result);


		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			is.close();
		}

		return rstObject;
	}
}