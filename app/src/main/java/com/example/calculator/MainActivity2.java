package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    Button calc, convert1, clear1, convert2, clear2;
    EditText et_Bin, et_Oct, et_Dec, et_Hex, et_m, et_km;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        calc = (Button) findViewById(R.id.btn_calc);
        calc.setOnClickListener(this);

        convert1 = (Button) findViewById(R.id.btn_convert1);
        convert1.setOnClickListener(this);

        clear1 = (Button) findViewById(R.id.btn_clear1);
        clear1.setOnClickListener(this);

        convert2 = (Button) findViewById(R.id.btn_convert2);
        convert2.setOnClickListener(this);

        clear2 = (Button) findViewById(R.id.btn_clear2);
        clear2.setOnClickListener(this);

        et_Bin = (EditText) findViewById(R.id.et_Bin);

        et_Oct = (EditText) findViewById(R.id.et_Oct);

        et_Dec = (EditText) findViewById(R.id.et_Dec);

        et_Hex = (EditText) findViewById(R.id.et_Hex);

        et_m = (EditText) findViewById(R.id.et_m);

        et_km = (EditText) findViewById(R.id.et_km);

    }

    @Override
    public void onClick(View v) {
        String str_Bin = et_Bin.getText().toString();
        String str_Oct = et_Oct.getText().toString();
        String str_Dec = et_Dec.getText().toString();
        String str_Hex = et_Hex.getText().toString();

        switch (v.getId()) {

            case R.id.btn_calc:
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_convert1:
                if (!str_Bin.isEmpty()) {
                    str_Dec = Integer.valueOf(str_Bin, 2).toString();
                    et_Dec.setText(str_Dec);
                    str_Oct = Integer.toOctalString(Integer.parseInt(str_Dec));
                    et_Oct.setText(str_Oct);
                    str_Hex = Integer.toHexString(Integer.parseInt(str_Dec));
                    et_Hex.setText(str_Hex);
                } else if (!str_Oct.isEmpty()) {
                    str_Dec = Integer.valueOf(str_Oct, 8).toString();
                    et_Dec.setText(str_Dec);
                    str_Bin = Integer.toBinaryString(Integer.parseInt(str_Dec));
                    et_Bin.setText(str_Bin);
                    str_Hex = Integer.toHexString(Integer.parseInt(str_Dec));
                    et_Hex.setText(str_Hex);
                } else if (!str_Dec.isEmpty()) {
                    str_Bin = Integer.toBinaryString(Integer.parseInt(str_Dec));
                    et_Bin.setText(str_Bin);
                    str_Oct = Integer.toOctalString(Integer.parseInt(str_Dec));
                    et_Oct.setText(str_Oct);
                    str_Hex = Integer.toHexString(Integer.parseInt(str_Dec));
                    et_Hex.setText(str_Hex);
                } else if (!str_Hex.isEmpty()) {
                    str_Dec = Integer.valueOf(str_Hex, 16).toString();
                    et_Dec.setText(str_Dec);
                    str_Bin = Integer.toBinaryString(Integer.parseInt(str_Dec));
                    et_Bin.setText(str_Bin);
                    str_Oct = Integer.toOctalString(Integer.parseInt(str_Dec));
                    et_Oct.setText(str_Oct);
                }
                break;
            case R.id.btn_clear1:
                et_Bin.setText("");
                et_Dec.setText("");
                et_Oct.setText("");
                et_Hex.setText("");
                break;
            case R.id.btn_convert2:
                String str_m = et_Hex.getText().toString();
                String str_km = et_km.getText().toString();
                str_m = et_m.getText().toString();
                str_km = et_km.getText().toString();
                if (!str_m.isEmpty()) {
                    int i=Integer.parseInt(str_m);
                    et_km.setText(Integer.toString(i/1000));
                }else if(!str_km.isEmpty()){
                    int i=Integer.parseInt(str_km);
                    et_m.setText(Integer.toString(i*1000));
                }
                break;
            case R.id.btn_clear2:
                et_m.setText("");
                et_km.setText("");
                break;
            default:
                break;
        }
    }
}