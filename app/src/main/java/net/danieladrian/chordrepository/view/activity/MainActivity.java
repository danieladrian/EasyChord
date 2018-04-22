package net.danieladrian.chordrepository.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.danieladrian.chordrepository.R;
import net.danieladrian.chordrepository.contract.activity.MainActivityContract;
import net.danieladrian.chordrepository.presenter.activity.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    MainActivityPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainActivityPresenter(getApplicationContext(),this);
    }
}
