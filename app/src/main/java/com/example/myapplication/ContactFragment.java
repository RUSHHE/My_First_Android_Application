package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.myapplication.databinding.FragmentContactBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class ContactFragment extends Fragment {
  private FragmentContactBinding binding;

  private List<ContactMode> mContactModeList;
  private ContactExpandableAdapter mContactExpandableAdapter;
  private ScrollExpandableListView mExpandableListView;

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentContactBinding.inflate(inflater, container, false);
    mExpandableListView = binding.contactExpandableListview;

    String ExpandableModeStr = readAssetsFile("ContactMode.json", requireContext());
    Gson gson = new Gson();
    mContactModeList = gson.fromJson(ExpandableModeStr, new TypeToken<List<ContactMode>>() {}.getType());
    mContactExpandableAdapter = new ContactExpandableAdapter(mContactModeList, requireContext());
    mExpandableListView.setAdapter(mContactExpandableAdapter);

    mExpandableListView.setOnChildClickListener((expandableListView, view, i, i1, l) -> {
      Toast.makeText(getContext(), i1 + "", Toast.LENGTH_SHORT).show();
      List<ContactMode.ChildDataBean> childDataBeans = mContactModeList.get(i).getChildData();

      mContactExpandableAdapter.notifyDataSetChanged();
      mExpandableListView.collapseGroup(i);
      mExpandableListView.expandGroup(i);
      return false;
    });

    //全部展开
    for(int i = 0; i < mContactModeList.size(); i++) {
      mExpandableListView.expandGroup(i);
    }
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    SmartRefreshLayout.setDefaultRefreshHeaderCreator(
        (context, refreshLayout) ->
            new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate));
  }

  /*
   * 以下是生命周期方法
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d("ContactFragment", "onCreate() called");
  }

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    Log.d("ContactFragment", "onAttach() called");
  }

  @Override
  public void onDetach() {
    super.onDetach();
    Log.d("ContactFragment", "onDetach() called");
  }

  @Override
  public void onStart() {
    super.onStart();
    Log.d("ContactFragment", "onStart() called");
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.d("ContactFragment", "onResume() called");
  }

  @Override
  public void onPause() {
    super.onPause();
    Log.d("ContactFragment", "onPause() called");
  }

  @Override
  public void onStop() {
    super.onStop();
    Log.d("ContactFragment", "onStop() called");
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    Log.d("ContactFragment", "onDestroyView() called");
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d("ContactFragment", "onDestroy() called");
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.d("ContactFragment", "onSaveInstanceState() called");
  }

  @Override
  public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    Log.d("ContactFragment", "onViewStateRestored() called");
  }

  /**
   * 读取assets中的文件 流程
   * readAssetsFile("json/xx.json", this);
   *
   * @param fileName 文件名
   * @param context  context
   * @return 读取的内容
   */
  public String readAssetsFile(String fileName, Context context) {
    // 输入流对象
    InputStream inputStream;
    // 缓存流对象
    BufferedReader bufferedReader = null;
    StringBuilder stringBuilder = new StringBuilder();
    try {
      // getAssets方法返回通过输入流对象
      inputStream = context.getAssets().open(fileName);
      // InputStreamReader 实现字节流到字符流的转换
      bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line);
      }
    } catch (IOException e) {
      Log.e("MainActivity", e.toString());
    } finally {
      try {
        if (bufferedReader != null) {
          bufferedReader.close();
        }
      } catch (IOException e) {
        Log.e("MainActivity", e.toString());
      }
    }
    return stringBuilder.toString();
  }
}
