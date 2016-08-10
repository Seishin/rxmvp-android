package com.apsoft.rxmvp.library.presenters;

import com.apsoft.rxmvp.library.models.IRxModel;
import com.apsoft.rxmvp.library.views.IRxView;

import rx.Subscription;

public interface IRxPresenter<T extends IRxView, E extends IRxModel> {
    /**
     * Add a subscription
     *
     * @param subscription
     */
    void addSubscription(Subscription subscription);

    /**
     * Returns a reference to the presenter's view
     *
     * @return T - presenter's view
     */
    T getView();

    /**
     * Setting a model to the selected presenter
     *
     * @param model - data model
     */
    void setModel(E model);

    /**
     * Returns the data model of the selected presenter
     *
     * @return E - data model
     */
    E getModel();

    /**
     * Callback for un-subscribing or de-allocating resources
     */
    void onPause();
}
