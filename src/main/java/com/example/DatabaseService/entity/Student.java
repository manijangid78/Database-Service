package com.example.DatabaseService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private String email;
    private String name;
    private String password;

    @ElementCollection(targetClass = String.class)
    private List<String> assignment = new ArrayList<String>();

    @ElementCollection(targetClass = String.class)
    private List<String> completeAssignment = new ArrayList<String>();

}
