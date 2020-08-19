package com.my.crolling;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.my.crolling.util.LogInterceptor;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	Logger log = LoggerFactory.getLogger(LogInterceptor.class);
	static List<CityInfo> list;
	
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
	public ModelAndView goCrolling(HttpServletRequest request, Model model) throws Exception {
		
		if((request.getParameter("siteURL"))==null) {
			return new ModelAndView("/home");
		}
		String url = request.getParameter("siteURL");
		
		InfoCreator infoCreator = new InfoCreator();
		ModelAndView modelAndView = infoCreator.siteCheck(url);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/downloadExcel")
	public View downloadExcel(HttpServletRequest request,Model model) {
		
		model.addAttribute("list",list);
		
		return new ListExcelDownload();
	}
}
