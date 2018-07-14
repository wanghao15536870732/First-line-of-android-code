# First-line-of-android-code

<div align="center">

![timg.jpg](https://upload-images.jianshu.io/upload_images/9140378-283fe6aac2a09b2a.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)
### [Android第一行代码](https://pan.baidu.com/s/1gr4SrfHNlkMflTb7ww4cNA)<br>
#### 密码 ：2xf3


## ResyclerViewTest
> 水果的一列展示
>> 水果的三列展示
>>> 水果的列向展示
>>>> 水果的横向展示

|一列的ResyclerView||一列的ResyclerView|
|:--:|:--:|:--:|
|![show8.png](https://upload-images.jianshu.io/upload_images/9140378-f9bb1bcbf9db973e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240) ||<![show7.png](https://upload-images.jianshu.io/upload_images/9140378-b518d5e5b0746c08.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240) |
|三列的ResyclerView||三列的ResyclerView|
|![show10.png](https://upload-images.jianshu.io/upload_images/9140378-e63c1145e8d9b1b2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)||![show9.png](https://upload-images.jianshu.io/upload_images/9140378-ca46c450b6420e0d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)|

</br></br>

## UIBestPractice
### 通过互相屏蔽两个列向的Fragment来实现QQ的消息发送和接受的功能(纯粹单机版的,没有实现网络的功能)
|我们最开始添加的三个消息|我们自己发送的消息|
|:--:|:--:|
|<div align=center><img width="300" height="550" src="https://github.com/wanghao15536870732/First-line-of-android-code/blob/master/UIBestPractice/app/src/main/res/drawable/show5.png"/></div>|<div align=center><img width="300" height="550" src="https://github.com/wanghao15536870732/First-line-of-android-code/blob/master/UIBestPractice/app/src/main/res/drawable/show6.png"/></div>|

</br></br>

# FragmentBestPractice
## 手机平板要兼顾--探究碎片
### 碎片的最佳实践----一个简易的新闻应用：(手机平板均兼容)
#### 模拟器若为手机
|手机兼容模式<br>MainActivity|手机兼容模式<br>NewsContentActivity|
|:--:|:--:|
|![img_3.png](https://upload-images.jianshu.io/upload_images/9140378-175340b60e00ddf9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![![img_7.png](https://upload-images.jianshu.io/upload_images/9140378-d8c2b8af17b97aa8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|
#### 模拟器若为平板或较大的Android模拟器
##### 下面两张照片两成一张照片的平板
|平板兼容模式<br>MainActivity|平板兼容模式<br>刷新NewsContentFragment中的内容|
|:--:|:--:|
|<img src="https://upload-images.jianshu.io/upload_images/9140378-d8c2b8af17b97aa8.png" width="290" height="505" alt="图片加载失败时，显示这段字"/>|<img src="https://upload-images.jianshu.io/upload_images/9140378-d8c2b8af17b97aa8.png" width="750" height="505" alt="图片加载失败时，显示这段字"/>|


</br></br>


# BroadcastBestPractice
### 实现QQ的强制下线功能、记住密码功能，至于密码的隐藏请戳：http://mp.blog.csdn.net/postedit

|logoActivity界面<br>没有勾选记住密码功能<br>并输入正确的账号：admin<br>密码：123456|logoActivity界面<br>勾选记住密码功能<br>并输入正确的账号：admin<br>密码：123456|
|:--:|:--:|
|![img_4.png](https://upload-images.jianshu.io/upload_images/9140378-a415e18353c72538.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![img_1.png](https://upload-images.jianshu.io/upload_images/9140378-f4f4c064c047a5c8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|
|MainAcxtivity<br>点击SEND FORCE OFFLINE BROADCAST按钮|MainActivity<br>点击SEND FORCE OFFLINE BROADCAST按钮|
|![img_6.png](https://upload-images.jianshu.io/upload_images/9140378-994523e98f695a8d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![img_6.png](https://upload-images.jianshu.io/upload_images/9140378-994523e98f695a8d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|
|ReceiveBroadcast<br>会接受到一条弹出框类的广播|ReceiveBrpadcast<br>会接受到一条弹出框类的广播|
|![img_5.png](https://upload-images.jianshu.io/upload_images/9140378-5ddab522b4791893.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![img_5.png](https://upload-images.jianshu.io/upload_images/9140378-5ddab522b4791893.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|
|点击OK之后<br>账号跟密码丢失<br>回到初始状态|点击OK之后<br>刚才输入的账号跟密码被保存下来了|
|![img_4.png](https://upload-images.jianshu.io/upload_images/9140378-a415e18353c72538.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![img_1.png](https://upload-images.jianshu.io/upload_images/9140378-f4f4c064c047a5c8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|

* 第一次写README.md，参考[大神博客](http://blog.csdn.net/ljc_563812704/article/details/53464039)

* 图片的大小控制参考[大佬博客](http://blog.csdn.net/htwhtw123/article/details/77069581)

</br></br>

# CameraAlbunmTest
## 演示一下：
<div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/First-line-of-android-code/blob/master/UIBestPractice/app/src/main/res/drawable/show1.gif"/></div>

</br></br>

# UIBestPractice
### 通过互相屏蔽两个列向的Fragment来实现QQ的消息发送和接受的功能(纯粹单机版的,没有实现网络的功能)

|我们最开始添加的三个消息|我们自己发送的消息|
|:--:|:--:|
|<div align=center><img width="300" height="550" src="https://github.com/wanghao15536870732/First-line-of-android-code/blob/master/UIBestPractice/app/src/main/res/drawable/show5.png"/></div>|<div align=center><img width="300" height="550" src="https://github.com/wanghao15536870732/First-line-of-android-code/blob/master/UIBestPractice/app/src/main/res/drawable/show6.png"/></div>|


</div>

</br></br>

# NetworkTest
# 看精彩的世界——————使用网络技术
## 使用HttpURIConnection访问网络
```java
    private void sendRequestWithHttpURIConnection() {
//        开启线程发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try{
                    URL url = new URL("http://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
//                    下面对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    showResponse(response.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (reader != null){
                        try{
                            reader.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if (connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
```

##   使用OkHttp 访问网络
* Pull的解析方式
* SAX的解析方式

</br></br>

<div align="center">

# LBSTest
# 基于位置的服务
![img_1.png](https://upload-images.jianshu.io/upload_images/9140378-6c2424243d03b52e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)

</br></br>

# 丰富你的程序————运用手机多媒体
## 播放多媒体文件
|MainActivity<br>播放音乐和视频,|点击开始音乐后<br>系统通知栏显示出来一个音乐的通知|
|:--:|:--:|
|![![img_2.jpg](https://upload-images.jianshu.io/upload_images/9140378-12dd2a8c9021a4d0.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![img_1.png](https://upload-images.jianshu.io/upload_images/9140378-7f87d5c31d3b54f8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|
|下拉通知栏<br>显示歌曲名字即歌曲的储存路径||
|![img_3.png](https://upload-images.jianshu.io/upload_images/9140378-7d38011904e55d02.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|同步歌曲于SeekBar进度条参考[濯君](http://blog.csdn.net/zzldm/article/details/52612455)的博客|

</div>


##    计算歌曲的时间
```java
    public String calculateTime(int time){
        int minute;
        int second;
        if (time > 60){
            minute = time / 60;
            second = time % 60;
            return minute + ":" + second;
        }else if (time < 60){
            second = time;
            return 0 + ":" + second;
        }
        return null;
    }
```
##    同步SeekBar与进度条时间
```java
   private void updataSeekBar(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null){
                    int mCurrentPosition = mediaPlayer.getCurrentPosition() / 1000;  //获取mediaPlayer当前进度，毫秒表示
                    int total = mediaPlayer.getDuration() / 1000; //获取当前歌曲的总时长
                    seekBar.setMax(total); //seekBar设置总时长

                }
                handler.postDelayed(this,100);//延迟一秒运行线程
            }
        });
    }
```

## 通知栏的显示
```java
                File file = new File(Environment.getExternalStorageDirectory(),
                        "说散就散 - 冯提莫.mp3");
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle(file.getName())
                        .setContentText("音乐文件位置：" + file.getPath())
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .build();
                manager.notify(1,notification);
```

# 千万不要忘掉申请储存的权限
```java
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

# NotificationTest
# 使用通知(Notification)
* 通知的基本用法
> 1.需要一个NotificationManager来对通知进行管理，可以调用Context的getSystemService()方法得到，这里参数我们传入Context.NOTIFICATION_SERVICE即可
 >> 2.解决API不稳定性在通知面板上尤为严重的问题，就是使用support库提供的兼容API，代码如下：<br>Notification notofication = new NotificationCompat.Builder(context).build();
 # 效果如下：
 
 |MainActivity<br>没有点击按钮之前|MainActivity<br>点击按钮之后，通知面板出现小图标|
 |:--:|:--:|
 |![img_1.png](https://upload-images.jianshu.io/upload_images/9140378-3f23b0b8256abd3d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![img_2.jpg](https://upload-images.jianshu.io/upload_images/9140378-70124f1a40edfdda.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|
 # 
 |下拉通知面板出现新的图标通知|点击调用新的活动NotificationActivity|
 |:--:|:--:|
 |![img_3.png](https://upload-images.jianshu.io/upload_images/9140378-44235f7074a6380e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|![img_4.png](https://upload-images.jianshu.io/upload_images/9140378-9c2676d89d68d3d5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)|
 
 # 点击图标启动新活动之后，图标消失
 
 ## NotificationActivity的结束活动
 ### 第一种写法——————点击通知消失法
 ```java
 Notification notofication = new NotificationCompat.Builder(this)
      ...
   *  .setAutoCancel(true)
      .build();
 ```
 ### 第二种写法—————修改NotificationActivity(启动活动消失法)
 ```java
 public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(1);
    }
}
 ```

