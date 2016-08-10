package com.apsoft.rxmvp.library.views;

import android.content.Context;

import com.apsoft.rxmvp.library.presenters.IRxPresenter;

public interface IRxView<T extends IRxPresenter> {

    /**
     * Set a presenter to the selected view
     *
     * @param presenter - view's presenter
     */
    void setPresenter(T presenter);

    /**
     * Get reference to the view's presenter
     *
     */
    T getPresenter();

    Context getContext();
}
