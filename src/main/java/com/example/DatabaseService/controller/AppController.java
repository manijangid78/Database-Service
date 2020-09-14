package com.example.DatabaseService.controller;

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


    // Constructor to initialize instance
    @Autowired
    public AppController(StudentService studentService, AdminService adminService) {
        this.studentService = studentService;
        this.adminService = adminService;
    }

    // request : http://localhost:8072/student/student_id/assignments , It return assignment assign to student.
    @GetMapping("/student/{id}/assignments")
    public List<String> getAssignments(@PathVariable("id")String id){
        return studentService.getAssignments(id);
    }

    // request : http://localhost:8072/student/student_id/completeAssignments , It return assignment which is completed by student.
    @GetMapping("/student/{id}/completeAssignments")
    public List<String> getCompleteAssignments(@PathVariable("id")String id){
        return studentService.getCompleteAssignments(id);
    }

    // postRequest:  http://localhost:8072/student/student_id/addCompleteAssignment , to add assignment to complete assignments by student
    @PostMapping("/student/{id}/addCompleteAssignment")
    public void setCompleteAssignment(@PathVariable("id")String id, @RequestParam("assignment") String assignment){
        studentService.setCompleteAssignment(id,assignment);
    }

    // postRequest:  http://localhost:8072/student/student_id/addAssignment , to add new assignment to student by Admin
    @PostMapping("student/{id}/addAssignment")
    public List<String> addAssignment(@PathVariable("id")String id,@RequestParam("assignment")String assignment){
        return studentService.addAssignment(id,assignment);
    }

    // postRequest:  http://localhost:8072/admin/admin_id/addAssignment , to add assignment to admin's assignment
    @PostMapping("admin/{id}/addAssignment")
    public List<String> addAdminAssignment(@PathVariable("id")String id,@RequestParam("assignment")String assignment){
        return adminService.addNewAssignment(id,assignment);
    }

    // postRequest:  http://localhost:8072/admin/admin_id/assignments , to get all assignment of admin
    @GetMapping("/admin/{id}/assignments")
    public List<String> getAdminAssignments(@PathVariable("id")String id){
        List<String> strings = adminService.getAssignments(id);
        return adminService.getAssignments(id);
    }

    // postRequest:  http://localhost:8072/admin/admin_id/assignedAssignment , to get assignment to student with their name
    @GetMapping("/admin/{id}/assignedAssignment")
    public Map<String,List<String>> getAssignAssignments(@PathVariable("id")String id){
        Map<String, List<String>> assignAssignment =  studentService.getAllAssignments();
        return assignAssignment;
    }

    // postRequest:  http://localhost:8072/admin/admin_id/student , to get all student's name
    @GetMapping("/admin/{id}/students")
    public Map<String,String> getStudentName(@PathVariable("id")String id){
        return studentService.getAllStudentName();
    }

    // postRequest:  http://localhost:8072/student/login, to check student is valid or not
    @PostMapping("/student/login")
    public boolean checkStudent(@RequestParam("id")String id, @RequestParam("password")String password){
        return studentService.checkStudent(id,password);
    }
    // postRequest:  http://localhost:8072/admin/login, to check student is valid or not
    @PostMapping("/admin/login")
    public boolean checkAdmin(@RequestParam("id")String id, @RequestParam("password")String password){
        return adminService.checkAdmin(id,password);
    }


}
