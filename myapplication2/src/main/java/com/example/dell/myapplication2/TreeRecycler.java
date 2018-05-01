package com.example.dell.myapplication2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.multilevel.treelist.Node;
import com.multilevel.treelist.TreeRecyclerAdapter;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: TreeRecycler.java
 * @Package com.example.dell.myapplication2
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/30 12:51
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/30 星期一
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class TreeRecycler extends TreeRecyclerAdapter {

    public TreeRecycler(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel, int iconExpand, int iconNoExpand) {
        super(mTree, context, datas, defaultExpandLevel, iconExpand, iconNoExpand);
    }

    public TreeRecycler(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel) {
        super(mTree, context, datas, defaultExpandLevel);
    }


    @Override
    public void onBindViewHolder(Node node, RecyclerView.ViewHolder holder, int position) {
        final MyTreeView hold = (MyTreeView) holder;
        hold.mTvTitle.setText(node.getName());


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyTreeView(View.inflate(mContext, R.layout.item_content, null));
    }

    public class MyTreeView extends RecyclerView.ViewHolder {
        public TextView mTvTitle;

        public MyTreeView(View itemView) {
            super(itemView);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);

        }
    }
}
