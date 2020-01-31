package com.satendra.springLearn.SpringBot.Learnigs.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
public class UserResource {

    @Autowired
    private  UserDaoService service;

    //retrieve users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return  service.findAll();
    }



    //retrieve users
    @GetMapping("/users/{id}")
    public Resource<User> retrieveUser(@PathVariable Integer id){
        User user1 = service.findOne(id);

        if (null == user1){
            throw new UserNotFoundException("Id+ "+ id);
        }

        //HateOS
        Resource<User> resource = new Resource<User>(user1);
//        Resource<User> resource = new Resource<User>(user);
//        linkTo(controller);
        ControllerLinkBuilder link = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(link.withRel("all-users"));
        return resource;
    }

    //Created Created uri, details
    @PostMapping("/users")
    public  ResponseEntity  createUser(@Valid  @RequestBody User user){
        User usr = service.save(user);

        //CREATED
        ///users/{id}
       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usr.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping ("/users/{id}")
    public  void  createUser(@PathVariable Integer id){
        User user = service.deleteUserById(id );

        if (null == user){
            throw new UserNotFoundException("Id+ "+ id);
        }
//        return  user;

    }

}
