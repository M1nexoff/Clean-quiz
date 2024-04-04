package com.example.cleanquiz.data.source;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.cleanquiz.data.model.CategoryEnum;

public class Pref {

    private static final String PREF_NAME = "MyPref";
    private static final String KEY_IS_OPEN = "isOpen";
    private static SharedPreferences sharedPreferences;

    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static Pref getInstance() {
        if (sharedPreferences == null) {
            throw new IllegalStateException("Call init() before calling getInstance()");
        }
        return new Pref();
    }

    public boolean isOpen(CategoryEnum categoryEnum) {
        return sharedPreferences.getBoolean(categoryEnum.name(), false);
    }

    public void setOpen(CategoryEnum categoryEnum) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(categoryEnum.name(), true);
        editor.apply();
    }
}
