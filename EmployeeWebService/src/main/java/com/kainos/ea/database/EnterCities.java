package com.kainos.ea.database;

import com.kainos.ea.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnterCities {

    public static List<String> execute(List<City> citiesToAdd) {

        int result = 0;
        Database myDatabase = new Database();

        String query = queryBuilder(citiesToAdd);

        try (Connection myConnection = myDatabase.getConnection();
                PreparedStatement preparedQuery = myConnection.prepareStatement(query)) {

            result = preparedQuery.executeUpdate();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        if(result == 1) {

            List<String> cityNames = new ArrayList<>();

            for(City city : citiesToAdd) {

                cityNames.add(city.getName());

            }

            return cityNames;

        } else {

            return Collections.emptyList();

        }


    }

    public static String queryBuilder(List<City> cities) {

        String values = "";

        values = "('" + cities.get(0).getName() + "', '" + cities.get(0).getCountryCode() +
                "', '" + cities.get(0).getDistrict() + "', " +cities.get(0).getPopulation() + ")";

        if(cities.size() > 1) {

            for (City city : cities) {

                values = values + ",('" + city.getName() + "', '" + city.getCountryCode() +
                        "', '" + city.getDistrict() + "', " + city.getPopulation() + ")";

            }

        }

        values += ";";

        String query = "insert into city(Name,CountryCode,District,Population)" +
                " values " + values;

        return query;

    }
}
