package net.codestory;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.*;

public class BasketResourceTest {
  @Test
  public void basket() {
    Basket expectedBasket = new Basket();
    BasketFactory basketFactory = mock(BasketFactory.class);
    when(basketFactory.basket("david@devoxx.io,jl@devoxx.io")).thenReturn(expectedBasket);

    BasketResource basketResource = new BasketResource(basketFactory);
    Basket basket = basketResource.basket("david@devoxx.io,jl@devoxx.io");

    assertThat(basket).isSameAs(expectedBasket);
  }
}
