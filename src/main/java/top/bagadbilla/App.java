package top.bagadbilla;

import com.google.gson.Gson;
import io.javalin.Javalin;
import io.javalin.http.Context;
import picocli.CommandLine;

@CommandLine.Command(name = "wizarr-api-helper", version = "wizarr-api-helper 1.0", mixinStandardHelpOptions = true)
public class App implements Runnable {
    @CommandLine.Option(names = {"-a", "--auth"}, description = "Wizarr API Token", required = true)
    String auth;
    @CommandLine.Option(names = {"-u", "--url"}, description = "Wizarr URL")
    String url = "http://fallout:5690/";

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Override
    public void run() {
        Javalin.create()
                .get("/", ctx -> ctx.result(new Gson().toJson(WizarrHelper.get(url, auth))))
                .head("/", Context::status)
                .start(7070);
    }
}
