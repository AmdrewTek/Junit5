package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

  @BeforeAll
  static void beforeAll() {
    //Configuration.browser = "Edge";
    Configuration.pageLoadStrategy = "eager";
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
  }

  @AfterEach
  void afterEach() {
    Selenide.closeWebDriver();
  }

}
