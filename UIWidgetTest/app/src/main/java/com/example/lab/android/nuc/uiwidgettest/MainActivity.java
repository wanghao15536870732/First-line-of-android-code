package com.example.lab.android.nuc.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;

    private ImageView imageView;

    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //用于将系统自带的标题栏隐藏掉
        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null){
            actionbar.hide();
        }


        Button button1 = (Button) findViewById(R.id.button_1);

        Button button2 = (Button) findViewById(R.id.button_2);

        Button button3 = (Button)findViewById(R.id.button_3);
        editText = (EditText) findViewById(R.id.edit_text);

        imageView = (ImageView) findViewById(R.id.image_view);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        button1.setOnClickListener(this);

        button2.setOnClickListener(this);

        button3.setOnClickListener(this);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"You clicked button1",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                //点击Button显示在输入框输入的文字
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this,inputText,
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_2:
                imageView.setImageResource(R.drawable.img_1);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is s Dialog");
                dialog.setMessage("Somthing important.");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(MainActivity.this,"You select OK",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"You select Cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;
            case R.id.button_3:

//                是否显示圆圈的进度图标
//                if (progressBar.getVisibility() == View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else {
//                    progressBar.setVisibility(View.GONE);
//                }

                //显示能够通过连续点击改变进度条的进度
//                int progress = progressBar.getProgress();
//                progress = progress + 10;
//                progressBar.setProgress(progress);

                ProgressDialog progressDialog = new ProgressDialog
                        (MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
