package com.openclassrooms.paymybuddy.restController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class RestTESTController
{

    @PostMapping("testpost")
    public String testPost()
    {
        System.out.println("POST RestTESTController CALLED");

        return """
                {"fromTestPOST":"POST OK"}
                """;
    }


    @GetMapping("testget")
    public String testGet()
    {
        System.out.println("GET RestTESTController CALLED");

        return """
                {"fromTestGET":"GET OK"}
                """;
    }

}
