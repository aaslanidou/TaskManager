package com.example.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.model.User;
import com.example.TaskManager.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
     //1.see if the user exists.
     //2.handle password
     //3.email is valid.
    
    public User saveUser(User u) throws Exception{
        
            if(u.getEmail()==null || u.getEmail().isEmpty() || u.getEmail().isBlank()) throw new Exception("email is empty");
            User user = userRepository.findByEmail(u.getEmail());
            if(user != null) throw new Exception("email already exists");

            return userRepository.save(u);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
      userRepository.deleteById(id);
    }

    public User updateUserName(Long id, User u ) throws Exception{
       User user= userRepository.findById(id).orElseThrow( () -> new  Exception("user not found"));
        user.setName(u.getName());
        return userRepository.save(user);
    }

    public User updateUserEmail(Long id, User u) {
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not fount"));
        user.setEmail(u.getEmail());
        return userRepository.save(user);
    }


}
