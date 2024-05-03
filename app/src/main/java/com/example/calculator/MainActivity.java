package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public String text="",h="";
    public float e;
    public String d="";
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
        Button rotate=findViewById(R.id.power);
        Button clear=findViewById(R.id.clear);
        Button add=findViewById(R.id.add);
        Button sub=findViewById(R.id.sub);
        Button multiply=findViewById(R.id.multiply);
        Button divide=findViewById(R.id.divide);
        Button cbracket=findViewById(R.id.cbracket);
        Button obracket=findViewById(R.id.obracket);
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
        cbracket.setOnClickListener(this);
        obracket.setOnClickListener(this);
        negative.setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
        rotate.setOnClickListener(this);
        add.setOnClickListener(this);
        screen.setOnClickListener(this);
    }
        public static double eval(final String str) {
            return new Object() {
                int pos = -1, ch;

                void nextChar() {
                    ch = (++pos < str.length()) ? str.charAt(pos) : -1;
                }

                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }

                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                    return x;
                }

                // Grammar:
                // expression = term | expression `+` term | expression `-` term
                // term = factor | term `*` factor | term `/` factor
                // factor = `+` factor | `-` factor | `(` expression `)` | number
                //        | functionName `(` expression `)` | functionName factor
                //        | factor `^` factor

                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if      (eat('+')) x += parseTerm(); // addition
                        else if (eat('-')) x -= parseTerm(); // subtraction
                        else return x;
                    }
                }

                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if      (eat('*')) x *= parseFactor(); // multiplication
                        else if (eat('÷')) x /= parseFactor(); // division
                        else return x;
                    }
                }

                double parseFactor() {
                    if (eat('+')) return +parseFactor(); // unary plus
                    if (eat('-')) return -parseFactor(); // unary minus

                    double x;
                    int startPos = this.pos;
                    if (eat('(')) { // parentheses
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')'");
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(str.substring(startPos, this.pos));
                    } else if (ch >= 'a' && ch <= 'z') { // functions
                        while (ch >= 'a' && ch <= 'z') nextChar();
                        String func = str.substring(startPos, this.pos);
                        if (eat('(')) {
                            x = parseExpression();
                            if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                        } else {
                            x = parseFactor();
                        }
                        switch (func) {
                            case "sqrt":
                                x = Math.sqrt(x);
                                break;
                            case "sin":
                                x = Math.sin(Math.toRadians(x));
                                break;
                            case "cos":
                                x = Math.cos(Math.toRadians(x));
                                break;
                            case "tan":
                                x = Math.tan(Math.toRadians(x));
                                break;
                            default:
                                throw new RuntimeException("Unknown function: " + func);
                        }
                    } else {
                        throw new RuntimeException("Unexpected: " + (char)ch);
                    }

                    if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                    return x;
                }
            }.parse();
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
                if (text.length() > 0){
                    text=text.substring(0,text.length()-1);
                }
                screen.setText(text);
                break;
            case R.id.history:
                break;
            case R.id.sub:
                    text=text+"-";
                    screen.setText(text);

                break;
            case R.id.multiply:
                    text=text+"*";
                    screen.setText(text);
                break;
            case R.id.divide:
                    text=text+"÷";
                    screen.setText(text);
                break;
            case R.id.obracket:
                text=text+"(";
                screen.setText(text);
                break;
            case R.id.cbracket:
                text=text+")";
                screen.setText(text);
                break;
            case R.id.negative:
                text= "-(" +text+')';
                screen.setText(text);
                break;
            case R.id.point:
                text=text+".";
                screen.setText(text);
                break;
            case R.id.power:
                text=text+"^";
                screen.setText(text);
                break;
            case R.id.clear:
                text="";
                screen.setText(text);
                break;
            case R.id.add:
                    text=text+"+";
                    screen.setText(text);
                break;
            case R.id.equal:
                try {
                    text= String.valueOf(eval(text));
                    screen.setText(text);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
    }