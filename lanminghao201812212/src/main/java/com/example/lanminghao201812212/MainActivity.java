package com.example.lanminghao201812212;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int a=5;
//Handler倒计时
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(a==0){
                Intent intent = new Intent(MainActivity.this,Zhuye.class);
                startActivity(intent);
                finish();
                return;
            }
            a--;
            textView.setText(a+"");
            handler.sendEmptyMessageDelayed(0, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.dao);

        handler.sendEmptyMessageDelayed(0,1000);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Zhuye.class);
                startActivity(intent);
            }
        });
    }
}
