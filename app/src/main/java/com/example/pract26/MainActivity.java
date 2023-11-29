package com.example.pract26;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Идентификатор уведомления
    int NOTIFY_ID = 101;

    // Идентификатор канала
    String CHANNEL_ID = "Cat channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnNotif);

        button.setOnClickListener(this);

    }

    public void onClick(View view) {
                 NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
                Notification.Builder builder =
                new Notification.Builder(MainActivity.this);
                        builder
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Напоминание")
                        .setContentText("Пора покормить кота");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("1", "my_channel", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
            builder.setChannelId("1");
        }
        manager.notify(NOTIFY_ID, builder.build());
        }
}
