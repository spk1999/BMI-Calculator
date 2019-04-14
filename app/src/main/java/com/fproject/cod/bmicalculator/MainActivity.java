package com.fproject.cod.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_height,et_weight,et_res;
    Button btn_compute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_compute=findViewById(R.id.btn_compute);
        btn_compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                et_height = findViewById(R.id.et_editHeight);
                et_weight = findViewById(R.id.et_editWeight);
                et_res = findViewById(R.id.et_res);
                if (et_height.getText().toString().length() <= 0) {
                    et_height.setError("Enter a valid number");
                } else if (et_weight.getText().toString().length() <= 0) {
                    et_weight.setError("Enter a valid number");
                } else {
                    float h, w;
                    h = Float.parseFloat(et_height.getText().toString());
                    w = Float.parseFloat(et_weight.getText().toString());
                    h = h / 100;

                    float bmi = w / (h * h);
                    et_res.setText(""+ bmi);
                    String status="";
                    if(bmi<18.5)
                    {
                        status="Underweight";
                    }
                    else if(bmi> 18.5 && bmi<25)
                    {
                        status="Normal Weight";
                    }
                    else if(bmi> 25 && bmi <30)
                    {
                        status="OverWeight";
                    }
                    else if(bmi>29.9)
                    {
                        status="Obesity";
                    }
                    Toast.makeText(MainActivity.this,status,Toast.LENGTH_LONG).show();

                }
            }});
    }






}