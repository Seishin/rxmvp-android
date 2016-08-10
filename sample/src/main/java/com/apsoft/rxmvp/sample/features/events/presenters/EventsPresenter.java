package com.apsoft.rxmvp.sample.features.events.presenters;

import com.apsoft.rxmvp.library.models.IRxModel;
import com.apsoft.rxmvp.library.presenters.RxPresenter;
import com.apsoft.rxmvp.sample.features.events.views.EventsActivity;

public class EventsPresenter extends RxPresenter<EventsActivity, IRxModel> {

    public EventsPresenter(EventsActivity view) {
        super(view);
    }
}
