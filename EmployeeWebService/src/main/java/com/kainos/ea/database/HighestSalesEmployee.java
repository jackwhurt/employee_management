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

        ResultSet rs;
        SalesEmployee dbEmp = new SalesEmployee ();
        try (Connection myConnection = getConnection();
             Statement st = (myConnection == null) ? null : myConnection.createStatement()) {

            if (myConnection == null)
                throw new SQLException ("Database connection null");

            rs = st.executeQuery("select * from SalesEmployee_JackH where SalesTotal IN (select max(SalesTotal) from SalesEmployee_JackH);");

                        dbEmp.setNumber((short) rs.getInt("EmployeeNo"));
                        dbEmp.setName (rs.getString("EmployeeName"));
                        dbEmp.setCommission (rs.getInt ("Commission"));
                        dbEmp.setSalesTotal (rs.getInt("SalesTotal"));

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return dbEmp;
    }
}
