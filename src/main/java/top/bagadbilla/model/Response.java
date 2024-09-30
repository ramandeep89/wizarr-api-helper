package top.bagadbilla.model;

import java.util.List;

public record Response(
        List<User> users,
        List<Invitation> invitations,
        List<Task> tasks
) {
}
