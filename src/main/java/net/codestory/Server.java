package net.codestory;

import net.codestory.http.*;
import net.codestory.http.injection.*;
import net.codestory.http.routes.*;

import com.google.inject.*;

public class Server {
  public static void main(String[] args) {
    new WebServer(new ServerConfiguration()).start();
  }

  public static class ServerConfiguration extends AbstractGuiceConfiguration {
    public ServerConfiguration(Module... modules) {
      super(modules);
    }

    @Override
    protected void configure(Routes routes, Injector injector) {
      routes.add(BasketResource.class);
    }
  }
}
