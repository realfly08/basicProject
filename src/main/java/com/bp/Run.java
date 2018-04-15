package com.bp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.bp")
@MapperScan("com.bp.dao")
@Controller
public class Run {

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }

    @RequestMapping({"/", "/index.html"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
