package com.gilxyj.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: springssm
 * @description:
 * @author: GilbertXiao
 * @create: 2019-06-30 22:20
 **/
public class DateConverter implements Converter<String, Date> {

    static ThreadLocal<DateFormat> localdateformat=new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public Date convert(String source) {

        DateFormat dateFormat = localdateformat.get();
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
