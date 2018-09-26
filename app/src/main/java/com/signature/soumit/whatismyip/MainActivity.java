package com.signature.soumit.whatismyip;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView myIpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myIpView = findViewById(R.id.tv_myip);
        myIpView.setText(getMyPhoneIPAddress());
        Log.d(TAG, "onCreate: my phone ip : " + getMyPhoneIPAddress());
        myIpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });
    }

    public String getMyPhoneIPAddress(){
        Log.d(TAG, "getMyPhoneIPAddress: ");
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

        return ip;
    }

    public void refresh(){
        Log.d(TAG, "refresh: ");
        finish();
        startActivity(getIntent());
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


}
