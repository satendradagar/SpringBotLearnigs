package com.satendra.springLearn.SpringBot.Learnigs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.websocket.Session;
import java.util.Locale;

@SpringBootApplication
public class SpringBotLearnigsApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBotLearnigsApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver resolver = new  SessionLocaleResolver();
				resolver.setDefaultLocale(Locale.US);
		return  resolver;
//				AceeptHeaderLocaleResolver resolver = new  AceeptHeaderLocaleResolver();
//				resolver.setDefaultLocale(Locale.US);
//		return  resolver;
	}

//	@Bean
//	public ResourceBundleMessageSource bundleMessageSource(){
//		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
////		source.setBasename("/WEB-INF/resources/messages");
//
//		source.setBasename("messages");
//		return  source;
//
//	}
}

