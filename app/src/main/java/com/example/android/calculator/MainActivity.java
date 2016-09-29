package com.example.android.calculator;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;

import java.util.Stack;

public class MainActivity extends Activity {

    public String exp = "";
    public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);

    }

    public void onclickbutton(View v) {
        Button b = (Button) v;
//        b.setOnTouchListener(new View.OnTouchListener() {
//
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN: {
//                        v.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_ATOP);
//                        v.invalidate();
//                        break;
//                    }
//                    case MotionEvent.ACTION_UP: {
//                        v.getBackground().clearColorFilter();
//                        v.invalidate();
//                        break;
//                    }
//                }
//                return false;
//            }
//        });
        exp = exp + (b.getText());
        display(exp);
    }


    public void onclickop(View v)
    {
        Button op=(Button) v;
        if(exp.length()>0) {
            char temp = exp.substring(exp.length() - 1, exp.length()).toCharArray()[0];
            if (temp == '+' | temp == '-' | temp == '*' | temp == '/') {

                exp = exp.substring(0, exp.length() - 1) + op.getText();
            } else {
                exp = exp + op.getText();
            }
            display(exp);
        }
    }

    public void delete(View v)
    {

        if(exp!=null&&exp.length()>0)
        {
            exp=exp.substring(0,exp.length()-1);
            display(exp);
        }
    }
    public void display(String exp) {
        tv.setText(exp);
    }

    public void evaluate(View v) {
            boolean cond=true;
        char temp[]=exp.toCharArray();
        char tem = exp.substring(exp.length() - 1, exp.length()).toCharArray()[0];
        if (tem == '+' | tem == '-' | tem == '*' | tem == '/') {
            exp=exp.substring(0,exp.length()-1);
        }
        if(exp.length()>0) {
            for (int i = 0; i < exp.length() - 1; i++) {
                if (temp[i] == '/' && temp[i + 1] == '0') {
                    cond = false;
                }
            }
            if (cond == true) {
                exp = "" + EvaluateString.evaluate(exp);
                tv.setText(exp);
            } else {
                tv.setText("Can't divide by 0");
            }
        }
    }

    public void reset(View v)
    {
        exp="";
        display(exp);
    }
//    public void result(double d) {
//        tv.setText((int) d);
//    }


}
