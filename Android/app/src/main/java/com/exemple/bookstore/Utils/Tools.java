package com.exemple.bookstore.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jonathan on 06/12/2015.
 */
public class Tools {

    public static void saveToPreferences(Context context, String key, String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences("account", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String key, String defaultValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences("account", Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultValue);
    }
}
