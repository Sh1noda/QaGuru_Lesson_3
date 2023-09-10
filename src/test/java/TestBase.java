import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

abstract public class TestBase {
    @BeforeAll
    public void setUp () {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.pageLoadStrategy="eager";
    }
}
