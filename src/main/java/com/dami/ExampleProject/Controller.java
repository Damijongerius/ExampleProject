package com.dami.ExampleProject;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/test/get")
    public String getString(){
        return "minecraft string uit de supermarkt";
    }

    @GetMapping("/test/getSpecial/{resource}")
    public String getSpecialString(@PathVariable String resource){
        return "string :" + resource;
    }

    @PostMapping("/test/postProfile")
    public void receiveData(@RequestBody Profile profile){
        System.out.println("here is :" + profile);
    }
}

class Profile{
    String naam;
    String achternaam;
    int leeftijd;

    public Profile(){

    }
}