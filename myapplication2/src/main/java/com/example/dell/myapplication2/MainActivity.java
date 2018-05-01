package com.example.dell.myapplication2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.multilevel.treelist.Node;
import com.multilevel.treelist.OnTreeNodeClickListener;
import com.multilevel.treelist.TreeRecyclerAdapter;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView mLvContent;
    private RecyclerView mRlvContent;
    private ArrayList<Node> mList;
    private ArrayList<Persion> mDatas;
    private TreeRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initData() {
        mList = new ArrayList<>();
        mDatas = new ArrayList<>();
        int a = 10;
        for (int i = 0; i < a; i++) {
            Persion persion = new Persion();
            persion.setId(i + "");
            persion.setNanme("小明" + i);
            persion.setSex("男");
            persion.setTime(new Date().toString());
            persion.setPid(i + 1 + "");
            mDatas.add(persion);
        }
        for (int i = 0; i < mDatas.size(); i++) {
            Persion persion = mDatas.get(i);
            if (i == 0) {

                mList.add(new Node(persion.getId(), "-1", persion.getNanme(), persion));
            } else {
                mList.add(new Node(persion.getId(), persion.getPid(), persion.getNanme(), persion));

            }
        }

    }

    private void initView() {
        initData();
        mRlvContent = (RecyclerView) findViewById(R.id.rlv_content);
        mRlvContent.setOnClickListener(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRlvContent.setLayoutManager(gridLayoutManager);
        mRlvContent.addItemDecoration(new DividerItemDecoration(this, GridLayoutManager.VERTICAL));
        adapter = new TreeRecycler(mRlvContent,
                this, mList, 0, R.mipmap.ic_launcher, R.mipmap.cricle);
        mRlvContent.setAdapter(adapter);
        adapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener() {
            @Override
            public void onClick(Node node, int position) {
                String name = node.getName();
                if (!node.isRoot()) {
                    Object id = node.getId();
                    Toast.makeText(MainActivity.this, id + "/" + name, Toast.LENGTH_SHORT).show();
                    Log.e("yfl", "onClick: " + node.getpId());
                }

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
