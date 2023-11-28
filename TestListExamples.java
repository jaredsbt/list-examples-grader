import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

class hasHe implements StringChecker {
  public boolean checkString(String s) {
    return s.contains("He");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testFilter1() {
    List<String> expected = Arrays.asList("Hey", "Hello");
    List<String> input1 = Arrays.asList("Hey", "Hello", "Hi");
    hasHe sc = new hasHe();
    assertEquals(expected, ListExamples.filter(input1, sc));
  }

  @Test
  public void testMoon1(){
    List<String> expected = Arrays.asList("MOON", "Moon");
    List<String> input1 = Arrays.asList("MOON", "MUNE", "MINE", "Moon");
    IsMoon sc = new IsMoon();
    assertEquals(expected, ListExamples.filter(input1, sc));
  }
}
