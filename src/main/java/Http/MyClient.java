package Http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import sun.net.www.http.HttpClient;

public class MyClient {
    CloseableHttpClient httpClient = HttpClients.createDefault();
}
