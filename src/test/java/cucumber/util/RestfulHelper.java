package cucumber.util;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class RestfulHelper {
    private static final String LOCALHOST = "http://localhost:";

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private HttpHeaders headers = new HttpHeaders();
    private HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    private int port;

    public static RestfulHelper connect(int port) {
        return new RestfulHelper(port);
    }

    public RestfulHelper(int port) {
        this.port = port;
    }

    public ResponseEntity<String> get(String url) {
        return restTemplate.exchange(fullUrl(url), HttpMethod.GET, entity, String.class);
    }

    public ResponseEntity<String> post(String url) {
        return restTemplate.exchange(fullUrl(url), HttpMethod.POST, entity, String.class);
    }

    private String fullUrl(String entry) {
        return LOCALHOST + port + entry;
    }

}
