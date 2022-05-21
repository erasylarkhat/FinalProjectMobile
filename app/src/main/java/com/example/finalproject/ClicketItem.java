package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ClicketItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicket_item);

        Intent intent = getIntent();

        ImageView imageView = findViewById(R.id.imageView2);
        Glide.with(this).load(intent.getStringExtra("img")).into(imageView);

        TextView itemName = findViewById(R.id.itemName);
        itemName.setText(intent.getStringExtra("name"));

        TextView itemBirth = findViewById(R.id.itemBirth);
        itemBirth.setText(intent.getStringExtra("birth"));


        TextView itemStataus = findViewById(R.id.profStatus);
        itemStataus.setText(intent.getStringExtra("status"));
    }
}