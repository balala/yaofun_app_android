package com.balala.yaofun.base;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class BasePresenter <v extends BaseView> {
    protected v mView;
    protected ArrayList<BaseModel> models = new ArrayList<>();

    public void bind(v baseView) {
        WeakReference<v> weakReference = new WeakReference<>(baseView);
        v v = weakReference.get();
        this.mView=v;
    }
    public void OnDestroy(){
        mView=null;
        for (BaseModel model : models) {
            model.onDestory();
        }
        models.clear();

    }
}
