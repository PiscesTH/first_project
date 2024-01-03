package com.clean.cleanssakssak.common;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController implements ErrorController { //시큐리티 사용시 이슈 발생. /허용 해야할 때 안해야 할 때 구분을 못해서 생기는 이슈 ?
    @GetMapping({"/", "/error"})
    public String index() {
        return "index.html";
    }
}