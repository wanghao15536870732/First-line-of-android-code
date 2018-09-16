package com.example.lab.android.nuc.coolweather.gson;

import android.view.Menu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 王浩 on 2018/3/1.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{

        @SerializedName("txt")
        public String info;
    }
}
