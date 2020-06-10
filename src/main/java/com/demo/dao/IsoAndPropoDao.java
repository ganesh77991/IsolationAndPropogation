package com.demo.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.JpaRepo;
import com.demo.model.Employee;

@Repository
public class IsoAndPropoDao {
	
	@Autowired
	JpaRepo repo;
	
	
	
	/*
	 * @Transactional(isolation =Isolation.READ_UNCOMMITTED ,propagation =
	 * Propagation.REQUIRED) public Employee reg(Employee emp) {
	 * 
	 * return repo.save(emp); }
	 */
	
	/*
	 * @Transactional(isolation =Isolation.READ_UNCOMMITTED ,propagation =
	 * Propagation.MANDATORY) public Employee reg(Employee emp) {
	 * 
	 * return repo.save(emp); }
	 */
	
	@Transactional(isolation =Isolation.READ_UNCOMMITTED ,propagation = Propagation.NOT_SUPPORTED)
	public Employee reg(Employee emp) {
		
		return repo.save(emp);
	}
	
	/*
	 * @Transactional(isolation = Isolation.READ_COMMITTED,propagation =
	 * Propagation.SUPPORTS) public Employee update(Employee emp) {
	 * 
	 * return repo.save(emp); }
	 */
	
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW)
	public Employee update(Employee emp) {
		
		return repo.save(emp);
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.NESTED)
	public void delete(Integer id) {
		
		 repo.deleteById(id);
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE,propagation = Propagation.NEVER)
	public List<Employee> getAll() {
		
		return repo.findAll();
	}

}
