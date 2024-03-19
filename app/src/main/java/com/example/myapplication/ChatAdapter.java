package com.example.myapplication;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.myapplication.databinding.ChatItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends ArrayAdapter<Chat> {
    int resourceId;
    List<Chat> data;
    public ChatAdapter(Activity activity, int resourceId, List<Chat> data) {
        super(activity, resourceId, data);
        this.resourceId = resourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ChatItemLayoutBinding binding = ChatItemLayoutBinding.bind(view);

        Chat chat = getItem(position);
        if (chat != null) {
            binding.imageView3.setImageResource(data.get(position).imageId);
            binding.nameTextView.setText(data.get(position).name);
            binding.contentTextView.setText(data.get(position).content);
        }
        return view;
    }
}

