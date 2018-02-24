package com.andy_huang.mycalculator;

public class InputTextContent {

    private String inputContent="";

    private String inputType = "";
    private InputRule inputRule = new InputRule();

    //get TextContent Function
    public String getTextAfter(){
        return inputContent;
    }

    public void setTextContent(String inputChar,String type) {
        inputRule.inuputForRule(type);
        inputContent = inputContent+ inputChar;
    }





}
