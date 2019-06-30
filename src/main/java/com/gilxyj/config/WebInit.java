package com.gilxyj.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @program: springssm
 * @description:
 * @author: GilbertXiao
 * @create: 2019-06-30 21:19
 **/

@Configuration
public class WebInit implements WebApplicationInitializer {
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //指定springMVC的配置
        context.register(SpringMVCConfig.class);
        ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc", new DispatcherServlet(context));
        springmvc.addMapping("/");
        springmvc.setLoadOnStartup(1);


    }
}
