package com.example.azeducationtoo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.mbms.MbmsErrors;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;

public class Phay_video extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener{

    YouTubePlayerView youTubePlayerView;
    int REQUEST_VIDEO = 123;
    public static String getvideo;
    private YouTubePlayer youTubePlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phay_video);

        Intent intent = getIntent(); // lấy ID từ Intent
        getvideo = intent.getStringExtra("codevideo2");
      //  Toast.makeText(this, getvideo, Toast.LENGTH_SHORT).show();

         youTubePlayerView = (YouTubePlayerView) findViewById(R.id.myyoutube);
         youTubePlayerView.initialize(MainActivity.API_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        //youTubePlayer.cueVideo(""+getvideo);
        findViewById(R.id.progressBar).setVisibility(View.GONE);   // set progresBar khi load video
        youTubePlayer.setFullscreen(true); // set full screen video
        // youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);

        youTubePlayer.setShowFullscreenButton(false);
        youTubePlayer.cueVideo(getvideo);
        

    }

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(Phay_video.this, "HOHO", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(Phay_video.this, "HOHO", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,REQUEST_VIDEO);
        }else{
            Toast.makeText(this, "ERROR !!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode ==REQUEST_VIDEO){
            youTubePlayerView.initialize(MainActivity.API_KEY,this);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}
