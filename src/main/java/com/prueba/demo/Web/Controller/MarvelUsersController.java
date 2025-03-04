package com.prueba.demo.Web.Controller;

import com.prueba.demo.Domain.MarvelUser;
import com.prueba.demo.Domain.Service.MarvelUsersService;
import com.prueba.demo.crusscutting.constants.ResourceEndpoint;
import com.prueba.demo.crusscutting.constants.constant;/*
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = ResourceEndpoint.PATH_USER)
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE
})
public class MarvelUsersController {

    @Autowired
    private MarvelUsersService marvelUsersService;

    @GetMapping(value = ResourceEndpoint.HEALTH)
    public String health(){
        return String.format("Up Collection = %s", ResourceEndpoint.PATH_USER);
    }

    @GetMapping(value = ResourceEndpoint.GET_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    /*@ApiOperation("Get all Users")
    @ApiResponse(code = 200 , message = "bajada de datos ok")*/
    public ResponseEntity<List<MarvelUser>> getAll(){
        return new ResponseEntity<>(marvelUsersService.getAll(), HttpStatus.OK);
    }

    @GetMapping()/*
    @ApiOperation("get userById")
    @ApiResponses({
            @ApiResponse(code = 200, message = "user find"),
            @ApiResponse(code = 404, message = "user Not find")
    })*/
    public ResponseEntity<MarvelUser> getRegister(
            //@ApiParam(value = "get userById", required = true, example = "3")
            @RequestParam(value = constant.USER_ID) int userId){
        return marvelUsersService.getRegister(userId)
                .map( marvelUser -> new ResponseEntity<>(marvelUser, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = ResourceEndpoint.SAVE)
    //@ApiOperation("Add new user")
    public ResponseEntity<MarvelUser> saveRegister(
            @RequestBody MarvelUser marvelUser){
        return new ResponseEntity<>(marvelUsersService.saveRegister(marvelUser), HttpStatus.CREATED);
    }

    @DeleteMapping(value = ResourceEndpoint.DELETE)
    //@ApiOperation("Delete Specific User")
    public ResponseEntity delete(
            @RequestParam(value = constant.USER_ID) int userId ){
        if(marvelUsersService.delete(userId)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
