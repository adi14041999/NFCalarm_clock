package com.security.adityaprabhu.nfcalarmclock;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Adi on 10/15/2017.
 */

public class AlarmPlayer extends IntentService {

    private static MediaPlayer mMediaPlayer;
    public static boolean play = true;

    public AlarmPlayer() {
        super("AlarmPlayer");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        boolean intentPlay = intent.getBooleanExtra("play", true);

        if(play && intentPlay){
            try {
                play = true;
                Uri alert =  RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                mMediaPlayer = new MediaPlayer();
                mMediaPlayer.setDataSource(this, alert);
                final AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                if (audioManager.getStreamVolume(AudioManager.STREAM_RING) != 0) {
                    mMediaPlayer.setAudioStreamType(AudioManager.STREAM_RING);
                    mMediaPlayer.setLooping(true);
                    mMediaPlayer.prepare();
                    mMediaPlayer.start();
                }
            } catch(Exception e) {
            }
        }

        else{
            play = false;
            mMediaPlayer.stop();
        }


    }
}
