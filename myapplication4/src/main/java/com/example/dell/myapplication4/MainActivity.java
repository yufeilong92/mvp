package com.example.dell.myapplication4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRlvContentTitle;
    private XRefreshView mXfvContent;
    private ArrayList mArray;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        clearData();
        initAdapter();
        initXrfresh();
        mXfvContent.startRefresh();
    }

    private void initXrfresh() {
        mXfvContent.setPullRefreshEnable(true);
        mXfvContent.setAutoLoadMore(true);
        mXfvContent.setPullLoadEnable(true);
        mXfvContent.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                mXfvContent.stopRefresh();
                ArrayList<HomeVo> homeVos = initData();
                addList(homeVos);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore(boolean isSilence) {

            }
        });

    }

    private void initAdapter() {

        GridLayoutManager manager = new GridLayoutManager(this, 1);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        adapter = new RecyclerViewAdapter(this, mArray);
        adapter.setCustomLoadMoreView(new XRefreshViewFooter(this));
        mRlvContentTitle.setLayoutManager(manager);
        mRlvContentTitle.setAdapter(adapter);
    }

    private ArrayList<HomeVo> initData() {
        ArrayList<HomeVo> vos = new ArrayList<>();
        int a=3;
        for (int i = 0; i < a; i++) {
            HomeVo vo = new HomeVo();
            vo.setUrl("https://www.baidu.com/");
            vo.setTitle("小敏");
            ArrayList<String> list = new ArrayList<>();
            int b = 10;
            for (int j = 0; j< b; j++) {
                list.add("小米哥" + j);
            }
            vo.setList(list);
            vos.add(vo);
        }
        return vos;
    }

    private void clearData() {
        if (mArray == null) {
            mArray = new ArrayList();
        } else {
            mArray.clear();
        }
    }

    private void addList(List<?> mList) {
        if (mArray == null) {
            clearData();
        }
        if (mList == null || mList.isEmpty()) {
            return;
        }
        mArray.addAll(mList);
    }

    private void initView() {
        mRlvContentTitle = (RecyclerView) findViewById(R.id.rlv_content_title);
        mXfvContent = (XRefreshView) findViewById(R.id.xfv_content);
    }
}
