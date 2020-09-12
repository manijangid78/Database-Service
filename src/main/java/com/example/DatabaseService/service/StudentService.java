package com.example.DatabaseService.service;

import com.example.DatabaseService.entity.Student;
import com.example.DatabaseService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudent(String email){
        Student student = studentRepository.getOne(email);
        return student;
    }

    public Map<String,String> getAllStudentName(){
        List<Student> students = studentRepository.findAll();
        Map<String,String> stds = new HashMap<>();
        for (Student student:students) {
            stds.put(student.getEmail(),student.getName());
        }
        return stds;
    }

    public List<String> getAssignments(String email){
        Student student = studentRepository.getOne(email);
        List<String> assignments= student.getAssignment();
        return assignments;
    }

    public List<String> getCompleteAssignments(String email){
        Student student = studentRepository.getOne(email);
        List<String> completeAssignment= student.getCompleteAssignment();
        return completeAssignment;
    }

    // To get All assignment of students by admin
    public Map<String, List<String>> getAllAssignments(){
        List<Student> students = studentRepository.findAll();

        Map<String, List<String>> assignAssignment = new HashMap<String, List<String>>();

        for (Student student: students) {
            assignAssignment.put(student.getEmail(),student.getAssignment());
        }

        return assignAssignment;

    }

    // To add new assignment to student account
    public List<String> addAssignment(String id, String assignment){
        Student student = studentRepository.getOne(id);
        student.getAssignment().add(assignment);
        studentRepository.save(student);
        return student.getAssignment();
    }

    public void setCompleteAssignment(String email, String assignment){
        Student student = studentRepository.getOne(email);
        student.getCompleteAssignment().add(assignment);
        student.getAssignment().remove(assignment);
        studentRepository.save(student);
    }

    // check student user id id valid or not
    public boolean checkStudent(String email, String password){
        try{
            Student student = studentRepository.getOne(email);
            return student.getPassword().equals(password);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
