package com.dami.ExampleProject;

import com.dami.ExampleProject.DataBase.JpaEntities.classes.User;
import com.dami.ExampleProject.Services.DatabaseService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {
    private DatabaseService service = DatabaseService.getInstance();

    @PostMapping("/Leaderboard/Money")
    public String getString(){
        service.getUsersData();
        return "minecraft string uit de supermarkt";
    }

    @GetMapping("/test/getSpecial/{resource}")
    public String getSpecialString(@PathVariable String resource){
        return "string :" + resource;
    }

}

