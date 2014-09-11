package net.codestory;

import net.codestory.http.annotations.*;

import javax.inject.*;

public class BasketResource {
  private final BasketFactory basketFactory;

  @Inject
  public BasketResource(BasketFactory basketFactory) {
    this.basketFactory = basketFactory;
  }

  @Get("/basket?emails=:emails")
  public Basket basket(String emails) {
    return basketFactory.basket(emails);
  }
}
