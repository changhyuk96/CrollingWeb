package com.my.crolling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.my.crolling.util.LogInterceptor;

public class InfoCreator {
	
	Logger log = LoggerFactory.getLogger(LogInterceptor.class);

	public String siteCheck(String url, Model model) throws Exception{
		
		if(url.contains("weather")) {
			createWeatherInfo(url,model);
			return "/weatherResult";
		}
		else if(url.contains("ncov")) {
			createCoronaInfo(url,model);
			return "/coronaResult";
		}
		
		return "/";
	}
	
	public void createCoronaInfo(String url,Model model) throws Exception{
		
		Document document = Jsoup.connect(url).get();
		Elements tableElements = document.select("table.num.midsize tbody tr");
		
		List<CityInfo> cityInfoList = new ArrayList<CityInfo>();
		
		for(Element tableElement : tableElements) {
			
			// \\s+로 연속된 공백을 하나의 공백으로 취급해서 자르기
			String[] array = tableElement.text().split("\\s+");
			CityInfo cityInfo = new CityInfo(array[0], array[1], array[2]
									, array[3], array[4], array[5], array[6]);
			
			cityInfoList.add(cityInfo);
		}
		
		Collections.sort(cityInfoList, (c1, c2) ->  Integer.parseInt(c2.getTodayTotal())-Integer.parseInt(c1.getTodayTotal()));

		// 		Collections.sort(cityInfoList, new ListComparator());

		model.addAttribute("cityInfo", cityInfoList);
	}
	
	
	
	public void createWeatherInfo(String url, Model model) throws Exception{
		
		// Jsoup.connect : 해당 URL의 HTML 페이지를 가져온다.
		Document document = Jsoup.connect(url).get();
		
		Elements cardElement = document.select("div.card.card_today");
		
		WeatherInfo weatherInfo = new WeatherInfo();
		weatherInfo.setNowTemperature(cardElement.select("strong.current").text());
		weatherInfo.setNowWeather(cardElement.select("span.weather").text());
		
		model.addAttribute("info",weatherInfo);
	}
}
