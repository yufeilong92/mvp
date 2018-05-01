package com.example.dell.myapplication4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: RecyclerAdapter.java
 * @Package com.example.dell.myapplication4
 * @Description: todo
 * @author: YFL
 * @date: 2018/5/1 09:44
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/5/1 星期二
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHodler> {
    private Context mContext;
    private ArrayList mData;
    private final LayoutInflater inflater;

    public RecyclerAdapter(Context mContext, ArrayList mData) {
        this.mContext = mContext;
        this.mData = mData;
        inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.item, null);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        holder.mTvTitle.setText((CharSequence) mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHodler extends RecyclerView.ViewHolder {
        public TextView mTvTitle;

        public ViewHodler(View itemView) {
            super(itemView);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);

        }
    }

}
