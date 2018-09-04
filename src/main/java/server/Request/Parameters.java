package server.Request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parameters {
  public static String decodeParameter(String parameter) {
    String decodedParameter = "";
    try {
      decodedParameter = URLDecoder.decode(parameter, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return decodedParameter;
  }

  public static HashMap<String, String> getAllParameters(String rawParameter) {
    String[] splitParameters = rawParameter.split("=|&");
    HashMap<String, String> parameters = new HashMap<>();
    for(int i = 0; i < splitParameters.length; i += 2) {
        parameters.put(splitParameters[i], decodeParameter(splitParameters[i + 1]));
    }
    return parameters;
  }

  public static ArrayList<String> format(HashMap<String, String> parameters) {
    ArrayList<String> stringParameters= new ArrayList<>();
    for (Map.Entry<String, String> entry : parameters.entrySet()) {
      stringParameters.add(entry.getKey() + " = " + entry.getValue());
    }
    return stringParameters;
  }
}
