package com.example.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManager.model.User;
import com.example.TaskManager.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        
        try {
            User savedUser = userService.saveUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
       userService.deleteUser(id);
       return ResponseEntity.ok("user with id:" +id+ " deleted");
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<User> updateUserName(@PathVariable Long id, @RequestBody User u) throws Exception{
        User user = userService.updateUserName(id,u);
        return ResponseEntity.ok(user);

    }

    @PutMapping("/{id}/email")
    public ResponseEntity<User> updateUserEmail(@PathVariable Long id , @RequestBody User u){
        User user=userService.updateUserEmail(id,u);
        return ResponseEntity.ok(user);
            
    }

    

   
    
    

    
    }
    


