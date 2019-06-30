package com.gilxyj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: springssm
 * @description:
 * @author: GilbertXiao
 * @create: 2019-06-30 21:44
 **/

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(Date date){
        System.out.println(date);
        return "hello";
    }
}
