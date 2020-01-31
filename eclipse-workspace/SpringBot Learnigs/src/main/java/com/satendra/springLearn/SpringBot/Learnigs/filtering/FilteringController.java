package com.satendra.springLearn.SpringBot.Learnigs.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public  MappingJacksonValue retrieveSomeBean(){

//        return new SomeBean("Value1","Value2","Value3");

        SomeBean beans = new SomeBean("Value1", "Value2", "Value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");

        FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(beans);
        mapping.setFilters(provider);
        return mapping;

    }


    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean(){

        List<SomeBean> someBeans = Arrays.asList(new SomeBean("Value1", "Value2", "Value3"), new SomeBean("Value21", "Value22", "Value23"));


        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");

        FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
        mapping.setFilters(provider);
        return mapping;

    }
}
