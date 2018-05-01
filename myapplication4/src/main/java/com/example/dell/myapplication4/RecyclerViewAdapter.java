package com.example.dell.myapplication4;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;

import java.util.ArrayList;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: RecyclerViewAdapter.java
 * @Package com.example.dell.myapplication4
 * @Description: todo
 * @author: YFL
 * @date: 2018/5/1 09:28
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/5/1 星期二
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class RecyclerViewAdapter extends BaseRecyclerAdapter {
    private Context mContext;
    private ArrayList mData;
    private final LayoutInflater mInflater;
    public String TAG = "RecyclerViewAdapter.class";


    private static final int VewView = 0;//web
    private static final int JiXiView = 1;//解析
    private static final int Evalue = 2;//评价
    private int ViewType = VewView;
    private String url;
    private String title;
    private ArrayList mList;

    public RecyclerViewAdapter(Context mContext, ArrayList mData) {
        this.mContext = mContext;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setUrl(String url) {
        this.url = url;
        notifyDataSetChanged();
    }

    public void setJieXi(String title) {
        this.title = title;
        notifyDataSetChanged();
    }

    public void setRlvContent(ArrayList mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getAdapterItemCount() {
        return mData==null?0:mData.size();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view) {
        int type = view.getLayerType();
        switch (type) {
            case VewView:
                return new WebHolder(view);
            case JiXiView:
                return new JieXiHodler(view);
            case Evalue:
                return new EvaluaHodler(view);
        }
        return null;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {

        switch (viewType) {
            case VewView:
                View view = mInflater.inflate(R.layout.item_web, null);
                return new WebHolder(view);
            case JiXiView:
                View view1 = mInflater.inflate(R.layout.jiexi, null);
                return new JieXiHodler(view1);
            case Evalue:
                View view2 = mInflater.inflate(R.layout.evalua, null);
                return new EvaluaHodler(view2);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, boolean isItem) {
        int type = getAdapterItemViewType(position);
        HomeVo vo = (HomeVo) mData.get(position);
        if (type == VewView) {
            WebHolder webholder = (WebHolder) holder;
            initWeb(webholder.mWebView,vo.getUrl());

        } else if (type == JiXiView) {
            JieXiHodler jixi = (JieXiHodler) holder;
            jixi.mTvContent.setText(vo.getTitle());

        } else if (type == Evalue) {
            EvaluaHodler ev = (EvaluaHodler) holder;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 1);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            RecyclerAdapter recyclerAdapter = new RecyclerAdapter(mContext, vo.getList());
            ev.mRlvContent.setLayoutManager(gridLayoutManager);
            ev.mRlvContent.setAdapter(recyclerAdapter);
        }

    }

    private void initWeb(WebView webholder, String url) {
        WebSettings settings = webholder.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        webholder.loadUrl(url);
        webholder.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;

            }
        });
    }

    @Override
    public int getAdapterItemViewType(int position) {
        switch (position) {
            case VewView:
                ViewType = VewView;
                break;
            case JiXiView:
                ViewType = JiXiView;
                break;
            case Evalue:
                ViewType = Evalue;
                break;
        }
        return ViewType;

    }

    public class WebHolder extends RecyclerView.ViewHolder {
        public WebView mWebView;

        public WebHolder(View itemView) {
            super(itemView);
            this.mWebView = itemView.findViewById(R.id.wb_content);
        }
    }

    public class JieXiHodler extends RecyclerView.ViewHolder {
        public TextView mTvContent;

        public JieXiHodler(View itemView) {
            super(itemView);
            this.mTvContent = itemView.findViewById(R.id.tv_content);
        }
    }

    public class EvaluaHodler extends RecyclerView.ViewHolder {
        public RecyclerView mRlvContent;

        public EvaluaHodler(View itemView) {
            super(itemView);
            this.mRlvContent = itemView.findViewById(R.id.rlv_content);
        }
    }


}
