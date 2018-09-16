package com.example.lab.android.nuc.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //首先给左边的碎片注册了一个点击事件

        Button button = (Button) findViewById(R.id.Button);
        button.setOnClickListener(this);

        //然后调用replacefragment()方法添加了RightFragment这个碎片
        replaceFragment(new RightFragment());

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.Button:
//                当点击左边碎片的按钮时，将右边的碎片换成AnotherRightFragment
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment){
////        首先获取FragmentManager,在活动中可以直接通过调用getSupportFragmentManager()方法得到
//        FragmentManager fragmentManager = getSupportFragmentManager();
////        开启一个事务，通过调用beginTransaction()方法开启
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
////        想容器内添加或替换碎片，一般用replace()方法实现，需要传入容器的id和待添加的碎片实例
//        transaction.replace (R.id.right_layout, fragment);
//
////        它可以接受一个名字用于描述返回栈的状态，一般传入null即可
//        transaction.addToBackStack(null);
////        提交事务，调用commit()方法来完成
//        transaction.commit();
    }
}
