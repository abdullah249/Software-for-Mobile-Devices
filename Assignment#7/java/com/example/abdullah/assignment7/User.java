package com.example.abdullah.assignment7;

import android.text.TextUtils;

import static com.example.abdullah.assignment7.MainActivity.cName;
import static com.example.abdullah.assignment7.MainActivity.cPassword;

public class User implements IUser {
   private String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isValid() {
        if (!(TextUtils.isEmpty(email)&&TextUtils.isEmpty(password)))
            if(email.equals(cName)&&password.equals(cPassword))
                return true;

        return false;

    }
}
