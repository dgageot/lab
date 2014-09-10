package web;

import net.codestory.http.WebServer;
import org.junit.Before;
import org.junit.Test;

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
  public void page_not_found() {
    goTo("/");

    find("h1").should().contain("Page not found");
  }
}
