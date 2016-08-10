package com.apsoft.rxmvp.sample.features.loading_data.models;

import com.apsoft.rxmvp.library.models.IRxModel;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;

public class DataModel implements IRxModel {

    public Observable<ArrayList<String>> loadColors() {
        return Observable.create(new Observable.OnSubscribe<ArrayList<String>>() {
            @Override
            public void call(Subscriber<? super ArrayList<String>> subscriber) {
                ArrayList<String> colors = new ArrayList<>(0);
                colors.add("Red");
                colors.add("Blue");
                colors.add("Green");
                colors.add("White");
                colors.add("Black");
                subscriber.onNext(colors);
            }
        });
    }
}
