package com.cosy.sun.jdk.newj;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Java11NewFunc {

    public void enhanceString() {
        String str = "";
        // 判断是否为空白
        str.isBlank();
        // 去除收尾空格
        str.strip();
        // 去除首部空格
        str.stripLeading();
        // 字符串复制
        str.repeat(3);
        // 行数统计
        str.lines().count();
    }

    public void httpClientApi() throws IOException, InterruptedException {
        HttpClient build = HttpClient.newBuilder().authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return super.getPasswordAuthentication();
                    }
                })
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(1000))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(""))
                .header("name", "value")
                .timeout(Duration.ofDays(1))
                .GET()
                .build();
        HttpResponse<Object> send = build.send(request, responseInfo -> {
            HttpResponse.BodySubscriber<Object> o = null;
            return o;
        });
        CompletableFuture<HttpResponse<Object>> httpResponseCompletableFuture = build.sendAsync(request, responseInfo -> {
            return null;
        });
        HttpResponse<Object> join = httpResponseCompletableFuture.join();
        Object body = join.body();

        // 并发请求


        // websocket长连接
        HttpClient client = HttpClient.newHttpClient();
        client.newWebSocketBuilder()
                .buildAsync(URI.create(""),
                        new WebSocket.Listener() {
                            @Override
                            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                                return WebSocket.Listener.super.onText(webSocket, data, last);
                            }
                        });
    }

    /**
     * todo zgc
     */

}
