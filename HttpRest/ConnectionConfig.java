package HttpRest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionConfig {
    String url = "";
    String method = "";
    public ConnectionConfig(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public HttpURLConnection createConnection() throws MalformedURLException, IOException{

        HttpURLConnection connection =  (HttpURLConnection) new URL(this.url).openConnection();
        connection.setRequestMethod(this.method.toUpperCase());
        connection.setDoOutput(true);

        return connection;
    }

    
}
