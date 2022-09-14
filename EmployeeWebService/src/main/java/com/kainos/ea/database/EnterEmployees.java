package com.kainos.ea.database;

import com.kainos.ea.model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EnterEmployees {

    public static List<Employee> enterEmployees(List<Employee> employeesToAdd) {
        List<Employee> bigEmps = new ArrayList<>();
        ResultSet rs = null;
        Database myDatabase = new Database();
        String values = "";

        values = "('" + employeesToAdd.get(0).getName() + "', '" + employeesToAdd.get(0).getAddress() + "', '" + employeesToAdd.get(0).getNin() +
                "', '" + employeesToAdd.get(0).getBankAccount() + "', " +employeesToAdd.get(0).getSalary() + ", '" + employeesToAdd.get(0).getDepartment() + "')";

        if(employeesToAdd.size() > 1) {

            for (Employee employee : employeesToAdd) {

                values = values + ",('" + employee.getName() + "', '" + employee.getAddress() + "', '" + employee.getNin() +
                        "', '" + employee.getBankAccount() + "', " + employee.getSalary() + ", '" + employee.getDepartment() + "')";

            }

        }
        values += ";";

        try (
                Connection myConnection = myDatabase.getConnection();
                Statement st = (myConnection == null) ? null : myConnection.createStatement()) {

            if (myConnection == null)
                throw new SQLException("Database connection null");

            st.executeUpdate("insert into employee_JackH(EmployeeName,Address,NIN,BankAccountNo,Salary,Department)" +
                    " values " + values);

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
