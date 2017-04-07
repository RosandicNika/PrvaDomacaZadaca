package com.example.nika.prvadomacazadaca;
import org.achartengine.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class MainUnosActivity extends AppCompatActivity {

    public Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    public double[] result;
    public EditText firstComplex, secondComplex;
    double re1, im1, re2, im2, real, imag;

    public void spliter(EditText text, double re, double im) {
        String tmp = text.getText().toString();
        if (tmp.contains("+")) {
            String[] array = tmp.split("\\+");
            re = Double.parseDouble(array[0]);
            im = Double.parseDouble(array[1].replace("i", " ").trim());
        } else {
            im = Double.parseDouble(tmp.substring(tmp.lastIndexOf("-"), tmp.indexOf('i')));
            re = Double.parseDouble(tmp.substring(0, tmp.lastIndexOf("-")));
        }
    }


    public void buttonOnClick() {
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub=(Button)findViewById(R.id.buttonSub);
        buttonMul=(Button)findViewById(R.id.buttonMul);
        buttonDiv=(Button)findViewById(R.id.buttonDiv);
        firstComplex=(EditText)findViewById(R.id.firstComplex);
        secondComplex=(EditText)findViewById(R.id.secondComplex);


        View.OnClickListener listener=new View.OnClickListener() {
            public void onClick(View v) {
                spliter(firstComplex, re1, im1);
                spliter(secondComplex, re2, im2);
                switch (v.getId()) {
                    case R.id.buttonAdd:
                        real = re1 + re2;
                        imag = im1 + im2;
                        break;
                    case R.id.buttonSub:
                        real = re1 - re2;
                        imag = im1 - im2;
                        break;
                    case R.id.buttonMul:
                        real = re1 * re2 + im1 * im2;
                        imag = re1 * im2 + re2 * im1;
                        break;
                    case R.id.buttonDiv:
                        double realHelp = re1 * re2 + im1 * im2;
                        double imagHelp = re2 * im1 - re1 * im2;
                        double squares = re2 * re2 + im2 * im2;
                        real = realHelp / squares;
                        imag = imagHelp / squares;
                        break;
                }
                result[0]=re1;
                result[1]=im1;
                result[2]=re2;
                result[3]=im2;
                result[4]=real;
                result[5]=imag;
                LineGraph line=new LineGraph();
                Intent lineIntent=line.getIntent(result, MainUnosActivity.this);
                startActivity(lineIntent);
            }
        };
        buttonAdd.setOnClickListener(listener);
        buttonSub.setOnClickListener(listener);
        buttonMul.setOnClickListener(listener);
        buttonDiv.setOnClickListener(listener);


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_unos);

        buttonOnClick();


    }
}
