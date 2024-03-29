package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author rushhe
 */
public class QZoneRecyclerViewAdapter extends RecyclerView.Adapter<QZoneRecyclerViewAdapter.QZoneViewHolder> {

    private List<QZoneMode> qZoneModeList;
    private Context mContext;


    public QZoneRecyclerViewAdapter(List<QZoneMode> qZoneModeList, Context context) {
        this.qZoneModeList = qZoneModeList;
        mContext = context;
    }

    public static class QZoneViewHolder extends RecyclerView.ViewHolder {

        ImageView qzoneIcon;
        TextView personName;
        TextView qzoneReleaseTime;
        TextView qzoneContext;
        ImageView qzonePic;
        TextView qzonePhone;
        TextView likeZone;

        public QZoneViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public QZoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.qzone_style, parent, false);
        return new QZoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QZoneViewHolder holder, int position) {
        QZoneMode qZoneMode = qZoneModeList.get(position);
        int qzoneIconRes = getImageMipmapRes(mContext, qZoneMode.getQQIcon());
        holder.qzoneIcon.setImage()
    }

    @Override
    public int getItemCount() {
        return qZoneModeList.size();
    }

    public int getImageMipmapRes(Context context, String filename) {
        return context.getResources().getIdentifier(filename, "mipmap", context.getPackageName());
    }

    public int getImageDrawableRes(Context context, String filename) {
        return context.getResources().getIdentifier(filename, "drawable", context.getPackageName());
    }
}
