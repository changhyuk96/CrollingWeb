package com.my.crolling;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.crolling.util.LogInterceptor;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	Logger log = LoggerFactory.getLogger(LogInterceptor.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "home";
	}
	
	@RequestMapping(value="/goCrolling")
	public String goCrolling(HttpServletRequest request) throws Exception {
		
		if((request.getParameter("siteURL"))==null) {
			return "home";
		}
		String url = request.getParameter("siteURL");
		siteCheck(url);
		
		Document document = Jsoup.connect(url).get();
		log.info("= = = = = "+document.baseUri()+"의 정보입니다. = = = = = ");
		
		
		log.info(document.select("trackList g-all-transitions-300 lazyLoadingList").toString());
		
		return "home";
	}
	
	public void siteCheck(String url) {
		
		if(url.contains("weather")) {
			weatherInfo();
			return;
		}
	}
	
	public void weatherInfo() {
		
	}
}
