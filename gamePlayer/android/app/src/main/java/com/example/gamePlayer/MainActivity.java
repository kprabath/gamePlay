package com.example.gamePlayer;
import com.unity3d.player.UnityPlayerActivity;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import android.os.PowerManager;
import android.os.Build;
import android.content.Intent;

public class MainActivity extends FlutterActivity {

    private static final String CHANNEL = "heartbeat.fritz.ai/native";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);

        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler((call, result) -> {
                    if (call.method.equals("powerManage")) {
                      getDeviceStatus();

                    }

                });
    }

    private void getDeviceStatus() {
//        boolean deviceStatus = false;
//        if (Build.VERSION.SDK_INT >=  Build.VERSION_CODES.LOLLIPOP) {
//            PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
//            deviceStatus = powerManager.isDeviceIdleMode();
//
//        }
//
//        return deviceStatus;
        android.widget.Toast.makeText(this, "HI I am a Toast", android.widget.Toast.LENGTH_SHORT).show();
        Intent intent  = new Intent(MainActivity.this , UnityPlayerActivity.class) ;
        startActivity(intent);



    }

}
