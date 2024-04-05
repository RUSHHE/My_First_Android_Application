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
import com.example.myapplication.databinding.FragmentBlankBinding;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import java.util.ArrayList;

public class BlankFragment extends Fragment {
  String[] names = {"AAA售房经理小圣", "行稳致远", "花开富贵", "aaaaaaadaze～～～", "不是二次元", "SoulMaker"};
  private FragmentBlankBinding binding;
  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentBlankBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ArrayList<Chat> chatList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      for (String name : names) {
        chatList.add(new Chat(name, "你好", R.drawable.author));
      }
    }
    ChatAdapter chatAdapter = new ChatAdapter(getActivity(), R.layout.chat_item_layout, chatList);
    binding.VeChatList.setAdapter(chatAdapter);

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
    Log.d("BlankFragment", "onCreate() called");
  }

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    Log.d("BlankFragment", "onAttach() called");
  }

  @Override
  public void onDetach() {
    super.onDetach();
    Log.d("BlankFragment", "onDetach() called");
  }

  @Override
  public void onStart() {
    super.onStart();
    Log.d("BlankFragment", "onStart() called");
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.d("BlankFragment", "onResume() called");
  }

  @Override
  public void onPause() {
    super.onPause();
    Log.d("BlankFragment", "onPause() called");
  }

  @Override
  public void onStop() {
    super.onStop();
    Log.d("BlankFragment", "onStop() called");
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    Log.d("BlankFragment", "onDestroyView() called");
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d("BlankFragment", "onDestroy() called");
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.d("BlankFragment", "onSaveInstanceState() called");
  }

  @Override
  public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    Log.d("BlankFragment", "onViewStateRestored() called");
  }

  public void refresh() {
    binding.chatNestedScrollView.scrollTo(0, 0);
    binding.miniPrograms.autoRefresh();
  }
}