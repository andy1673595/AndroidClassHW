package com.andy_huang.mycalculator;

import java.util.Stack;

public class Caculate {

    private Stack<String> tempStack = new Stack<String>();
    private String result;
    private String recentOP="";
    private String element="";

    public String caculateString(Stack<String> stringForCaculation) {
        //reverse the string stack
        stringForCaculation.push("end");
        stringForCaculation = reverse(stringForCaculation);

        while (!stringForCaculation.empty() && result!="error") {
            element = stringForCaculation.pop();

            //end mark , pop all element and excute
            if(element.equals("end")) {
                while(tempStack.size()>1) {
                    //caculate the top from stack
                    result = numberOpNumber();
                    //push back
                    tempStack.push(result);
                }
            }
            //op * or /
            else if (element.equals("*")||element.equals("/")) {
                if(recentOP =="*"||recentOP =="/") {
                    //caculate the top from stack
                    result = numberOpNumber();
                    //push back
                    tempStack.push(result);
                    tempStack.push(element);
                    recentOP = element;
                }
                else {
                    tempStack.push(element);
                    recentOP = element;
                }

                recentOP = element;
            }

            else if(element.equals("+")||element.equals("-")) {
                if(recentOP != "") {
                    result = numberOpNumber();
                    tempStack.push(result);
                    tempStack.push(element);
                    recentOP = element;
                }
                else {
                    tempStack.push(element);
                    recentOP = element;
                }

            }
            //element is number
            else{
                tempStack.push(element);
            }
        }

        //return the bottom element, which is final answer
        return tempStack.pop();
    }

    //reverse the String
    public Stack<String> reverse(Stack<String> before) {
        Stack<String> after = new Stack<String>();

        while (!before.empty()) {
            after.push(before.pop());
        }
        return after;
    }

    //Function for number excute +-*/
    public String numberOpNumber(){
        float num2 = Float.parseFloat(tempStack.pop());
        String op = tempStack.pop();
        float num1 = Float.parseFloat(tempStack.pop());
        String answerAfterCaculate="";
        switch (op) {
            case "+":
                answerAfterCaculate = String.valueOf(num1+num2);
                break;
            case "-":
                answerAfterCaculate = String.valueOf(num1-num2);
                break;
            case "*":
                answerAfterCaculate = String.valueOf(num1*num2);
                break;
            case "/":
                if(num2 ==0) answerAfterCaculate = "error";
                else answerAfterCaculate = String.valueOf(num1/num2);
                break;
        }

        return answerAfterCaculate;
    }
}
