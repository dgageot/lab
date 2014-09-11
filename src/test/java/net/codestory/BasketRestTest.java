package net.codestory;

import static net.codestory.Server.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import net.codestory.http.*;

import org.junit.*;

import com.google.inject.*;
import com.jayway.restassured.*;

public class BasketRestTest {
  BasketFactory basketFactory = mock(BasketFactory.class);

  WebServer webServer;

  @Before
  public void startServer() {
    webServer = new WebServer(new ServerConfiguration(new AbstractModule() {
      @Override
      protected void configure() {
        bind(BasketFactory.class).toInstance(basketFactory);
      }
    })).startOnRandomPort();
  }

  @Test
  public void two_developers() {
    when(basketFactory.basket("david@devoxx.io,jl@devoxx.io")).thenReturn(basket(4, 3, 0, 3, 5, 2000));

    RestAssured
        .given().port(webServer.port())
        .when().get("/basket?emails=david@devoxx.io,jl@devoxx.io").
        then()
        .contentType("application/json")
        .statusCode(200)
        .body("test", equalTo(4)).
        and().body("back", equalTo(3)).
        and().body("database", equalTo(0)).
        and().body("front", equalTo(3)).
        and().body("hipster", equalTo(5)).
        and().body("sum", equalTo(2000));
  }

  private static Basket basket(int test, int back, int database, int front, int hipster, int sum) {
    Basket basket = new Basket();
    basket.test = test;
    basket.back = back;
    basket.database = database;
    basket.front = front;
    basket.hipster = hipster;
    basket.sum = sum;
    return basket;
  }
}
