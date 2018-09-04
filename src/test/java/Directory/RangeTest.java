package Directory;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeTest {

  @Test
  public void getContentWithBothRanges() {
    byte[] content = "this is some text".getBytes();
    assertEquals("this", new String(Range.getContent(content, "0-4")));
  }

  @Test
  public void getContentWithStart() {
    byte[] content = "this is some text".getBytes();
    assertEquals("text", new String(Range.getContent(content, "-5")));
  }

  @Test
  public void getContentWithEnd() {
    byte[] content = "this is some text".getBytes();
    assertEquals("is some text", new String(Range.getContent(content, "5-")));
  }
}