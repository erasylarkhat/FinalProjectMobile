package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private Context mContexct;
    private List<CharacterItem> charactersList;
    private OnItemClickListener onItemClickListener;


    public interface OnItemClickListener{
        void onItemClick(int possition);
    }

    public void setOnItemClickListener (OnItemClickListener listener){
        onItemClickListener =  listener;
    }


    public Adapter(Context mContexct, List<CharacterItem> charactersList) {
        this.mContexct = mContexct;
        this.charactersList = charactersList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        LayoutInflater layoutInflater =LayoutInflater.from(mContexct);
        v = layoutInflater.inflate(R.layout.character_block,parent,false);



        return new MyViewHolder(v, onItemClickListener) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.title.setText(charactersList.get(position).getName());
        holder.birth.setText(charactersList.get(position).getBirthday());
        holder.status.setText(charactersList.get(position).getStatus());

        Glide.with(mContexct)
                .load(charactersList.get(position).getImg())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return charactersList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView birth;
        TextView status;
        ImageView img;


        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            title = itemView.findViewById(R.id.tittle);
            status = itemView.findViewById(R.id.status);
            birth =itemView.findViewById(R.id.birtd);
            img = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int pos = getAdapterPosition();
                        if (pos!=RecyclerView.NO_POSITION){
                            listener.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }
}
