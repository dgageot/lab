package net.codestory;

import static net.codestory.http.misc.Fluent.*;

import javax.inject.*;

public class BasketFactory {
  private final Developers developers;
  private final Tags tags;

  @Inject
  public BasketFactory(Developers developers, Tags tags) {
    this.developers = developers;
    this.tags = tags;
  }

  public Basket basket(String emails) {
    Basket basket = new Basket();

    for (Developer developer : findDeveloper(emails)) {
      basket.test += tags.count("test", developer.tags);
      basket.back += tags.count("back", developer.tags);
      basket.database += tags.count("database", developer.tags);
      basket.front += tags.count("front", developer.tags);
      basket.hipster += tags.count("hipster", developer.tags);
      basket.sum += developer.price;
    }

    return basket;
  }

  private Iterable<Developer> findDeveloper(String emails) {
    return split(emails, ",").map(of(developers.findAll()).uniqueIndex(dev -> dev.email)::get).notNulls();
  }
}
