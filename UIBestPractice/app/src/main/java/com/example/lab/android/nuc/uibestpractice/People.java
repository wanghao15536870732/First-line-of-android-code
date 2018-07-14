package com.example.lab.android.nuc.uibestpractice;

import android.os.Parcel;
import android.os.Parcelable;


public class People implements Parcelable {

    private String name;

    private int age;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);//写出name
        dest.writeInt(age);//写出age
    }

    public static final Parcelable.Creator<People> CREATOR = new Parcelable.Creator<People>(){

        @Override
        public People createFromParcel(Parcel source) {
            People people = new People();
//            读取的顺序一定要和上面的一样
            people.name = source.readString();//读取姓名
            people.age = source.readInt();//读取年龄
            return people;
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };
}
