package com.example.DatabaseService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students")
public class Student {

    @Id
    @Column(name = "student_id")
    private String email;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_password")
    private String password;

    @ElementCollection(targetClass = String.class)
    @Column(name = "student_assignment")
    private List<String> assignment = new ArrayList<String>();

    @ElementCollection(targetClass = String.class)
    @Column(name = "student_complete_assignment")
    private List<String> completeAssignment = new ArrayList<String>();


}
