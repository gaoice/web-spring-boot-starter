package com.gaoice.web.spring.boot.demo;

import com.gaoice.web.exception.WebException;
import com.gaoice.web.oplog.annotation.EnableOplog;
import com.gaoice.web.oplog.annotation.Oplog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableOplog
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/user/add")
    @Oplog("添加用户")
    public String addUser() {
        return "success";
    }

    @GetMapping("/user/delete")
    @Oplog("删除用户")
    public String deleteUser() {
        throw new WebException("操作失败！");
    }
}
