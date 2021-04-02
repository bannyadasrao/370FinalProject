package edu.qc.seclass.glm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;

    public Adapter(Context ctx, List<String> titles, List<Integer> images){
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_grid_layout,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.titles.setText(titles.get(position));
        holder.gridpic.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titles;
        ImageView gridpic;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titles = itemView.findViewById(R.id.textView3);
            gridpic = itemView.findViewById(R.id.pics);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Clicked "+getAdapterPosition(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(),searchCategory.class);
                    i.putExtra("title",images.get(getAdapterPosition()));
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}
