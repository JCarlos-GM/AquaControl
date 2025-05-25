package com.tecnm.aquacontrol.extra_clases;

import android.util.Log;

import com.google.gson.Gson;

import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class Websockect {
    private static final String TAG = "WebSocket";
    private WebSocket webSocket;
    private Gson gson = new Gson();


    public void initWebsocket(){
        Log.e("ds", "Conectando");
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("ws://192.168.0.106:8080") // Cambia IP según tu servidor
                .build();

        webSocket = client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                Log.d(TAG, "Conectado al servidor");
                webSocket.send(gson.toJson(new WSModel("connection", "57257", 0, null)));
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {

                WSModel wsModel = gson.fromJson(text, WSModel.class);
                if (!Objects.equals(wsModel.getType(), "verification")) {
                    Log.d(TAG, "Mensaje recibido: " + text);
                }

            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                Log.d(TAG, "Mensaje binario recibido: " + bytes.hex());
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                webSocket.close(1000, null);
                Log.d(TAG, "Conexión cerrándose: " + reason);
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                Log.d(TAG, "Conexión cerrada: " + reason);
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                Log.e(TAG, "Error en WebSocket: " + t.getMessage());
            }
        });

        client.dispatcher().executorService().shutdown(); // opcional
    }

    public void closeWebsocket() {
        if (webSocket != null) {
            webSocket.close(1000, "App cerrada");
        }
    }
}
