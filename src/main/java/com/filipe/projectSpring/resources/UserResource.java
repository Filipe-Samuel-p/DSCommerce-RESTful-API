package com.filipe.projectSpring.resources;


import com.filipe.projectSpring.Entities.User;
import com.filipe.projectSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping // método HTTP para inserção
    public ResponseEntity<User> insert(@RequestBody  User obj){ //o objeto irá chegar como JSON. Para converter o JSON em um obj para salvar no BD, usa @RequestBody
        obj = service.insert(obj); // o obj recebe o próprio obj salvo no BD?????
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
        //created retorna um 201, e para isso, precisa mandar um URI.
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    } // @PathVariable é pro Long id ser reconhecido como uma variável pela URL


}
