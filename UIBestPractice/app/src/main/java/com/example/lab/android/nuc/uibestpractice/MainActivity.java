package com.example.lab.android.nuc.uibestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Msg> msgList = new ArrayList<>();

    private EditText inputText;

    private EditText outputText;

    private Button send;

    private Button recevied;

    private RecyclerView msgResyclerView;

    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMags();//初始化消息数据

//        发送消息按钮

        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
//        接受消息按钮

        outputText = (EditText) findViewById(R.id.output_text);
        recevied = (Button) findViewById(R.id.received);

        msgResyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgResyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgResyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();

                    Msg msg = new Msg(content, Msg.TYRE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);
//                   当有消息时，刷新ListView 中的显示
                    msgResyclerView.scrollToPosition(msgList.size() - 1);
//                    将ListView定位到最后一行
                    inputText.setText("");
//                    清空输入框内的内容

            }
        });
        recevied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content1 = outputText.getText().toString();

                    Msg msg1 = new Msg(content1, Msg.TYPE_RECEIVED);
                    msgList.add(msg1);
                    adapter.notifyItemInserted(msgList.size() - 1);
                    msgResyclerView.scrollToPosition(msgList.size() - 1);
                    outputText.setText("");

            }
        });
//        Person person = new Person();
//        person.setName("wanghao");
//        person.setAge(18);
//        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//        intent.putExtra("person_data",person);
//        startActivity(intent);
    }
    private void initMags() {
//        添加几条已有消息
        Msg msg1 = new Msg("你好!",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("你好!请问你是。。。。？",Msg.TYRE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("我是Tom，很高兴见到你",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
