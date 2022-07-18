package com.gaoice.web.spring.boot.demo;

import com.gaoice.web.exception.WebException;
import com.gaoice.web.r.R;
import com.gaoice.web.r.RTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public R<String> hello() {
        return RTime.ok("hello");
    }

    @GetMapping("/exception")
    public R<String> exception() {
        throw new WebException("exception");
    }
}
