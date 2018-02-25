package com.andy_huang.mycalculator;
import java.util.Stack;

public class InputRule {

    private Stack<String> inputStack = new Stack<String>();
    private String recentState = "zero";
    private String inputType = "";
    private String numberTemp="";
    private String keyChar;
    private String outputOnInputText="0";
    private String answer = "0";
    private boolean positiveOrNagtive = true;
    private boolean percent = false;

    //get the input from inputTextContent.java
    public void inuputForRule(String inputChar,String input) {
        inputType = input;
        keyChar = inputChar;

        //reset all variable
        if(inputType == "reset") {
            resetFunction();
            outputOnInputText="0";
            answer ="0";
        }
        //KeyEqual ,Start to caculate
        else if(inputType == "equal") {
            //Start to caculate
            Caculate caculate = new Caculate();

            if(recentState =="NumberFrontPart"||recentState =="NumberBackPart"
                    ||recentState =="zero"||recentState =="±0") {
                //push last number
                if(recentState =="zero"||recentState =="±0") {numberTemp ="0";}
                else {numberTemp=numberHandle(numberTemp);}

                inputStack.push(numberTemp);

                //call caculate function
                answer = caculate.caculateString(inputStack);
                //reset variables

                if(answer=="error" ||answer =="Infinity"||answer =="-Infinity") {
                    inputStack.clear();
                    recentState = "error";
                    numberTemp="";
                    positiveOrNagtive = true;
                    percent = false;
                }
                else if(numberIsInteger(answer)) {
                    //cut part ".0"
                    if(!answer.equals("0")) {
                        answer=answer.substring(0,answer.length()-2);
                        resetFunction();
                        recentState ="NumberFrontPart";
                        outputOnInputText = answer;
                        numberTemp+= answer;
                    }
                    else {
                        resetFunction();
                        outputOnInputText="0";
                        answer ="0";
                    }



                }
 
                else {
                    resetFunction();
                    outputOnInputText = answer;
                    numberTemp+= answer;
                    recentState ="NumberBackPart";
                }



            }
            //Illegal input string
            else {
                recentState = "error";
                answer="error";
            }
        }
        else{ FSM(recentState, inputType); }
    }



    //get TextContent Function
    public String getTextAfter(){
        return outputOnInputText;
    }

    public String getAnswer(){
        return answer;
    }

    public void resetFunction(){
        inputStack.clear();
        recentState = "zero";
        numberTemp="";
        positiveOrNagtive = true;
        percent = false;
    }

    public boolean numberIsInteger(String number) {
        float numberFloat = Float.valueOf(number);
        int numInt = (int) numberFloat;
        return  numInt == numberFloat;
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
                else if (inputType=="±") {
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
                else if(inputType=="-") {
                    recentState = "Nagtive";
                    outputOnInputText+=keyChar;
                    positiveOrNagtive = !positiveOrNagtive;
                }
                else if(inputType =="±") {
                    recentState = "PorN";
                    outputOnInputText += keyChar;
                    positiveOrNagtive = !positiveOrNagtive;
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
                if(inputType =="+*/") {
                    recentState = "+-*/";
                    outputOnInputText=outputOnInputText.substring(0,outputOnInputText.length()-1);
                    outputOnInputText+= keyChar;
                }
                else if(inputType =="-") {
                    recentState = "Nagtive";
                    char op = outputOnInputText.charAt(outputOnInputText.length()-1);
                    inputStack.push(String.valueOf(op));
                    outputOnInputText += keyChar;
                    positiveOrNagtive = !positiveOrNagtive;
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
                    char op = outputOnInputText.charAt(outputOnInputText.length()-1);
                    inputStack.push(String.valueOf(op));
                    outputOnInputText+="0";
                }
                else if(inputType =="%"){
                    recentState ="PorN";
                    char op = outputOnInputText.charAt(outputOnInputText.length()-1);
                    inputStack.push(String.valueOf(op));
                    outputOnInputText+= "%";
                    percent = true;
                }
                else if(inputType == "±") {
                    recentState = "PorN";
                    char op = outputOnInputText.charAt(outputOnInputText.length()-1);
                    inputStack.push(String.valueOf(op));
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
