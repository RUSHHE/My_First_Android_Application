package com.example.myapplication;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.myapplication.databinding.ActivityMain2Binding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
  ActivityMain2Binding binding;
  BlankFragment blankFragment;
  String[] tabNames = {"消息", "频道", "联系人", "动态"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    binding = ActivityMain2Binding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    setSupportActionBar(binding.materialToolbar); // 设置toolbar
    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    binding.materialToolbar.setNavigationOnClickListener(
        view -> {
          //          getOnBackPressedDispatcher().onBackPressed(); // 返回
          binding.drawer.openDrawer(GravityCompat.START); // 打开侧边栏
        });

    ViewCompat.setOnApplyWindowInsetsListener(
        binding.getRoot(),
        (v, insets) -> {
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
                  blankFragment = new BlankFragment();
                return blankFragment;
              case 1:
                return new BlankFragment2();
              case 2:
                return new ContactFragment();
              case 3:
                return new QZoneFragment();
              default:
                throw new IllegalArgumentException("Invalid position: " + i);
            }
          }
        };
    binding.viewPager21.setAdapter(adapter);
    binding.viewPager21.setUserInputEnabled(false); // 禁止滑动

    // 将TabLayout与ViewPager2关联起来
    new TabLayoutMediator(
            binding.tabLayout1,
            binding.viewPager21,
            (tab, position) -> {
                tab.setText(tabNames[position]);
                switch (position) {
                    case 0:
                        tab.setIcon(R.drawable.shuoshuo);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.more);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.settings);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.qzone);
                        break;
                }
            } // 设置Tab
            )
        .attach();

    binding.tabLayout1.addOnTabSelectedListener(
        new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {}

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {}

          @Override
          public void onTabReselected(TabLayout.Tab tab) {
            if (tab.getPosition() == 0) {
              blankFragment.refresh();
            }
          }
        });

    DisplayMetrics displayMetrics = new DisplayMetrics();
    WindowManager manager = (WindowManager) getBaseContext().getSystemService(WINDOW_SERVICE);
    if (manager != null) {
      manager.getDefaultDisplay().getMetrics(displayMetrics);
    }

    binding.navView.getLayoutParams().width = displayMetrics.widthPixels;
    binding.navView.requestLayout();

    binding.navView.setNavigationItemSelectedListener(
        menuItem -> {
          Toast.makeText(MainActivity2.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
          return true;
        });

    Window window = getWindow();
    // 请求进行全屏布局+更改状态栏字体颜色
    // 获取程序是不是夜间模式
    int uiMode = getApplicationContext().getResources().getConfiguration().uiMode;
    if ((uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
      //            SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION  and  SYSTEM_UI_FLAG_LAYOUT_STABLE请求进行全屏布局
      //            SYSTEM_UI_FLAG_VISIBLE进行更改状态栏字体颜色
      window
          .getDecorView()
          .setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                  | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                  | View.SYSTEM_UI_FLAG_VISIBLE); // 白色
    } else {
      window
          .getDecorView()
          .setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                  | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                  | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); // 黑色
    }
    //                让内容显示在系统栏的后面,也就是显示在状态栏和导航栏的后面
    WindowCompat.setDecorFitsSystemWindows(window, true);
    // 沉浸状态栏(给任务栏上透明的色)(Android 10 上，只需要将系统栏颜色设为完全透明即可:)
    window.setStatusBarColor(Color.TRANSPARENT);
    // 沉浸导航栏（设置透明色）
    window.setNavigationBarColor(Color.TRANSPARENT);

    // 在安卓10以上禁用系统栏视觉保护。
    // 当设置了  导航栏 栏背景为透明时，NavigationBarContrastEnforced 如果为true，则系统会自动绘制一个半透明背景
    // 状态栏的StatusBarContrast 效果同理，但是值默认为false，因此不用设置
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      window.setNavigationBarContrastEnforced(false);
    }
  }
}