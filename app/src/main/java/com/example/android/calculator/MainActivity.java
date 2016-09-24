package com.example.android.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public String exp = "";
    public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
    }

    public void onclickbutton(View v) {
        Button b = (Button) v;
        exp = exp + (b.getText());
        display(exp);
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
