package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public String text="",h="";
    public float a=0;
    public float e,f,g;
    public String b,c,d="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=findViewById(R.id.b1);
        Button b2=findViewById(R.id.b2);
        Button b3=findViewById(R.id.b3);
        Button b4=findViewById(R.id.b4);
        Button b5=findViewById(R.id.b5);
        Button b6=findViewById(R.id.b6);
        Button b7=findViewById(R.id.b7);
        Button b8=findViewById(R.id.b8);
        Button b9=findViewById(R.id.b9);
        Button b0=findViewById(R.id.b0);
        Button history=findViewById(R.id.history);
        Button rotate=findViewById(R.id.rotate);
        Button clear=findViewById(R.id.clear);
        Button add=findViewById(R.id.add);
        Button sub=findViewById(R.id.sub);
        Button multiply=findViewById(R.id.multiply);
        Button divide=findViewById(R.id.divide);
        Button percent=findViewById(R.id.percent);
        Button bracket=findViewById(R.id.bracket);
        Button negative=findViewById(R.id.negative);
        Button point=findViewById(R.id.point);
        Button equal=findViewById(R.id.equal);
        Button back=findViewById(R.id.back);
        TextView screen=findViewById(R.id.scree);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        back.setOnClickListener(this);
        history.setOnClickListener(this);
        sub.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        percent.setOnClickListener(this);
        bracket.setOnClickListener(this);
        negative.setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
        rotate.setOnClickListener(this);
        add.setOnClickListener(this);
        screen.setOnClickListener(this);
    }


    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        TextView screen=findViewById(R.id.scree);
        switch (v.getId()){
            case R.id.b1:
                text=text+"1";
                screen.setText(text);
                break;
            case R.id.b2:
                text=text+"2";
                screen.setText(text);
                break;
            case R.id.b3:
                text=text+"3";
                screen.setText(text);
                break;
            case R.id.b4:
                text=text+"4";
                screen.setText(text);
                break;
            case R.id.b5:
                text=text+"5";
                screen.setText(text);
                break;
            case R.id.b6:
                text=text+"6";
                screen.setText(text);
                break;
            case R.id.b7:
                text=text+"7";
                screen.setText(text);
                break;
            case R.id.b8:
                text=text+"8";
                screen.setText(text);
                break;
            case R.id.b9:
                text=text+"9";
                screen.setText(text);
                break;
            case R.id.b0:
                text=text+"0";
                screen.setText(text);
                break;
            case R.id.back:
                break;
            case R.id.history:
                break;
            case R.id.sub:
                if (a==0){
                    b=text;
                    c="-";
                    text=text+"-";
                    screen.setText(text);
                    a++;
                }
                break;
            case R.id.multiply:
                if (a==0){
                    b=text;
                    c="X";
                    text=text+"X";
                    screen.setText(text);
                    a++;
                }
                break;
            case R.id.divide:
                if (a==0){
                    b=text;
                    c="÷";
                    text=text+"÷";
                    screen.setText(text);
                    a++;
                }
                break;
            case R.id.percent:
                text=text+"%";
                d=text;
                d=d.replace("%","");
                e=Float.parseFloat(d);
                e=e/100;
                h=Float.toString(e);
                text=h;
                screen.setText(text);
                break;
            case R.id.bracket:
                break;
            case R.id.negative:
                e=Float.parseFloat(text);
                e=e*(-1);
                h=Float.toString(e);
                text=h;
                screen.setText(text);
                break;
            case R.id.point:
                if(text.contains(".")==false){
                text=text+".";
                screen.setText(text);}
                if(a!=0){
                    d=text;
                    d=d.replaceFirst(b,"");
                    d=d.replace(c,"");
                    if (d.contains(".")==false){
                        text=text+".";
                        screen.setText(text);
                    }
                    }
                break;

            case R.id.rotate:
                break;
            case R.id.clear:
                text="";
                screen.setText(text);
                break;
            case R.id.add:
                if (a==0){
                    b=text;
                    c="+";
                    text=text+"+";
                    screen.setText(text);
                    a++;
                }
                break;
            case R.id.equal:

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
    }