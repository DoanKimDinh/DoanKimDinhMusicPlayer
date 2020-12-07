package doankimdinh.i.doankimdinhmusicplayer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import doankimdinh.i.doankimdinhmusicplayer.MyService.MyBinder;

public class ControlActivity extends AppCompatActivity {
    private MyService myService;
    private boolean isBound = false;
    private ServiceConnection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        ImageView btnPlay =findViewById(R.id.btnPlay);
        ImageView btnPause = findViewById(R.id.btnPause);
        ImageView btnNext = findViewById(R.id.btnNext);
        ImageView btnPrevious = findViewById(R.id.btnPrevious);
        ImageView btnBack = findViewById(R.id.btn_back);
        ImageView imageMusic = findViewById(R.id.img_music);
        TextView txtNameMusic = findViewById(R.id.tvNameMusic);

        Intent intentAdapter =getIntent();
        int mp3 = intentAdapter.getIntExtra("mp3",0);
        String name = intentAdapter.getStringExtra("name");
        txtNameMusic.setText(name);
        int img = intentAdapter.getIntExtra("img",0);
        imageMusic.setImageResource(img);

        connection = new ServiceConnection() {
            @Override
            public void onServiceDisconnected(ComponentName name) {

                isBound = false;
            }
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyBinder binder = (MyBinder) service;
                myService = binder.getService();
                isBound = true;
            }
        };

        final Intent intent =
                new Intent(ControlActivity.this,
                        MyService.class);
        intent.putExtra("mp3", mp3);
        bindService(intent, connection,
                Context.BIND_AUTO_CREATE);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myService.play();
                btnPlay.setVisibility(View.INVISIBLE);
                btnPause.setVisibility(View.VISIBLE);
                isBound = true;
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBound){
                    myService.pause();
                    btnPlay.setVisibility(View.VISIBLE);
                    btnPause.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBound){
                    unbindService(connection);
                    isBound = false;
                    finish();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBound){
                    myService.fastForward();
                }else{
                    Toast.makeText(ControlActivity.this,
                            "Service is not running", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBound){
                    myService.fastBack();
                }else{
                    Toast.makeText(ControlActivity.this,
                            "Service is not running", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}