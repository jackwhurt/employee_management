package com.kainos.ea.database;

import com.kainos.ea.model.SalesEmployee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HighestSalesEmployee {

    public static List<SalesEmployee> getHighestSalesEmployee(){

        ResultSet rs;
        List<SalesEmployee> bigEmps = new ArrayList<> ();
        Database myDatabase = new Database();

        try (Connection myConnection = myDatabase.getConnection();
             Statement st = (myConnection == null) ? null : myConnection.createStatement()) {

            if (myConnection == null)
                throw new SQLException ("Database connection null");

            rs = st.executeQuery ("select * from SalesEmployee_JackH where SalesTotal IN (select max(SalesTotal) from SalesEmployee_JackH);");

            while (rs.next()) {
                SalesEmployee dbEmp = new SalesEmployee ((short) rs.getInt ("EmployeeNo"),
                        rs.getString ("EmployeeName"),
                        rs.getFloat ("Commission"),
                        rs.getInt ("SalesTotal"));
                bigEmps.add(dbEmp);
            }



        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return bigEmps;
    }
}
