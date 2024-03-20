package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import androidx.core.content.ContextCompat;

import com.example.myapplication.utils.ViewHolder;

import java.util.List;

public class ContactExpandableAdapter extends BaseExpandableListAdapter {
    private List<ContactMode> mContactModeList;
    private Context mContext;
    private ViewHolder mViewHolder;

    public ContactExpandableAdapter(List<ContactMode> contactModeList, Context context) {
        mContactModeList = contactModeList;
        mContext = context;
        mViewHolder = ViewHolder.getInstance();
    }

    /**
     * @return 返回组item数量
     */
    @Override
    public int getGroupCount() {
        return mContactModeList == null ? 0 : mContactModeList.size();
    }

    /**
     * 根据出入的组groupPosition返回子item的数量。
     *
     * @param i groupPosition
     * @return 返回子item的数量。
     */
    @Override
    public int getChildrenCount(int i) {
        if (mContactModeList == null) {
            return 0;
        }
        List<ContactMode.ChildDataBean> childDataBeans = mContactModeList.get(i).getChildData();
        return childDataBeans == null ? 0 : childDataBeans.size();
    }

    /**
     * 获取组实体对象
     *
     * @param i groupPosition
     * @return 返回组实体对象
     */
    @Override
    public Object getGroup(int i) {
        return mContactModeList == null ? null : mContactModeList.get(i);
    }

    /**
     * 获取子实体对象
     *
     * @param i groupPosition
     * @param i1 childPosition
     * @return 返回子实体对象
     */
    @Override
    public Object getChild(int i, int i1) {
        if (mContactModeList == null) {
            return null;
        }
        List<ContactMode.ChildDataBean> childDataBeans = mContactModeList.get(i).getChildData();
        return childDataBeans == null ? null : childDataBeans.get(i1);
    }

    /**
     * 获取组id,我理解为获取组的唯一ID，一般自己返回groupPosition即可
     *
     * @param i groupPosition
     * @return Position
     */
    @Override
    public long getGroupId(int i) {
        return 0;
    }

    /**
     * 获取子ID
     *
     * @param i groupPosition
     * @param i1 childPosition
     * @return 返回子id
     */
    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    /**
     * 用来判断ExpandableListView内容id是否有效的,我也不太明白，它具体有什么作用，设置返回true和false的效果是一样的。
     *
     * @return true or false
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * 获取给定分组的视图，主要重写的方法。
     *
     * @param i groupPosition
     * @param b    该组是展开状态还是收起状态
     * @param view   convertView
     * @param viewGroup        parent
     * @return View
     */
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.contact_item_group, viewGroup, false);
        }
        ContactMode contactMode = mContactModeList.get(i);
        String groupName = contactMode.getGroupName();
        mViewHolder.setText(view, R.id.contact_group_name, groupName);
        return view;
    }

    /**
     * 获取给定分组给定子位置的数据用的视图，主要重写的方法。
     *
     * @param i groupPosition
     * @param i1 childPosition
     * @param b   是否为改组最后一个子视图
     * @param view   convertView
     * @param viewGroup        parent
     * @return View
     */
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.contact_item_child, viewGroup, false);
        }
        ContactMode contactMode = mContactModeList.get(i);
        List<ContactMode.ChildDataBean> childDataBeans = contactMode.getChildData();
        ContactMode.ChildDataBean childDataBean = childDataBeans.get(i1);

        String childName = childDataBean.getChildName();
        String childIcon = childDataBean.getChildIcon();
        String childAbout = childDataBean.getChildAbout();

        int childIconRes = getImageMipmapRes(mContext, childIcon);
        Drawable drawable = ContextCompat.getDrawable(mContext, childIconRes);
        mViewHolder.setImage(view, R.id.contact_child_icon, drawable);
        mViewHolder.setText(view, R.id.contact_child_name, childName);
        mViewHolder.setText(view, R.id.contact_child_about, childAbout);
        return view;
    }

    /**
     * 子item是否可点击
     * 当isChildSelectable方法返回false的时候，子item不可点击，且不会绘制分割线
     *
     * @param i groupPosition
     * @param i1 childPosition
     * @return true可点击 false不可点击
     */
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    /**
     * 通过文件名，获取对应的图片资源
     *
     * @param context  context
     * @param filename filename
     * @return 对应的图片资源
     */
    public int getImageMipmapRes(Context context, String filename) {
        return context.getResources().getIdentifier(filename, "mipmap", context.getPackageName());
    }
}
