package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class App {




    public ArrayList<Countries> allCapitalCitiesInWorld(String cities,String region) throws SQLException {
        // Create an SQL statement


        //try statement handling exception of query
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name,Region " +
                            "FROM country  " +
                            "ORDER BY SurfaceArea DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // List to store city information
            ArrayList<Countries> queryNineteenList = new ArrayList<>();
            boolean isCorrect = false;

            // Process the results from the query
            while (rset.next()) {
                // Retrieve city name and population
                String CityName = rset.getString("Name");
                String Region = rset.getString("Region");

                // Format the string to store in the list
                Countries queryNineteenInfo = new Countries(cities, region); //queryOne.CountryName + " Population = " + queryOne.Population;
                queryNineteenList.add(queryNineteenInfo);
                isCorrect = true;

            }

            // If no results were found, print a message
            if (!isCorrect) {
                System.out.println("Unsuccessful");
            }
            return queryNineteenList;
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

        ArrayList<Countries> allCapitalCitiesInWorld= a.allCapitalCitiesInWorld();

        //  print the result if conditions is passed
        if (allCapitalCitiesInWorld != null && allCapitalCitiesInWorld.stream().count() > 0) {
            System.out.println("Cities in Region:");
            for (Countries countryInfo : allCapitalCitiesInWorld) {
                System.out.println(countryInfo.cities + " Region = " + countryInfo.region);
            }
        } else {
            System.out.println("No cities found in the region.");
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