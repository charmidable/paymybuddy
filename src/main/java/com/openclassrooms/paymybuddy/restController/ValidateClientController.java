package com.openclassrooms.paymybuddy.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("api/basicAuth")
public class ValidateClientController
{
    private Logger logger = Logger.getLogger(ValidateClientController.class.getName());

    @RequestMapping("validate")
    public String userIsValid()
    {
        return "{\"result\" : \"ok\"}";
    }
}