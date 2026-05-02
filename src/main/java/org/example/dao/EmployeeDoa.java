package org.example.dao;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDoa {

    public List<Employee> findAll() throws SQLException;
    Employee  findById(int id) throws SQLException;

    void save(Employee employee);

    void deleteById(int id);

}
