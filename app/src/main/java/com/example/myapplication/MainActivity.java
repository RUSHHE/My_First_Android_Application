package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView=findViewById(R.id.imageView);

        Glide.with(this)
                .load("https://avatars.githubusercontent.com/u/63961439?s=400&u=7f18725e8c4eddf8cdf26e9d438e16f3760e13ab&v=4")
                .into(imageView);

        TextView accountText = findViewById(R.id.accountText);
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> {
            Toast.makeText(this, "按钮已按下" + "帐号:" + accountText.getText(), Toast.LENGTH_SHORT).show();
            ComponentName componentName = new ComponentName(this, "com.example.myapplication.MainActivity2");
            startActivity(new Intent().setComponent(componentName));
        });


    }
}