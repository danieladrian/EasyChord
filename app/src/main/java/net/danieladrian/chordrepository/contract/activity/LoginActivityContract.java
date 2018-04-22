package net.danieladrian.chordrepository.contract.activity;

public interface LoginActivityContract {

    interface View{

        void loginSuccess();
    }

    interface Model{

    }

    interface Presenter{

        void loginToServer();
    }
}
