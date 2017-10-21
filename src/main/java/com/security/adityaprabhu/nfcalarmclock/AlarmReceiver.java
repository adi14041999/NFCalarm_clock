package com.security.adityaprabhu.nfcalarmclock;

/**
 * Created by Adi on 10/15/2017.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show();
        Intent i = new Intent(context, AlarmPlayer.class);
        context.startService(i);
    }
}
