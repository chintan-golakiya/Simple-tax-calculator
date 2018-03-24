package com.example.chintan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGrouptype,radioGrpper;
    RadioButton radioButtontype,radioButtonper;
    TextView textView;
    EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGrouptype = findViewById(R.id.chtype);
        radioGrpper = findViewById(R.id.chper);
        amount = findViewById(R.id.val);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(view);
            }
        });
    }

    public void calculate(View v){
        int radioid = radioGrouptype.getCheckedRadioButtonId();
        radioButtontype = findViewById(radioid);
        radioButtonper = findViewById(radioGrpper.getCheckedRadioButtonId());
        Double val = Double.parseDouble(amount.getText().toString());
        //textView =findViewById(R.id.valamt);
        //textView.setText(val.toString());
        StringTokenizer st = new StringTokenizer(radioButtonper.getText().toString());
        int per = Integer.parseInt(st.nextToken());
        if(radioid == R.id.radio0)
        {
            val = val/(100+per)*100;
        }
        val = Math.round(val*100.0)/100.0;
        Double cg  = val*per/200;
        cg = Math.round(cg*100.0)/100.0;
        Double total = val + (val*per/100);
        total = Math.round(total*100.0)/100.0;
        textView = findViewById(R.id.valamt);
        textView.setText(val.toString());
        textView = findViewById(R.id.cval);
        textView.setText(cg.toString());
        textView = findViewById(R.id.sval);
        textView.setText(cg.toString());
        textView = findViewById(R.id.valtotal);
        textView.setText(total.toString());
    }
}
