package vn.lequan.lienminhsamsoi.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.R;

public class YoutubePlayerActivity extends YouTubeBaseActivity implements OnInitializedListener {
    private static final String API_KEY = "AIzaSyAeg5VR1BrVzbx9OAhxd3hHrJ8j9e8yWZk";
    private String VIDEO_ID;
    private PlaybackEventListener playbackEventListener = new C14641();
    private PlayerStateChangeListener playerStateChangeListener = new C14652();

    class C14641 implements PlaybackEventListener {
        C14641() {
        }

        public void onBuffering(boolean arg0) {
        }

        public void onPaused() {
        }

        public void onPlaying() {
        }

        public void onSeekTo(int arg0) {
        }

        public void onStopped() {
        }
    }

    class C14652 implements PlayerStateChangeListener {
        C14652() {
        }

        public void onAdStarted() {
        }

        public void onError(ErrorReason arg0) {
        }

        public void onLoaded(String arg0) {
        }

        public void onLoading() {
        }

        public void onVideoEnded() {
        }

        public void onVideoStarted() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_player);
        this.VIDEO_ID = getIntent().getExtras().getString("KEY_VIDEO_ID");
        ((YouTubePlayerView) findViewById(R.id.youtube_player)).initialize(API_KEY, this);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        player.setPlayerStateChangeListener(this.playerStateChangeListener);
        player.setPlaybackEventListener(this.playbackEventListener);
        if (!wasRestored) {
            player.cueVideo(this.VIDEO_ID);
            player.play();
            player.setFullscreen(true);
        }
    }

    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failured to Initialize!", 1).show();
    }
}
