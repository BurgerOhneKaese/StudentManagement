package com.example.studentmanagement.Service;

import com.example.studentmanagement.AdminUserDetails;
import com.example.studentmanagement.Entity.Admin;
import com.example.studentmanagement.Entity.Student;
import com.example.studentmanagement.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    public AdminService(){}

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = adminRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Benutzer nicht vorhanden");
        }
        return new AdminUserDetails(user);
    }
    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }

}
