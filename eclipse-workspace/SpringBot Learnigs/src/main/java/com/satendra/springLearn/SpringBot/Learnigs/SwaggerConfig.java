package com.satendra.springLearn.SpringBot.Learnigs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact  DEFAULT_CONTACT = new Contact("Satendra Dagar", "https://corebitss.com", "satendradagar@gmail.com");

 public ApiInfo   DEFAULT = new ApiInfo("MY API", "Custom Api details", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());

public Set<String> formats = new HashSet<>(Arrays.asList("application/xml","application/json"));

    @Bean
    public Docket api(){
//
        return  new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT).produces(formats).consumes(formats);

    }
}
