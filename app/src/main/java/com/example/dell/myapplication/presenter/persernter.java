package com.example.dell.myapplication.presenter;

import android.util.Log;

import com.example.dell.myapplication.model.Imodel;
import com.example.dell.myapplication.view.IView;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: persernter.java
 * @Package com.example.dell.myapplication.presenter
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/28 22:27
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/28 星期六
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class persernter {
    IView view;
    Imodel imodel;

    public persernter(IView view, Imodel imodel) {
        this.view = view;
        this.imodel = imodel;
    }

    public void clickButton() {
        view.showToast(imodel.makeToastContent());
        Log.e("yfl", "clickButton: ");
    }
}
