package com.example.lab.android.nuc.uibestpractice;

/**
 * Created by 王浩 on 2018/2/9.
 */

public class Msg {

    public static final int TYPE_RECEIVED = 0;

    public static final int TYRE_SENT = 1;

    private String content;

    private int type;

    public Msg(String content ,int type){
        this.content = content;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
