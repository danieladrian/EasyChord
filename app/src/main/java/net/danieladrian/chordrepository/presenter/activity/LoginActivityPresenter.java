package net.danieladrian.chordrepository.presenter.activity;

import android.content.Context;

import net.danieladrian.chordrepository.contract.activity.LoginActivityContract;

public class LoginActivityPresenter implements LoginActivityContract.Presenter {

    LoginActivityContract.View mView;
    Context mContext;
    public LoginActivityPresenter(Context context, LoginActivityContract.View view) {
        mView = view;
        mContext = context;
    }

    @Override
    public void loginToServer() {

        mView.loginSuccess();
    }
}
