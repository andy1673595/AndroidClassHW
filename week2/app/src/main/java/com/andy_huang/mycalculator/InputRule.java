package com.andy_huang.mycalculator;
import java.util.Stack;

public class InputRule {

    private Stack<String> inputStack = new Stack<String>();
    private String recentState = "zero";
    private String inputType = "";
    private String numberTemp="";
    private String keyChar;
    private String outputOnInputText="0";
    private boolean positiveOrNagtive = true;
    private boolean percent = false;

    //get the input from inputTextContent.java
    public void inuputForRule(String inputChar,String input) {
        inputType = input;
        keyChar = inputChar;
        FSM(recentState,inputType);
    }



    //get TextContent Function
    public String getTextAfter(){
        return outputOnInputText;
    }

    /*****************************************************
            Final State Machine
     ******************************************************/
    public void FSM(String recentStateIN,String inputType) {
        switch (recentStateIN){

            /******case initial zero******/
            case "zero":
                if(inputType == ".") {
                    recentState = "dot";
                    numberTemp = "0.";    //mean 0.XXXX
                    outputOnInputText="0.";
                }
                else if(inputType == "0") {
                    recentState = "zero";
                }
                else if(inputType =="%") {
                    recentState = "PorN";
                    percent = true;
                    outputOnInputText="%";
                }
                else if(inputType == "±") {
                    recentState = "PorN";
                    positiveOrNagtive = !positiveOrNagtive;
                    outputOnInputText="±";
                }
                else if(inputType =="1~9"){
                    recentState = "NumberFrontPart";
                    numberTemp += keyChar; // add number into the FrontPart of Number
                    outputOnInputText=keyChar;
                }
                else if(inputType == "-") {
                    recentState = "Nagtive";
                    positiveOrNagtive = !positiveOrNagtive;
                    outputOnInputText="-";
                }
                else if(inputType=="+*/") {
                    recentState = "+-*/";
                    inputStack.push("0");  //  0  +-*/ ...
                    outputOnInputText+=keyChar;
                }
                else{
                    outputOnInputText = "0";  //Illegal input
                }
                break;


            /****case positive or nagtive****/
            case "PorN":
                if( (inputType=="%") && !percent) {
                    recentState ="PorN";
                    percent = true;
                    outputOnInputText+="%";
                }
                else if (inputType=="±" && !percent) {
                    recentState = "PorN";
                    positiveOrNagtive = !positiveOrNagtive;
                    outputOnInputText+="±";
                }
                else if(inputType =="-") {
                    recentState = "PorN";
                    positiveOrNagtive = !positiveOrNagtive;
                    outputOnInputText+="-";
                }
                else if(inputType == "0") {
                    recentState = "±0";
                    outputOnInputText+="0";
                }
                else if(inputType=="1~9") {
                    recentState ="NumberFrontPart";
                    numberTemp += keyChar;
                    outputOnInputText+=keyChar;
                }
                break;


            /**********case Nagtive**********/
            case "Nagtive":
                if(inputType == "0") {
                    recentState = "±0";
                    outputOnInputText+="0";
                }
                else if(inputType=="1~9") {
                    recentState = "NumberFrontPart";
                    numberTemp += keyChar;
                    outputOnInputText+=keyChar;
                }
                break;

            /**********case ±0**********/
            case "±0":
                if(inputType =="."){
                    recentState = "dot";
                    outputOnInputText+=".";
                    numberTemp += "0.";
                }
                else if(inputType=="1~9") {
                    recentState="NumberFrontPart";
                    //delete the 0,and add new number
                    outputOnInputText=outputOnInputText.substring(0,outputOnInputText.length()-1);
                    outputOnInputText+= keyChar;
                    numberTemp += keyChar;
                }
                else  if(inputType=="+*/"||inputType =="-"){
                    outputOnInputText+=keyChar;
                    inputStack.push("0");  //  0  +-*/ ...
                }
                break;

            /**********NumberFrontPart**********/
            case "NumberFrontPart":

                if(inputType ==".") {
                    recentState = "dot";
                    outputOnInputText+=".";
                    numberTemp+=".";
                }
                else if(inputType=="1~9"||inputType=="0") {
                    recentState = "NumberFrontPart";
                    outputOnInputText +=keyChar;
                    numberTemp += keyChar;
                }
                else if(inputType =="+*/"||inputType =="-") {
                    recentState = "+-*/";
                    outputOnInputText += keyChar;
                    numberTemp = numberHandle(numberTemp);
                    inputStack.push(numberTemp);
                    numberTemp ="";
                }
                break;
            case "dot":
                if(inputType=="1~9"||inputType=="0") {
                    recentState = "NumberBackPart";
                    numberTemp+=keyChar;
                    outputOnInputText+=keyChar;
                }
                break;
            case "NumberBackPart":
                if(inputType=="1~9"||inputType=="0"){
                    recentState = "NumberBackPart";
                    numberTemp+=keyChar;
                    outputOnInputText+=keyChar;
                }
                else if(inputType =="+*/"||inputType =="-"){
                    recentState = "+-*/";
                    outputOnInputText += keyChar;
                    numberTemp = numberHandle(numberTemp);
                    inputStack.push(numberTemp);
                    numberTemp ="";
                }
                break;
            case "+-*/":
                if(inputType =="+*/"||inputType =="-") {
                    recentState = "+-*/";
                    outputOnInputText=outputOnInputText.substring(0,outputOnInputText.length()-1);
                    outputOnInputText+= keyChar;
                }
                else if(inputType =="1~9") {
                    recentState = "NumberFrontPart";
                    numberTemp+= keyChar;
                    //push +-*/ into stack
                    char op = outputOnInputText.charAt(outputOnInputText.length()-1);
                    inputStack.push(String.valueOf(op));
                    outputOnInputText+=keyChar;
                }
                else if(inputType =="0") {
                    recentState = "±0";
                    outputOnInputText+="0";
                }
                else if(inputType =="%"){
                    recentState ="PorN";
                    outputOnInputText+= "%";
                    percent = true;
                }
                else if(inputType == "±") {
                    recentState = "PorN";
                    positiveOrNagtive = !positiveOrNagtive;
                    outputOnInputText += "±";
                }

                break;

        }//end switch
    }//end of Final State Machine


    /*****************************************************
      Handle the positiveOrNagtive and percent
     ******************************************************/
    public String numberHandle(String number) {
        float numberGet = Float.parseFloat(number);
        if(!positiveOrNagtive) numberGet = numberGet*(-1);
        if(percent) numberGet = numberGet/100;
        //reset the state
        percent = false;
        positiveOrNagtive = true;
        return String.valueOf(numberGet);
    }
}
