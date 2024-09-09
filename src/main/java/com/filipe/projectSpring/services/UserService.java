package com.filipe.projectSpring.services;

import com.filipe.projectSpring.Entities.User;
import com.filipe.projectSpring.repositories.UserRepository;
import com.filipe.projectSpring.services.exceptions.DataBaseException;
import com.filipe.projectSpring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // método que tenta dar o get, se não achar, vai lançar uma excecao
        // como o throw é pra uma excecao personalizada, a gente precisa indicar qual excecao.
    }

    public User insert(User obj){
        return repository.save(obj); //o método "save" ja retorna o obj salvo
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }

    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id); //método para instanciar um usuário,
       udpateData(entity,obj);                          // mas não vai no bando de dados ainda. Ele deixa um objeto para se trablhar com ele
       return repository.save(entity);                  // e depois ir ao BD. É mais eficiente assim.
    }

    private void udpateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

