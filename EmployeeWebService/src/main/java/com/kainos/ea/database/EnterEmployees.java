package com.kainos.ea.database;

import com.kainos.ea.employee_stuff.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.kainos.ea.database.Database.getConnection;

public class EnterEmployees {

    public static List<Employee> enterEmployees(List<Employee> employeesToAdd) {
        List<Employee> bigEmps = new ArrayList<>();
        ResultSet rs = null;

        String values = "";

        for(Employee employee: employeesToAdd) {

            values = values + ",(" + employee.getName() + ", " + employee.getAddress() + ", " + employee.getNin() +
                    ", " + employee.getBankAccount() + ", " +employee.getSalary() + ", " + employee.getDepartment() + ")";

        }

        try (
                Connection myConnection = getConnection();
                Statement st = (myConnection == null) ? null : myConnection.createStatement()) {

            if (myConnection == null)
                throw new SQLException("Database connection null");

            rs = st.executeQuery("insert into(EmployeeName,Address,NIN,BankAccountNo,Salary,Department)" +
                    " Employee_JackH values " + values);

//            while (rs.next()) {
//                Employee dbEmp = new Employee((short) rs.getInt("EmployeeNo"),
//                        rs.getString("EmployeeName"), rs.getString("Address"),
//                        rs.getString("NIN"), rs.getString("BankAccountNo"),
//                        rs.getInt("Salary"), rs.getString("Department"));
//                bigEmps.add(dbEmp);
//            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return bigEmps;

    }
}
