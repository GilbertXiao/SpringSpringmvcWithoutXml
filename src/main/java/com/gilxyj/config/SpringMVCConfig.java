package com.gilxyj.config;

import com.gilxyj.converter.DateConverter;
import com.gilxyj.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @program: springssm
 * @description:
 * @author: GilbertXiao
 * @create: 2019-06-30 21:10
 **/

@Configuration
/*@ComponentScan(basePackages = "com.gilxyj",useDefaultFilters = false,includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
})*/

@ComponentScan(basePackages = "com.gilxyj")
public class SpringMVCConfig extends WebMvcConfigurationSupport {


    //静态资源过滤

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }

    @Override
    public FormattingConversionService mvcConversionService() {
        FormattingConversionService service = super.mvcConversionService();
        service.addConverter(new DateConverter());
        return service;
    }

    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/jsp/", ".jsp");
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/aaa").setViewName("index");
    }
}
