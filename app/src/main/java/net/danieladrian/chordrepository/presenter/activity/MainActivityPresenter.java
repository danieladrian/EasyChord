package net.danieladrian.chordrepository.presenter.activity;

import android.content.Context;

import net.danieladrian.chordrepository.contract.activity.MainActivityContract;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View mView;
    Context mContext;

    public MainActivityPresenter(Context context,MainActivityContract.View view) {
        this.mContext = context;
        mView = view;
    }


}
