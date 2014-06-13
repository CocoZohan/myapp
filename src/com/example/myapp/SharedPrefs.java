package com.example.myapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Practicant1.ORPO_KRG on 13.06.2014.
 */
public class SharedPrefs {

    public final static String PREF_FILE = "MyPref";

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_FILE, 0);
    }

    public static String getMyStringPref(Context context, String key) {
        return getPrefs(context).getString(key, "default");
    }

    public static int getMyIntPref(Context context, String key) {
        return getPrefs(context).getInt(key, 42);
    }

    public static void setMyStringPref(Context context, String key, String value) {
        // perform validation etc..
        getPrefs(context).edit().putString(key, value).commit();
    }

    public static void setMyIntPref(Context context, String key, int value) {
        // perform validation etc..
        getPrefs(context).edit().putInt(key, value).commit();
    }
}
