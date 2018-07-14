package com.example.lab.android.nuc.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.send_notice);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_notice:
                Intent intent = new Intent(this,NotificationActivity.class);
//                PendingIntent可以简单的认为延迟执行的Intent
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
                NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("这是一个标题")
                        .setContentText("这是具体内容")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.mipmap.ic_launcher))
//                        NotificationCompat.Builder构造器可以连接一个setContentIntent()方法，
//                          接受的参数正好是一个PendingIntent对象
                        .setContentIntent(pi)

////                        点击放出声音
////                        接受一个Uri参数，所以在指定音频文件的时候还要获取到音频文件对应的URI
//                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
//
////                        点击产生震动
////                        下表为0的值表示手机静止的时长，下表为1的值表示手机震动的时长，以此类推
//                        .setVibrate(new long[]{0,300,300,300})
////                        最后不要忘了控制手机振动还需要声明权限
//
////                        点击LED灯变亮,第一个参数为亮灯的颜色,后两个参数为亮和暗的时间
//                        .setLights(Color.GREEN,1000,1000)


//                        直接使用默认的效果
                        .setDefaults(NotificationCompat.DEFAULT_ALL)


//                      显示长文字或者是长图片
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("学习怎样建立通通知，发送和接受信息，" +
                                "运用Android Studio 的IDE和建造工具去开发Android类的app，最后你的Notification项目运行成功了"))


//                        显示大图片
//                        这次我们在参数中创建了一个NotificationCompat.BigPictureStyle()对象，这个对象就是设置大图片的
//                        通过BitmapFactory的decodeResource()方法将图片解析成Bitmap对象，再传入到bigPicture()方法中就好了
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),
                                R.drawable.img_nice)))

//                        学习setPriority()方法，他可以用与设置通知的重要程度,这里设置了最重要的成都
                        .setPriority(NotificationCompat.PRIORITY_MAX)
//                        运行一下,发现不是在系统状态栏里显示一个小图标了，而是直接弹了出来
                        .build();
                manager.notify(1,notification);
                break;
            default:
                break;
        }
    }
}
