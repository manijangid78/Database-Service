package com.example.DatabaseService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Admin")
public class Admin {

    @Id
    private String id;
    private String name;
    private String password;

    @ElementCollection(targetClass = String.class)
    private List<String> allAssignments = new ArrayList<String>();

}
