package doankimdinh.i.doankimdinhmusicplayer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListMusicAdapter listMusicAdapter;
    private ArrayList<Song> arrayList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);

        arrayList = new ArrayList<>();
        arrayList.add(new Song("Anh Là Của Em - Karik",R.raw.anhlacuaem,R.drawable.anhlacuaem));
        arrayList.add(new Song("Bạc Phận - JACK",R.raw.bacphan,R.drawable.bacphan));
        arrayList.add(new Song("Em Bé - Karik",R.raw.embe,R.drawable.embe));
        arrayList.add(new Song("Em Gì Ơi - JACK",R.raw.emgioi,R.drawable.emgioi));
        arrayList.add(new Song("Hồng Nhan - JACK",R.raw.hongnhan,R.drawable.hongnhan));
        arrayList.add(new Song("Người Lạ Ơi - Karik",R.raw.nguoilaoi,R.drawable.nguoilaoi));
        arrayList.add(new Song("Sóng Gió - JACK",R.raw.songgio,R.drawable.songgio));
        arrayList.add(new Song("Trò Chơi - JACK",R.raw.trochoi,R.drawable.trochoi));
        arrayList.add(new Song("Việt Nam tôi - JACK",R.raw.vietnamtoi,R.drawable.vietnamtoi));



        listMusicAdapter = new ListMusicAdapter(arrayList,this);

        recyclerView.setAdapter(listMusicAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }
}