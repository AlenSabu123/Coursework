import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.App;
import java.sql.SQLException;

class MyTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void getCountriesInContinentTestNull() {
        try {
            app.getCountriesInContinent(null);  // Just call the method
        } catch (SQLException e) {
            // If an exception is thrown, print a message (optional, for logging purposes)
            System.out.println("SQLException was thrown: " + e.getMessage());
        }
    }
}
