package com.sun.commonlib;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SharePreferenceUtil {

    private static final String DB_NAME = "db";
    static SharedPreferences sharedPreferences;
    private static SharePreferenceUtil spUtil = new SharePreferenceUtil();

    public static SharePreferenceUtil getInstance(Context contxt) {
        sharedPreferences = contxt.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        return spUtil;
    }

    //保存objec
    public void saveObject(HashMap<String,Object> map){

    }

    //保存字符串
    public void  saveString(String str){

    }

    public void saveInt(int number){

    }


}
