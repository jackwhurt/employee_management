package com.kainos.ea.database;

import com.kainos.ea.employee_stuff.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static com.kainos.ea.database.Database.getConnection;

public class DatabaseEmployee {

    private static Connection myConnection;
    public static List<Employee> getEmployees() {

        List<Employee> bigEmps = new ArrayList<>();
        ResultSet rs = null;

        try (Connection myConnection = getConnection();
             Statement st = (myConnection == null) ? null : myConnection.createStatement()) {

            if (myConnection == null)
                throw new SQLException("Database connection null");

            rs = st.executeQuery("select * from employee_JackH");

            while (rs.next()) {
                Employee dbEmp = new Employee((short) rs.getInt("EmployeeNo"),
                        rs.getString("EmployeeName"), rs.getString("Address"),
                        rs.getString("NIN"),rs.getString("BankAccountNo"),
                        rs.getInt("Salary"), rs.getString("Department"));
                bigEmps.add(dbEmp);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return bigEmps;

    }
}
