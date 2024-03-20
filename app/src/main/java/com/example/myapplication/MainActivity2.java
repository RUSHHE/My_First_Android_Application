package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.databinding.ActivityMain2Binding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity2 extends AppCompatActivity {
    String[] tabNames = {"小而美", "通讯录", "发现", "我"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityMain2Binding am2Binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(am2Binding.getRoot());

        setSupportActionBar(am2Binding.materialToolbar); //设置toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        am2Binding.materialToolbar.setNavigationOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());

        ViewCompat.setOnApplyWindowInsetsListener(am2Binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    FragmentStateAdapter adapter =
        new FragmentStateAdapter(this) {
          @Override
          public int getItemCount() {
            return 4;
          }

          @NonNull
          @Override
          public Fragment createFragment(int i) {
            switch (i) {
              case 0:
                return new BlankFragment();
              case 1:
                return new ContactFragment();
              case 2:
                return new MomentFragment();
              case 3:
                return new BlankFragment2();
              default:
                throw new IllegalArgumentException("Invalid position: " + i);
            }
          }
        };
        am2Binding.viewPager21.setAdapter(adapter);
//        am2Binding.viewPager21.setUserInputEnabled(false); // 禁止滑动

        // 将TabLayout与ViewPager2关联起来
        new TabLayoutMediator(am2Binding.tabLayout1, am2Binding.viewPager21,
                (tab, position) -> tab.setText(tabNames[position]) // 设置Tab标题
        ).attach();
    }
}