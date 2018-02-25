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

    private InputRule inputRule = new InputRule();

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

        outputView.setText("0");

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

        private String inputChar;
        private String type;

        public void onClick(View v) {
            //get the button id to select event
            switch (v.getId()) {
                case R.id.keyNumber0:
                    inputChar = "0";
                    type ="0";
                    break;
                case R.id.keyNumber1:
                    inputChar = "1";
                    type ="1~9";
                    break;
                case R.id.keyNumber2:
                    inputChar = "2";
                    type ="1~9";
                    break;
                case R.id.keyNumber3:
                    inputChar = "3";
                    type ="1~9";
                    break;
                case R.id.keyNumber4:
                    inputChar = "4";
                    type ="1~9";
                    break;
                case R.id.keyNumber5:
                    inputChar = "5";
                    type ="1~9";
                    break;
                case R.id.keyNumber6:
                    inputChar = "6";
                    type ="1~9";
                    break;
                case R.id.keyNumber7:
                    inputChar = "7";
                    type ="1~9";
                    break;
                case R.id.keyNumber8:
                    inputChar = "8";
                    type ="1~9";
                    break;
                case R.id.keyNumber9:
                    inputChar = "9";
                    type ="1~9";
                    break;
                case R.id.keyPlus:
                    inputChar = "+";
                    type ="+*/";
                    break;
                case R.id.keyDot:
                    inputChar = ".";
                    type =".";
                    break;
                case R.id.keyEqual:
                    inputChar = "=";
                    type ="equal";
                    break;
                case R.id.keyMinus:
                    inputChar = "-";
                    type ="-";
                    break;
                case R.id.keyMutiple:
                    inputChar = "*";
                    type ="+*/";
                    break;
                case R.id.keyChangesign:
                    inputChar = "±";
                    type ="±";
                    break;
                case R.id.keyPerC_ent:
                    inputChar = "%";
                    type ="%";
                    break;
                case R.id.keyDivide:
                    inputChar = "/";
                    type ="+*/";
                    break;
                case R.id.keyReset:
                    inputChar = "C";
                    type ="reset";
                    break;

                default:
                    break;
            }//end of switch

            //input the Key
            inputRule.inuputForRule(inputChar,type);
            //get the Text and set into inputView
            inputView.setText(inputRule.getTextAfter());
            //get the answer and set it into View
            outputView.setText(inputRule.getAnswer());
        }//end of Onclick
    }
}
