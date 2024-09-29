package top.bagadbilla.model;

public record Response(
        User[] users,
        Invitation[] invitations
) {
}
