package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class App {




    public ArrayList<Countries> getCountriesInWorld() throws SQLException {
        // Create an SQL statement



        //try statement handling exception of query
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Population " +
                            "FROM country " +
                            "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // List to store country information
            ArrayList<Countries> queryOneList = new ArrayList<>();
            boolean isCorrect = false;

            // Process the results from the query
            while (rset.next()) {
                // Retrieve country name and population
                String CountryName = rset.getString("Name");
                int Population = rset.getInt("Population");

                // Format the string to store in the list
                Countries queryOneInfo = new Countries(CountryName, Population); //queryOne.CountryName + " Population = " + queryOne.Population;
                queryOneList.add(queryOneInfo);
                isCorrect = true;

            }

            // If no results were found, print a message
            if (!isCorrect) {
                System.out.println("Unsuccessful");
            }
            return queryOneList;
        } catch (Exception e) {
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

        ArrayList<Countries> getCountriesInWorld= a.getCountriesInWorld();

        //  print the result if conditions is passed
        if (getCountriesInWorld != null && getCountriesInWorld.stream().count() > 0) {
            System.out.println("Countries in World:");
            for (Countries countryInfo : getCountriesInWorld) {
                System.out.println(countryInfo.CountryName + " Population = " + countryInfo.Population);
            }
        } else {
            System.out.println("No countries found in the World.");
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