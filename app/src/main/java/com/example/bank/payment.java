package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class payment extends AppCompatActivity {

    private TextView tv;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        tv = findViewById(R.id.textView2);
        btn2 = findViewById(R.id.button2);

        Bundle bundle = getIntent().getExtras(); // она может быть нулл
        if(bundle != null) {
            tv.setText(bundle.getString("ccc"));
        }

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}