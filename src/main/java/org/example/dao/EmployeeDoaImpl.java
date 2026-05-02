package org.example.dao;

import org.example.Utils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDoaImpl implements EmployeeDoa {
    @Override
    public List<Employee> findAll() throws SQLException {
        Connection con = DBConnection.getConnection();
        if(con == null){
            return null;
        }
        List<Employee> employees = new ArrayList<>();

        String query = "select * from employee";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Employee employee = new Employee(resultSet.getInt("id"),resultSet.getString("name"),
                        resultSet.getBoolean("gender"),resultSet.getDate("birth_date"),resultSet.getDouble("salary"));

                employees.add(employee);
            }
        }
        finally{
            con.close();
        }

        return employees;

    }

    @Override
    public Employee findById(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        if(con == null){
            return null;
        }

        String query = "Select * from employee where id = ?";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return new Employee(id,
                        resultSet.getString("name"),
                        resultSet.getBoolean("gender"),
                        resultSet.getDate("birth_date"),
                        resultSet.getDouble("salary"));
            }
        }

         return null;
    }

    @Override
    public void save(Employee employee) {
        Connection con = DBConnection.getConnection() ;
        if(con == null){
          return;
        }

        if(employee.getId()>0){ // update
            String query = "update employee set name=?,gender=? ,birth_date=? ,salary = ? where id=?";

            try(PreparedStatement preparedStatement = con.prepareStatement(query)){
                preparedStatement.setString(1,employee.getName());
                preparedStatement.setBoolean(2,employee.isGender() );
                preparedStatement.setDate(3,Util.sqlDate(employee.getBirthDate()));
                preparedStatement.setDouble(4,employee.getSalary());
                preparedStatement.setInt(5,employee.getId());

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
               e.printStackTrace();
            }
            finally{
                try {
                    con.close();
                } catch (SQLException e) {
                   e.printStackTrace();
                }
            }


        }
        else{ // create
            String query = "INSERT INTO employee(name,gender,birth_date,salary) VALUES (?,?,?,?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)){
                preparedStatement.setString(1,employee.getName());
                preparedStatement.setBoolean(2,employee.isGender());
                preparedStatement.setDate(3, Util.sqlDate(employee.getBirthDate()));
                preparedStatement.setDouble(4, employee.getSalary());

                preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            finally{
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }




        }




    }

    @Override
    public void deleteById(int id) {
        Connection con = DBConnection.getConnection();
        if(con == null){
            return;
        }
        String query = "delete from employee where id = ?";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
