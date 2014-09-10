package misc;

import org.webjars.WebJarExtractor;

import java.io.File;
import java.io.IOException;

public class ExtractWebjars {
  public static void main(String[] args) throws IOException {
    new WebJarExtractor().extractAllWebJarsTo(new File("target/webjars"));
  }
}
