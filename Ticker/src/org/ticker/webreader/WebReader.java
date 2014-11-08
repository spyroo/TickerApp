package org.ticker.webreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class WebReader {

	public WebReader() {
		
	}

	public static ArrayList<String> getUrlSource(String url) {
		try {
			URL siteUrl = new URL(url);
			URLConnection siteConnection = siteUrl.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(siteConnection.getInputStream(), "UTF-8"));
			String inputLine;
			ArrayList<String> temp = new ArrayList<String>();
			while ((inputLine = in.readLine()) != null)
				temp.add(inputLine);
			in.close();
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
