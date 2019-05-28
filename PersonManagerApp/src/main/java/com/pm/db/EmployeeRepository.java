package com.pm.db;

import org.springframework.data.repository.CrudRepository;

import com.pm.business.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
