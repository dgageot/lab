package net.codestory;

import static net.codestory.Server.*;

import net.codestory.http.*;
import net.codestory.simplelenium.*;

import org.junit.*;

public class BasketSeleniumTest extends SeleniumTest {
  WebServer webServer = new WebServer(new ServerConfiguration()).startOnRandomPort();

  @Override
  public String getDefaultBaseUrl() {
    return "http://localhost:" + webServer.port();
  }

  @Before
  public void goToIndex() {
    goTo("/");
  }

  @Test
  public void two_developers() {
    find("#clear").click();
    find("#David .add").click();
    find("#Mathilde .add").click();

    find("#basket .price").should().contain("1700");
  }

  @Test
  public void one_developer() {
    find("#clear").click();
    find("#David .add").click();

    find("#basket .test:not(.ng-hide)").should().haveSize(1);
    find("#basket .back:not(.ng-hide)").should().haveSize(1);
    find("#basket .database:not(.ng-hide)").should().beEmpty();
    find("#basket .front:not(.ng-hide)").should().haveSize(2);
    find("#basket .hipster:not(.ng-hide)").should().haveSize(1);
  }
}
