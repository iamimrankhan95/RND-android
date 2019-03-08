package com.iamimrankhan95.audioandvideo;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    SeekBar volumeControl;
    SeekBar audioScrub;
    AudioManager audioManager;
    protected void startAudio(View view){
        mediaPlayer.start();
    }
    protected void stopAudio(View view){
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //video();
        audio();
        seekBarForAudioVolume();
        seekBarForAudioScrub();
    }
    protected void seekBarForAudioScrub(){
        audioScrub=findViewById(R.id.seekBarAudioScrub);
        audioScrub.setMax(mediaPlayer.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                audioScrub.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,100);

        audioScrub.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    protected void seekBarForAudioVolume(){
        audioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);// getting system audio settings
        volumeControl= findViewById(R.id.seekBarVolume);
        //volumeControl.setMin(audioManager.getStreamMinVolume(AudioManager.STREAM_MUSIC));
        volumeControl.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)); //STREAM_MUSIC for currently playing Audio
        volumeControl.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    protected void video(){
        VideoView video=findViewById(R.id.videoView);
        video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.ayout);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(video);// binding video to mediaController
        video.setMediaController(mediaController);//binding mediaController to Video
        video.start();
    }
    protected void audio(){
        mediaPlayer=MediaPlayer.create(this,R.raw.laughter);
        mediaPlayer.start();
    }
}
