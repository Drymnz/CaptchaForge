package com.cunoc.CaptchaForge.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/analizer")
public class HolaMundoController {

    @GetMapping("/cc/{text}")   
    public String[] HolaMund(@PathVariable String text){
        String[] nombres = {"Carlos", "Ana", "Miguel", "Lucía", "Juan"};
        return nombres;
    }
}
