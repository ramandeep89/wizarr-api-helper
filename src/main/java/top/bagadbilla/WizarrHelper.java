package top.bagadbilla;

import top.bagadbilla.model.Invitation;
import top.bagadbilla.model.Response;
import top.bagadbilla.model.Task;
import top.bagadbilla.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WizarrHelper {
    public static Response get(String baseUrl, String token) throws IOException, InterruptedException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + token);
        List<User> users = new HttpHelper<List<User>>(baseUrl + "/api/users", headers).get();
        List<Invitation> invitations  = new HttpHelper<List<Invitation>>(baseUrl + "/api/invitations", headers).get();
        List<Task> tasks = new HttpHelper<List<Task>>(baseUrl + "/api/tasks", headers).get();
        return new Response(users, invitations, tasks);
    }
}
