package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entites.Admin;
import com.example.demo.exception.DetailsNotFoundException;
import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.InvalidDetailsException;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;

@SpringBootTest
public class InternetBankingApplicationTests {
    @Autowired
    AdminService adminService;

    @MockBean
    AdminRepository adminRepository;
    Admin admin = new Admin(2, "sai", "201032145", "sai@gamil.com");
    Admin admin1 = new Admin(3, "kumar", "201032146", "kumar@gamil.com");

    /**
     * testaddAdmin
     * <p>
     * testing the addadmin
     * </P>
     * 
     * @throws InvalidDetailsException
     */
    @Test
    public void testaddAdmin() throws InvalidDetailsException {
        Admin admin = new Admin(1, "venkatesh", "9092032690", "venkatesh@gamil.com");
        when(adminRepository.save(admin)).thenReturn(admin);

        assertEquals(admin, adminService.addAdmin(admin));
    }

    /**
     * testaddAdminThrowsInvalidDetailsException
     * <p>
     * testing InvalidDetailsExceptions in addAdmin
     * </P>
     */

    @Test

    public void testaddAdminThrowsInvalidDetailsException() {
        Admin admin = new Admin(12, "venkat", "9092032690", "venkat@gamil.com");
        when(adminRepository.save(admin)).thenReturn(admin);
        Assertions.assertThrows(InvalidDetailsException.class, () -> {
            adminService.updateAdmin(admin);
        });

    }

    /**
     * testfindAdminById
     * <p>
     * Testing the admin details using with adminId
     * </P>
     * 
     * @throws DetailsNotFoundException
     */

    @Test
    public void testfindAdminById() throws DetailsNotFoundException {
        when(adminRepository.findById((long) 2)).thenReturn(Optional.of(admin));
        Admin fetchAdmin = adminService.findAdminById(2);
        assertNotNull(fetchAdmin);
        assertEquals(admin, fetchAdmin);

    }

    /**
     * testupdateAdmin
     * <p>
     * testing updateAdmin
     * </P>
     * 
     * @throws InvalidDetailsException
     */

    @Test
    public void testupdateAdmin() throws InvalidDetailsException {
        when(adminRepository.save(admin)).thenReturn(admin);
        when(adminRepository.findById((long) 2)).thenReturn(Optional.of(admin));
        Admin updateAdmin = adminService.updateAdmin(admin);
        assertNotNull(updateAdmin);
        assertEquals(admin, updateAdmin);
    }

    /**
     * testupdateAdminThrowsInvalidDetailsException
     * <p>
     * testing InvalidDetailsExceptions in updateAdmin
     * </P>
     */

    @Test
    public void testupdateAdminThrowsInvalidDetailsException() {
        Admin admin = new Admin(11, "ramesh", "09876545", "ramesh@gamil.com");
        when(adminRepository.findById((long) 10)).thenReturn(Optional.of(new Admin()));
        Assertions.assertThrows(InvalidDetailsException.class, () -> {
            adminService.updateAdmin(admin);
        });

    }

    @Test
    public void testremoveAdmin() throws DetailsNotFoundException {

        when(adminRepository.findById((long) 2)).thenReturn(Optional.of(admin));
        boolean isDeleted = adminService.removeAdmin(admin.getAdminId());

        Mockito.verify(adminRepository, times(1)).deleteById((long) 2);
        assertEquals(true, isDeleted);
    }

    /**
     * testremoveAdminThrowsDetailsNotFoundException
     * <p>
     * To test DetailsNotFoundException
     * </P>
     */

    @Test
    public void testremoveAdminThrowsDetailsNotFoundException() {
        Admin admin = new Admin(101, "ramesh", "09876545", "ramesh@gamil.com");
        Assertions.assertThrows(DetailsNotFoundException.class, () -> {
            adminService.removeAdmin(102);
        });
    }

    /**
     * testListAllAdmins
     * <p>
     * To test alladmins
     * </P>
     * * @throws EmptyListException
     */
    @Test
    public void testListAllAdmins() throws EmptyListException {
        List<Admin> listallAdmin = new ArrayList<Admin>();
        Set<Admin> setallAdmin = new HashSet<Admin>();
        listallAdmin.add(admin);
        when((adminRepository).findAll()).thenReturn(listallAdmin);
        setallAdmin = adminService.listAllAdmins();
        assertNotNull(setallAdmin);
        assertEquals(listallAdmin.size(), setallAdmin.size());
    }

}
