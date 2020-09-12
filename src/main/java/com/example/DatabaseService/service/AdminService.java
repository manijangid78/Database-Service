package com.example.DatabaseService.service;

import com.example.DatabaseService.entity.Admin;
import com.example.DatabaseService.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<String> getAssignments(String id){
        Admin admin = adminRepository.getOne(id);
        return admin.getAllAssignments();
    }

    public List<String> addNewAssignment(String id, String assignment){
        Admin admin = adminRepository.getOne(id);
        admin.getAllAssignments().add(assignment);
        adminRepository.save(admin);
        return admin.getAllAssignments();
    }

    public boolean checkAdmin(String email, String password){
        try{
            Admin admin= adminRepository.getOne(email);
            return admin.getPassword().equals(password);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

}
