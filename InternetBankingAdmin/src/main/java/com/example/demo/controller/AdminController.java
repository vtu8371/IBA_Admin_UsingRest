package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Admin;
import com.example.demo.exception.DetailsNotFoundException;
import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.InvalidDetailsException;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * addAdmin
     * <p>
     * To adding admin details in database if details are invalid throws exception
     * </p>
     * 
     * @param admin
     * @return ResponseEntity<Admin>
     * @throws InvalidDetailsException
     */

    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws InvalidDetailsException {
        Admin res = adminService.addAdmin(admin);
        return new ResponseEntity<Admin>(res, HttpStatus.OK);
    }

    /**
     * findAdminById
     * <p>
     * To find the details of admin by using admin_id as parameter and return admin
     * object if not present throws exceptions
     * </p>
     * 
     * @param adminId
     * @return ResponseEntity<Admin>
     * @throws DetailsNotFoundException
     */
    @GetMapping("/findAdminById/{adminId}")
    public ResponseEntity<Admin> findAdminById(@PathVariable long adminId) throws DetailsNotFoundException {
        Admin res = adminService.findAdminById(adminId);
        return new ResponseEntity<Admin>(res, HttpStatus.OK);
    }

    /**
     * updateAdmin
     * <p>
     * Any changes in admin then we can modify in updateAdmin
     * </p>
     * 
     * @param admin
     * @return ResponseEntity<Admin>
     * @throws InvalidDetailsException
     */

    @PutMapping("/updateAdmin")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) throws InvalidDetailsException {
        Admin Long = adminService.updateAdmin(admin);
        return new ResponseEntity<Admin>(Long, HttpStatus.OK);
    }

    /**
     * removeAdmin
     * <p>
     * Deleting the admin by using adminId and return boolean values if adminid not
     * found then throws exception
     * </p>
     * 
     * @param adminId
     * @return ResponseEntity<Admin>
     * @throws DetailsNotFoundException
     */
    @DeleteMapping("/removeAdmin/{adminId}")
    public ResponseEntity<Boolean> removeAdmin(@PathVariable long adminId) throws DetailsNotFoundException {
        boolean isDeleted = adminService.removeAdmin(adminId);

        return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);

    }

    /**
     * findAllAdmins 
     * <p>
     * to find all admins
     * </p>
     * 
     * @return Set<Admin>
     * @throws EmptyListException
     */
    @GetMapping("/findAllAdmin")
    public Set<Admin> findAllAdmins() throws EmptyListException {
        return adminService.listAllAdmins();
    }

}
