package com.androidexample.gcm;

import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;

/**
 * Created by kavi on 1/24/14.
 */
public class ToServer implements IOCallback {

    private SocketIO socket;
    private TextView txtTest;

    public ToServer(TextView a) {
        this.txtTest = a;
    }

    public void sentEmit() throws Exception {
        socket = new SocketIO();
        socket.connect("http://192.168.8.89:3000", this);
        socket.emit("my other event", "SERVER RECEBEU ANDROID");
    }

    @Override
    public void onDisconnect() {
        Log.d("onDisconnect", "Connection terminated.");
    }

    @Override
    public void onConnect() {
        Log.d("onConnect","Connection established");
    }

    @Override
    public void onMessage(String data, IOAcknowledge ioAcknowledge) {
        txtTest.setText(data);
        Log.d("Event",data);
    }

    @Override
    public void onMessage(JSONObject jsonObject, IOAcknowledge ioAcknowledge) {
        try {
            txtTest.setText(jsonObject.toString(2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void on(String event, IOAcknowledge ioAcknowledge, Object... objects) {
        txtTest.setText(event);
        Log.d("Event",event );
    }

    @Override
    public void onError(SocketIOException e) {
        Log.d("Error", "an Error occurred");
        e.printStackTrace();
    }
}
