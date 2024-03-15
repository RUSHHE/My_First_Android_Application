package com.example.myapplication;

import android.os.Bundle;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityMain2Binding am2Binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(am2Binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(am2Binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FragmentStateAdapter adapter = new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return 3;
            }

            @NonNull
            @Override
            public Fragment createFragment(int i) {
                switch (i) {
                    case 0:
                        return new BlankFragment();
                    case 1:
                        return new BlankFragment2();
                    case 2:
                        return new MomentFragment();
                    default:
                        throw new IllegalArgumentException("Invalid position: " + i);
                }

            }
        };
        am2Binding.viewPager21.setAdapter(adapter);
//        am2Binding.viewPager21.setUserInputEnabled(false); // 禁止滑动

        // 将TabLayout与ViewPager2关联起来
        new TabLayoutMediator(am2Binding.tabLayout1, am2Binding.viewPager21,
                (tab, position) -> tab.setText("Test") // 设置Tab标题
        ).attach();
//        // 初始化 FragmentManager
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        // 创建一个新的 FragmentTransaction
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 设置 TabLayout 的选项卡选择监听器
//        am2Binding.tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                FragmentTransaction newTransaction = fragmentManager.beginTransaction();
//                switch (tab.getPosition()) {
//                    case 0:
//                        newTransaction.replace(R.id.frameLayout1, blankFragment);
//                        break;
//                    case 1:
//                        // 创建并添加 BlankFragment2
//                        BlankFragment2 blankFragment2 = new BlankFragment2();
//                        newTransaction.replace(R.id.frameLayout1, blankFragment2);
//                        break;
//                    case 2:
//                        // 创建并添加 BlankFragment3
//                        MomentFragment blankFragment3 = new MomentFragment();
//                        newTransaction.replace(R.id.frameLayout1, blankFragment3);
//                        break;
//                }
//                newTransaction.commit();
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                // 如果需要处理未选中的选项卡事件，可以在这里添加代码
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                // 如果需要处理重新选择选项卡事件，可以在这里添加代码
//            }
//        });
    }
}