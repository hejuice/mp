package com.example.mycaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int value1;
    int value2;
    int result;
    int operator;   //연산자 기억위한 변수 1+ 2-
    int numberOfInput;
    //int[] num = new int[10];

    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = (EditText) findViewById(R.id.number);
        numberOfInput = 0;
    }

    public void cal(int v){    //계산하는 함수
        if(numberOfInput==0){
            value1=v;
            numberOfInput++;
            myEditText.setText(String.valueOf(value1)); //값을 넣는거
            //num[numberOfInput]=value1;
        }
        else if (numberOfInput==1){
            value2=v;
            //myEditText.setText(String.valueOf(value1));
            if(operator==1)
                result=value1+value2;
            else if(operator==2)
                result=value1-value2;
            else if(operator==3)
                result=value1*value2;
            else if(operator==4)
                result=value1/value2;
            myEditText.setText(String.valueOf(value2)); //값을 넣는거
            numberOfInput++;
            //결과를 다시 첫번째 피연산자로 두려면
            //numberOfInput--;
            //value1=result;
        }
    }

    public void onClick1(View view) {
        cal(1);
    }

    public void onClick2(View view) {
        cal(2);
    }

    public void onClick3(View view) {
        cal(3);
    }

    public void onClick4(View view) {
        cal(4);
    }

    public void onClick5(View view) {
        cal(5);
    }

    public void onClick6(View view) {
        cal(6);
    }

    public void onClick7(View view) {
        cal(7);
    }

    public void onClick8(View view) {
        cal(8);
    }

    public void onClick9(View view) {
        cal(9);
    }

    public void onClick0(View view) {
        cal(0);
    }

    public void onClickPlus(View view) {
        operator=1;
    }

    public void onClickMinus(View view) {
        operator=2;
    }

    public void onClickMul(View view) {
        operator=3;
    }

    public void onClickDiv(View view) {
        operator=4;
    }

    public void onClickClear(View view) {
        numberOfInput = 0;
        result = 0;
        myEditText.setText(String.valueOf(result));
    }

    public void onClickOK(View view) {
        if(numberOfInput==2){
            myEditText.setText(String.valueOf(result));
            numberOfInput=0;
        }
    }

}
