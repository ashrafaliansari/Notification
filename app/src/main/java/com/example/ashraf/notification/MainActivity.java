package com.example.ashraf.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Main2Activity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent pintent=PendingIntent.getActivity(MainActivity.this,0,i,PendingIntent.FLAG_ONE_SHOT);
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder nbuilder=new NotificationCompat.Builder(MainActivity.this).setSmallIcon(R.mipmap.ic_launcher_round).setContentTitle("Ab ghar jaana hai!! ").setContentText("bahot hua")
                        .setAutoCancel(true).setSound(uri).setContentIntent(pintent);
                NotificationManager nmanager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                nmanager.notify(0,nbuilder.build());
            }
        });
    }
}
