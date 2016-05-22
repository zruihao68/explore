package xyz.zrui.explore.front.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/test.do")
	public String testRequestMapping(HttpServletRequest request){
		request.setAttribute("aa", "aaaaaaa");
		return "success";
	}

}
