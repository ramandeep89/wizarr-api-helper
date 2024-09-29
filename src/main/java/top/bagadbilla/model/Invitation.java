package top.bagadbilla.model;

import java.util.ArrayList;

public record Invitation(
        String code,
        String created,
        String duration,
        String expires,
        boolean hide_user,
        int id,
        boolean live_tv,
        boolean plex_allow_sync,
        String sessions,
        ArrayList<String> specific_libraries,
        boolean unlimited,
        boolean used,
        String used_at,
        String used_by
) {
}
