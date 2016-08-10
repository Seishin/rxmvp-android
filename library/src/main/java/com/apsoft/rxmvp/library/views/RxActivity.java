package com.apsoft.rxmvp.library.views;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.apsoft.rxbus.RxBus;
import com.apsoft.rxbus.events.RxEvent;
import com.apsoft.rxmvp.library.presenters.IRxPresenter;

public abstract class RxActivity<T extends IRxPresenter> extends AppCompatActivity implements IRxView<T> {

    private T presenter;

    @Override
    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    @Override
    public T getPresenter() {
        return presenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        RxBus.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (presenter != null) {
            presenter.onPause();
        }

        RxBus.getInstance().unregister(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    protected RxBus getEventBus() {
        return RxBus.getInstance();
    }

    protected void sendEvent(RxEvent event) {
        RxBus.getInstance().send(event);
    }
}
