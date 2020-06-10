package com.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Employee;

public interface JpaRepo extends JpaRepository<Employee, Integer>{

}
