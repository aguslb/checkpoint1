package com.udemyAgus.checkpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemyAgus.checkpoint.service.ServiceLogTest;

@Controller
@RequestMapping("/ejercicio")
public class CheckController {

	public static final String URL_1 = "/ejercicio/test";
	public static final String TEST_VIEW = "index";

	@GetMapping("/redirectGo")
	public RedirectView redirect() {
		return new RedirectView(URL_1);
	}

	@GetMapping("/test")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView(TEST_VIEW);
		mav.addObject("dataList", serviceLogTest.randomNumbers());
		return mav;
	}

	@Autowired
	@Qualifier("ServiceLogTest")
	private ServiceLogTest serviceLogTest;
}