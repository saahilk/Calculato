package com.example.android.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        exp = exp + (b.getText());
        display(exp);
    }

    public void onclickop(View v)
    {
        Button op=(Button) v;
        if(exp.length()>0) {
            char temp = exp.substring(exp.length() - 1, exp.length()).toCharArray()[0];
            if (temp == '+' | temp == '-' | temp == '*' | temp == '/') {
                System.out.print(exp);
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

        exp=""+EvaluateString.evaluate(exp);
        tv.setText(exp);
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
