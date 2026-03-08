package com.example.TaskManager.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Task> task;




}
