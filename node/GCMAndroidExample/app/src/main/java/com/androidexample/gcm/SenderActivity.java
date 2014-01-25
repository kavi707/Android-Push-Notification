package com.androidexample.gcm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText sendMessageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        textView = (TextView) findViewById(R.id.messageText);
        sendButton = (Button) findViewById(R.id.sendButton);
        sendMessageEditText = (EditText) findViewById(R.id.sendMessage);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = sendMessageEditText.getText().toString();
                try {
                    ToServer tos = new ToServer(textView);
                    tos.sentEmit(message);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
