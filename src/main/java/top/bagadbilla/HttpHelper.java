package top.bagadbilla;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class HttpHelper<T> {
    private final Type type;
    private final String url;
    private final Map<String, String> headers;

    public HttpHelper(String url, Map<String, String> headers) {
        this.url = url;
        this.headers = headers;
        this.type = new TypeToken<T>() {
        }.getType();
    }

    public T get() throws IOException, InterruptedException {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest.Builder builder =
                    HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .GET();
            headers.forEach(builder::header);
            HttpRequest request = builder.build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), type);
        }
    }
}
