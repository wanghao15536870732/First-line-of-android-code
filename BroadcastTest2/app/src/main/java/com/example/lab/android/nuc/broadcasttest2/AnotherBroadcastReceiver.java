package com.example.lab.android.nuc.broadcasttest2;

import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;


public class AnotherBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"receiver in AnotherBroadcastReceiver",
                Toast.LENGTH_SHORT).show();
    }
}
