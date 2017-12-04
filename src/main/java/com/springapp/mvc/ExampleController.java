package com.springapp.mvc;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;


/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 10:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ExampleController {
    private static final Logger log = Logger.getLogger(ExampleController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable("calculateResult")
    public String calculateResult() {
        log.debug("Performing expensive calculation...");
        // perform computationally expensive calculation
        return "result";
    }
}
