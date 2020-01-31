package com.satendra.springLearn.SpringBot.Learnigs.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1(){

        return new PersonV1("Bol Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){

        Name name = new Name("Boob","Charl");

        return new PersonV2(name);
    }

}
