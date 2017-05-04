package com.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by HOZANDUNG on 17/5/4.
 */
@Controller
public class mainController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
