package org.example;

import org.example.dao.DBConnection;
import org.example.dao.Employee;
import org.example.dao.EmployeeDoa;
import org.example.dao.EmployeeDoaImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class App
{
    public static void main( String[] args )
    {
        Connection conn = DBConnection.getConnection();
        if(conn!=null)
        {
            System.out.println("Connected to the database");
        }
        else
        {
            System.out.println("Connection Failed");
        }


        Employee employee= new Employee(100,"KOKO",true,
                        new Date(2012, Calendar.OCTOBER,20),100.0 );

        EmployeeDoa employeeDoa = new EmployeeDoaImpl();
       // employeeDoa.save(employee);


           employeeDoa.deleteById(4);

        System.out.println("Done!");

     }
}
