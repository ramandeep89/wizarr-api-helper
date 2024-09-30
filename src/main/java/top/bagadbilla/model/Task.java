package top.bagadbilla.model;

public record Task(
        String id,
        String name,
        String next_run_time,
        String trigger
) {
}
