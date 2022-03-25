package com.example.controller;


import com.example.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/sayWow")
    @ResponseBody
    public String printWow(){

        return "Wow";
    }

    @GetMapping(value = "/printParam")
    @ResponseBody
    public String printParam(@RequestParam String nume){
        return "Wow, ce prost esti "+nume+"!!!";
    }
    @GetMapping(value = "/printPathVar/{location}/products")
    @ResponseBody
    public String printPathVar(@PathVariable String location){

        return "Showing products for region "+ location;
    }

    @GetMapping(value = "/createEmployee")
    @ResponseBody
    public List<Employee> createEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return List.of(new Employee(firstName, lastName, 200),
        new Employee("aa", "bb", 500 ),
        new Employee("jj", "ll", 420),
        new Employee("bb", "hh", 6969)
        );


    }

}


