package org.example;

import java.sql.*;
import java.util.ArrayList;

public class App {

    public static class Countries {
        public String CountryName;
        public int Population;

        public Countries(String countryName, int population) {
            this.CountryName = countryName;
            this.Population = population;
        }
    }

    public static class Cities {
        public String CityName;
        public int Population;

        public Cities(String cityName, int population) {
            this.CityName = cityName;
            this.Population = population;
        }
    }

    public static class CapitalCity {
        public String CapitalCityName;
        public int CapitalCityPopulation;

        public CapitalCity(String capitalCityName, int capitalCityPopulation) {
            this.CapitalCityName = capitalCityName;
            this.CapitalCityPopulation = capitalCityPopulation;
        }
    }

    public ArrayList<Countries> getCountriesInContinent(String continent) throws SQLException {
        if (continent == null) {
            System.out.println("Continent parameter is null");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT Name, Population FROM country WHERE Continent = '" + continent + "' ORDER BY Population DESC";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Countries> queryList = new ArrayList<>();
            while (rset.next()) {
                String countryName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Countries(countryName, population));
            }
            if (queryList.isEmpty()) System.out.println("No countries found.");
            return queryList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Countries> getCountriesInRegionOrderedByPopulation(String region) throws SQLException {
        if (region == null || region.isEmpty()) {
            System.out.println("Region parameter is null or empty");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT Name, Population FROM country WHERE Region = '" + region + "' ORDER BY Population DESC";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Countries> queryList = new ArrayList<>();
            while (rset.next()) {
                String countryName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Countries(countryName, population));
            }
            if (queryList.isEmpty()) System.out.println("No countries found in region: " + region);
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Countries> getTopNPopulatedCountries(int n) throws SQLException {
        if (n <= 0) {
            System.out.println("Invalid input: N must be greater than 0");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT Name, Population FROM country ORDER BY Population DESC LIMIT " + n;
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Countries> queryList = new ArrayList<>();
            while (rset.next()) {
                String countryName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Countries(countryName, population));
            }
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Countries> getTopNPopulatedCountriesInContinent(String continent, int n) throws SQLException {
        if (n <= 0) {
            System.out.println("Invalid input: N must be greater than 0");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT Name, Population FROM country WHERE Continent = '" + continent + "' ORDER BY Population DESC LIMIT " + n;
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Countries> queryList = new ArrayList<>();
            while (rset.next()) {
                String countryName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Countries(countryName, population));
            }
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Countries> getTopNPopulatedCountriesInRegion(String region, int n) throws SQLException {
        if (n <= 0) {
            System.out.println("Invalid input: N must be greater than 0");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT Name, Population FROM country WHERE Region = '" + region + "' ORDER BY Population DESC LIMIT " + n;
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Countries> queryList = new ArrayList<>();
            while (rset.next()) {
                String countryName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Countries(countryName, population));
            }
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cities> getAllCitiesOrderedByPopulation() throws SQLException {
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT Name, Population FROM city ORDER BY Population DESC";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Cities> queryList = new ArrayList<>();
            while (rset.next()) {
                String cityName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Cities(cityName, population));
            }
            if (queryList.isEmpty()) System.out.println("No cities found in the database.");
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cities> getCitiesInContinentOrderedByPopulation(String continent) throws SQLException {
        if (continent == null || continent.isEmpty()) {
            System.out.println("Continent parameter is null or empty");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.Population FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Continent = '" + continent + "' ORDER BY city.Population DESC";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Cities> queryList = new ArrayList<>();
            while (rset.next()) {
                String cityName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Cities(cityName, population));
            }
            if (queryList.isEmpty()) System.out.println("No cities found in continent: " + continent);
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cities> getCitiesInRegionOrderedByPopulation(String region) throws SQLException {
        if (region == null || region.isEmpty()) {
            System.out.println("Region parameter is null or empty");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.Population FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Region = '" + region + "' ORDER BY city.Population DESC";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Cities> queryList = new ArrayList<>();
            while (rset.next()) {
                String cityName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Cities(cityName, population));
            }
            if (queryList.isEmpty()) System.out.println("No cities found in region: " + region);
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cities> getCitiesInCountryOrderedByPopulation(String country) throws SQLException {
        if (country == null || country.isEmpty()) {
            System.out.println("Country parameter is null or empty");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT Name, Population FROM city WHERE CountryCode = (SELECT Code FROM country WHERE Name = '" + country + "') ORDER BY Population DESC";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Cities> queryList = new ArrayList<>();
            while (rset.next()) {
                String cityName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Cities(cityName, population));
            }
            if (queryList.isEmpty()) System.out.println("No cities found in country: " + country);
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cities> getCitiesInDistrictOrderedByPopulation(String district) throws SQLException {
        if (district == null || district.isEmpty()) {
            System.out.println("District parameter is null or empty");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT Name, Population FROM city WHERE LOWER(District) = LOWER('" + district + "') ORDER BY Population DESC";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Cities> queryList = new ArrayList<>();
            while (rset.next()) {
                String cityName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Cities(cityName, population));
            }
            if (queryList.isEmpty()) System.out.println("No cities found in district: " + district);
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cities> getTopNCitiesOrderedByPopulation(int n) throws SQLException {
        if (n <= 0) {
            System.out.println("Invalid input: N must be greater than 0");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT Name, Population FROM city ORDER BY Population DESC LIMIT " + n;
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Cities> queryList = new ArrayList<>();
            while (rset.next()) {
                String cityName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Cities(cityName, population));
            }
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cities> getCapitalCitiesOrderedByPopulation() throws SQLException {
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.Population FROM city JOIN country ON city.ID = country.Capital ORDER BY city.Population DESC";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Cities> queryList = new ArrayList<>();
            while (rset.next()) {
                String cityName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Cities(cityName, population));
            }
            if (queryList.isEmpty()) System.out.println("No capital cities found.");
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cities> getTopNCapitalCitiesOrderedByPopulation(int n) throws SQLException {
        if (n <= 0) {
            System.out.println("Invalid input: N must be greater than 0");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.Population FROM city JOIN country ON city.ID = country.Capital ORDER BY city.Population DESC LIMIT " + n;
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Cities> queryList = new ArrayList<>();
            while (rset.next()) {
                String cityName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Cities(cityName, population));
            }
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cities> getCapitalCitiesInContinentOrderedByPopulation(String continent) throws SQLException {
        if (continent == null || continent.isEmpty()) {
            System.out.println("Continent parameter is null or empty");
            return new ArrayList<>();
        }
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Continent = '" + continent + "' ORDER BY city.Population DESC";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Cities> queryList = new ArrayList<>();
            while (rset.next()) {
                String cityName = rset.getString("Name");
                int population = rset.getInt("Population");
                queryList.add(new Cities(cityName, population));
            }
            if (queryList.isEmpty()) System.out.println("No capital cities found in continent: " + continent);
            return queryList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    private static Connection con = null;

    public void connect(String[] params) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }
        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                Thread.sleep(6000);
                if (params.length == 0) {
                    con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                } else {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useSSL=false", "root", "example");
                }
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        App app = new App();
        app.connect(args);

        System.out.println("\nThis is Query 2:");
        ArrayList<Countries> countriesInContinent = app.getCountriesInContinent("Africa");
        for (Countries country : countriesInContinent) {
            System.out.println(country.CountryName + " Population = " + country.Population);
        }

        System.out.println("\nThis is Query 3:");
        ArrayList<Countries> countriesInRegion = app.getCountriesInRegionOrderedByPopulation("Caribbean");
        for (Countries country : countriesInRegion) {
            System.out.println(country.CountryName + " Population = " + country.Population);
        }

        System.out.println("\nThis is Query 4:");
        ArrayList<Countries> topNCountries = app.getTopNPopulatedCountries(5);
        for (Countries country : topNCountries) {
            System.out.println(country.CountryName + " Population = " + country.Population);
        }

        System.out.println("\nThis is Query 5:");
        ArrayList<Countries> topCountriesInContinent = app.getTopNPopulatedCountriesInContinent("Asia", 5);
        for (Countries country : topCountriesInContinent) {
            System.out.println(country.CountryName + " Population = " + country.Population);
        }

        System.out.println("\nThis is Query 6:");
        ArrayList<Countries> topCountriesInRegion = app.getTopNPopulatedCountriesInRegion("Caribbean", 5);
        for (Countries country : topCountriesInRegion) {
            System.out.println(country.CountryName + " Population = " + country.Population);
        }

        System.out.println("\nThis is Query 7:");
        ArrayList<Cities> citiesInWorld = app.getAllCitiesOrderedByPopulation();
        for (Cities city : citiesInWorld) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 8:");
        ArrayList<Cities> citiesInContinent = app.getCitiesInContinentOrderedByPopulation("Asia");
        for (Cities city : citiesInContinent) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 9:");
        ArrayList<Cities> citiesInRegion = app.getCitiesInRegionOrderedByPopulation("Caribbean");
        for (Cities city : citiesInRegion) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 10:");
        ArrayList<Cities> citiesInCountry = app.getCitiesInCountryOrderedByPopulation("France");
        for (Cities city : citiesInCountry) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 11:");
        ArrayList<Cities> citiesInDistrict = app.getCitiesInDistrictOrderedByPopulation("Tokyo-to");
        for (Cities city : citiesInDistrict) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 12:");
        ArrayList<Cities> topNCities = app.getTopNCitiesOrderedByPopulation(5);
        for (Cities city : topNCities) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 13:");
        ArrayList<Cities> topCitiesInContinent = app.getCitiesInContinentOrderedByPopulation("Asia");
        for (Cities city : topCitiesInContinent) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 14:");
        ArrayList<Cities> topCitiesInRegion = app.getCitiesInRegionOrderedByPopulation("Caribbean");
        for (Cities city : topCitiesInRegion) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 15:");
        ArrayList<Cities> topCitiesInCountry = app.getCitiesInCountryOrderedByPopulation("France");
        for (Cities city : topCitiesInCountry) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 16:");
        ArrayList<Cities> topCitiesInDistrict = app.getCitiesInDistrictOrderedByPopulation("Tokyo-to");
        for (Cities city : topCitiesInDistrict) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 17:");
        ArrayList<Cities> capitalCities = app.getCapitalCitiesOrderedByPopulation();
        for (Cities city : capitalCities) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 18:");
        ArrayList<Cities> capitalCitiesInContinent = app.getCapitalCitiesInContinentOrderedByPopulation("Asia");
        for (Cities city : capitalCitiesInContinent) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 20:");
        ArrayList<Cities> topCapitalCities = app.getTopNCapitalCitiesOrderedByPopulation(5);
        for (Cities city : topCapitalCities) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        System.out.println("\nThis is Query 21:");
        ArrayList<Cities> topCapitalCitiesInContinent = app.getCapitalCitiesInContinentOrderedByPopulation("Asia");
        for (Cities city : topCapitalCitiesInContinent) {
            System.out.println(city.CityName + " Population = " + city.Population);
        }

        app.disconnect();
    }
}