package com.kainos.ea.database;

import com.kainos.ea.employee_stuff.Employee;
import com.kainos.ea.employee_stuff.SalesEmployee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.kainos.ea.database.Database.getConnection;

public class HighestSalesEmployee {

    public static SalesEmployee getHighestSalesEmployee(){

        ResultSet rs = null;
        SalesEmployee dbEmp = null;
        try (Connection myConnection = getConnection();
             Statement st = (myConnection == null) ? null : myConnection.createStatement()) {

            if (myConnection == null)
                throw new SQLException ("Database connection null");

            while (rs.next()) {
                rs = st.executeQuery ("select * from SalesEmployee_JackH where SalesTotal IN (select max(SalesTotal) from SalesEmployee_JackH);");
                dbEmp = new SalesEmployee ((short) rs.getInt ("EmployeeNo"),
                        rs.getString ("EmployeeName"),
                        rs.getInt ("Commission"),
                        rs.getInt ("SalesTotal"));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return dbEmp;
    }
}
