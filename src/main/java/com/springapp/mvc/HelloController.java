package com.springapp.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    private final Log logger = LogFactory.getLog(this.getClass());
	@RequestMapping(value="/hello")
	public String printWelcome(ModelMap model) {
        logger.error("test logger....");
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
}