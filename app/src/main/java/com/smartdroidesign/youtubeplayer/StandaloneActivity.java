package com.smartdroidesign.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;


public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        // Method 1: requires interface implementation View.OnclickListener -> shorter, cleaner
        Button btnPlayVideo = findViewById(R.id.btnPlayVideo);
        Button btnPlaylist = findViewById(R.id.btnPlayList);

        btnPlayVideo.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);

//        // Method 2: Requires the creation of a listener in a variable that gets assigned later on
//        View.OnClickListener ourListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        };
//
//        btnPlaylist.setOnClickListener(ourListener);
//        btnPlayVideo.setOnClickListener(ourListener);
//
//        // Method 3: Requires the creation of an anonymous class that gets passed the View.OnclickListener object to it
//        btnPlaylist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        // Launch Google standalone player with an id of video or playlist
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnPlayVideo:
//                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID);
                // Autoplay the video when you click on 'play' button from the MainActivity
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, true);
                break;

            case R.id.btnPlayList:
//                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST);
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST, 0, 0, true, true);
                break;

            default:

        }

        if(intent != null) {
            startActivity(intent);
        }
    }
}
