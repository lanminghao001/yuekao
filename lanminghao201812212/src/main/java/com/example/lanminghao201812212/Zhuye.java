package com.example.lanminghao201812212;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.example.lanminghao201812212.frag.Frag1;
import com.example.lanminghao201812212.frag.Frag2;
import com.example.lanminghao201812212.frag.Frag3;
import com.example.lanminghao201812212.frag.Frag4;
import com.example.lanminghao201812212.frag.Frag5;

public class Zhuye extends FragmentActivity implements View.OnClickListener {
    private RadioButton btn1,btn2,btn3,btn4,btn5;
    private Frag1 aa;
    private Frag2 bb;
    private Frag3 cc;
    private Frag4 dd;
    private Frag5 ee;
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuye);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        aa = new Frag1();
        bb = new Frag2();
        cc = new Frag3();
        dd = new Frag4();
        ee = new Frag5();

        transaction.add(R.id.frag,aa);
        transaction.add(R.id.frag,bb);
        transaction.add(R.id.frag,cc);
        transaction.add(R.id.frag,dd);
        transaction.add(R.id.frag,ee);
        transaction.show(aa).hide(bb).hide(cc).hide(dd).hide(ee);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
//fragment点击显示
        FragmentTransaction transaction2 = manager.beginTransaction();
        switch (v.getId()){
            case R.id.btn1:
                transaction2.show(aa).hide(bb).hide(cc).hide(dd).hide(ee);
                break;
            case R.id.btn2:
                transaction2.show(bb).hide(aa).hide(cc).hide(dd).hide(ee);
                break;
            case R.id.btn3:
                transaction2.show(cc).hide(bb).hide(aa).hide(dd).hide(ee);
                break;
            case R.id.btn4:
                transaction2.show(dd).hide(bb).hide(cc).hide(aa).hide(ee);
                break;
            case R.id.btn5:
                transaction2.show(ee).hide(bb).hide(cc).hide(dd).hide(aa);
                break;
        }
        transaction2.commit();
    }
}
