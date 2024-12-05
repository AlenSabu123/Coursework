import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.App;
import java.sql.SQLException;

/**
 * class for my test
 * */
class MyTest
{
  /**
   * instantiation of app object
   * */
    static App app;

    /**
     * init object intiates app object
     */
    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * sample test for method in app class for a query
     * */
    @Test
    void getCountriesInContinentTestNull()
    {
        //try catch block carries out exception handling
        try {
            app.getCountriesInContinent(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
