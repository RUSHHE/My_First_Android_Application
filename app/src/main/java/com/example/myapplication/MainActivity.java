package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.DialogCustomBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding amBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amBinding.getRoot());

        Glide.with(this)
                .load("https://avatars.githubusercontent.com/u/63961439?s=400&u=7f18725e8c4eddf8cdf26e9d438e16f3760e13ab&v=4")
                .into(amBinding.imageView);

        amBinding.loginButton.setOnClickListener(v -> {
            Toast.makeText(this, "按钮已按下" + "帐号:" + amBinding.accountText.getText(), Toast.LENGTH_SHORT).show();
            ComponentName componentName = new ComponentName(this, "com.example.myapplication.MainActivity2");
            startActivity(new Intent().setComponent(componentName));
        });


        Dialog dialog = new Dialog(this);
        DialogCustomBinding dcBinding = DialogCustomBinding.inflate(getLayoutInflater());
        dialog.setContentView(dcBinding.getRoot());
        Glide.with(this).load("https://img.moehu.org/pic.php?id=miku")
                .into(dcBinding.dialogImageView);
//        dialog.show();
    }
}
