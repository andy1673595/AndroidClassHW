package com.andy_huang.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView inputView;
    private TextView outputView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //hidden the title
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setTxtView
        inputView = (TextView)findViewById(R.id.inputTextView);
        outputView = (TextView)findViewById(R.id.outputTextView);

        inputView.setText("55555");
        outputView.setText("88888");


    }
}
