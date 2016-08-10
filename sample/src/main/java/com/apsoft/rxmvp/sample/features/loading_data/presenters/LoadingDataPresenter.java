package com.apsoft.rxmvp.sample.features.loading_data.presenters;

import com.apsoft.rxmvp.library.presenters.RxPresenter;
import com.apsoft.rxmvp.sample.features.loading_data.models.DataModel;
import com.apsoft.rxmvp.sample.features.loading_data.views.LoadingDataActivity;

import java.util.ArrayList;

import rx.functions.Action1;

public class LoadingDataPresenter extends RxPresenter<LoadingDataActivity, DataModel> {

    public LoadingDataPresenter(LoadingDataActivity view) {
        super(view);
        setModel(new DataModel());
    }

    public void loadColors() {
        addSubscription(getModel().loadColors().subscribe(new Action1<ArrayList<String>>() {
            @Override
            public void call(ArrayList<String> colors) {
                getView().onColorsListReceived(colors);
            }
        }));
    }
}
