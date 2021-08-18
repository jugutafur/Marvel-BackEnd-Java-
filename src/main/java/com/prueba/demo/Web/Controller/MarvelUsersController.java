package com.prueba.demo.Web.Controller;

import com.prueba.demo.Domain.MarvelUser;
import com.prueba.demo.Domain.Service.MarvelUsersService;
import com.prueba.demo.Persistence.Entity.MarvelUsuarios;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class MarvelUsersController {

    @Autowired
    private MarvelUsersService marvelUsersService;

    @GetMapping("/todos")
    @ApiOperation("Get all Users")
    @ApiResponse(code = 200 , message = "bajada de datos ok")
    public List<MarvelUser> getAll(){return marvelUsersService.getAll(); }

    @GetMapping("{este}")
    @ApiOperation("Get only item")
    @ApiResponse(code = 200, message = "super")
    public Optional<MarvelUser> getRegister(
            @ApiParam(value = "obtine un solo elemento", required = true, example = "3")
            @PathVariable("este") int id){
        return marvelUsersService.getRegister(id);
    }

    @GetMapping("prueba{otro}")
    public String getOnlyOney(
            @ApiParam(value = "Obtiene un solo elemento", required = true, example = "4")
            @PathVariable("otro") int id ){
        return marvelUsersService.getOnlyOney( id);
    }

    @PostMapping("/save")
    @ApiOperation("Add new user")
    public MarvelUser saveRegister(@RequestBody MarvelUser marvelUser){
        return marvelUsersService.saveRegister(marvelUser);
    }

}
