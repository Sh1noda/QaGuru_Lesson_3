import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

abstract public class TestBase {
    @BeforeAll
    static void setUp () {
        Configuration.browser = "chrome";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy="eager";
    }
}
