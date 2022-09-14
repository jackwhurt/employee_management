package com.kainos.ea.database;

import com.kainos.ea.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GetCities {

    private static Connection myConnection;
    public static List<City> execute() {

        List<City> cities = new ArrayList<>();
        ResultSet rs = null;
        Database myDatabase = new Database();
        String query = "select * from city";

        try (Connection myConnection = myDatabase.getConnection();
             PreparedStatement preparedQuery = myConnection.prepareStatement(query)) {

            rs = preparedQuery.executeQuery();

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