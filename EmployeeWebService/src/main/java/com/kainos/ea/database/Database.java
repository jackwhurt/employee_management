package com.kainos.ea.database;

import org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForArraysOfLong;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Properties;

public class Database {

    private static Connection myConnection;

    public static void main(String[] args) {

        long t1;
        long t2;
        List<Employee> bigEmps = new ArrayList<>();
        ResultSet rs = null;

        try(Connection myCon = getConnection();
            Statement st = (myCon == null) ? null : myCon.createStatement()) {

            if(myCon == null)
                throw new SQLException("Database connection null");

            rs = st.executeQuery(
                    "SELECT emp_no AS `number`, "
                            + "CONCAT_WS (' ', first_name, last_name) AS `name`, "
                            + "salary * 100 AS `salary` "
                            + "FROM employees JOIN salaries USING(emp_no) ");

            while (rs.next()) {
                Employee dbEmp = new Employee((short) rs.getInt("number"),
                        rs.getInt("salary"), rs.getString("name"));
                bigEmps.add(dbEmp);

            }

        } catch(SQLException ex) {

            System.out.println(ex.getMessage());

        }

        OptionalDouble avgSalaries = bigEmps.stream().filter(emp -> emp.getName().split(" ")[1].trim().equals("Farris"))
                .sorted((x, y) -> (x.getSalary() - y.getSalary()))
                .mapToDouble(Employee::getSalary).average();

        if(avgSalaries.isPresent())
            System.out.printf("Average salary is £%,.2f.%n", avgSalaries.getAsDouble()/100);

        t1 = System.nanoTime();
        t2 = System.nanoTime();
        System.err.println("Printing: Trace took " + (t2-t1) + " nanos.");

    }

    private static Connection getConnection() {

        String user;
        String password;
        String host;

        if (myConnection != null)
            return myConnection;

        try(FileInputStream propsStream = new FileInputStream("employeesdb.properties")) {

            Properties props = new Properties();
            props.load(propsStream);

            user = props.getProperty("user");
            password = props.getProperty("password");
            host = props.getProperty("host");

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain " + "user, password, and host properties.");
            myConnection = DriverManager.getConnection("jdbc:mysql://" + host +
                    "/employees?useSSL=false", user, password);
            return myConnection;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

}
