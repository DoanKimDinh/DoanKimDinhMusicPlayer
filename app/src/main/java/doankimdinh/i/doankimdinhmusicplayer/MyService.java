package doankimdinh.i.doankimdinhmusicplayer;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MyPlayer myPlayer;
    private IBinder binder;

    @Override
    public void onCreate() {
        super.onCreate();
        binder = new MyBinder();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        int mp3 = intent.getIntExtra("mp3", 0);
        myPlayer = new MyPlayer(this, mp3);
        return binder;

    }
    @Override
    public boolean onUnbind(Intent intent) {
        myPlayer.stop();
        return super.onUnbind(intent);
    }

    public void fastForward() {
        int currentPosition = myPlayer.getCurrentPosition();
        currentPosition += 12000;
        myPlayer.fastForward(currentPosition);
    }

    public void fastBack(){
        int currentPosition = myPlayer.getCurrentPosition();
        currentPosition -= 12000;
        myPlayer.fastForward(currentPosition);
    }

    public void fastStart(){
        myPlayer.fastStart();
    }

    public void play() {
        myPlayer.play();
    }

    public void pause() {
        myPlayer.pause();
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

}

class MyPlayer {
    private MediaPlayer mediaPlayer;

    public MyPlayer(Context context, int mp3) {
        mediaPlayer = MediaPlayer.create(context, mp3);
        mediaPlayer.setLooping(true);
    }

    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }
    public void fastForward(int pos){
        mediaPlayer.seekTo(pos);
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public void fastStart(){
        mediaPlayer.start();
    }

    public void play() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}