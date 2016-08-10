package com.apsoft.rxmvp.library.presenters;

import com.apsoft.rxmvp.library.models.IRxModel;
import com.apsoft.rxmvp.library.views.IRxView;

import java.util.ArrayList;

import rx.Subscription;

public abstract class RxPresenter<T extends IRxView, E extends IRxModel> implements IRxPresenter<T, E> {

    private static final String TAG = RxPresenter.class.getCanonicalName();

    private T view;
    private E model;

    private ArrayList<Subscription> subscriptions = new ArrayList<>(0);

    public RxPresenter(T view) {
        this.view = view;
    }

    public RxPresenter(T view, E model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
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
        for (Subscription s : subscriptions) {
            if (!s.isUnsubscribed()) {
                s.unsubscribe();
                subscriptions.remove(s);
            }
        }
    }
}
