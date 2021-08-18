package com.prueba.demo.Web.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class InicioController {

    @GetMapping("/Nene")
    public String hola(){return "desde otra vez";}
}
