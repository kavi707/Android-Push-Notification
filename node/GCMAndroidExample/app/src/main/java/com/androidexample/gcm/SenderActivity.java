package com.androidexample.gcm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
public class SenderActivity extends Activity {

    private TextView textView;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        textView = (TextView) findViewById(R.id.messageText);
        sendButton = (Button) findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ToServer tos = new ToServer(textView);
                    tos.sentEmit();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    /*public class ToServer implements IOCallback {

        private SocketIO socket;
        private TextView txtTest;

        public ToServer(TextView a) throws Exception {
            socket = new SocketIO();
            this.txtTest = a;
            socket.connect("http://nodebruno.jit.su", this);
            socket.emit("my other event", "SERVER RECEBEU ANDROID");
        }

        @Override
        public void onDisconnect() {
            Log.d("onDisconnect","Connection terminated.");
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
    }*/
}
