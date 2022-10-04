package com.openclassrooms.paymybuddy.restController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/basicAuth")
public class ValidateClientController
{
    @RequestMapping("validate")
    public String userIsValid()
    {
        System.out.println("*** validate userIsValid  ***");
        return "{\"result\" : \"ok\"}";
    }
}