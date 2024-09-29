package top.bagadbilla;

import com.google.gson.Gson;
import top.bagadbilla.model.Invitation;
import top.bagadbilla.model.Response;
import top.bagadbilla.model.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WizarrHelper {
    public static Response get(String baseUrl, String token) throws IOException, InterruptedException {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/api/users"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            User[] users = new Gson().fromJson(response.body(), User[].class);
            request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/api/invitations"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Invitation[] invitations = new Gson().fromJson(response.body(), Invitation[].class);
            return new Response(users, invitations);
        }
    }
}
