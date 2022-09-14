package com.kainos.ea.database;

import com.kainos.ea.employee_stuff.City;
import com.kainos.ea.employee_stuff.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.kainos.ea.database.Database.getConnection;

public class GetCities {

    private static Connection myConnection;
    public static List<City> getCities() {

        List<City> cities = new ArrayList<>();
        ResultSet rs = null;

        try (Connection myConnection = getConnection();
             Statement st = (myConnection == null) ? null : myConnection.createStatement()) {

            if (myConnection == null)
                throw new SQLException("Database connection null");

            rs = st.executeQuery("select * from city");

            while (rs.next()) {
                City city = new City((short) rs.getInt("ID"),
                        rs.getString("Name"), rs.getString("CountryCode"),
                        rs.getString("District"),rs.getInt("Population"));
                cities.add(city);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return cities;

    }
}
