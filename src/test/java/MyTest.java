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
    void getCountriesInContinentTestNull()
    {
        try {
            app.getCountriesInContinent(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
