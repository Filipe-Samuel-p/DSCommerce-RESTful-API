package com.filipe.projectSpring.services;

import com.filipe.projectSpring.Entities.User;
import com.filipe.projectSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User obj){
        return repository.save(obj); //o método "save" ja retorna o obj salvo
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}

