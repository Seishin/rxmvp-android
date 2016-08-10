package com.apsoft.rxmvp.library.presenters;

import com.apsoft.rxmvp.library.models.IRxModel;
import com.apsoft.rxmvp.library.views.IRxView;

import rx.Subscription;

public abstract class RxPresenter<T extends IRxView, E extends IRxModel> implements IRxPresenter<T, E> {

    private static final String TAG = RxPresenter.class.getCanonicalName();

    private T view;
    private E model;

    private Subscription subscription;

    public RxPresenter(T view) {
        this.view = view;
    }

    public RxPresenter(T view, E model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public T getView() {
        return view;
    }

    @Override
    public void setModel(E model) {
        this.model = model;
    }

    @Override
    public E getModel() {
        return model;
    }

    @Override
    public void onPause() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
