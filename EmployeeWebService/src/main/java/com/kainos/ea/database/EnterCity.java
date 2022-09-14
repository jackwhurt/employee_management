package com.kainos.ea.database;

import com.kainos.ea.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnterCity {

    public static String execute(City cityToAdd) {

        int result = 0;
        Database myDatabase = new Database();

        String query = queryBuilder(cityToAdd);

        try (Connection myConnection = myDatabase.getConnection();
             PreparedStatement preparedQuery = myConnection.prepareStatement(query)) {

            result = preparedQuery.executeUpdate();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        if(result == 1) {

            String cityName = cityToAdd.getName();
            return cityName;

        } else {

            return "";

        }


    }

    public static String queryBuilder(City city) {

        String values = "";

        values = "('" + city.getName() + "', '" + city.getCountryCode() +
                "', '" + city.getDistrict() + "', " + city.getPopulation() + ");";

        String query = "insert into city(Name,CountryCode,District,Population)" +
                " values " + values;

        return query;

    }
}
