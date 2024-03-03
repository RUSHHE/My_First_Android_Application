package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TabLayout tabLayout = findViewById(R.id.tabLayout1);

// 初始化 FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

// 创建一个新的 FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

// 添加初始的 BlankFragment
        BlankFragment blankFragment = new BlankFragment();
        fragmentTransaction.add(R.id.frameLayout1, blankFragment);
        fragmentTransaction.commit();

// 设置 TabLayout 的选项卡选择监听器
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction newTransaction = fragmentManager.beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        newTransaction.replace(R.id.frameLayout1, blankFragment);
                        break;
                    case 1:
                        // 创建并添加 BlankFragment2
                        BlankFragment2 blankFragment2 = new BlankFragment2();
                        newTransaction.replace(R.id.frameLayout1, blankFragment2);
                        break;
                }
                newTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // 如果需要处理未选中的选项卡事件，可以在这里添加代码
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // 如果需要处理重新选择选项卡事件，可以在这里添加代码
            }
        });

}
}