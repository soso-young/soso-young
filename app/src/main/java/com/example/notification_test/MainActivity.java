package com.example.notification_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText eTitle;
    private EditText eMessage;
    private Button channel1btn;
    private Notification mNotificationhelper;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTitle = findViewById(R.id.edit_title);
        eMessage = findViewById(R.id.edit_message);
        channel1btn = findViewById(R.id.btn_channel1);

        mNotificationhelper = new Notification(this);

        channel1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = eTitle.getText().toString();
                String message = eMessage.getText().toString();
                sendonchannel1(title, message);

            }
        });

    }

    public void sendonchannel1(String title, String message){
        NotificationCompat.Builder nb = mNotificationhelper.getChannel1Notification(title, message);
        mNotificationhelper.getManager().notify(1, nb.build());

    }


}