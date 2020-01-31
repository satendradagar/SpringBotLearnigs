package com.satendra.springLearn.SpringBot.Learnigs.HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;
    //Get
    //URI - Hello World
    //method
//    @RequestMapping(method= RequestMethod.GET, path = "/helloworld")
    @GetMapping(path="helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    //HelloWorldBean
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World msg");
    }


    //HelloWorldBean with path params
    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean("Hello World msg"+ name);
    }

    @GetMapping(path="/hello-world-internationalization")
    public String helloWorldInternationalization(@RequestHeader(name="Accept-Language",required = false) Locale locale) {

//        String message = messageSource.getMessage("good.morning.message",null, locale);

        String message = messageSource.getMessage("good.morning.message",null,locale);
        return message;
    }


//    @GetMapping(path="/hello-world-internationalization")
//    public String helloWorldInternationalization() {
//
////        String message = messageSource.getMessage("good.morning.message",null, locale);
//
//        String message = messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
//        return message;
//    }
}
