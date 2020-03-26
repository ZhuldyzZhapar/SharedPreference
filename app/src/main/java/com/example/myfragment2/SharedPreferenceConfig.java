package com.example.myfragment2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreferenceConfig(Context applicationContext) {
    }

    public void SharedPreferenceConfig(Context context){
            this.context = context;
            sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_shared_preference), Context.MODE_PRIVATE);

    }
    public void login_status(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_shared_preference), status);
        editor.commit();
    }
    public boolean read_login_status(){
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_shared_preference), false);
        return status;
    }
}
