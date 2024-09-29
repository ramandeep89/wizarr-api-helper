package top.bagadbilla.model;

public record User(
        String auth,
        String code,
        String created,
        String email,
        String expires,
        int id,
        String token,
        String username
) {
}
