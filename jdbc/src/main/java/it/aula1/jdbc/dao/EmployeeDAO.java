package it.aula1.jdbc.dao;

import java.util.List;

import it.aula1.jdbc.model.Employee;

public interface EmployeeDAO {

	public boolean initEmployee();
	boolean addEmployee(int id, String name, long salary);
	List<Employee> list();
}
