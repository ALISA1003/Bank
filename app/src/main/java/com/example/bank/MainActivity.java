package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private TextView mTextView;
    private EditText ed_years;
    private EditText ed_procent;
    private EditText ed_payment;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        mTextView = (TextView)findViewById(R.id.textView);
        mTextView.setText("0");

        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);

        ed_years = findViewById(R.id.tv_years);
        ed_years.setText("0");
        ed_procent = findViewById(R.id.tv_procent);
        ed_procent.setText("0");
        ed_payment = findViewById(R.id.tv_payment);
        ed_payment.setText("0");
    }

    @Override
    public void onClick(View v) {
        int ans = 0;

        double n = Integer.parseInt(String.valueOf(ed_years.getText()));
        double pr = Integer.parseInt(String.valueOf(ed_procent.getText()));
        double pm = Integer.parseInt(String.valueOf(ed_payment.getText()));
        String str = String.valueOf(mTextView.getText());
        String S[] = str.split(" ");
        double s = Integer.parseInt(S[0]);

        ans = (int)( (pr/100)*((n+1)/2)*s );
        //ans = s;
        String data = "Your's payment: " + String.valueOf(ans) + "k";

        Intent intent = new Intent(this, payment.class);
        intent.putExtra("ccc", data);
        startActivity(intent);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mTextView.setText(String.valueOf(seekBar.getProgress()*10) + " k");
    }
}