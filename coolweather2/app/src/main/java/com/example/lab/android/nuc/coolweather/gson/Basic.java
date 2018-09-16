package com.example.lab.android.nuc.coolweather.gson;


import com.example.lab.android.nuc.coolweather.util.Utility;
import com.google.gson.annotations.SerializedName;

/**
 * Created by 王浩 on 2018/3/1.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{

        @SerializedName("loc")
        public String updateTime;
    }
}
