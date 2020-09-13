package com.example.DatabaseService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Admins")
public class Admin {

    @Id
    @Column(name = "admin_id")
    private String id;
    @Column(name = "admin_name")
    private String name;
    @Column(name = "admin_password")
    private String password;

    @ElementCollection(targetClass = String.class)
    @Column(name = "admin_all_assignments")
    private List<String> allAssignments = new ArrayList<String>();

}
