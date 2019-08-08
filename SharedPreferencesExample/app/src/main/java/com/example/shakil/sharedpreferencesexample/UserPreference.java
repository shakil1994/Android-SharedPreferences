package com.example.shakil.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreference {
    private static final String USER_EMAIL = "email";
    private static final String USER_PASSWORD = "password";
    private static final String DEFAULT = "No Data Found!";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public UserPreference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUser(String email, String pass){
        editor.putString(USER_EMAIL, email);
        editor.putString(USER_PASSWORD, pass);
        editor.commit();
    }

    public String showEmail(){
        return sharedPreferences.getString(USER_EMAIL, DEFAULT);
    }

    public String showPassword(){
        return sharedPreferences.getString(USER_PASSWORD, DEFAULT);
    }

    public void resetUser(){
        editor.clear();
        editor.commit();
    }
}
