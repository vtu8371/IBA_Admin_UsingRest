package com.example.demo.service;

import java.util.Set;

import com.example.demo.entites.Admin;
import com.example.demo.exception.DetailsNotFoundException;
import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.InvalidDetailsException;




public interface IAdminService {

	public Admin  addAdmin(Admin admin) throws InvalidDetailsException;
	public Admin findAdminById(long adminId)throws DetailsNotFoundException ;
	public Admin updateAdmin(Admin admin) throws InvalidDetailsException ;
	public boolean removeAdmin(long adminId)throws DetailsNotFoundException;
	public Set<Admin> listAllAdmins() throws EmptyListException;
}
