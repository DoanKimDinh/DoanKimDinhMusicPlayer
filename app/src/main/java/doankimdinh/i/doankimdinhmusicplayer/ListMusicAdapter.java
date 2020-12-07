package doankimdinh.i.doankimdinhmusicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListMusicAdapter extends RecyclerView.Adapter<ListMusicAdapter.ViewHolder> {

    private ArrayList<Song> arrayList;
    private Context context;

    public ListMusicAdapter(ArrayList<Song> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_layout,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song item = arrayList.get(position);
        holder.txtName.setText(String.valueOf(item.getTenBaiHat()));
        holder.imageView.setImageResource(item.getImageSong());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,ControlActivity.class);
                intent.putExtra("name",item.getTenBaiHat());
                intent.putExtra("img",item.getImageSong());
                intent.putExtra("mp3",item.getMp3());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView txtName;
        //   private TextView txtPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.txtName = itemView.findViewById(R.id.txtNamePhone);
            //     this.txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}
