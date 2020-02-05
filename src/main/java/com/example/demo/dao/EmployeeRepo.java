package com.example.demo.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	public Employee findByname(String name);
	
	@Query("from Employee where id =?1")
	public Employee findByEmpid(@Param("id") int id);

}
