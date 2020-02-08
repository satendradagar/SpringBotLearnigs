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
import java.util.Optional;


@RestController
public class UserJPAResource {

//    @Autowired
//    private  UserDaoService service;

    @Autowired
    private  UserReposotory reposotory;

    @Autowired
    private  PostReposotory postReposotory;

    //retrieve users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return  reposotory.findAll();
    }



    //retrieve users
    @GetMapping("/jpa/users/{id}")
    public Resource<User> retrieveUser(@PathVariable Integer id){
//        User user1 = service.findOne(id);
       Optional<User> user1 = reposotory.findById(id);

        if (!user1.isPresent()){
            throw new UserNotFoundException("USer do not exist with Id+ "+ id);
        }

        //HateOS
        Resource<User> resource = new Resource<User>(user1.get());
//        Resource<User> resource = new Resource<User>(user);
//        linkTo(controller);
        ControllerLinkBuilder link = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(link.withRel("all-users"));
        return resource;
    }

    //Created Created uri, details
    @PostMapping("/jpa/users")
    public  ResponseEntity  createUser(@Valid  @RequestBody User user){
        User usr = reposotory.save(user);

        //CREATED
        ///users/{id}
       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usr.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping ("/jpa/users/{id}")
    public  void  deleteUser(@PathVariable Integer id){

        reposotory.deleteById(id);


    }

    //retrieve users
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveUserPosts(@PathVariable Integer id){

        Optional<User> user1 = reposotory.findById(id);

        if (!user1.isPresent()){
            throw new UserNotFoundException("USer do not exist with Id+ "+ id);
        }

        Resource<User> resource = new Resource<User>(user1.get());
        return user1.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity addUserPosts(@PathVariable Integer id, @Valid @RequestBody  Post post) {

        Optional<User> user1 = reposotory.findById(id);

        if (!user1.isPresent()) {
            throw new UserNotFoundException("USer do not exist with Id+ " + id);
        }
        User user = user1.get();
        post.setUser(user);
        postReposotory.save(post);

        //CREATED
        ///users/{id}/posts/postId
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
