package org.engripaye.oauth2resourceserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return " \uD83D\uDD12 Hello, secure world! You passed the token check.";
    }

    @GetMapping("/")
    public String open() {
        return "\uD83D\uDC4B Hello, this is public";
    }
}
