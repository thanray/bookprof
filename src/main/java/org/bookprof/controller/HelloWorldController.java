package org.bookprof.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class HelloWorldController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {

        String str = "Hello World! 4";
        
        return str;
    }

}
