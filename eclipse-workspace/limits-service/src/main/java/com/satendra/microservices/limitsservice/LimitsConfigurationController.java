package com.satendra.microservices.limitsservice;

import com.satendra.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.Configuration;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private ConfigurationProp configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration() {

        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }

}
