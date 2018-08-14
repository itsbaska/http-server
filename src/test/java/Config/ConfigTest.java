package Config;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ConfigTest {

  @Test
  public void setRoutes() {
    assertEquals("/", Config.setRoutes().getRoutes().get(0).getPath());
  }

  @Test
  public void setPort() throws IOException {
    String [] args = new String[]{"-p", "5000"};
    assertEquals("5000", Config.setPort(args));
  }
}