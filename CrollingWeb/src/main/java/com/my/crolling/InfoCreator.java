package com.my.crolling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
		Elements tableElement = document.select("table.num.midsize");
		
		CoronaInfo coronaInfo = new CoronaInfo();
		
		log.info(tableElement.html());
		
		model.addAttribute("info", coronaInfo);
		
		
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
