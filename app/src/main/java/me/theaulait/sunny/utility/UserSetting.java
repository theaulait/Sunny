package me.theaulait.sunny.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by c4q-vanice on 6/27/15.
 */
public class UserSetting {
    private String name;
    SharedPreferences mSharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;

    public UserSetting(Context context){
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

//    public String getStoredPreference(){
//
//    }

}
