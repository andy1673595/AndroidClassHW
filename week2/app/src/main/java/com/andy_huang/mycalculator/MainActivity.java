package com.andy_huang.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView inputView;
    private TextView outputView ;
    private ImageButton buttonNum0,buttonNum1,buttonNum2,buttonNum3,buttonNum4,
                        buttonNum5,buttonNum6,buttonNum7,buttonNum8,buttonNum9;
    private ImageButton buttonPlus,buttonDot,buttonEqual,buttonMinus,buttonMutiple,
                        buttonReset,buttonChangesign,buttonPerCent,buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //hidden the title
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setTxtView
        inputView = (TextView)findViewById(R.id.inputTextView);
        outputView = (TextView)findViewById(R.id.outputTextView);

        setButtonValue();

        outputView.setText("88888");



    }

    /*****************************************************
             set the each button's value
     ******************************************************/
    private void setButtonValue() {
        buttonNum0 = (ImageButton) findViewById(R.id.keyNumber0);
        buttonNum1 = (ImageButton) findViewById(R.id.keyNumber1);
        buttonNum2 = (ImageButton) findViewById(R.id.keyNumber2);
        buttonNum3 = (ImageButton) findViewById(R.id.keyNumber3);
        buttonNum4 = (ImageButton) findViewById(R.id.keyNumber4);
        buttonNum5 = (ImageButton) findViewById(R.id.keyNumber5);
        buttonNum6 = (ImageButton) findViewById(R.id.keyNumber6);
        buttonNum7 = (ImageButton) findViewById(R.id.keyNumber7);
        buttonNum8 = (ImageButton) findViewById(R.id.keyNumber8);
        buttonNum9 = (ImageButton) findViewById(R.id.keyNumber9);

        buttonPlus       = (ImageButton) findViewById(R.id.keyPlus);
        buttonDot        = (ImageButton) findViewById(R.id.keyDot);
        buttonEqual      = (ImageButton) findViewById(R.id.keyEqual);
        buttonMinus      = (ImageButton) findViewById(R.id.keyMinus);
        buttonMutiple    = (ImageButton) findViewById(R.id.keyMutiple);
        buttonReset      = (ImageButton) findViewById(R.id.keyReset);
        buttonChangesign = (ImageButton) findViewById(R.id.keyChangesign);
        buttonPerCent    = (ImageButton) findViewById(R.id.keyPerC_ent);
        buttonDivide     = (ImageButton) findViewById(R.id.keyDivide);


        buttonNum0.setOnClickListener(new MyListener());
        buttonNum1.setOnClickListener(new MyListener());
        buttonNum2.setOnClickListener(new MyListener());
        buttonNum3.setOnClickListener(new MyListener());
        buttonNum4.setOnClickListener(new MyListener());
        buttonNum5.setOnClickListener(new MyListener());
        buttonNum6.setOnClickListener(new MyListener());
        buttonNum7.setOnClickListener(new MyListener());
        buttonNum8.setOnClickListener(new MyListener());
        buttonNum9.setOnClickListener(new MyListener());

        buttonPlus.setOnClickListener(new MyListener());
        buttonDot.setOnClickListener(new MyListener());
        buttonEqual.setOnClickListener(new MyListener());
        buttonMinus.setOnClickListener(new MyListener());
        buttonMutiple.setOnClickListener(new MyListener());
        buttonReset.setOnClickListener(new MyListener());
        buttonChangesign.setOnClickListener(new MyListener());
        buttonPerCent.setOnClickListener(new MyListener());
        buttonDivide.setOnClickListener(new MyListener());

    }

    /*****************************************************
                Class MyListener for buttons 
    ******************************************************/
    public class MyListener implements View.OnClickListener {
        public void onClick(View v) {
            //get the button id
            switch (v.getId()) {
                case R.id.keyNumber0:
                    inputView.setText("0000");
                    break;
                case R.id.keyNumber1:
                    inputView.setText("1111");
                    break;
                case R.id.keyNumber2:
                    inputView.setText("2222");
                    break;
                case R.id.keyNumber3:
                    inputView.setText("3333");
                    break;
                case R.id.keyNumber4:
                    inputView.setText("4444");
                    break;
                case R.id.keyNumber5:
                    inputView.setText("5555");
                    break;
                case R.id.keyNumber6:
                    inputView.setText("6666");
                    break;
                case R.id.keyNumber7:
                    inputView.setText("7777");
                    break;
                case R.id.keyNumber8:
                    inputView.setText("8888");
                    break;
                case R.id.keyNumber9:
                    inputView.setText("9999");
                    break;
                case R.id.keyPlus:
                    inputView.setText("++++");
                    break;
                case R.id.keyDot:
                    inputView.setText("....");
                    break;
                case R.id.keyEqual:
                    inputView.setText("====");
                    break;
                case R.id.keyMinus:
                    inputView.setText("----");
                    break;
                case R.id.keyMutiple:
                    inputView.setText("****");
                    break;
                case R.id.keyChangesign:
                    inputView.setText("ChCh");
                    break;
                case R.id.keyPerC_ent:
                    inputView.setText("%%%%");
                    break;
                case R.id.keyDivide:
                    inputView.setText("////");
                    break;
                case R.id.keyReset:
                    inputView.setText("CCCC");
                    break;

                default:

                    break;
            }
        }
    }
}
