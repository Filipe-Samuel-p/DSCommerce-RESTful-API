package com.filipe.projectSpring.resources;


import com.filipe.projectSpring.Entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User("filipe@gmail",1L,"filipe","1234","99858");
        return ResponseEntity.ok().body(u);
    }
}
