package gradle.cucumber;

public class StepDefinitionsHelper {
  public static String[] parseFormData(String data) {
    return data.split("=");
  }
}
