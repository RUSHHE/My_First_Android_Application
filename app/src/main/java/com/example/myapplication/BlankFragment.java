package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BlankFragment extends Fragment implements AdapterView.OnItemClickListener {
    //帮我随机生成20个中文人名
    String[] name = {"李狗蛋", "王二狗", "沈金冰", "张三", "李四", "王五", "赵四", "李荣", "李田所", "李狗蛋", "王二狗", "沈金冰", "张三", "李四", "王五", "赵四", "李荣", "李田所"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.VeChatList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, name);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(getActivity(), name[position], Toast.LENGTH_SHORT).show();
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
}