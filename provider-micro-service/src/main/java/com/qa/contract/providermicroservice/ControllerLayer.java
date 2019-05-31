package com.qa.contract.providermicroservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class ControllerLayer {



    @GetMapping(value = "/type", produces = "application/json")
    public String getToothPasteInfo(@RequestParam("number") int number){
        //http://localhost:8090/math/type?number=6
        //http://localhost:8090/math/type?number=7

        return (number % 2) == 0 ? "Even number" : "Odd number";
    }



}
