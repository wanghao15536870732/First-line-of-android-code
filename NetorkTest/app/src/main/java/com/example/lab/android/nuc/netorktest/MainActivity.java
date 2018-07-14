package com.example.lab.android.nuc.netorktest;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    TextView responseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendRequest = (Button) findViewById(R.id.send_request);
        responseText = (TextView) findViewById(R.id.response_text);
        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request){
//            使用Http协议访问网络

//            使用HttpURIConnection访问网络
//            sendRequestWithHttpURIConnection();

//            使用OkHttp 访问网络
            sendRequestWithOkhttp();
        }
    }
//    使用OkHttp 访问网络
    private void sendRequestWithOkhttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
//                            访问地址为baidu的地址
//                            .url("http://www.baidu.com")
////                            指定访问的服务器地址是电脑本机
//                            .url("http://10.0.0.2/get_data.xml")
                            .url("http://10.0.0.2/get_data.json")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();

//                    解析XML格式的数据
//                    showResponse(responseData);

////                    Pull的解析方式
//                   parseXMLWithPull(responseData);
////
////                    SAX的解析方式
//                    parseXMLWithSAX(responseData);


//                    解析JSON格式数据
////                    JSONObject的解析方式
//                    parseJSONObject(responseData);
//                  GSON的解析方式
                    parseJSONWithGSON(responseData);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }).start();
    }

//                    解析JSON格式数据

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>()
        {}.getType());
        for (App app : appList){
            Log.d("MainActivity","id is " + app.getId());
            Log.d("MainActivity","name is " + app.getName());
            Log.d("MainActivity","version is " + app.getVersion());
        }
    }



//    ////         JSONObject的解析方式
//    private void parseJSONObject(String jsonData) {
//        try{
//            JSONArray jsonArray = new JSONArray(jsonData);
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                String id = jsonObject.getString("id");
//                String name = jsonObject.getString("name");
//                String version = jsonObject.getString("version");
//                Log.d("MainActivity","id id " + id);
//                Log.d("MainActivity","name is" + name);
//                Log.d("MainActivity","version is " + version);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }





//    解析XMl格式的数据

//    这是SAX的解析方式
//private void parseXMLWithSAX(String xmlData) {
//
//        try{
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
//            ContentHander hander = new ContentHander();
////            将ContentHander的实例设置到XMLReader中
//            xmlReader.setContentHandler(hander);
////            开始执行解析
//            xmlReader.parse(new InputSource(new StringReader(xmlData)));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }





//    这是Pull的解析方式
//    private void parseXMLWithPull(String xmlData) {
//        try{
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            XmlPullParser xmlPullParser = factory.newPullParser();
//            xmlPullParser.setInput(new StringReader(xmlData));
//            int eventType = xmlPullParser.getEventType();
//            String id = "";
//            String name = "";
//            String version = "";
//            while (eventType == xmlPullParser.END_DOCUMENT){
//                String nodeName = xmlPullParser.getName();
//                switch(eventType){
////                    开始解析摸个节点
//                    case XmlPullParser.START_TAG:{
//                        if ("id".equals(nodeName)){
//                            id = xmlPullParser.nextText();
//                        }else if ("name".equals(nodeName)){
//                            name = xmlPullParser.nextText();
//                        }else if ("version".equals(nodeName)){
//                            version = xmlPullParser.nextText();
//                        }
//                        break;
//                    }
////                    完成解析某个节点
//                    case XmlPullParser.END_TAG:{
//                        if ("app".equals(nodeName)){
//                            Log.d("MainActivity","id id " + id);
//                            Log.d("MainActivity","name is " + name);
//                            Log.d("MainActivity","version is " + version);
//                        }
//                        break;
//                    }
//                    default:
//                        break;
//                }
//                eventType = xmlPullParser.next();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }













//    使用HttpURIConnection访问网络
//    private void sendRequestWithHttpURIConnection() {
////        开启线程发起网络请求
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HttpURLConnection connection = null;
//                BufferedReader reader = null;
//                try{
//                    URL url = new URL("http://www.baidu.com");
//                    connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
//                    connection.setConnectTimeout(8000);
//                    connection.setReadTimeout(8000);
//                    InputStream in = connection.getInputStream();
////                    下面对获取到的输入流进行读取
//                    reader = new BufferedReader(new InputStreamReader(in));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//                    while ((line = reader.readLine()) != null){
//                        response.append(line);
//                    }
//                    showResponse(response.toString());
//                }catch (Exception e){
//                    e.printStackTrace();
//                }finally {
//                    if (reader != null){
//                        try{
//                            reader.close();
//                        }catch (IOException e){
//                            e.printStackTrace();
//                        }
//                    }
//                    if (connection != null){
//                        connection.disconnect();
//                    }
//                }
//            }
//        }).start();
//    }
    private void showResponse(final String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                在这里进行UI操作，将结果显示到界面上
                responseText.setText(response);
            }
        });
    }
}
