package net.codestory;

import net.codestory.http.*;

import org.junit.*;

public class SeleniumTest extends net.codestory.simplelenium.SeleniumTest {
  private WebServer webServer = new WebServer();

  @Before
  public void startServer() {
    webServer.startOnRandomPort();
  }

  @Override
  public String getDefaultBaseUrl() {
    return "http://localhost:" + webServer.port();
  }

  @Test
  public void two_developers() {
    goTo("/");

    find("h1").should().contain("Page not found");
  }
}
