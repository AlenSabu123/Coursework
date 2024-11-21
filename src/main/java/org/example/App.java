package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class App {

//instantiating class to carry out query takes in paramter continent.
    public ArrayList<Countries> getCountriesInContinent(String continent) throws SQLException {
        // Create an SQL statement
        if (continent == null) {
            System.out.println("Continent parameter is null");
            return new ArrayList<>(); // Return an empty list if continent is null
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Population " +
                            "FROM country " +
                            "WHERE Continent = '" + continent + "' " + // Use the continent parameter
                            "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // List to store country information
            ArrayList<Countries> queryTwoList = new ArrayList<>();
            boolean isCorrect = false;

            // Process the results from the query
            while (rset.next()) {
                // Retrieve country name and population
                String CountryName = rset.getString("Name");
                int Population = rset.getInt("Population");

                // Format the string to store in the list
                Countries queryTwoInfo = new Countries(CountryName, Population); //queryTwo.CountryName + " Population = " + queryTwo.Population;
                queryTwoList.add(queryTwoInfo);
                isCorrect = true;

                // print the result
                System.out.println(CountryName + " Population = " + Population);
            }

            // If no results were found, print a message
            if (!isCorrect) {
                System.out.println("Unsuccessful");
            }
            return queryTwoList;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }




    }

    /**
     * Connection to MySQL database.
     */
    private static Connection con = null;

    /**
     * jijijoi
     *
     * @param args ioilujlouj
     */
    //main method
    public static void main(String[] args) throws SQLException {

        //intialisation of app object.
        App a = new App();
        a.connect(args);

        ArrayList<Countries> countriesInAfrica = a.getCountriesInContinent("Africa");

        //  print the result if conditions is passed
        if (countriesInAfrica != null && countriesInAfrica.stream().count() > 0) {
            System.out.println("Countries in Africa:");
            for (Countries countryInfo : countriesInAfrica) {
                System.out.println(countryInfo.CountryName + " Population = " + countryInfo.Population);
            }
        } else {
            System.out.println("No countries found in Africa.");
        }

        // Disconnect from the database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect(String[] params) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(6000);
                // Connect to database
                if (params.length == 0) {
                    con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                } else {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useSSL=false", "root", "example");
                }
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

}