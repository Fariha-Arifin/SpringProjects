package com.luv2code.springdemo.curddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springdemo.curddemo.entity.Employee;

//@RepositoryRestResource(path="member")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
