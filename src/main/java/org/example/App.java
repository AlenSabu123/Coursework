package org.example;

import java.sql.*;


public class App {


    public static class Countries{

    public String CountryName;

    public int Population;



    }
    /**
     * Connection to MySQL database.
     */
    private static Connection con = null;

    /**
     * jijijoi
     * @param args ioilujlouj
     */
    //main meth od
    public static void main(String[] args) throws SQLException {

        //intialisation of app object.
        App a = new App();
        System.out.println("Test");
        //connect to database
        a.connect(args);
        System.out.println("Test");

        // Crea te an SQL statement
        Statement stmt = con.createStatement();
        // Create string for SQL statement
        String strSelect =
                "SELECT Name, Population " +
                        "FROM country " +
                        "WHERE Continent = 'Africa' "+// Using parameterized query would be ideal, but staying consist
        "ORDER BY Population DESC";


        // Execute SQL statement
        ResultSet rset = stmt.executeQuery(strSelect);
        boolean isCorrect = false;
        while(rset.next()) {
            // Display results
            Countries queryTwo = new Countries();
            queryTwo.CountryName = rset.getString("Name");
            queryTwo.Population= rset.getInt("Population");
            isCorrect = true;
            System.out.println(queryTwo.CountryName + " Population = " + queryTwo.Population);

        }  if(!isCorrect) {
            // If no results were found
            System.out.println("Unsuccessful");
        }

        //disconnect fr om database.
        a.disconnect();

    }




    /**
     * Connect to the MySQL database.
     */
    public void connect(String[] params)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(6000);
                // Connect to database
                if(params.length == 0) {
                    con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                }
                else {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world?useSSL=false", "root", "example");
                }
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
}
