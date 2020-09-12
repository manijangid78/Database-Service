package com.example.DatabaseService.controller;

import com.example.DatabaseService.entity.Student;
import com.example.DatabaseService.service.AdminService;
import com.example.DatabaseService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AppController {

    private StudentService studentService;
    private AdminService adminService;

    @Autowired
    public AppController(StudentService studentService, AdminService adminService) {
        this.studentService = studentService;
        this.adminService = adminService;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id")String id){
        System.out.println(studentService.getStudent(id));
        return studentService.getStudent(id);
    }

    @GetMapping("/student/{id}/assignments")
    public List<String> getAssignments(@PathVariable("id")String id){
        return studentService.getAssignments(id);
    }

    @GetMapping("/student/{id}/completeAssignments")
    public List<String> getCompleteAssignments(@PathVariable("id")String id){
        return studentService.getCompleteAssignments(id);
    }

    @PostMapping("/student/{id}/addCompleteAssignment")
    public void setCompleteAssignment(@PathVariable("id")String id, @RequestParam("assignment") String assignment){
        System.out.println(id);
        System.out.println(assignment);
        studentService.setCompleteAssignment(id,assignment);
    }

    @PostMapping("student/{id}/addAssignment")
    public List<String> addAssignment(@PathVariable("id")String id,@RequestParam("assignment")String assignment){
        return studentService.addAssignment(id,assignment);
    }

    @PostMapping("admin/{id}/addAssignment")
    public List<String> addAdminAssignment(@PathVariable("id")String id,@RequestParam("assignment")String assignment){
        return adminService.addNewAssignment(id,assignment);
    }

    @GetMapping("/admin/{id}/assignments")
    public List<String> getAdminAssignments(@PathVariable("id")String id){
        List<String> strings = adminService.getAssignments(id);
        System.out.println(strings.toString());
        return adminService.getAssignments(id);
    }

    @GetMapping("/admin/{id}/assignedAssignment")
    public Map<String,List<String>> getAssignAssignments(@PathVariable("id")String id){
        Map<String, List<String>> assignAssignment =  studentService.getAllAssignments();
        System.out.println(assignAssignment.get("man"));
        return assignAssignment;
    }

    @GetMapping("/admin/{id}/students")
    public Map<String,String> getStudentName(@PathVariable("id")String id){
        return studentService.getAllStudentName();
    }

    // login mappings
    @PostMapping("/student/login")
    public boolean checkStudent(@RequestParam("id")String id, @RequestParam("password")String password){
        return studentService.checkStudent(id,password);
    }

    @PostMapping("/admin/login")
    public boolean checkAdmin(@RequestParam("id")String id, @RequestParam("password")String password){
        return adminService.checkAdmin(id,password);
    }


}
