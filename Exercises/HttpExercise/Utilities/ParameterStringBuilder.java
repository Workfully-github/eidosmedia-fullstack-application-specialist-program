package HttpExercise.Utilities;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class ParameterStringBuilder {
    
    public static String getParamsString(HashMap<String, String> requestParams) 

        throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();

            for (HashMap.Entry<String, String> entry : requestParams.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }

            String resultString = result.toString();
            return resultString.length() > 0
            ? resultString.substring(0, resultString.length() - 1)
            : resultString;
    }
}
