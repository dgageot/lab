package net.codestory;

import net.codestory.http.convert.*;
import net.codestory.http.misc.Env;
import net.codestory.http.templating.*;

public class Developers {
  public Developer[] findAll() {
    return TypeConvert.convertValue(new Site(new Env()).getData().get("developers"), Developer[].class);
  }
}
