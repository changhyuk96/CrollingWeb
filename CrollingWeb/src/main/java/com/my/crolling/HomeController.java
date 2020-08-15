package com.my.crolling;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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
	JSONObject JSONInfo = new JSONObject();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping(value = "/coronaResult")
	public String coronaResult(Model model) {
		return "/coronaResult";
	}
	@RequestMapping(value = "/")
	public String weatherResult(Model model) {
		return "/weatherResult";
	}
	
	@RequestMapping(value="/goCrolling")
	public String goCrolling(HttpServletRequest request, Model model) throws Exception {
		
		if((request.getParameter("siteURL"))==null) {
			return "home";
		}
		String url = request.getParameter("siteURL");
		
		InfoCreator infoCreator = new InfoCreator();
		String returnPage = infoCreator.siteCheck(url, model);
		
		return returnPage;
	}
}
