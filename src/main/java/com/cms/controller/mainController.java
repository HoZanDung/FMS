package com.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HOZANDUNG on 17/5/4.
 */
@Controller
public class mainController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String user() {
        return "user";
    }

    @RequestMapping(value = "/table",method = RequestMethod.GET)
    public String table() {
        return "table";
    }

    @RequestMapping(value = "/typography",method = RequestMethod.GET)
    public String typography() {
        return "typography";
    }

    @RequestMapping(value = "/upgrade",method = RequestMethod.GET)
    public String upgrade() {
        return "upgrade";
    }
}
