import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.App;
import java.sql.SQLException;

//class for my test
class MyTest
{
    //static app object
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    //Test to test if method getCountriesInContinent is working
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
