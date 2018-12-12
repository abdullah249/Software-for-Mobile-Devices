package com.example.abdullah.assignment7;

import android.content.Intent;

public class loginPresenter implements IloginPresenter {
    IloginView loginView;

    public loginPresenter(IloginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
            User u=new User(email,password);
            boolean isloginSuccess=u.isValid();
            if (isloginSuccess)
                loginView.mloginResult("Login Success");

            else
                loginView.mloginResult("login Unsuccessul");

    }

}
